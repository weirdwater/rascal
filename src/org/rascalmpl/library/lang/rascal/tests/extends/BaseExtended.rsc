module lang::rascal::tests::extends::BaseExtended

extend lang::rascal::tests::extends::Base;

syntax S = "z";

alias STRING = str;

alias LIST_INTEGER = list[INTEGER];

data D = d2();

data E = e();

str ident(str s) = s;

str f(1) = "one";