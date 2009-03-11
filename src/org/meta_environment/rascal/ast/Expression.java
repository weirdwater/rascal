package org.meta_environment.rascal.ast;

import org.eclipse.imp.pdb.facts.INode;

public abstract class Expression extends AbstractAST {
	public java.util.List<org.meta_environment.rascal.ast.Statement> getStatements() {
		throw new UnsupportedOperationException();
	}

	public boolean hasStatements() {
		return false;
	}

	public boolean isNonEmptyBlock() {
		return false;
	}

	static public class NonEmptyBlock extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private NonEmptyBlock() {
		}

		/* package */NonEmptyBlock(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Statement> statements) {
			this.node = node;
			this.statements = statements;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionNonEmptyBlock(this);
		}

		@Override
		public boolean isNonEmptyBlock() {
			return true;
		}

		@Override
		public boolean hasStatements() {
			return true;
		}

		private java.util.List<org.meta_environment.rascal.ast.Statement> statements;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Statement> getStatements() {
			return statements;
		}

		private void $setStatements(
				java.util.List<org.meta_environment.rascal.ast.Statement> x) {
			this.statements = x;
		}

		public NonEmptyBlock setStatements(
				java.util.List<org.meta_environment.rascal.ast.Statement> x) {
			NonEmptyBlock z = new NonEmptyBlock();
			z.$setStatements(x);
			return z;
		}
	}

	static public class Ambiguity extends Expression {
		private final java.util.List<org.meta_environment.rascal.ast.Expression> alternatives;

		public Ambiguity(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Expression> alternatives) {
			this.alternatives = java.util.Collections
					.unmodifiableList(alternatives);
			this.node = node;
		}

		public java.util.List<org.meta_environment.rascal.ast.Expression> getAlternatives() {
			return alternatives;
		}

		@Override
		public <T> T accept(IASTVisitor<T> v) {
			return v.visitExpressionAmbiguity(this);
		}
	}

	public org.meta_environment.rascal.ast.Visit getVisit() {
		throw new UnsupportedOperationException();
	}

	public boolean hasVisit() {
		return false;
	}

	public boolean isVisit() {
		return false;
	}

	static public class Visit extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Visit() {
		}

		/* package */Visit(INode node,
				org.meta_environment.rascal.ast.Visit visit) {
			this.node = node;
			this.visit = visit;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionVisit(this);
		}

		@Override
		public boolean isVisit() {
			return true;
		}

		@Override
		public boolean hasVisit() {
			return true;
		}

		private org.meta_environment.rascal.ast.Visit visit;

		@Override
		public org.meta_environment.rascal.ast.Visit getVisit() {
			return visit;
		}

		private void $setVisit(org.meta_environment.rascal.ast.Visit x) {
			this.visit = x;
		}

		public Visit setVisit(org.meta_environment.rascal.ast.Visit x) {
			Visit z = new Visit();
			z.$setVisit(x);
			return z;
		}
	}

	@Override
	public abstract <T> T accept(IASTVisitor<T> visitor);

	public org.meta_environment.rascal.ast.Literal getLiteral() {
		throw new UnsupportedOperationException();
	}

	public boolean hasLiteral() {
		return false;
	}

	public boolean isLiteral() {
		return false;
	}

	static public class Literal extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Literal() {
		}

		/* package */Literal(INode node,
				org.meta_environment.rascal.ast.Literal literal) {
			this.node = node;
			this.literal = literal;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionLiteral(this);
		}

		@Override
		public boolean isLiteral() {
			return true;
		}

		@Override
		public boolean hasLiteral() {
			return true;
		}

		private org.meta_environment.rascal.ast.Literal literal;

		@Override
		public org.meta_environment.rascal.ast.Literal getLiteral() {
			return literal;
		}

		private void $setLiteral(org.meta_environment.rascal.ast.Literal x) {
			this.literal = x;
		}

		public Literal setLiteral(org.meta_environment.rascal.ast.Literal x) {
			Literal z = new Literal();
			z.$setLiteral(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.QualifiedName getQualifiedName() {
		throw new UnsupportedOperationException();
	}

	public java.util.List<org.meta_environment.rascal.ast.Expression> getArguments() {
		throw new UnsupportedOperationException();
	}

	public boolean hasQualifiedName() {
		return false;
	}

	public boolean hasArguments() {
		return false;
	}

	public boolean isCallOrTree() {
		return false;
	}

	static public class CallOrTree extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private CallOrTree() {
		}

		/* package */CallOrTree(
				INode node,
				org.meta_environment.rascal.ast.QualifiedName qualifiedName,
				java.util.List<org.meta_environment.rascal.ast.Expression> arguments) {
			this.node = node;
			this.qualifiedName = qualifiedName;
			this.arguments = arguments;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionCallOrTree(this);
		}

		@Override
		public boolean isCallOrTree() {
			return true;
		}

		@Override
		public boolean hasQualifiedName() {
			return true;
		}

		@Override
		public boolean hasArguments() {
			return true;
		}

		private org.meta_environment.rascal.ast.QualifiedName qualifiedName;

		@Override
		public org.meta_environment.rascal.ast.QualifiedName getQualifiedName() {
			return qualifiedName;
		}

		private void $setQualifiedName(
				org.meta_environment.rascal.ast.QualifiedName x) {
			this.qualifiedName = x;
		}

		public CallOrTree setQualifiedName(
				org.meta_environment.rascal.ast.QualifiedName x) {
			CallOrTree z = new CallOrTree();
			z.$setQualifiedName(x);
			return z;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> arguments;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getArguments() {
			return arguments;
		}

		private void $setArguments(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.arguments = x;
		}

		public CallOrTree setArguments(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			CallOrTree z = new CallOrTree();
			z.$setArguments(x);
			return z;
		}
	}

	public java.util.List<org.meta_environment.rascal.ast.Expression> getElements() {
		throw new UnsupportedOperationException();
	}

	public boolean hasElements() {
		return false;
	}

	public boolean isList() {
		return false;
	}

	static public class List extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private List() {
		}

		/* package */List(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Expression> elements) {
			this.node = node;
			this.elements = elements;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionList(this);
		}

		@Override
		public boolean isList() {
			return true;
		}

		@Override
		public boolean hasElements() {
			return true;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> elements;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getElements() {
			return elements;
		}

		private void $setElements(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.elements = x;
		}

		public List setElements(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			List z = new List();
			z.$setElements(x);
			return z;
		}
	}

	public boolean isSet() {
		return false;
	}

	static public class Set extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Set() {
		}

		/* package */Set(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Expression> elements) {
			this.node = node;
			this.elements = elements;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionSet(this);
		}

		@Override
		public boolean isSet() {
			return true;
		}

		@Override
		public boolean hasElements() {
			return true;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> elements;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getElements() {
			return elements;
		}

		private void $setElements(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.elements = x;
		}

		public Set setElements(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			Set z = new Set();
			z.$setElements(x);
			return z;
		}
	}

	public boolean isTuple() {
		return false;
	}

	static public class Tuple extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Tuple() {
		}

		/* package */Tuple(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Expression> elements) {
			this.node = node;
			this.elements = elements;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionTuple(this);
		}

		@Override
		public boolean isTuple() {
			return true;
		}

		@Override
		public boolean hasElements() {
			return true;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> elements;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getElements() {
			return elements;
		}

		private void $setElements(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.elements = x;
		}

		public Tuple setElements(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			Tuple z = new Tuple();
			z.$setElements(x);
			return z;
		}
	}

	public java.util.List<org.meta_environment.rascal.ast.Mapping> getMappings() {
		throw new UnsupportedOperationException();
	}

	public boolean hasMappings() {
		return false;
	}

	public boolean isMap() {
		return false;
	}

	static public class Map extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Map() {
		}

		/* package */Map(INode node,
				java.util.List<org.meta_environment.rascal.ast.Mapping> mappings) {
			this.node = node;
			this.mappings = mappings;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionMap(this);
		}

		@Override
		public boolean isMap() {
			return true;
		}

		@Override
		public boolean hasMappings() {
			return true;
		}

		private java.util.List<org.meta_environment.rascal.ast.Mapping> mappings;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Mapping> getMappings() {
			return mappings;
		}

		private void $setMappings(
				java.util.List<org.meta_environment.rascal.ast.Mapping> x) {
			this.mappings = x;
		}

		public Map setMappings(
				java.util.List<org.meta_environment.rascal.ast.Mapping> x) {
			Map z = new Map();
			z.$setMappings(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.URL getUrl() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getOffset() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getLength() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getBeginLine() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getBeginColumn() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getEndLine() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getEndColumn() {
		throw new UnsupportedOperationException();
	}

	public boolean hasUrl() {
		return false;
	}

	public boolean hasOffset() {
		return false;
	}

	public boolean hasLength() {
		return false;
	}

	public boolean hasBeginLine() {
		return false;
	}

	public boolean hasBeginColumn() {
		return false;
	}

	public boolean hasEndLine() {
		return false;
	}

	public boolean hasEndColumn() {
		return false;
	}

	public boolean isLocation() {
		return false;
	}

	static public class Location extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Location() {
		}

		/* package */Location(INode node,
				org.meta_environment.rascal.ast.URL url,
				org.meta_environment.rascal.ast.Expression offset,
				org.meta_environment.rascal.ast.Expression length,
				org.meta_environment.rascal.ast.Expression beginLine,
				org.meta_environment.rascal.ast.Expression beginColumn,
				org.meta_environment.rascal.ast.Expression endLine,
				org.meta_environment.rascal.ast.Expression endColumn) {
			this.node = node;
			this.url = url;
			this.offset = offset;
			this.length = length;
			this.beginLine = beginLine;
			this.beginColumn = beginColumn;
			this.endLine = endLine;
			this.endColumn = endColumn;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionLocation(this);
		}

		@Override
		public boolean isLocation() {
			return true;
		}

		@Override
		public boolean hasUrl() {
			return true;
		}

		@Override
		public boolean hasOffset() {
			return true;
		}

		@Override
		public boolean hasLength() {
			return true;
		}

		@Override
		public boolean hasBeginLine() {
			return true;
		}

		@Override
		public boolean hasBeginColumn() {
			return true;
		}

		@Override
		public boolean hasEndLine() {
			return true;
		}

		@Override
		public boolean hasEndColumn() {
			return true;
		}

		private org.meta_environment.rascal.ast.URL url;

		@Override
		public org.meta_environment.rascal.ast.URL getUrl() {
			return url;
		}

		private void $setUrl(org.meta_environment.rascal.ast.URL x) {
			this.url = x;
		}

		public Location setUrl(org.meta_environment.rascal.ast.URL x) {
			Location z = new Location();
			z.$setUrl(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression offset;

		@Override
		public org.meta_environment.rascal.ast.Expression getOffset() {
			return offset;
		}

		private void $setOffset(org.meta_environment.rascal.ast.Expression x) {
			this.offset = x;
		}

		public Location setOffset(org.meta_environment.rascal.ast.Expression x) {
			Location z = new Location();
			z.$setOffset(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression length;

		@Override
		public org.meta_environment.rascal.ast.Expression getLength() {
			return length;
		}

		private void $setLength(org.meta_environment.rascal.ast.Expression x) {
			this.length = x;
		}

		public Location setLength(org.meta_environment.rascal.ast.Expression x) {
			Location z = new Location();
			z.$setLength(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression beginLine;

		@Override
		public org.meta_environment.rascal.ast.Expression getBeginLine() {
			return beginLine;
		}

		private void $setBeginLine(org.meta_environment.rascal.ast.Expression x) {
			this.beginLine = x;
		}

		public Location setBeginLine(
				org.meta_environment.rascal.ast.Expression x) {
			Location z = new Location();
			z.$setBeginLine(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression beginColumn;

		@Override
		public org.meta_environment.rascal.ast.Expression getBeginColumn() {
			return beginColumn;
		}

		private void $setBeginColumn(
				org.meta_environment.rascal.ast.Expression x) {
			this.beginColumn = x;
		}

		public Location setBeginColumn(
				org.meta_environment.rascal.ast.Expression x) {
			Location z = new Location();
			z.$setBeginColumn(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression endLine;

		@Override
		public org.meta_environment.rascal.ast.Expression getEndLine() {
			return endLine;
		}

		private void $setEndLine(org.meta_environment.rascal.ast.Expression x) {
			this.endLine = x;
		}

		public Location setEndLine(org.meta_environment.rascal.ast.Expression x) {
			Location z = new Location();
			z.$setEndLine(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression endColumn;

		@Override
		public org.meta_environment.rascal.ast.Expression getEndColumn() {
			return endColumn;
		}

		private void $setEndColumn(org.meta_environment.rascal.ast.Expression x) {
			this.endColumn = x;
		}

		public Location setEndColumn(
				org.meta_environment.rascal.ast.Expression x) {
			Location z = new Location();
			z.$setEndColumn(x);
			return z;
		}
	}

	public boolean isQualifiedName() {
		return false;
	}

	static public class QualifiedName extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private QualifiedName() {
		}

		/* package */QualifiedName(INode node,
				org.meta_environment.rascal.ast.QualifiedName qualifiedName) {
			this.node = node;
			this.qualifiedName = qualifiedName;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionQualifiedName(this);
		}

		@Override
		public boolean isQualifiedName() {
			return true;
		}

		@Override
		public boolean hasQualifiedName() {
			return true;
		}

		private org.meta_environment.rascal.ast.QualifiedName qualifiedName;

		@Override
		public org.meta_environment.rascal.ast.QualifiedName getQualifiedName() {
			return qualifiedName;
		}

		private void $setQualifiedName(
				org.meta_environment.rascal.ast.QualifiedName x) {
			this.qualifiedName = x;
		}

		public QualifiedName setQualifiedName(
				org.meta_environment.rascal.ast.QualifiedName x) {
			QualifiedName z = new QualifiedName();
			z.$setQualifiedName(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Type getType() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Name getName() {
		throw new UnsupportedOperationException();
	}

	public boolean hasType() {
		return false;
	}

	public boolean hasName() {
		return false;
	}

	public boolean isTypedVariable() {
		return false;
	}

	static public class TypedVariable extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private TypedVariable() {
		}

		/* package */TypedVariable(INode node,
				org.meta_environment.rascal.ast.Type type,
				org.meta_environment.rascal.ast.Name name) {
			this.node = node;
			this.type = type;
			this.name = name;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionTypedVariable(this);
		}

		@Override
		public boolean isTypedVariable() {
			return true;
		}

		@Override
		public boolean hasType() {
			return true;
		}

		@Override
		public boolean hasName() {
			return true;
		}

		private org.meta_environment.rascal.ast.Type type;

		@Override
		public org.meta_environment.rascal.ast.Type getType() {
			return type;
		}

		private void $setType(org.meta_environment.rascal.ast.Type x) {
			this.type = x;
		}

		public TypedVariable setType(org.meta_environment.rascal.ast.Type x) {
			TypedVariable z = new TypedVariable();
			z.$setType(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Name name;

		@Override
		public org.meta_environment.rascal.ast.Name getName() {
			return name;
		}

		private void $setName(org.meta_environment.rascal.ast.Name x) {
			this.name = x;
		}

		public TypedVariable setName(org.meta_environment.rascal.ast.Name x) {
			TypedVariable z = new TypedVariable();
			z.$setName(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Expression getCondition() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getThenExp() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getElseExp() {
		throw new UnsupportedOperationException();
	}

	public boolean hasCondition() {
		return false;
	}

	public boolean hasThenExp() {
		return false;
	}

	public boolean hasElseExp() {
		return false;
	}

	public boolean isIfThenElse() {
		return false;
	}

	static public class IfThenElse extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private IfThenElse() {
		}

		/* package */IfThenElse(INode node,
				org.meta_environment.rascal.ast.Expression condition,
				org.meta_environment.rascal.ast.Expression thenExp,
				org.meta_environment.rascal.ast.Expression elseExp) {
			this.node = node;
			this.condition = condition;
			this.thenExp = thenExp;
			this.elseExp = elseExp;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionIfThenElse(this);
		}

		@Override
		public boolean isIfThenElse() {
			return true;
		}

		@Override
		public boolean hasCondition() {
			return true;
		}

		@Override
		public boolean hasThenExp() {
			return true;
		}

		@Override
		public boolean hasElseExp() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression condition;

		@Override
		public org.meta_environment.rascal.ast.Expression getCondition() {
			return condition;
		}

		private void $setCondition(org.meta_environment.rascal.ast.Expression x) {
			this.condition = x;
		}

		public IfThenElse setCondition(
				org.meta_environment.rascal.ast.Expression x) {
			IfThenElse z = new IfThenElse();
			z.$setCondition(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression thenExp;

		@Override
		public org.meta_environment.rascal.ast.Expression getThenExp() {
			return thenExp;
		}

		private void $setThenExp(org.meta_environment.rascal.ast.Expression x) {
			this.thenExp = x;
		}

		public IfThenElse setThenExp(
				org.meta_environment.rascal.ast.Expression x) {
			IfThenElse z = new IfThenElse();
			z.$setThenExp(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression elseExp;

		@Override
		public org.meta_environment.rascal.ast.Expression getElseExp() {
			return elseExp;
		}

		private void $setElseExp(org.meta_environment.rascal.ast.Expression x) {
			this.elseExp = x;
		}

		public IfThenElse setElseExp(
				org.meta_environment.rascal.ast.Expression x) {
			IfThenElse z = new IfThenElse();
			z.$setElseExp(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Expression getPattern() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getExpression() {
		throw new UnsupportedOperationException();
	}

	public boolean hasPattern() {
		return false;
	}

	public boolean hasExpression() {
		return false;
	}

	public boolean isMatch() {
		return false;
	}

	static public class Match extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Match() {
		}

		/* package */Match(INode node,
				org.meta_environment.rascal.ast.Expression pattern,
				org.meta_environment.rascal.ast.Expression expression) {
			this.node = node;
			this.pattern = pattern;
			this.expression = expression;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionMatch(this);
		}

		@Override
		public boolean isMatch() {
			return true;
		}

		@Override
		public boolean hasPattern() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression pattern;

		@Override
		public org.meta_environment.rascal.ast.Expression getPattern() {
			return pattern;
		}

		private void $setPattern(org.meta_environment.rascal.ast.Expression x) {
			this.pattern = x;
		}

		public Match setPattern(org.meta_environment.rascal.ast.Expression x) {
			Match z = new Match();
			z.$setPattern(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public Match setExpression(org.meta_environment.rascal.ast.Expression x) {
			Match z = new Match();
			z.$setExpression(x);
			return z;
		}
	}

	public boolean isNoMatch() {
		return false;
	}

	static public class NoMatch extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private NoMatch() {
		}

		/* package */NoMatch(INode node,
				org.meta_environment.rascal.ast.Expression pattern,
				org.meta_environment.rascal.ast.Expression expression) {
			this.node = node;
			this.pattern = pattern;
			this.expression = expression;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionNoMatch(this);
		}

		@Override
		public boolean isNoMatch() {
			return true;
		}

		@Override
		public boolean hasPattern() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression pattern;

		@Override
		public org.meta_environment.rascal.ast.Expression getPattern() {
			return pattern;
		}

		private void $setPattern(org.meta_environment.rascal.ast.Expression x) {
			this.pattern = x;
		}

		public NoMatch setPattern(org.meta_environment.rascal.ast.Expression x) {
			NoMatch z = new NoMatch();
			z.$setPattern(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public NoMatch setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			NoMatch z = new NoMatch();
			z.$setExpression(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Expression getLhs() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getRhs() {
		throw new UnsupportedOperationException();
	}

	public boolean hasLhs() {
		return false;
	}

	public boolean hasRhs() {
		return false;
	}

	public boolean isEquals() {
		return false;
	}

	static public class Equals extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Equals() {
		}

		/* package */Equals(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionEquals(this);
		}

		@Override
		public boolean isEquals() {
			return true;
		}

		@Override
		public boolean hasLhs() {
			return true;
		}

		@Override
		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		@Override
		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Equals setLhs(org.meta_environment.rascal.ast.Expression x) {
			Equals z = new Equals();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		@Override
		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Equals setRhs(org.meta_environment.rascal.ast.Expression x) {
			Equals z = new Equals();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isValueProducer() {
		return false;
	}

	static public class ValueProducer extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private ValueProducer() {
		}

		/* package */ValueProducer(INode node,
				org.meta_environment.rascal.ast.Expression pattern,
				org.meta_environment.rascal.ast.Expression expression) {
			this.node = node;
			this.pattern = pattern;
			this.expression = expression;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionValueProducer(this);
		}

		@Override
		public boolean isValueProducer() {
			return true;
		}

		@Override
		public boolean hasPattern() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression pattern;

		@Override
		public org.meta_environment.rascal.ast.Expression getPattern() {
			return pattern;
		}

		private void $setPattern(org.meta_environment.rascal.ast.Expression x) {
			this.pattern = x;
		}

		public ValueProducer setPattern(
				org.meta_environment.rascal.ast.Expression x) {
			ValueProducer z = new ValueProducer();
			z.$setPattern(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public ValueProducer setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			ValueProducer z = new ValueProducer();
			z.$setExpression(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Strategy getStrategy() {
		throw new UnsupportedOperationException();
	}

	public boolean hasStrategy() {
		return false;
	}

	public boolean isValueProducerWithStrategy() {
		return false;
	}

	static public class ValueProducerWithStrategy extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private ValueProducerWithStrategy() {
		}

		/* package */ValueProducerWithStrategy(INode node,
				org.meta_environment.rascal.ast.Strategy strategy,
				org.meta_environment.rascal.ast.Expression pattern,
				org.meta_environment.rascal.ast.Expression expression) {
			this.node = node;
			this.strategy = strategy;
			this.pattern = pattern;
			this.expression = expression;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionValueProducerWithStrategy(this);
		}

		@Override
		public boolean isValueProducerWithStrategy() {
			return true;
		}

		@Override
		public boolean hasStrategy() {
			return true;
		}

		@Override
		public boolean hasPattern() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		private org.meta_environment.rascal.ast.Strategy strategy;

		@Override
		public org.meta_environment.rascal.ast.Strategy getStrategy() {
			return strategy;
		}

		private void $setStrategy(org.meta_environment.rascal.ast.Strategy x) {
			this.strategy = x;
		}

		public ValueProducerWithStrategy setStrategy(
				org.meta_environment.rascal.ast.Strategy x) {
			ValueProducerWithStrategy z = new ValueProducerWithStrategy();
			z.$setStrategy(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression pattern;

		@Override
		public org.meta_environment.rascal.ast.Expression getPattern() {
			return pattern;
		}

		private void $setPattern(org.meta_environment.rascal.ast.Expression x) {
			this.pattern = x;
		}

		public ValueProducerWithStrategy setPattern(
				org.meta_environment.rascal.ast.Expression x) {
			ValueProducerWithStrategy z = new ValueProducerWithStrategy();
			z.$setPattern(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public ValueProducerWithStrategy setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			ValueProducerWithStrategy z = new ValueProducerWithStrategy();
			z.$setExpression(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Comprehension getComprehension() {
		throw new UnsupportedOperationException();
	}

	public boolean hasComprehension() {
		return false;
	}

	public boolean isComprehension() {
		return false;
	}

	static public class Comprehension extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Comprehension() {
		}

		/* package */Comprehension(INode node,
				org.meta_environment.rascal.ast.Comprehension comprehension) {
			this.node = node;
			this.comprehension = comprehension;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionComprehension(this);
		}

		@Override
		public boolean isComprehension() {
			return true;
		}

		@Override
		public boolean hasComprehension() {
			return true;
		}

		private org.meta_environment.rascal.ast.Comprehension comprehension;

		@Override
		public org.meta_environment.rascal.ast.Comprehension getComprehension() {
			return comprehension;
		}

		private void $setComprehension(
				org.meta_environment.rascal.ast.Comprehension x) {
			this.comprehension = x;
		}

		public Comprehension setComprehension(
				org.meta_environment.rascal.ast.Comprehension x) {
			Comprehension z = new Comprehension();
			z.$setComprehension(x);
			return z;
		}
	}

	public java.util.List<org.meta_environment.rascal.ast.Expression> getGenerators() {
		throw new UnsupportedOperationException();
	}

	public boolean hasGenerators() {
		return false;
	}

	public boolean isAll() {
		return false;
	}

	static public class All extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private All() {
		}

		/* package */All(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Expression> generators) {
			this.node = node;
			this.generators = generators;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionAll(this);
		}

		@Override
		public boolean isAll() {
			return true;
		}

		@Override
		public boolean hasGenerators() {
			return true;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> generators;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getGenerators() {
			return generators;
		}

		private void $setGenerators(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.generators = x;
		}

		public All setGenerators(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			All z = new All();
			z.$setGenerators(x);
			return z;
		}
	}

	public boolean isAny() {
		return false;
	}

	static public class Any extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Any() {
		}

		/* package */Any(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Expression> generators) {
			this.node = node;
			this.generators = generators;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionAny(this);
		}

		@Override
		public boolean isAny() {
			return true;
		}

		@Override
		public boolean hasGenerators() {
			return true;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> generators;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getGenerators() {
			return generators;
		}

		private void $setGenerators(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.generators = x;
		}

		public Any setGenerators(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			Any z = new Any();
			z.$setGenerators(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Parameters getParameters() {
		throw new UnsupportedOperationException();
	}

	public boolean hasParameters() {
		return false;
	}

	public boolean isClosure() {
		return false;
	}

	static public class Closure extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Closure() {
		}

		/* package */Closure(
				INode node,
				org.meta_environment.rascal.ast.Type type,
				org.meta_environment.rascal.ast.Parameters parameters,
				java.util.List<org.meta_environment.rascal.ast.Statement> statements) {
			this.node = node;
			this.type = type;
			this.parameters = parameters;
			this.statements = statements;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionClosure(this);
		}

		@Override
		public boolean isClosure() {
			return true;
		}

		@Override
		public boolean hasType() {
			return true;
		}

		@Override
		public boolean hasParameters() {
			return true;
		}

		@Override
		public boolean hasStatements() {
			return true;
		}

		private org.meta_environment.rascal.ast.Type type;

		@Override
		public org.meta_environment.rascal.ast.Type getType() {
			return type;
		}

		private void $setType(org.meta_environment.rascal.ast.Type x) {
			this.type = x;
		}

		public Closure setType(org.meta_environment.rascal.ast.Type x) {
			Closure z = new Closure();
			z.$setType(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Parameters parameters;

		@Override
		public org.meta_environment.rascal.ast.Parameters getParameters() {
			return parameters;
		}

		private void $setParameters(org.meta_environment.rascal.ast.Parameters x) {
			this.parameters = x;
		}

		public Closure setParameters(
				org.meta_environment.rascal.ast.Parameters x) {
			Closure z = new Closure();
			z.$setParameters(x);
			return z;
		}

		private java.util.List<org.meta_environment.rascal.ast.Statement> statements;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Statement> getStatements() {
			return statements;
		}

		private void $setStatements(
				java.util.List<org.meta_environment.rascal.ast.Statement> x) {
			this.statements = x;
		}

		public Closure setStatements(
				java.util.List<org.meta_environment.rascal.ast.Statement> x) {
			Closure z = new Closure();
			z.$setStatements(x);
			return z;
		}
	}

	public boolean isVoidClosure() {
		return false;
	}

	static public class VoidClosure extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private VoidClosure() {
		}

		/* package */VoidClosure(
				INode node,
				org.meta_environment.rascal.ast.Parameters parameters,
				java.util.List<org.meta_environment.rascal.ast.Statement> statements) {
			this.node = node;
			this.parameters = parameters;
			this.statements = statements;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionVoidClosure(this);
		}

		@Override
		public boolean isVoidClosure() {
			return true;
		}

		@Override
		public boolean hasParameters() {
			return true;
		}

		@Override
		public boolean hasStatements() {
			return true;
		}

		private org.meta_environment.rascal.ast.Parameters parameters;

		@Override
		public org.meta_environment.rascal.ast.Parameters getParameters() {
			return parameters;
		}

		private void $setParameters(org.meta_environment.rascal.ast.Parameters x) {
			this.parameters = x;
		}

		public VoidClosure setParameters(
				org.meta_environment.rascal.ast.Parameters x) {
			VoidClosure z = new VoidClosure();
			z.$setParameters(x);
			return z;
		}

		private java.util.List<org.meta_environment.rascal.ast.Statement> statements;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Statement> getStatements() {
			return statements;
		}

		private void $setStatements(
				java.util.List<org.meta_environment.rascal.ast.Statement> x) {
			this.statements = x;
		}

		public VoidClosure setStatements(
				java.util.List<org.meta_environment.rascal.ast.Statement> x) {
			VoidClosure z = new VoidClosure();
			z.$setStatements(x);
			return z;
		}
	}

	public boolean isBracket() {
		return false;
	}

	static public class Bracket extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Bracket() {
		}

		/* package */Bracket(INode node,
				org.meta_environment.rascal.ast.Expression expression) {
			this.node = node;
			this.expression = expression;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionBracket(this);
		}

		@Override
		public boolean isBracket() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public Bracket setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			Bracket z = new Bracket();
			z.$setExpression(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Expression getFirst() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getLast() {
		throw new UnsupportedOperationException();
	}

	public boolean hasFirst() {
		return false;
	}

	public boolean hasLast() {
		return false;
	}

	public boolean isRange() {
		return false;
	}

	static public class Range extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Range() {
		}

		/* package */Range(INode node,
				org.meta_environment.rascal.ast.Expression first,
				org.meta_environment.rascal.ast.Expression last) {
			this.node = node;
			this.first = first;
			this.last = last;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionRange(this);
		}

		@Override
		public boolean isRange() {
			return true;
		}

		@Override
		public boolean hasFirst() {
			return true;
		}

		@Override
		public boolean hasLast() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression first;

		@Override
		public org.meta_environment.rascal.ast.Expression getFirst() {
			return first;
		}

		private void $setFirst(org.meta_environment.rascal.ast.Expression x) {
			this.first = x;
		}

		public Range setFirst(org.meta_environment.rascal.ast.Expression x) {
			Range z = new Range();
			z.$setFirst(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression last;

		@Override
		public org.meta_environment.rascal.ast.Expression getLast() {
			return last;
		}

		private void $setLast(org.meta_environment.rascal.ast.Expression x) {
			this.last = x;
		}

		public Range setLast(org.meta_environment.rascal.ast.Expression x) {
			Range z = new Range();
			z.$setLast(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Expression getSecond() {
		throw new UnsupportedOperationException();
	}

	public boolean hasSecond() {
		return false;
	}

	public boolean isStepRange() {
		return false;
	}

	static public class StepRange extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private StepRange() {
		}

		/* package */StepRange(INode node,
				org.meta_environment.rascal.ast.Expression first,
				org.meta_environment.rascal.ast.Expression second,
				org.meta_environment.rascal.ast.Expression last) {
			this.node = node;
			this.first = first;
			this.second = second;
			this.last = last;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionStepRange(this);
		}

		@Override
		public boolean isStepRange() {
			return true;
		}

		@Override
		public boolean hasFirst() {
			return true;
		}

		@Override
		public boolean hasSecond() {
			return true;
		}

		@Override
		public boolean hasLast() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression first;

		@Override
		public org.meta_environment.rascal.ast.Expression getFirst() {
			return first;
		}

		private void $setFirst(org.meta_environment.rascal.ast.Expression x) {
			this.first = x;
		}

		public StepRange setFirst(org.meta_environment.rascal.ast.Expression x) {
			StepRange z = new StepRange();
			z.$setFirst(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression second;

		@Override
		public org.meta_environment.rascal.ast.Expression getSecond() {
			return second;
		}

		private void $setSecond(org.meta_environment.rascal.ast.Expression x) {
			this.second = x;
		}

		public StepRange setSecond(org.meta_environment.rascal.ast.Expression x) {
			StepRange z = new StepRange();
			z.$setSecond(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression last;

		@Override
		public org.meta_environment.rascal.ast.Expression getLast() {
			return last;
		}

		private void $setLast(org.meta_environment.rascal.ast.Expression x) {
			this.last = x;
		}

		public StepRange setLast(org.meta_environment.rascal.ast.Expression x) {
			StepRange z = new StepRange();
			z.$setLast(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.OperatorAsValue getOperator() {
		throw new UnsupportedOperationException();
	}

	public boolean hasOperator() {
		return false;
	}

	public boolean isOperatorAsValue() {
		return false;
	}

	static public class OperatorAsValue extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private OperatorAsValue() {
		}

		/* package */OperatorAsValue(INode node,
				org.meta_environment.rascal.ast.OperatorAsValue operator) {
			this.node = node;
			this.operator = operator;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionOperatorAsValue(this);
		}

		@Override
		public boolean isOperatorAsValue() {
			return true;
		}

		@Override
		public boolean hasOperator() {
			return true;
		}

		private org.meta_environment.rascal.ast.OperatorAsValue operator;

		@Override
		public org.meta_environment.rascal.ast.OperatorAsValue getOperator() {
			return operator;
		}

		private void $setOperator(
				org.meta_environment.rascal.ast.OperatorAsValue x) {
			this.operator = x;
		}

		public OperatorAsValue setOperator(
				org.meta_environment.rascal.ast.OperatorAsValue x) {
			OperatorAsValue z = new OperatorAsValue();
			z.$setOperator(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.FunctionAsValue getFunction() {
		throw new UnsupportedOperationException();
	}

	public boolean hasFunction() {
		return false;
	}

	public boolean isFunctionAsValue() {
		return false;
	}

	static public class FunctionAsValue extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private FunctionAsValue() {
		}

		/* package */FunctionAsValue(INode node,
				org.meta_environment.rascal.ast.FunctionAsValue function) {
			this.node = node;
			this.function = function;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionFunctionAsValue(this);
		}

		@Override
		public boolean isFunctionAsValue() {
			return true;
		}

		@Override
		public boolean hasFunction() {
			return true;
		}

		private org.meta_environment.rascal.ast.FunctionAsValue function;

		@Override
		public org.meta_environment.rascal.ast.FunctionAsValue getFunction() {
			return function;
		}

		private void $setFunction(
				org.meta_environment.rascal.ast.FunctionAsValue x) {
			this.function = x;
		}

		public FunctionAsValue setFunction(
				org.meta_environment.rascal.ast.FunctionAsValue x) {
			FunctionAsValue z = new FunctionAsValue();
			z.$setFunction(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.ClosureAsFunction getClosure() {
		throw new UnsupportedOperationException();
	}

	public boolean hasClosure() {
		return false;
	}

	public boolean isClosureCall() {
		return false;
	}

	static public class ClosureCall extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private ClosureCall() {
		}

		/* package */ClosureCall(
				INode node,
				org.meta_environment.rascal.ast.ClosureAsFunction closure,
				java.util.List<org.meta_environment.rascal.ast.Expression> arguments) {
			this.node = node;
			this.closure = closure;
			this.arguments = arguments;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionClosureCall(this);
		}

		@Override
		public boolean isClosureCall() {
			return true;
		}

		@Override
		public boolean hasClosure() {
			return true;
		}

		@Override
		public boolean hasArguments() {
			return true;
		}

		private org.meta_environment.rascal.ast.ClosureAsFunction closure;

		@Override
		public org.meta_environment.rascal.ast.ClosureAsFunction getClosure() {
			return closure;
		}

		private void $setClosure(
				org.meta_environment.rascal.ast.ClosureAsFunction x) {
			this.closure = x;
		}

		public ClosureCall setClosure(
				org.meta_environment.rascal.ast.ClosureAsFunction x) {
			ClosureCall z = new ClosureCall();
			z.$setClosure(x);
			return z;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> arguments;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getArguments() {
			return arguments;
		}

		private void $setArguments(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.arguments = x;
		}

		public ClosureCall setArguments(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			ClosureCall z = new ClosureCall();
			z.$setArguments(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Name getKey() {
		throw new UnsupportedOperationException();
	}

	public org.meta_environment.rascal.ast.Expression getReplacement() {
		throw new UnsupportedOperationException();
	}

	public boolean hasKey() {
		return false;
	}

	public boolean hasReplacement() {
		return false;
	}

	public boolean isFieldUpdate() {
		return false;
	}

	static public class FieldUpdate extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private FieldUpdate() {
		}

		/* package */FieldUpdate(INode node,
				org.meta_environment.rascal.ast.Expression expression,
				org.meta_environment.rascal.ast.Name key,
				org.meta_environment.rascal.ast.Expression replacement) {
			this.node = node;
			this.expression = expression;
			this.key = key;
			this.replacement = replacement;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionFieldUpdate(this);
		}

		@Override
		public boolean isFieldUpdate() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		@Override
		public boolean hasKey() {
			return true;
		}

		@Override
		public boolean hasReplacement() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public FieldUpdate setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			FieldUpdate z = new FieldUpdate();
			z.$setExpression(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Name key;

		@Override
		public org.meta_environment.rascal.ast.Name getKey() {
			return key;
		}

		private void $setKey(org.meta_environment.rascal.ast.Name x) {
			this.key = x;
		}

		public FieldUpdate setKey(org.meta_environment.rascal.ast.Name x) {
			FieldUpdate z = new FieldUpdate();
			z.$setKey(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression replacement;

		@Override
		public org.meta_environment.rascal.ast.Expression getReplacement() {
			return replacement;
		}

		private void $setReplacement(
				org.meta_environment.rascal.ast.Expression x) {
			this.replacement = x;
		}

		public FieldUpdate setReplacement(
				org.meta_environment.rascal.ast.Expression x) {
			FieldUpdate z = new FieldUpdate();
			z.$setReplacement(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Name getField() {
		throw new UnsupportedOperationException();
	}

	public boolean hasField() {
		return false;
	}

	public boolean isFieldAccess() {
		return false;
	}

	static public class FieldAccess extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private FieldAccess() {
		}

		/* package */FieldAccess(INode node,
				org.meta_environment.rascal.ast.Expression expression,
				org.meta_environment.rascal.ast.Name field) {
			this.node = node;
			this.expression = expression;
			this.field = field;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionFieldAccess(this);
		}

		@Override
		public boolean isFieldAccess() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		@Override
		public boolean hasField() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public FieldAccess setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			FieldAccess z = new FieldAccess();
			z.$setExpression(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Name field;

		@Override
		public org.meta_environment.rascal.ast.Name getField() {
			return field;
		}

		private void $setField(org.meta_environment.rascal.ast.Name x) {
			this.field = x;
		}

		public FieldAccess setField(org.meta_environment.rascal.ast.Name x) {
			FieldAccess z = new FieldAccess();
			z.$setField(x);
			return z;
		}
	}

	public java.util.List<org.meta_environment.rascal.ast.Field> getFields() {
		throw new UnsupportedOperationException();
	}

	public boolean hasFields() {
		return false;
	}

	public boolean isFieldProject() {
		return false;
	}

	static public class FieldProject extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private FieldProject() {
		}

		/* package */FieldProject(INode node,
				org.meta_environment.rascal.ast.Expression expression,
				java.util.List<org.meta_environment.rascal.ast.Field> fields) {
			this.node = node;
			this.expression = expression;
			this.fields = fields;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionFieldProject(this);
		}

		@Override
		public boolean isFieldProject() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		@Override
		public boolean hasFields() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public FieldProject setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			FieldProject z = new FieldProject();
			z.$setExpression(x);
			return z;
		}

		private java.util.List<org.meta_environment.rascal.ast.Field> fields;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Field> getFields() {
			return fields;
		}

		private void $setFields(
				java.util.List<org.meta_environment.rascal.ast.Field> x) {
			this.fields = x;
		}

		public FieldProject setFields(
				java.util.List<org.meta_environment.rascal.ast.Field> x) {
			FieldProject z = new FieldProject();
			z.$setFields(x);
			return z;
		}
	}

	public java.util.List<org.meta_environment.rascal.ast.Expression> getSubscripts() {
		throw new UnsupportedOperationException();
	}

	public boolean hasSubscripts() {
		return false;
	}

	public boolean isSubscript() {
		return false;
	}

	static public class Subscript extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Subscript() {
		}

		/* package */Subscript(
				INode node,
				org.meta_environment.rascal.ast.Expression expression,
				java.util.List<org.meta_environment.rascal.ast.Expression> subscripts) {
			this.node = node;
			this.expression = expression;
			this.subscripts = subscripts;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionSubscript(this);
		}

		@Override
		public boolean isSubscript() {
			return true;
		}

		@Override
		public boolean hasExpression() {
			return true;
		}

		@Override
		public boolean hasSubscripts() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		@Override
		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public Subscript setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			Subscript z = new Subscript();
			z.$setExpression(x);
			return z;
		}

		private java.util.List<org.meta_environment.rascal.ast.Expression> subscripts;

		@Override
		public java.util.List<org.meta_environment.rascal.ast.Expression> getSubscripts() {
			return subscripts;
		}

		private void $setSubscripts(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			this.subscripts = x;
		}

		public Subscript setSubscripts(
				java.util.List<org.meta_environment.rascal.ast.Expression> x) {
			Subscript z = new Subscript();
			z.$setSubscripts(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Expression getArgument() {
		throw new UnsupportedOperationException();
	}

	public boolean hasArgument() {
		return false;
	}

	public boolean isIsDefined() {
		return false;
	}

	static public class IsDefined extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private IsDefined() {
		}

		/* package */IsDefined(INode node,
				org.meta_environment.rascal.ast.Expression argument) {
			this.node = node;
			this.argument = argument;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionIsDefined(this);
		}

		@Override
		public boolean isIsDefined() {
			return true;
		}

		@Override
		public boolean hasArgument() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression argument;

		@Override
		public org.meta_environment.rascal.ast.Expression getArgument() {
			return argument;
		}

		private void $setArgument(org.meta_environment.rascal.ast.Expression x) {
			this.argument = x;
		}

		public IsDefined setArgument(
				org.meta_environment.rascal.ast.Expression x) {
			IsDefined z = new IsDefined();
			z.$setArgument(x);
			return z;
		}
	}

	public boolean isNegation() {
		return false;
	}

	static public class Negation extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Negation() {
		}

		/* package */Negation(INode node,
				org.meta_environment.rascal.ast.Expression argument) {
			this.node = node;
			this.argument = argument;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionNegation(this);
		}

		@Override
		public boolean isNegation() {
			return true;
		}

		@Override
		public boolean hasArgument() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression argument;

		@Override
		public org.meta_environment.rascal.ast.Expression getArgument() {
			return argument;
		}

		private void $setArgument(org.meta_environment.rascal.ast.Expression x) {
			this.argument = x;
		}

		public Negation setArgument(org.meta_environment.rascal.ast.Expression x) {
			Negation z = new Negation();
			z.$setArgument(x);
			return z;
		}
	}

	public boolean isNegative() {
		return false;
	}

	static public class Negative extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Negative() {
		}

		/* package */Negative(INode node,
				org.meta_environment.rascal.ast.Expression argument) {
			this.node = node;
			this.argument = argument;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionNegative(this);
		}

		@Override
		public boolean isNegative() {
			return true;
		}

		@Override
		public boolean hasArgument() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression argument;

		@Override
		public org.meta_environment.rascal.ast.Expression getArgument() {
			return argument;
		}

		private void $setArgument(org.meta_environment.rascal.ast.Expression x) {
			this.argument = x;
		}

		public Negative setArgument(org.meta_environment.rascal.ast.Expression x) {
			Negative z = new Negative();
			z.$setArgument(x);
			return z;
		}
	}

	public boolean isTransitiveReflexiveClosure() {
		return false;
	}

	static public class TransitiveReflexiveClosure extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private TransitiveReflexiveClosure() {
		}

		/* package */TransitiveReflexiveClosure(INode node,
				org.meta_environment.rascal.ast.Expression argument) {
			this.node = node;
			this.argument = argument;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionTransitiveReflexiveClosure(this);
		}

		@Override
		public boolean isTransitiveReflexiveClosure() {
			return true;
		}

		public boolean hasArgument() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression argument;

		public org.meta_environment.rascal.ast.Expression getArgument() {
			return argument;
		}

		private void $setArgument(org.meta_environment.rascal.ast.Expression x) {
			this.argument = x;
		}

		public TransitiveReflexiveClosure setArgument(
				org.meta_environment.rascal.ast.Expression x) {
			TransitiveReflexiveClosure z = new TransitiveReflexiveClosure();
			z.$setArgument(x);
			return z;
		}
	}

	public boolean isTransitiveClosure() {
		return false;
	}

	static public class TransitiveClosure extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private TransitiveClosure() {
		}

		/* package */TransitiveClosure(INode node,
				org.meta_environment.rascal.ast.Expression argument) {
			this.node = node;
			this.argument = argument;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionTransitiveClosure(this);
		}

		public boolean isTransitiveClosure() {
			return true;
		}

		public boolean hasArgument() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression argument;

		public org.meta_environment.rascal.ast.Expression getArgument() {
			return argument;
		}

		private void $setArgument(org.meta_environment.rascal.ast.Expression x) {
			this.argument = x;
		}

		public TransitiveClosure setArgument(
				org.meta_environment.rascal.ast.Expression x) {
			TransitiveClosure z = new TransitiveClosure();
			z.$setArgument(x);
			return z;
		}
	}

	public boolean isGetAnnotation() {
		return false;
	}

	static public class GetAnnotation extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private GetAnnotation() {
		}

		/* package */GetAnnotation(INode node,
				org.meta_environment.rascal.ast.Expression expression,
				org.meta_environment.rascal.ast.Name name) {
			this.node = node;
			this.expression = expression;
			this.name = name;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionGetAnnotation(this);
		}

		public boolean isGetAnnotation() {
			return true;
		}

		public boolean hasExpression() {
			return true;
		}

		public boolean hasName() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public GetAnnotation setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			GetAnnotation z = new GetAnnotation();
			z.$setExpression(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Name name;

		public org.meta_environment.rascal.ast.Name getName() {
			return name;
		}

		private void $setName(org.meta_environment.rascal.ast.Name x) {
			this.name = x;
		}

		public GetAnnotation setName(org.meta_environment.rascal.ast.Name x) {
			GetAnnotation z = new GetAnnotation();
			z.$setName(x);
			return z;
		}
	}

	public org.meta_environment.rascal.ast.Expression getValue() {
		throw new UnsupportedOperationException();
	}

	public boolean hasValue() {
		return false;
	}

	public boolean isSetAnnotation() {
		return false;
	}

	static public class SetAnnotation extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private SetAnnotation() {
		}

		/* package */SetAnnotation(INode node,
				org.meta_environment.rascal.ast.Expression expression,
				org.meta_environment.rascal.ast.Name name,
				org.meta_environment.rascal.ast.Expression value) {
			this.node = node;
			this.expression = expression;
			this.name = name;
			this.value = value;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionSetAnnotation(this);
		}

		public boolean isSetAnnotation() {
			return true;
		}

		public boolean hasExpression() {
			return true;
		}

		public boolean hasName() {
			return true;
		}

		public boolean hasValue() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression expression;

		public org.meta_environment.rascal.ast.Expression getExpression() {
			return expression;
		}

		private void $setExpression(org.meta_environment.rascal.ast.Expression x) {
			this.expression = x;
		}

		public SetAnnotation setExpression(
				org.meta_environment.rascal.ast.Expression x) {
			SetAnnotation z = new SetAnnotation();
			z.$setExpression(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Name name;

		public org.meta_environment.rascal.ast.Name getName() {
			return name;
		}

		private void $setName(org.meta_environment.rascal.ast.Name x) {
			this.name = x;
		}

		public SetAnnotation setName(org.meta_environment.rascal.ast.Name x) {
			SetAnnotation z = new SetAnnotation();
			z.$setName(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression value;

		public org.meta_environment.rascal.ast.Expression getValue() {
			return value;
		}

		private void $setValue(org.meta_environment.rascal.ast.Expression x) {
			this.value = x;
		}

		public SetAnnotation setValue(
				org.meta_environment.rascal.ast.Expression x) {
			SetAnnotation z = new SetAnnotation();
			z.$setValue(x);
			return z;
		}
	}

	public boolean isComposition() {
		return false;
	}

	static public class Composition extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Composition() {
		}

		/* package */Composition(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionComposition(this);
		}

		public boolean isComposition() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Composition setLhs(org.meta_environment.rascal.ast.Expression x) {
			Composition z = new Composition();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Composition setRhs(org.meta_environment.rascal.ast.Expression x) {
			Composition z = new Composition();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isProduct() {
		return false;
	}

	static public class Product extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Product() {
		}

		/* package */Product(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionProduct(this);
		}

		public boolean isProduct() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Product setLhs(org.meta_environment.rascal.ast.Expression x) {
			Product z = new Product();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Product setRhs(org.meta_environment.rascal.ast.Expression x) {
			Product z = new Product();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isDivision() {
		return false;
	}

	static public class Division extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Division() {
		}

		/* package */Division(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionDivision(this);
		}

		public boolean isDivision() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Division setLhs(org.meta_environment.rascal.ast.Expression x) {
			Division z = new Division();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Division setRhs(org.meta_environment.rascal.ast.Expression x) {
			Division z = new Division();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isModulo() {
		return false;
	}

	static public class Modulo extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Modulo() {
		}

		/* package */Modulo(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionModulo(this);
		}

		public boolean isModulo() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Modulo setLhs(org.meta_environment.rascal.ast.Expression x) {
			Modulo z = new Modulo();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Modulo setRhs(org.meta_environment.rascal.ast.Expression x) {
			Modulo z = new Modulo();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isIntersection() {
		return false;
	}

	static public class Intersection extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Intersection() {
		}

		/* package */Intersection(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionIntersection(this);
		}

		public boolean isIntersection() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Intersection setLhs(org.meta_environment.rascal.ast.Expression x) {
			Intersection z = new Intersection();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Intersection setRhs(org.meta_environment.rascal.ast.Expression x) {
			Intersection z = new Intersection();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isAddition() {
		return false;
	}

	static public class Addition extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Addition() {
		}

		/* package */Addition(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionAddition(this);
		}

		public boolean isAddition() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Addition setLhs(org.meta_environment.rascal.ast.Expression x) {
			Addition z = new Addition();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Addition setRhs(org.meta_environment.rascal.ast.Expression x) {
			Addition z = new Addition();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isSubtraction() {
		return false;
	}

	static public class Subtraction extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Subtraction() {
		}

		/* package */Subtraction(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionSubtraction(this);
		}

		public boolean isSubtraction() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Subtraction setLhs(org.meta_environment.rascal.ast.Expression x) {
			Subtraction z = new Subtraction();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Subtraction setRhs(org.meta_environment.rascal.ast.Expression x) {
			Subtraction z = new Subtraction();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isNotIn() {
		return false;
	}

	static public class NotIn extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private NotIn() {
		}

		/* package */NotIn(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionNotIn(this);
		}

		public boolean isNotIn() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public NotIn setLhs(org.meta_environment.rascal.ast.Expression x) {
			NotIn z = new NotIn();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public NotIn setRhs(org.meta_environment.rascal.ast.Expression x) {
			NotIn z = new NotIn();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isIn() {
		return false;
	}

	static public class In extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private In() {
		}

		/* package */In(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionIn(this);
		}

		public boolean isIn() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public In setLhs(org.meta_environment.rascal.ast.Expression x) {
			In z = new In();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public In setRhs(org.meta_environment.rascal.ast.Expression x) {
			In z = new In();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isIfDefinedOtherwise() {
		return false;
	}

	static public class IfDefinedOtherwise extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private IfDefinedOtherwise() {
		}

		/* package */IfDefinedOtherwise(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionIfDefinedOtherwise(this);
		}

		public boolean isIfDefinedOtherwise() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public IfDefinedOtherwise setLhs(
				org.meta_environment.rascal.ast.Expression x) {
			IfDefinedOtherwise z = new IfDefinedOtherwise();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public IfDefinedOtherwise setRhs(
				org.meta_environment.rascal.ast.Expression x) {
			IfDefinedOtherwise z = new IfDefinedOtherwise();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isLessThan() {
		return false;
	}

	static public class LessThan extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private LessThan() {
		}

		/* package */LessThan(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionLessThan(this);
		}

		public boolean isLessThan() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public LessThan setLhs(org.meta_environment.rascal.ast.Expression x) {
			LessThan z = new LessThan();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public LessThan setRhs(org.meta_environment.rascal.ast.Expression x) {
			LessThan z = new LessThan();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isLessThanOrEq() {
		return false;
	}

	static public class LessThanOrEq extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private LessThanOrEq() {
		}

		/* package */LessThanOrEq(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionLessThanOrEq(this);
		}

		public boolean isLessThanOrEq() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public LessThanOrEq setLhs(org.meta_environment.rascal.ast.Expression x) {
			LessThanOrEq z = new LessThanOrEq();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public LessThanOrEq setRhs(org.meta_environment.rascal.ast.Expression x) {
			LessThanOrEq z = new LessThanOrEq();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isGreaterThan() {
		return false;
	}

	static public class GreaterThan extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private GreaterThan() {
		}

		/* package */GreaterThan(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionGreaterThan(this);
		}

		public boolean isGreaterThan() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public GreaterThan setLhs(org.meta_environment.rascal.ast.Expression x) {
			GreaterThan z = new GreaterThan();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public GreaterThan setRhs(org.meta_environment.rascal.ast.Expression x) {
			GreaterThan z = new GreaterThan();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isGreaterThanOrEq() {
		return false;
	}

	static public class GreaterThanOrEq extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private GreaterThanOrEq() {
		}

		/* package */GreaterThanOrEq(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionGreaterThanOrEq(this);
		}

		public boolean isGreaterThanOrEq() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public GreaterThanOrEq setLhs(
				org.meta_environment.rascal.ast.Expression x) {
			GreaterThanOrEq z = new GreaterThanOrEq();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public GreaterThanOrEq setRhs(
				org.meta_environment.rascal.ast.Expression x) {
			GreaterThanOrEq z = new GreaterThanOrEq();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isNonEquals() {
		return false;
	}

	static public class NonEquals extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private NonEquals() {
		}

		/* package */NonEquals(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionNonEquals(this);
		}

		public boolean isNonEquals() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public NonEquals setLhs(org.meta_environment.rascal.ast.Expression x) {
			NonEquals z = new NonEquals();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public NonEquals setRhs(org.meta_environment.rascal.ast.Expression x) {
			NonEquals z = new NonEquals();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isImplication() {
		return false;
	}

	static public class Implication extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Implication() {
		}

		/* package */Implication(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionImplication(this);
		}

		public boolean isImplication() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Implication setLhs(org.meta_environment.rascal.ast.Expression x) {
			Implication z = new Implication();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Implication setRhs(org.meta_environment.rascal.ast.Expression x) {
			Implication z = new Implication();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isEquivalence() {
		return false;
	}

	static public class Equivalence extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Equivalence() {
		}

		/* package */Equivalence(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionEquivalence(this);
		}

		public boolean isEquivalence() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Equivalence setLhs(org.meta_environment.rascal.ast.Expression x) {
			Equivalence z = new Equivalence();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Equivalence setRhs(org.meta_environment.rascal.ast.Expression x) {
			Equivalence z = new Equivalence();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isAnd() {
		return false;
	}

	static public class And extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private And() {
		}

		/* package */And(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionAnd(this);
		}

		public boolean isAnd() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public And setLhs(org.meta_environment.rascal.ast.Expression x) {
			And z = new And();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public And setRhs(org.meta_environment.rascal.ast.Expression x) {
			And z = new And();
			z.$setRhs(x);
			return z;
		}
	}

	public boolean isOr() {
		return false;
	}

	static public class Or extends Expression {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Or() {
		}

		/* package */Or(INode node,
				org.meta_environment.rascal.ast.Expression lhs,
				org.meta_environment.rascal.ast.Expression rhs) {
			this.node = node;
			this.lhs = lhs;
			this.rhs = rhs;
		}

		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitExpressionOr(this);
		}

		public boolean isOr() {
			return true;
		}

		public boolean hasLhs() {
			return true;
		}

		public boolean hasRhs() {
			return true;
		}

		private org.meta_environment.rascal.ast.Expression lhs;

		public org.meta_environment.rascal.ast.Expression getLhs() {
			return lhs;
		}

		private void $setLhs(org.meta_environment.rascal.ast.Expression x) {
			this.lhs = x;
		}

		public Or setLhs(org.meta_environment.rascal.ast.Expression x) {
			Or z = new Or();
			z.$setLhs(x);
			return z;
		}

		private org.meta_environment.rascal.ast.Expression rhs;

		public org.meta_environment.rascal.ast.Expression getRhs() {
			return rhs;
		}

		private void $setRhs(org.meta_environment.rascal.ast.Expression x) {
			this.rhs = x;
		}

		public Or setRhs(org.meta_environment.rascal.ast.Expression x) {
			Or z = new Or();
			z.$setRhs(x);
			return z;
		}
	}

	static public class Lexical extends Expression {
		private String string;

		/* package */Lexical(INode node, String string) {
			this.node = node;
			this.string = string;
		}

		public String getString() {
			return string;
		}

		public <T> T accept(IASTVisitor<T> v) {
			return v.visitExpressionLexical(this);
		}
	}
}