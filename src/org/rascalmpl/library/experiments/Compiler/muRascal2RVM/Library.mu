 
 module Library

/*
function main[1,1,args] { return next(init(create(TRUE))); }

function TRUE[0,0,] { return true; }   // should be true
 
function FALSE[0,0,] { return false; }


function AND_U_U[2,2,lhs,rhs]{
  return prim("and_bool_bool", lhs, rhs);
}

function AND_M_U[2,2,lhs,rhs,clhs]{
   clhs = init(create(lhs));
   while(hasNext(clhs)){
     if(next(clhs)){
        if(rhs){
           yield true;
        };
     };          
   };
   return 0;
}

function AND_U_M[2,2,lhs,rhs,crhs]{
   if(lhs){
      crhs = init(create(rhs));
      while(hasNext(crhs)){
        if(next(crhs)){
           yield true;
        } else {
          return false;
        };
      };         
   };
   return false;
}

function AND_M_M[2,2,lhs,rhs,clhs,crhs]{
   clhs = init(create(lhs));
   while(hasNext(clhs)){
     if(next(clhs)){
        crhs = init(create(rhs));
        while(hasNext(crhs)){
          if(next(crhs)){
             yield true;
          } else {
            return false;
          };
        };       
     };          
   };
   return false;
}

function ONE[1,1,arg, carg]{
   carg = init(create(arg));
   return next(arg);
}

function ALL[1,1,arg,carg]{
   carg = init(create(arg));
   while(hasNext(carg)){
        yield next(carg);
   };
   return false;
}        
*/


// Pattern matching

function MATCH[1,2,pat,subject,cpat]{
   cpat = init(pat, subject);
   while(hasNext(cpat)){
      if(next(cpat)){
         yield true;
      } else {
        return false;
      };
   };
   return false;
}

function MATCH_N[1, 2, pats, subjects, plen, slen, p, pat]{
   prim("println", ["MATCH_N", pats, subjects]);
   plen = prim("size_list", pats);
   slen = prim("size_list", subjects);
   if(prim("not_equals_num_num", plen, slen)){
      prim("println", ["MATCH_N: unequal length", plen, slen]);
      return false;
   };
   p = 0;
   while(prim("less_num_num", p, plen)){
     prim("println",  ["MATCH_N: init ", p]);
     set pats[p] = init(get pats[p], get subjects[p]);
     p = prim("addition_num_num", p, 1);
   };
   
   while(true){
     p = 0;
     while(prim("less_num_num", p, plen)){
       prim("println", ["p = ", p]);
       pat = get pats[p];
       if(hasNext(pat)){
          if(next(pat)){
              p = prim("addition_num_num", p, 1);
           } else {
              return false;
           };   
       } else {
         return false;
       };
     };
     prim("println", ["MATCH_N yields true"]);
     yield true; 
   };
}

function MATCH_CALL_OR_TREE[1, 2, pats, subject, cpats]{
    prim("println", ["MATCH_CALL_OR_TREE", pats, subject]);
    cpats = init(create(fun MATCH_N, pats, prim("get_name_and_children", subject)));
    while(hasNext(cpats)){
      prim("println", ["MATCH_CALL_OR_TREE", "hasNext=true"]);
      if(next(cpats)){
         yield true;
      } else {
         return false;
      };
    };
    return false;
}


function MATCH_INT[1,2,pat,subject, res]{
   res = prim("equals_num_num", pat, subject);
   prim("println", ["MATCH_INT", pat, subject, res]);
   return res;
}

function MATCH_STR[1,2,pat,subject, res]{
   res = prim("equals_str_str", pat, subject);
   prim("println", ["MATCH_STR", pat, subject, res]);
   return res;
}

function MATCH_VAR[1, 2, varref, subject]{
   deref varref = subject;
   return true;
}
// List matching

function MATCH_LIST[1, 2, pats,   						// A list of coroutines to match list elements
						  subject,						// The subject list
						  patlen,						// Length of pattern list
						  patlen1,						// patlen - 1
						  sublen,						// Length of subject list
						  p,							// Cursor in patterns
						  cursor,						// Cursor in subject
						  forward,
						  matcher,						// Currently active pattern matcher
						  matchers,						// List of currently active pattern matchers
						  success,						// Success flag of last macth
						  nextCursor					// Cursor movement of last successfull match
					]{

     patlen   = prim("size_list", pats);
     patlen1 =  prim("subtraction_num_num", patlen, 1);
     sublen   = prim("size_list", subject);
     p        = 0; 
     cursor   = 0;
     forward  = true;
     matcher  = init(get pats[p], subject, cursor, sublen);
     matchers = prim("make_object_list", 0);
     matchers = prim("addition_elm_list", matcher, matchers);
     
     while(true){
     	// Move forward
     	 forward = hasNext(matcher);
     	 // prim("println", ["At head", p, cursor, forward]);
         while(prim("and_bool_bool", forward, hasNext(matcher))){
        	[success, nextCursor] = next(matcher);
            if(success){ 
               forward = true;
               cursor = nextCursor;
               // prim("println", ["SUCCESS", p, cursor]);
               if(prim("and_bool_bool",
                       prim("equals_num_num", p, patlen1),
                       prim("equals_num_num", cursor, sublen))) {
                   // prim("println", ["*** YIELD", p, cursor]);
              	   yield true;
              	   // prim("println", ["Back from yield", p, cursor]); 
               } else {
                 if(prim("less_num_num", p, patlen1)){
                   p = prim("addition_num_num", p, 1);
                   // prim("println", ["Forward", p, cursor]);
                   matcher  = init(get pats[p], subject, cursor,  prim("subtraction_num_num", sublen, cursor));
                   matchers = prim("addition_elm_list", matcher, matchers);
                 } else {
                   if(hasNext(matcher)){
                     // explore more alternatives
                   } else {
                      // prim("println", ["Backward", p, cursor]);
                      forward = false;
                   };
                 };  
               };
            } else {
              // prim("println", ["No success, Backward", p, cursor]);
              forward = false;
            };
         }; 
         // If possible, move backward
         if(forward){
           // nothing
         } else {  
           if(prim("greater_num_num", p, 0)){
               p        = prim("subtraction_num_num", p, 1);
               // prim("println", ["Previous", p, cursor]);
               matchers = prim("tail_list", matchers);
               matcher  = prim("head_list", matchers);
               forward  = true;
           } else {
         	   // prim("println", ["RETURN FALSE", p, cursor]);
               return false;
           };
         };
     };
}

// All coroutines that may occur in a list pattern have the following parameters:
// - pat: the actual pattern to match one or more elements
// - start: the start index in the subject list
// - available: the number of remianing, unmatched, elements in the subject list

function MATCH_PAT_IN_LIST[1, 4, pat, subject, start, available, cpat]{
    if(prim("less_equal_num_num", available, 0)){
       return [false, start];
    };   
    cpat = init(pat, get subject[start]);
    
    while(hasNext(cpat)){
       if(next(cpat)){
          return [true, prim("addition_num_num", start, 1)];
       };   
    };
    return [false, start];
} 

function MATCH_VAR_IN_LIST[1, 4, varref, subject, start, available]{
   if(prim("less_equal_num_num", available, 0)){
       return [false, start];
   }; 
   deref varref =  get subject[start];
   return [true, prim("addition_num_num", start, 1)];
}

function MATCH_MULTIVAR_IN_LIST[1, 4, varref, subject, start, available, len]{
    len = 0;
    while(prim("less_equal_num_num", len, available)){
        deref varref = prim("sublist", subject, start, len);
        // prim("println", ["MATCH_MULTIVAR_IN_LIST", prim("addition_num_num", start, len)]);
        yield [true, prim("addition_num_num", start, len)];
        len = prim("addition_num_num", len, 1);
     };
     return [false, start];
}

