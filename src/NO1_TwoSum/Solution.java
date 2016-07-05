
package NO1_TwoSum ;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        
        int solu[] = new int[2];
        int size = nums.length;
        
        for ( int i = 0 ; i < size - 1  ; i++){
//            if ( nums[i] <= target ){
                for ( int j = i + 1 ; j < size ; j ++ ){
                    if ( (nums[i] + nums[j]) == target){
                        solu[0] = i;
                        solu[1] = j;
                        return solu;
                    }
                }
//            }
        }
        
        solu[0] = 0;
        solu[1] = 0;
        return solu;
        
    }
    
    public static void main(String[] args) {

//    	int[] nums = {1,2,3,4,5,6,7,8,9,10} ;
    	int[] nums = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10} ;
    	int target = -12;
    	int[] solu = twoSum(nums,target);
    	
    	System.out.print("["+solu[0]+","+solu[1]+"]"
    			+ "");
    	

    	
    }
    
}