class Test 
{ 
  private static final String [] reserved = 
   { "and", 
     "begin", 
     "define", 
     "do", 
     "else", 
     "end", 
     "if", 
     "not", 
     "or", 
     "return", 
     "then", 
     "while" }; 
 
  private static int hash(String name) 
  { 
    return  name.charAt(0) * 3 + name.charAt(1) * 7;
  } 
 
  public static void main(String [] args) 
  { 
    for (int index = 0; index < reserved.length ; index += 1) 
    { 
      System.out.print("h(\"" + reserved[index] + "\") = "); 
      System.out.print(hash(reserved[index])); 
      System.out.println(); 
    } 
  } 
}

/*

Result when run: 
h("and") = 1061
h("begin") = 1001
h("define") = 1007
h("do") = 1077
h("else") = 1059
h("end") = 1073
h("if") = 1029
h("not") = 1107
h("or") = 1131
h("return") = 1049
h("then") = 1076
h("while") = 1085

As you can see, there are no duplicates and the numbers in order of greatest to least are 
1001
1007
1029
1049
1059
1061
1073
1076
1077
1085
1107
1131
*/
