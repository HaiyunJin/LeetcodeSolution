public class Solution {
    static public void main (String Argv[]){
        String[] strs = {"aca","cba"};
        System.out.println(longestCommonPrefix(strs));
    }

    static public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if ( size <= 0 ) return "";
        
        int comlen = 0;
        /* Take the first one as longest*/
        comlen = strs[0].length();
        
        int len;
        for (int i = 1 ; i < size ; ++i ){
            // short string set comlen
            if ( (len = strs[i].length()) < comlen )
                comlen = len;
            // or check from last
            for ( int j = comlen-1 ; j > -1; --j ) {
                if (strs[0].charAt(j) != strs[i].charAt(j) ) {
                    comlen = j;
                }
            }
        }
        return strs[0].substring(0,comlen);
    }
}
