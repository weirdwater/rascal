package org.meta_environment.rascal.ast;

import org.eclipse.imp.pdb.facts.INode;

public abstract class Character extends AbstractAST {
	public org.meta_environment.rascal.ast.NumChar getNumChar() {
		throw new UnsupportedOperationException();
	}

	public boolean hasNumChar() {
		return false;
	}

	public boolean isNumeric() {
		return false;
	}

	static public class Numeric extends Character {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Numeric() {
		}

		/* package */Numeric(INode node,
				org.meta_environment.rascal.ast.NumChar numChar) {
			this.node = node;
			this.numChar = numChar;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitCharacterNumeric(this);
		}

		@Override
		public boolean isNumeric() {
			return true;
		}

		@Override
		public boolean hasNumChar() {
			return true;
		}

		private org.meta_environment.rascal.ast.NumChar numChar;

		@Override
		public org.meta_environment.rascal.ast.NumChar getNumChar() {
			return numChar;
		}

		private void $setNumChar(org.meta_environment.rascal.ast.NumChar x) {
			this.numChar = x;
		}

		public Numeric setNumChar(org.meta_environment.rascal.ast.NumChar x) {
			Numeric z = new Numeric();
			z.$setNumChar(x);
			return z;
		}
	}

	static public class Ambiguity extends Character {
		private final java.util.List<org.meta_environment.rascal.ast.Character> alternatives;

		public Ambiguity(
				INode node,
				java.util.List<org.meta_environment.rascal.ast.Character> alternatives) {
			this.alternatives = java.util.Collections
					.unmodifiableList(alternatives);
			this.node = node;
		}

		public java.util.List<org.meta_environment.rascal.ast.Character> getAlternatives() {
			return alternatives;
		}

		@Override
		public <T> T accept(IASTVisitor<T> v) {
			return v.visitCharacterAmbiguity(this);
		}
	}

	public org.meta_environment.rascal.ast.ShortChar getShortChar() {
		throw new UnsupportedOperationException();
	}

	public boolean hasShortChar() {
		return false;
	}

	public boolean isShort() {
		return false;
	}

	static public class Short extends Character {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Short() {
		}

		/* package */Short(INode node,
				org.meta_environment.rascal.ast.ShortChar shortChar) {
			this.node = node;
			this.shortChar = shortChar;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitCharacterShort(this);
		}

		@Override
		public boolean isShort() {
			return true;
		}

		@Override
		public boolean hasShortChar() {
			return true;
		}

		private org.meta_environment.rascal.ast.ShortChar shortChar;

		@Override
		public org.meta_environment.rascal.ast.ShortChar getShortChar() {
			return shortChar;
		}

		private void $setShortChar(org.meta_environment.rascal.ast.ShortChar x) {
			this.shortChar = x;
		}

		public Short setShortChar(org.meta_environment.rascal.ast.ShortChar x) {
			Short z = new Short();
			z.$setShortChar(x);
			return z;
		}
	}

	@Override
	public abstract <T> T accept(IASTVisitor<T> visitor);

	public boolean isTop() {
		return false;
	}

	static public class Top extends Character {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Top() {
		}

		/* package */Top(INode node) {
			this.node = node;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitCharacterTop(this);
		}

		@Override
		public boolean isTop() {
			return true;
		}
	}

	public boolean isEOF() {
		return false;
	}

	static public class EOF extends Character {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private EOF() {
		}

		/* package */EOF(INode node) {
			this.node = node;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitCharacterEOF(this);
		}

		@Override
		public boolean isEOF() {
			return true;
		}
	}

	public boolean isBottom() {
		return false;
	}

	static public class Bottom extends Character {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private Bottom() {
		}

		/* package */Bottom(INode node) {
			this.node = node;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitCharacterBottom(this);
		}

		@Override
		public boolean isBottom() {
			return true;
		}
	}

	public boolean isLabelStart() {
		return false;
	}

	static public class LabelStart extends Character {
		/** &syms -> &sort {&attr*1, cons(&strcon), &attr*2} */
		private LabelStart() {
		}

		/* package */LabelStart(INode node) {
			this.node = node;
		}

		@Override
		public <T> T accept(IASTVisitor<T> visitor) {
			return visitor.visitCharacterLabelStart(this);
		}

		@Override
		public boolean isLabelStart() {
			return true;
		}
	}
}