public class Solution {

    static public void main(String argv[]) {
        String s;
        s = "a";
        s = "aabbaa";

        System.out.println(longestPalindrome(s));
    }

    static public String longestPalindrome(String s) {

     /* len of s*/
     int len = s.length();
     
     for ( int i = len ; i > 1 ; --i) {
         looplocate:
         for ( int j = 0; j <= len - i ; ++j ) { // j is the first chat at string
             int front = j;
             int end = front + i-1;
             loopcheck:
             while (front < end) {
                 if ( s.charAt(front) != s.charAt(end) )
                     continue looplocate;
                 ++front;
                 --end;
             }
             return s.substring(j,j+i);
         } 
     }
     // otherwise return the first char
     return s.substring(0,1);
    }
}
