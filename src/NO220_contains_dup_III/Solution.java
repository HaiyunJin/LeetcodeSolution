public class Solution {
    public static void main (String[] argv ){
        int nums[] = {7,1,3};
        int k = 2;
        int t = 3;
        System.out.println(containsNearbyAlmostDuplicate( nums, k, t));

    }
    static public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 ) return false;
        int len = nums.length;
        // int[] diff = new int[len];
        int diff;
        // System.arraycopy( nums, 0, diff, 0, len );
        if ( k > len ) k = len - 1 ;
        for ( int j = 0; j < len-1 ; ++j) {
            for (int i = j+k ; i > j ; --i ) {
                // diff[i] = nums[i+1] - nums[i];
                if ( i < len ) {
                diff = nums[i] - nums[j];
System.out.println("diff "+diff);
                // if ( (diff[i] <= t) && (diff[i] >= -t) ) return true;
                if ( (diff <= t) && (diff >= -t) ) return true;
                }
            } 
        }
        return false;
    }
}
