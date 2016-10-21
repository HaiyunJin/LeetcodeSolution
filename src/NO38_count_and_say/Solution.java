public class Solution {
    static public void main(String Argv[] ) {
        int n;
        n = 10;
//        for ( n = 0 ; n < 10 ; n ++){
        System.out.println(countAndSay(n)+"\n");
//        }
    }
    static    public String countAndSay(int n) {
        String start = "1";
        for (int i = 1 ; i < n ; ++i ) {
            String read = "";
            int len = start.length();
// System.out.println("len of start "+len);
            int count = 1;
            char last = '0';
            int pos = 0;
            while ( pos < len ) {
// System.out.println("looking at pos "+pos);
                if ( (pos+1<len) && start.charAt(pos) == start.charAt(pos+1) ) {
//System.out.println("same char");
                    count++;
                } else {
// System.out.println("count "+count);
// System.out.println(read);
                    char fig = (char)(count + '0');
// System.out.println("fig " + fig);
                    read += fig;
// System.out.println(read);
                    read += start.charAt(pos);
                    count = 1;
                }
                    last = start.charAt(pos);
                pos++;
            }
//            start = (read == "" )? "11" : read;
            start = read;
System.out.println(start);
        }
        return start;
    }
}
