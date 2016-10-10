public class Solution {
    static public void main(String Argv[]) {
        int dividend, divisor;
        dividend = 2147483647;
        divisor = 3;
        dividend = -1010369383;
        divisor =  -2147483648;
        System.out.println(divide(dividend,divisor));

    }
    static public int divide(int dividend, int divisor) {
        int res = 0;
        if ( divisor == 0 ) return Integer.MAX_VALUE;
        if ( dividend == 0 ) return 0;
        if ( divisor == 1 ) return dividend;
        if ( dividend == Integer.MIN_VALUE ) {
            if( divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (  divisor == Integer.MIN_VALUE ){
                return 1;
            } else {
                res++;
                if ( divisor < 0 ) {
                    dividend -= divisor;
                } else {
                    dividend += divisor;
                }
            }
        }

        if ( divisor == -1 ) return -dividend;
        if (  divisor == Integer.MIN_VALUE ) return 0;
        
        int sign = 1;
        if ( dividend > 0 ) {
            if ( divisor < 0 ) {
                divisor = -divisor;
                sign = -1;
            }
        } else {
            dividend = -dividend;
            if (divisor < 0) {
                divisor = -divisor;
            } else {
                sign = -1;
            }
        }
        int shift = 0;
        loop:
        while ( dividend >= divisor) {
            System.out.println("dividend, divisor: "+dividend +" " +divisor);
            //System.out.println("dividend >= divisor");
            shift = 0;
            int div = 0;
            while ( true ) {
                div = (divisor<<(shift+1));
                if ( div < 0 ) {
                    break;
                }
                if (dividend > div) {
                    ++shift;
                } else {
                    break;
                }
            //    System.out.println("increase shift "+shift);
                System.out.println(" "+(divisor<<shift));
            }
            res += (1<<shift);
            dividend = dividend - (divisor<<shift);
            System.out.println("new dividend: "+dividend);
        }
        if (sign == -1 ) {
            return -res;
        } else {
            return res;
        }
    }
}
