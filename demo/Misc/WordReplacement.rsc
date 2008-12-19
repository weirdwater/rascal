module WordReplacement

str capitalize1(str S){
    return visit (S) {
      // \b matches a word boundary
      // i turns on case-independent matching
      case /\brascal\b/i => "Rascal"
    };
}

str capitalize2(str S, str Pat, str Repl){
    return visit (S) {
      case /\b<Pat>\b/i => "<Repl>"
    };
}