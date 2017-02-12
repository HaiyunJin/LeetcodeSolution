
import java.util.*;

public class Solution {


    static public void main(String[] argv) {
        String res = getPermutation(3,5);
        System.out.println(res);
    }


    static public String getPermutation(int n, int k) {
        // total permutation is 
        // P(9,9) = 9!
        // P(8,8) = 8!
        
        // first find x = (n-1)!
        // k = k%x; append (k/x)+1
        // recurse 
        
        if ( n == 1 && k == 1) return "1";
        if ( n == 2 ) return (k==1)?"12":"21";
        
        k--;
        int[] factos = new int[n];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        factos[0] = 1;
        nums.add(1);
        for ( int i = 1; i < n ; i++) {
            factos[i] = factos[i-1]*(i+1);
            nums.add(i+1);
        }
        
        StringBuilder res = new StringBuilder();
        int thisNum=n-1;
        while ( thisNum > 0 ) {
    System.out.println("factos[thisNum-1] "+factos[thisNum-1]);
            int select = k/factos[thisNum-1];
    System.out.println("select "+select);
    System.out.println("thisNum "+thisNum);
            res.append(nums.remove(select));
            k %= factos[thisNum-1];
    System.out.println("new k "+k);
            thisNum--;
        }
        res.append(nums.remove(0));
        return res.toString();

        
    }
}
