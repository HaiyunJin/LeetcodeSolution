public class Solution {
    static public void main(String Argv[]) {
        String str;
        str = "1234";
        str = "1234acd";
        str = "  - 1234acd";
        str = "  010";
        str = "2147483648";
        str = "-2147483647";
        System.out.println(myAtoi(str));
    }

    static public int myAtoi(String str) {
        int len = str.length();
        if ( len == 0 ) return 0;
        int result = 0 ;
        int sign = 1;
        char chr = ' ';
        
        int j = 0;
        while ( chr == ' ' || chr == '\t' )
            chr = str.charAt(j++);
        --j;
        
        chr = str.charAt(j);
        if ( chr == '-' ) sign = -1;
        for ( int i = j; i < len ; ++i ) {
            chr = str.charAt(i);
            if ( (chr == '-' || chr == '+') && i == j ) continue;
            if ( chr >= '0' && chr <= '9' ) {
                System.out.println("Yes");
                if (result > 214748364) {
                    if( sign == 1 )  return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                int remainder = (chr - '0');
                if (result == 214748364 ) {
                    if ( sign == 1 && remainder > 7)  return Integer.MAX_VALUE;
                    else if (sign == -1 && remainder > 8) return Integer.MIN_VALUE;
                }
                result *= 10;
                result += remainder;
            } else {
                break;
            }
        }
        return sign*result;
    }
}

