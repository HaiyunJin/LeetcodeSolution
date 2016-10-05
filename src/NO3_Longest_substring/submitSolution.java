public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* 1. Perform one scan, record the char and position */
        ArrayList<Character> charArray = new ArrayList<Character>();
        ArrayList<ArrayList<Integer>> charList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0 ; i < s.length() ; ++i ) {
            Character thisChar = s.charAt(i);
            if ( charArray.contains(thisChar) ) {
                int indexOfChar = charArray.indexOf(thisChar);
                charList.get(indexOfChar).add(i); // add position
            } else {
                charArray.add(thisChar);
                // ArrayList<Integer> tmp = new ArrayList<Integer>();
                // tmp.add(i);
                charList.add( new ArrayList<Integer>());
                charList.get(charList.size()-1).add(i); // get last and add
            }
        }
        
        /* 2. scan distance matrix, check if others lie in */
        int maxlen = 0;
        loopstring:
        for (int i = 0 ; i < s.length() ; ++i ) {
            int indexOfChar = charArray.indexOf(s.charAt(i));
            // int start = charList.get(indexOfChar).get(0);
            int start = i;
            int end, len;
            try {
                end   = charList.get(indexOfChar).get(1);
                len = end - start ;
            } catch (java.lang.IndexOutOfBoundsException err ) {
                end = s.length()-1;
                len = end - start + 1 ;
            }
            if ( len > maxlen) {            
                loopsubstring:
                for ( int j = i+1 ; j <= end; ++j ) {
                    int indexOfNextChar = charArray.indexOf(s.charAt(j));
                    int nextpos;
                    try {
                        nextpos = charList.get(indexOfNextChar).get(1); // 0 is the current
                        if ( j == nextpos) break loopsubstring;
                        len = j - start + 1;
                        // if ( nextpos <= end ) 
                        //     continue loopsubstring;
                    } catch ( java.lang.IndexOutOfBoundsException err ) {
                        len = j - start + 1;
                    }
                    // len = j - start + 1;
                }
                maxlen = (len>maxlen)?len:maxlen; // or simpler
            }
            charList.get(indexOfChar).remove(0);
        }
        return maxlen;
    }
}
