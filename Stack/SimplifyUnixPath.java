/*
* T(n) : O(n) : n is length of the string
* S(n) : O(n)
* all the cases are passed at leet code
 */
import static java.lang.System.*;
import java.util.*;

public class SimplifyUnixPath {

    static String simplePath(String path) {
        String[] tokens = path.split("/+");
        Stack<String> stack = new Stack<>();

        //Start fron index 1 as first index is always gouing to be empty								
        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!token.equals(".")) {
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }

        /*
		* check if stack is empty for the case: /////
         */
        return stack.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String path
                = /*"/../";
                 */ "/a/./b/../c/./d/";/*
		 * "/../../../../../a";
		 * "////"; 
         */

 /*String str[]  = path.split("/+");
		 for(String s : str)
			 out.println(s);*/
        out.println(simplePath(path));
    }
}
