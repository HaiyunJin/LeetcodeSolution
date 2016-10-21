public class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums.length <= 1 ) return 0;
        // develop arraylist
        ArrayList<Integer> bit1 = new ArrayList<Integer>();
        ArrayList<Integer> bit0 = new ArrayList<Integer>();
        int shift = 31;
        int count1 = 0;
        while ( count1 == 0 && shift > 0 ) {
            shift--;
            for ( int i = 0 ; i < nums.length ; ++i ) {
                if ( (nums[i]>>shift)%2 == 1 ) {
                    ++count1;
                }
            }
        }
        for ( int i = 0 ; i < nums.length ; ++i ) {
            if ( (nums[i]>>shift)%2 == 1 )
                bit1.add(i);
            bit0.add(i);
        }
        return findmax(nums, bit1, bit0, shift);
    }
    
    int findmax(int nums[], ArrayList<Integer> bit1, ArrayList<Integer> bit0, int shift){
        if ( bit1.size() == 1 && bit0.size() == 1 ) {
            return nums[bit0.get(0)]^nums[bit1.get(0)];
        }
            
        ArrayList<Integer> bit11 = new ArrayList<Integer>();
        ArrayList<Integer> bit10 = new ArrayList<Integer>();
        ArrayList<Integer> bit01 = new ArrayList<Integer>();
        ArrayList<Integer> bit00 = new ArrayList<Integer>();
        
        if ( shift >= 0 ) {
            for ( int index: bit1 ) {
                if ( (nums[index]>>shift)%2 == 1 )
                    bit11.add(index);
                else
                    bit10.add(index);
            }
            for ( int index: bit0 ) {
                if ( (nums[index]>>shift)%2 == 1 )
                    bit01.add(index);
                else
                    bit00.add(index);
            }
        } else {
            bit11.add(bit1.get(0));
            bit00.add(bit0.get(0));
        }

        int res0 = -1, res1 = -1;

        if (bit11.size() == 0 ) bit11 = null;
        if (bit10.size() == 0 ) bit10 = null;
        if (bit01.size() == 0 ) bit01 = null;
        if (bit00.size() == 0 ) bit00 = null;

        // check diff bit
        if ( bit11 != null && bit00 != null )
            res0 = findmax(nums, bit11, bit00, shift-1);
        if ( bit10 != null && bit01 != null )
            res1 = findmax(nums, bit10, bit01, shift-1);
        
        if ( res0 >= 0 ) {
            if ( res1 > res0 ) {
                return res1;
            }
            return res0;
        } else if ( res1 >= 0 ) {
            return res1;
        }
        // check same bit
        res0 = -1; res1 = -1;
        if ( bit11 != null && bit01 != null )
            res0 = findmax(nums, bit11, bit01, shift-1);
        if ( bit10 != null && bit00 != null )
            res1 = findmax(nums, bit10, bit00, shift-1);
        if ( res0 >= 0 ) {
            if ( res1 > res0 )
                return res1;
            return res0;
        } else {
            return res1;
        }
    }
}
