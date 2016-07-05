package NO371_SumOfTwoInteger;


public class Solution {
    public static int getSum(int a, int b) {
     	
    	// if b > 0 
    	if (b > 0 ){
        	for ( int i = 0 ; i < b ; i++ ){
        		a ++ ;
        	}
    	} else if ( b < 0 ) {
        	for ( int i = 0 ; i > b ; i-- ){
        		a -- ;
        	}
    	}
    	return a;
    	
    	
/*    	
        int aa = Math.max(a,b);
        int bb = Math.min(a,b);
        
    	if (bb > 0 ){
        	for ( int i = 0 ; i < bb ; i++ ){
        		aa ++ ;
        	}
    	} else if ( bb < 0 ) {
        	for ( int i = 0 ; i > bb ; i-- ){
        		aa -- ;
        	}
    	}
    	return aa;
*/    	
    	
    }
    
    public static void main(String[] args ){
    	System.out.println(getSum(3,-200));
    	
    }
    
    
}