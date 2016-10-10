import java.util.*;

public class Solution {
    static public void main(String Argv[]) {
        String s;
        s = "()";
        System.out.println(isValid(s));
        
    }
    static public boolean isValid(String s) {
        if ( s == null || s == "" || s.length()%2 == 1 ) {
        System.out.println("becasue not valid");
             return false;
        }
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for ( int i = 0 ; i < s.length() ; ++i ){
            System.out.println(s.charAt(i));
            switch ( s.charAt(i)) {
                case '(':  
                    nums.add(1); break;
                case ')':  
                    nums.add(-1); break;
                case '[':  
                    nums.add(2); break;
                case ']':  
                    nums.add(-2); break;
                case '{':  
                    nums.add(3); break;
                case '}':  
                    nums.add(-3); break;
            }
        }
        System.out.println("numssize "+nums.size());
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums.get(0));
        for ( int i = 1 ; i < s.length() ; ++i ){
            if ( nums.get(i) > 0 ) {
                stack.push(nums.get(i));
            } else {
                if ( stack.peek() + nums.get(i) == 0 ){
                    stack.pop();
                } else {
                    System.out.println("because not match");
                    return false;
                }
            }
        }
        if ( !stack.isEmpty() ) {
            System.out.println("because not empty");
            System.out.println(stack.pop());
            System.out.println(nums.size());

            return false;
        }
        return true;
    }
}
