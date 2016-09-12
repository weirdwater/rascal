@doc{
.Synopsis
a symbolic representation for abstract syntax trees of programming languages.

.Description

We provide a general set of data types for the syntactic constructs of programming languages: `Expression`, `Statement`, `Declaration` and `Type`.
Also, very common syntactic constructs are added to this, such as `if`, `while`, etc.

The idea is that parsers for different languages will map to common abstract syntax elements, when this can be done meaningfully.
If not, then these front-ends will extend the existing types with new constructor definitions, or even new kinds of types will
be added. The shared representation limits the element of surprise when working with different languages, and perhaps may
make some downstream analyses reusable.

The concept of a _source [Location]_ is important for abstract syntax trees. The annotation `src` will always point to value of type `loc`,
pointing to the physical location of the construct in the source code.

The concept of _declaration_ is also relevant. A `decl` annotation points from a use of a concept to its definition, but always
via an indirection (i.e. fully qualified name). The `decl` annotation is also of type `loc`, where each <<Expressions-Values-Location>> is a fully qualified name of the
definition that is used. 

Finally, the concept of a _type_ is relevant for ASTs. In particular an `Expression` may have a `typ` annotation, or
a variable declaration, etc.

.Benefits

*  Symbolic abstract syntax trees can be analyzed and transformed easily using Rascal primitives such as [Patterns], [$Rascal/Expressions/Comprehensions], and [Visit].

.Pitfalls

*  Even though different languages may map to the same syntactic construct, this does not mean that the semantics is the same. Downstream
metrics or other analysis tools should still take semantic differences between programming languages into account. 
}
module analysis::m3::AST

import Message;
import analysis::m3::TypeSymbol;

public data \AST(loc file = |unknown:///|)
  = declaration(Declaration declaration)
  | lines(list[str] contents)
  | noAST(Message msg)
  ;

data Declaration;
data Declaration(loc src = |unknown:///|);
//anno loc             Declaration@src;
data Declaration(loc decl = |unknown:///|); 
//anno loc             Declaration@decl;
data Declaration(TypeSymbol typ = \any());
//anno TypeSymbol      Declaration@typ;
data Declaration(list[Modifier] modifiers = []);
//anno list[Modifier]  Declaration@modifiers;
data Declaration(list[Message] messages = []);
//anno list[Message]   Declaration@messages;

data Statement;
data Statement(loc src = |unknown:///|);
//anno loc Statement@src;
data Statement(loc decl = |unknown:///|);
//anno loc Statement@decl;

data Expression;
data Expression(loc src = |unknown:///|);
//anno loc Expression@src;
data Expression(loc decl = |unknown:///|);
//anno loc Expression@decl;
data Expression(TypeSymbol typ = \any());
//anno TypeSymbol Expression@typ;

data Type;
data Type(loc name = |unknown:///|);
//anno loc Type@name;              
data Type(TypeSymbol typ = \any());
//anno TypeSymbol Type@typ;

data Modifier;