package org.meta_environment.rascal.interpreter;

import java.util.List;

import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.IListWriter;
import org.eclipse.imp.pdb.facts.IString;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.meta_environment.ValueFactoryFactory;
import org.meta_environment.rascal.ast.CharClass;
import org.meta_environment.rascal.ast.CharRange;
import org.meta_environment.rascal.ast.CharRanges;
import org.meta_environment.rascal.ast.Character;
import org.meta_environment.rascal.ast.NumChar;
import org.meta_environment.rascal.ast.OptCharRanges;
import org.meta_environment.rascal.ast.ShortChar;
import org.meta_environment.rascal.ast.SingleQuotedStrCon;
import org.meta_environment.rascal.ast.StrCon;
import org.meta_environment.rascal.ast.Symbol;
import org.meta_environment.rascal.ast.Type;
import org.meta_environment.rascal.ast.NumChar.Lexical;
import org.meta_environment.rascal.interpreter.asserts.ImplementationError;
import org.meta_environment.rascal.interpreter.asserts.NotYetImplemented;
import org.meta_environment.uptr.Factory;

public class Symbols {
	private static IValueFactory factory = ValueFactoryFactory.getValueFactory();
	
	public static IValue typeToSymbol(Type type) {
		if (type.isUser()) {
			return Factory.Symbol_Cf.make(factory, Factory.Symbol_Sort.make(factory, factory.string(Names.name(type.getUser().getName()))));
		}
		else if (type.isSymbol()) {
			return Factory.Symbol_Cf.make(factory, symbolAST2SymbolConstructor(type.getSymbol()));
		}
			
	    return null;
	}

	private static IValue symbolAST2SymbolConstructor(Symbol symbol) {
		if (symbol.isAlternative()) {
			return Factory.Symbol_Alt.make(factory, symbolAST2SymbolConstructor(symbol.getLhs()), symbolAST2SymbolConstructor(symbol.getRhs()));
		}
		if (symbol.isCaseInsensitiveLiteral()) {
			return Factory.Symbol_CiLit.make(factory, ciliteral2Symbol(symbol.getSingelQuotedString()));
		}
		if (symbol.isCharacterClass()) {
			CharClass cc = symbol.getCharClass();
			return charclass2Symbol(cc);
		}
		if (symbol.isEmpty()) {
			return Factory.Symbol_Empty.make(factory);
		}
		if (symbol.isIter()) {
			return Factory.Symbol_IterPlus.make(factory, symbolAST2SymbolConstructor(symbol.getSymbol()));
		}
		if (symbol.isIterSep()) {
			return Factory.Symbol_IterPlusSep.make(factory, symbolAST2SymbolConstructor(symbol.getSymbol()), literal2Symbol(symbol.getSep()));
		}
		if (symbol.isIterStar()) {
			return Factory.Symbol_IterStar.make(factory, symbolAST2SymbolConstructor(symbol.getSymbol()));
		}
		if (symbol.isIterStarSep()) {
			return Factory.Symbol_IterStarSep.make(factory, symbolAST2SymbolConstructor(symbol.getSymbol()), literal2Symbol(symbol.getSep()));
		}
		if (symbol.isLiteral()) {
			return literal2Symbol(symbol.getString());
		}
		if (symbol.isOptional()) {
			return Factory.Symbol_Opt.make(factory, symbolAST2SymbolConstructor(symbol.getSymbol()));
		}
		if (symbol.isSequence()) {
			return Factory.Symbol_Seq.make(factory, symbols2Symbols(symbol.getHead(), symbol.getTail()));
		}
		if (symbol.isSort()) {
			IString name = factory.string(Names.name(symbol.getName()));
			return Factory.Symbol_Sort.make(factory, name);
		}
		
		return null;
	}

	private static IValue symbols2Symbols(Symbol head, List<Symbol> tail) {
		IListWriter result = factory.listWriter(Factory.Symbol);
		result.insert(symbolAST2SymbolConstructor(head));
		
		for (Symbol elem : tail) {
			result.append(symbolAST2SymbolConstructor(elem));
		}
		
		return result.done();
	}

	private static IValue literal2Symbol(StrCon sep) {
		String lit = ((StrCon.Lexical) sep).getString();
		StringBuilder builder = new StringBuilder();
		
		for (int i = 1; i < lit.length() - 1; i++) {
			if (lit.charAt(i) == '\\') {
				i++;
				switch (lit.charAt(i)) {
				case 'n':
					builder.append('\n');
					break;
				case 't':
					builder.append('\t');
					break;
				case 'r':
					builder.append('\r');
					break;
				case '\\':
					builder.append('\\');
					break;
				case '\"':
					builder.append('\"');
					break;
				default:
					int a = lit.charAt(i++);
					int b = lit.charAt(i++);
					int c = lit.charAt(i);
					builder.append( (char) (100 * a + 10 * b + c));	
				}
			}
			else {
				builder.append(lit.charAt(i));
			}
		}
		
		return Factory.Symbol_Lit.make(factory, factory.string(builder.toString()));
	}
	
	private static IValue ciliteral2Symbol(SingleQuotedStrCon sep) {
		String lit = ((SingleQuotedStrCon.Lexical) sep).getString();
		StringBuilder builder = new StringBuilder();
		
		for (int i = 1; i < lit.length() - 1; i++) {
			if (lit.charAt(i) == '\\') {
				i++;
				switch (lit.charAt(i)) {
				case 'n':
					builder.append('\n');
					break;
				case 't':
					builder.append('\t');
					break;
				case 'r':
					builder.append('\r');
					break;
				case '\\':
					builder.append('\\');
					break;
				case '\"':
					builder.append('\'');
					break;
				default:
					int a = lit.charAt(i++);
					int b = lit.charAt(i++);
					int c = lit.charAt(i);
					builder.append( (char) (100 * a + 10 * b + c));	
				}
			}
			else {
				builder.append(lit.charAt(i));
			}
		}
		
		return Factory.Symbol_Lit.make(factory, factory.string(builder.toString()));
	}

	private static IValue charclass2Symbol(CharClass cc) {
		if (cc.isSimpleCharclass()) {
			OptCharRanges ranges = cc.getOptionalCharRanges();
			
			if (ranges.isAbsent()) {
				return Factory.Symbol_CharClass.make(factory, factory.list());
			}
			return Factory.Symbol_CharClass.make(factory, ranges2Ranges(ranges.getRanges()));
		}
		throw new NotYetImplemented(cc);
	}
	
	private static IList ranges2Ranges(CharRanges ranges) {
		if (ranges.isBracket()) {
			return ranges2Ranges(ranges.getRanges());
		}
		if (ranges.isConcatenate()) {
			return ranges2Ranges(ranges.getLhs()).concat(ranges2Ranges(ranges.getRhs()));
		}
		if (ranges.isRange()) {
			CharRange range = ranges.getRange();
			
			if (range.isCharacter()) {
				IValue ch = char2int(range.getCharacter());
				return factory.list(Factory.CharRange_Single.make(factory, ch));
			}
			else if (range.isRange()) {
				IValue from = char2int(range.getStart());
				IValue to = char2int(range.getEnd());
				return factory.list(Factory.CharRange_Range.make(factory, from, to));
			}
		}
		
		throw new ImplementationError("Unexpected type of ranges: " + ranges);
	}

	private static IValue char2int(Character character) {
		if (character.isBottom()) {
			return factory.integer(0);
		}
		if (character.isEOF()) {
			return factory.integer(256);
		}
		if (character.isNumeric()) {
			NumChar.Lexical num = (Lexical) character.getNumChar();
			Integer i = Integer.parseInt(num.getString().substring(1));
			return factory.integer(i);
		}
		if (character.isShort()) {
			ShortChar.Lexical ch = (org.meta_environment.rascal.ast.ShortChar.Lexical) character.getShortChar();
			String s = ch.getString();
			if (s.startsWith("\\")) {
				char cha = s.charAt(1);
				switch (cha) {
				case 't': return factory.integer(9);
				case 'n': return factory.integer(10);
				case 'r': return factory.integer(13);
				}
				s = s.substring(1);
			}
			char cha = s.charAt(0);
			return factory.integer(cha);
		}
		
		throw new NotYetImplemented(character);
	}
}
