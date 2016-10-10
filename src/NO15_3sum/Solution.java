import java.util.*;

public class Solution {

    static public void main(String Argv[] ) {
        //int[] nums={1,0,-1};
        //int[] nums={1,0,1,-2,-1,4};
        //int[] nums={-1,0,1,2,-1,4};
        //int[] nums={-2,0,1,1,2};
        int[] nums={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
    
        //List<List<Integer>> res = threeSum(nums);
        List<List<Integer>> res = threeSum2(nums);
        for ( int i = 0 ; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
    }
    static public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( nums == null || nums.length <3 ) return res;
        Arrays.sort(nums);
        for ( int i = 0 ; i < nums.length-2; ++i) {
            System.out.println("Checking "+nums[i]);
            // skip dup
            if ( i!=0 && nums[i] == nums[i-1] )
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while ( left < right ){
                int sum = nums[i] + nums[left] + nums[right];
                if ( sum == 0 ){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    ++left;
                    --right;
                    // remove dup
                    while ((left < right) && nums[left] == nums[left-1]) ++left;
                    while ((left < right) && nums[right] == nums[right+1]) --right;
                } else if ( sum < 0 ) {
                    ++left;
                } else {
                    --right;
                }
            }
            
        }
        return res;
    }


    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item;// = new ArrayList<Integer>;
        
        int numsize = nums.length;
        int nNeg = 0;
        int nPos = 0;
        int nZero = 0;
        ArrayList<Integer> poss = new ArrayList<Integer>();
        ArrayList<Integer> negs = new ArrayList<Integer>();
        if ( numsize <3 ) {
            System.out.println("< 3 num");
            return res;
        }
        if ( numsize == 3 ) {
            if ( nums[0]+nums[1]+nums[2] != 0){
            System.out.println("3 num but not sum to 0");
                return res;
            }
            item = new ArrayList<Integer>();
            item.add(nums[0]);
            item.add(nums[1]);
            item.add(nums[2]);
            res.add(item);
            System.out.println("3 num sum to 0");
            return res;
        }
        /* Check sign */
        for (int i = 0 ; i < numsize; ++i ) {
            if (nums[i] > 0 )  poss.add(nums[i]);
            else if (nums[i] < 0)   negs.add(nums[i]);
            else  nZero++;
        }
        nPos = poss.size();
        nNeg = negs.size();
        
        /* Case: all pos || neg  */
        if ( (nNeg*nPos) == 0 ) {
            /* Subcase:  < 3 zeros */
            if( nZero < 3 ) {
            System.out.println("same sign < 3 zero");
                return res;
            }
            /* subcase:  > 3 zeros */
            else if ( nZero >= 3 ) {
                item = new ArrayList<Integer>();
                item.add(0);
                item.add(0);
                item.add(0);
                res.add(item);
            System.out.println("same sign > 3 zero");
                return res;
            }
        }
        
        /* Add by pairs */
        ArrayList<ArrayList<Integer>> neg2sum, pos2sum;
        neg2sum = make2sum(negs);
        pos2sum = make2sum(poss);
        
        
        /* If sum has no item */
        int neg2sumSize = neg2sum.size();
        int pos2sumSize = pos2sum.size(); 
        System.out.println("pos2sumsize: " + pos2sumSize);
        System.out.println("neg2sumsize: " + neg2sumSize);
        
        /* Sort xxx2sum list by the sum */
        /* Remove dups in sum list*/
        ArrayList<Integer> last;
        if ( neg2sumSize>0 ){
            Collections.sort(neg2sum, new Comparator<ArrayList<Integer>>() {
                    @Override
                    public int compare(ArrayList<Integer> list2, ArrayList<Integer> list1){
                        return  -list1.get(0).compareTo(list2.get(0));
                    }
                });
            last = neg2sum.get(0);
            for ( int i = 1 ; i < neg2sum.size() ; ++i ){
                if ( neg2sum.get(i).get(0) == last.get(0) && 
                       ( neg2sum.get(i).get(1) == last.get(1) ||
                         neg2sum.get(i).get(1) == last.get(2) ))
                    neg2sum.remove(i--);
                last = neg2sum.get(i);
            }
        }    
        if ( pos2sumSize>0 ){
            Collections.sort(pos2sum, new Comparator<ArrayList<Integer>>() {
                    @Override
                    public int compare(ArrayList<Integer> list2, ArrayList<Integer> list1){
                        return  list1.get(0).compareTo(list2.get(0));
                    }
                });
            last = pos2sum.get(0);
            for ( int i = 1 ; i < pos2sum.size() ; ++i ){
                if ( pos2sum.get(i).get(0) == last.get(0) &&
                        (  pos2sum.get(i).get(1) == last.get(1) ||
                       pos2sum.get(i).get(1) == last.get(2) )) {
                    System.out.println("i "+i);
                    pos2sum.remove(i--);
                }
                last = pos2sum.get(i);
            }
        }
        neg2sumSize = neg2sum.size();
        pos2sumSize = pos2sum.size(); 
        System.out.println("pos2sumsize: " + pos2sumSize);
        System.out.println("neg2sumsize: " + neg2sumSize);
        /* Sort negs and poss list */
        Collections.sort(negs,Collections.reverseOrder());
        Collections.sort(poss);

        /* Case:  neg && pos, no zero */
        /* subcase, has zeros */
        /* Make a copy of neg2sum and pos2sum */
        ArrayList<ArrayList<Integer>> neg2sumClone = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> pos2sumClone = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> possClone = new ArrayList<Integer>();
        ArrayList<Integer> negsClone = new ArrayList<Integer>();

        if ( nZero != 0 ) {
            System.out.println("Yes! we have 0!");
            /* Make a copy of neg2sum and pos2sum */
            if ( neg2sumSize>0 ){ 
            System.out.println("Make clone of neg2sum");
                for ( ArrayList<Integer> ele : neg2sum )
                    neg2sumClone.add((ArrayList<Integer>) ele.clone());
            }
            if ( pos2sumSize>0 ){ 
            System.out.println("Make clone of pos2sum");
                for ( ArrayList<Integer> ele : pos2sum )
                    pos2sumClone.add((ArrayList<Integer>)ele.clone());
            }
            for ( Integer ele : negs )
                negsClone.add(ele.intValue());
            for ( Integer ele : poss )
                possClone.add(ele.intValue());
            /* find doublet, add zero */
            // since we are using arraylist, start with smallest
            looppos:
            while ( possClone.size() > 0 ) {
                int posItem = possClone.remove(possClone.size()-1);
                System.out.println("Try to match "+posItem);
                while ( negsClone.size() > 0 ){
                    int negItem = negsClone.get(negsClone.size()-1);
                    System.out.println("Checking "+negItem);
                    if ( negItem + posItem > 0 )  {
                        System.out.println(" "+negItem);
                        continue looppos;
                    }
                    else {
                        negsClone.remove(negsClone.size()-1);
                        if ( negItem + posItem == 0 ) {
                            item = new ArrayList<Integer>();
                            item.add(0);
                            item.add(posItem);
                            item.add(negItem);
                            res.add(item);
                            System.out.println("Found "+negItem);
                            continue looppos;
                        }
                    }
                }
            }
        }
        /* subcase: no zero */
        /* find triplet in nums without zeros*/        
        // Loop pos, find negsum
        if ( neg2sumSize>0 ){ 
            loopposforsum:
            while ( poss.size() > 0 ) {
                int posItem = poss.remove(poss.size()-1);
                System.out.println("Try to match pos "+ posItem);
                while ( neg2sum.size() > 0 ){
                    ArrayList<Integer> negsumItem = neg2sum.get(neg2sum.size()-1);
                    System.out.println("Checking negsum "+ negsumItem.get(0));
                    if ( negsumItem.get(0) + posItem > 0 )  continue loopposforsum;
                    else {
                        neg2sum.remove(neg2sum.size()-1);
                        if ( negsumItem.get(0) + posItem == 0 ) {
                            item = new ArrayList<Integer>();
                            item.add(posItem);
                            item.add(negsumItem.get(1));
                            item.add(negsumItem.get(2));
                            res.add(item);
                            continue loopposforsum;
                        }
                    }
                }
            }
        }
        // Loop neg, find possum
        if ( pos2sumSize>0 ){ 
            loopnegforsum:
            while ( negs.size() > 0 ) {
                int negItem = negs.remove(negs.size()-1);
                System.out.println("Try to match neg "+ negItem);
                while ( pos2sum.size() > 0 ){
                    ArrayList<Integer> possumItem = pos2sum.get(pos2sum.size()-1);
                    System.out.println("Checking possum "+ possumItem.get(0));
                    if ( possumItem.get(0) + negItem < 0 )  continue loopnegforsum;
                    else {
                        pos2sum.remove(pos2sum.size()-1);
                        if ( possumItem.get(0) + negItem == 0 ) {
                            item = new ArrayList<Integer>();
                            item.add(negItem);
                            item.add(possumItem.get(1));
                            item.add(possumItem.get(2));
                            res.add(item);
                            continue loopnegforsum;
                        }
                    }
                }
            }
        }
        return res;
    }
    
    static private ArrayList<ArrayList<Integer>> make2sum(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> nums2sum = new ArrayList<ArrayList<Integer>>();
        int numsSize = nums.size();
        ArrayList<Integer> item;
        for ( int i = 0 ; i< numsSize; ++i ) {
            for ( int j = i+1 ; j < numsSize; ++j){
                item = new ArrayList<Integer>();
                item.add( nums.get(i) + nums.get(j) );
                item.add( nums.get(i) );
                item.add( nums.get(j) );
                nums2sum.add(item);
            }
        }
        return nums2sum;
    }

}
