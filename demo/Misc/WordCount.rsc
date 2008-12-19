module WordCount
 
/* this is a * test * comment */

public void main(list[str] argv){
  map[str, int] counts = {};
  for(str fileName : argv){
    try 
       counts[fileName] = wordCount(readFile(fileName));
    catch (IO.error e) println("Skipping file <fileName>");
  }


  println("In total <sum(range(counts))> words in all files");
  println("Word counts per file: <counts>");
}

int wordCount(str S){
  int count = 0;
  // the m-option enables multi-line matching
  for(/[a-zA-Z0-9]+/m: S){
       count += 1;
  }
  return count;
}

// Here is an alternative (but less desirable) declaration:
int wordCount2(str S){
  int count = 0;
  // \w matches any word character
  // <...> are groups and should appear at the top level.
  // m turns on multi-line matching
  while (/^.*?<word:\w+><rest:.*$>/m ~~ S) { 
    count += 1; 
    S = rest; 
  }
  return count;
}

// Maintain word count per word.
// Note how the += operator initializes each map entry
// to an appropriate value (0 in this case)

map[str,int] wordCountPerWord(str S){
  map[str,int] allCounts = {};

 for(/<word:^[a-zA-Z0-9]+>/m: S){
       allCounts[word] ? 0 += 1; 
	/* This is the same as */
       allCounts[word] = (allCounts[word] ? 0) + 1;
  }
  return allCounts;
}