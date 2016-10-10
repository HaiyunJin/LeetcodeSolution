public class Solution {
    static public void main(String Argv[]) {
        String s;
        s = "X";
        System.out.println(romanToInt(s));

    }
    static public int romanToInt(String s) {
        int len = s.length();
        int pos = 0 ;
        int result = 0;
        /* Read M 1000s */
        try {
            while ( s.charAt(pos) == 'M' ) {
                result += 1000;
                ++pos;
            }
            
            /* Read 100s */
            /* C CC CCC CD D DC DCC DCCC CM  */
            while ( s.charAt(pos) == 'C' ) {
                result += 100;
                ++pos;
            }
            if ( s.charAt(pos) == 'D') {
                result += (result%1000 == 0) ? 500 : 300;
                ++pos;
            } else if ( s.charAt(pos) == 'M') {
                result += 800;
                ++pos;
            }
            while ( s.charAt(pos) == 'C' ) {
                result += 100;
                ++pos;
            }
            
            /* Read 10s */
            /* X XX XXX XL L LX LXX LXXX XC  */
            while ( s.charAt(pos) == 'X' ) {
                result += 10;
                ++pos;
            }
            if ( s.charAt(pos) == 'L') {
                result += (result%100 == 0) ? 50 : 30;
                ++pos;
            } else if ( s.charAt(pos) == 'C') {
                result += 80;
                ++pos;
            }
            while ( s.charAt(pos) == 'X' ) {
                result += 10;
                ++pos;
            }
            /* Read 1s*/
            /* I II III IV V VII VIII IX*/
            while ( s.charAt(pos) == 'I' ) {
                result += 1;
                ++pos;
            }
            if ( s.charAt(pos) == 'V') {
                result += (result%10 == 0) ? 5 : 3;
                ++pos;
            } else if ( s.charAt(pos) == 'X') {
                result += 8;
                ++pos;
            }
            while ( s.charAt(pos) == 'I' ) {
                result += 1;
                ++pos;
            }
        } catch ( java.lang.StringIndexOutOfBoundsException e){
            
        } finally {
            return result;
        }
    }
}
