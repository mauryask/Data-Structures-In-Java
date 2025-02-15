/*
* Time complexity: O(n)
* Space complexity: O(n) 
**************
Another variation of the same problem
** A html file is given check if tags are balenced
 */

import static java.lang.System.*;
import java.util.*;

public class CheckBracketBalencing {

    static boolean isBalenced(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        set.add('(');
        set.add('{');
        set.add('[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (set.contains(ch)) {
                stack.push(ch);
            } else if (map.containsKey(ch)) {
                if (!stack.isEmpty() && Objects.equals(stack.peek(), map.get(ch))) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "([{]})";//"[a+(b+c)*{c+(d+e)+(b+e)}]";
		out.println(isBalenced(str)); 
    }
}
