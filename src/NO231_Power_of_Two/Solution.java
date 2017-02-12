public class Solution {
    public static void main(String Argv[]) {
        int n = 1073741824;
        System.out.println(isPowerOfTwo(n));
    }

    static public boolean isPowerOfTwo(int n) {
        System.out.println("n "+n);
        System.out.println("(n-1)&n "+((n-1)&n));
        System.out.println("(n-1)^n "+((n-1)^n));
        System.out.println("((n-1)^n)+1 "+(((n-1)^n)+1));
        System.out.println("((n-1)^n)+1 >>1 "+((((n-1)^n)+1)>>1));

//         return n>0 && ( ( ((n-1)^n) +1 ) >> 1 == n ) ;
        return n>0 && ( (n&(n-1)) == 0) ;
    }
}
