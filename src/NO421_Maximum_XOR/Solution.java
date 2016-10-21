import java.util.*;

public class Solution {

    static public void main(String Argv[]){
//         int[] nums = {3, 10, 5, 25, 2, 8};
//         int[] nums = {0};
//         int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
//         int[] nums = {10,23,20,18,28};
//         int[] nums = {1,2,3,4,5,6,7,8,9,10};
//          int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
//          };
        int[] nums = {1,1};
        int x = 25 >> -1;
        System.out.println(x);
        System.out.println(findMaximumXOR(nums));

    }
    static public int findMaximumXOR(int[] nums) {
        // develop arraylist
        ArrayList<Integer> bit1 = new ArrayList<Integer>();
        ArrayList<Integer> bit0 = new ArrayList<Integer>();
        int shift = 31;
//         int count0 = 0;
        int count1 = 0;
//         while ( ( count1 == 0 || count0 == 0 ) && shift > 0 ) {
        while ( count1 == 0 && shift > 0 ) {
            shift--;
//         System.out.println("Testing shift " + shift);
//             count0 = 0;
//             count1 = 0;
            for ( int i = 0 ; i < nums.length ; ++i ) {
                if ( (nums[i]>>shift)%2 == 1 ) {
                    ++count1;
//                 } else {
//                     ++count0;
                }
            }
        }
        System.out.println("Starting shift " + shift);
        for ( int i = 0 ; i < nums.length ; ++i ) {
            if ( (nums[i]>>shift)%2 == 1 ) {
                bit1.add(i);
            } else {
                bit0.add(i);
            }
        }

        System.out.print("initial bit1: ");
        printlist(nums, bit1);
        System.out.print("initial bit0: ");
        printlist(nums, bit0);

        int result =  findmax(nums, bit1, bit0, shift);
        if ( result == -1 )
            return 0;
        return result;
    }
    
    static int findmax(int nums[], ArrayList<Integer> bit1, ArrayList<Integer> bit0, int shift){
//         if ( shift < 0 ) return -1;
//         if ( shift < 0 ) shift = 0;
            System.out.println("shift "+shift);
//         if ( bit1.size() == 0 || bit0.size() == 0 ) return -1;
        if ( bit1.size() == 1 && bit0.size() == 1 ) {
            int x = nums[bit0.get(0)]^nums[bit1.get(0)];
            System.out.println(nums[bit0.get(0)]+" "+nums[bit1.get(0)]);
            System.out.println("returing "+x);
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
//             bit10.add(bit1.get(0));
//             bit01.add(bit0.get(0));
            bit00.add(bit0.get(0));
            
        }

        int res0 = -1, res1 = -1;

        if (bit11.size() == 0 ) bit11 = null;
        if (bit10.size() == 0 ) bit10 = null;
        if (bit01.size() == 0 ) bit01 = null;
        if (bit00.size() == 0 ) bit00 = null;

        System.out.print("bit11: ");
        printlist(nums, bit11);
        System.out.print("bit10: ");
        printlist(nums, bit10);
        System.out.print("bit01: ");
        printlist(nums, bit01);
        System.out.print("bit00: ");
        printlist(nums, bit00);


        // check diff bit
//         System.out.println("Evaluate bit11 bit 00 at "+ shift);
        if ( bit11 != null && bit00 != null )
            res0 = findmax(nums, bit11, bit00, shift-1);
//         System.out.println("Evaluate bit01 bit 10 at "+ shift);
        if ( bit01 != null && bit10 != null ) 
            res1 = findmax(nums, bit10, bit01, shift-1);
        
        if ( res0 >= 0 ) {
            if ( res1 > res0 ) {
                System.out.println("bit01 bit10 larger");
                return res1;
            }
            System.out.println("res1 zero return res0");
            return res0;
        } else if ( res1 >= 0 ) {
//         } else {
            System.out.println("res0 zero return res1");
                return res1;
        }
        // check same bit
//         res0 = -1; res1 = -1;
//         System.out.println("Evaluate bit11 bit 01 at "+ shift);
        if ( bit11 != null && bit01 != null )
            res0 = findmax(nums, bit11, bit01, shift-1);
//         System.out.println("Evaluate bit10 bit 00 at "+ shift);
        if ( bit10 != null && bit00 != null )
            res1 = findmax(nums, bit10, bit00, shift-1);
        if ( res0 >= 0 ) {
            if ( res1 > res0 )
                return res1;
            return res0;
//         } else if ( res1 >= 0 ) {
        } else {
            return res1;
        }
    }

    static void printlist(int[] nums, ArrayList<Integer> list) {
        if ( list == null ) {
            System.out.print("\n");
            return;
        }
        for ( int item : list ) 
            System.out.print(nums[item]+" ");
        System.out.print("\n");
        return;
    }

}
