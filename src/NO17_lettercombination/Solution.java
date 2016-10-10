import java.util.*;
public class Solution {
    static public void main(String Argv[]){
        String digits;
        digits = "23";
        System.out.println(letterCombinations(digits));
    }
    static public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        int diglen = 0;
        if ( digits == null || (diglen = digits.length()) == 0 ) {
            System.out.println("no digit");
            return res;
        }
        String[] int2letter = new String[10];
        int2letter[0] = "";
        int2letter[1] = "";
        int2letter[2] = "abc";
        int2letter[3] = "def";
        int2letter[4] = "ghi";
        int2letter[5] = "jkl";
        int2letter[6] = "mno";
        int2letter[7] = "pqrs";
        int2letter[8] = "tuv";
        int2letter[9] = "wxyz";
        int[] dicSize = new int[10];
        dicSize[0] = 0;
        dicSize[1] = 0;
        dicSize[2] = 3;
        dicSize[3] = 3;
        dicSize[4] = 3;
        dicSize[5] = 3;
        dicSize[6] = 3;
        dicSize[7] = 4;
        dicSize[8] = 3;
        dicSize[9] = 4;
        LinkedList<String> queue = new LinkedList<String>();
        
        queue.offer("");
        System.out.println("diglen "+diglen);
        for ( int i = 0 ; i < diglen ; ++i ) {
            int digit = digits.charAt(i)-'0';
        System.out.println("digit "+digit);
            int queueSize = queue.size();
            for ( int j = 0 ; j < queueSize; ++j ) {
                String parent = queue.poll();
        System.out.println("parent "+parent);
                for ( int k = 0; k < dicSize[digit]; ++k ) {
                    String child = new String(parent+int2letter[digit].charAt(k));
                    System.out.println("Child:" + child);
                    queue.offer(child);
                }
            }
        }
        res = queue;
        return res;
    }
}
