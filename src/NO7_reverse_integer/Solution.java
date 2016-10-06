public class Solution {

    static public void main( String argv[]) {
        int x;
        x = 123;
        x = 900000;
        x = 1534236469;
        System.out.println(x);
        System.out.println(reverse(x));
    }   
    static public int reverse(int x) {
        int num;
        if ( x < 0 ) 
            num = -x;
        else
            num = x;
            
        int result = 0 ;
        int highbit = num;
        int remainder ;
        while ( highbit > 0 ) {
            remainder = highbit%10;
            if (result > 214748364 ) return 0;
            if (result == 214748364 && remainder > 7)  return 0;
            result *= 10;
            result += remainder;
            System.out.println(result);
            highbit = highbit/10;
        }
        if ( x < 0 ) 
            return -result;
        else
            return result;
    }
}
