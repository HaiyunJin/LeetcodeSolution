/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* find the size */
        int i = 0 ;
        ListNode curr = l1;
        while ( curr != null ) {
            ++i;
            curr = curr.next;
        }
        int sizel1 = i;
        i = 0;
        curr = l2;
        while ( curr != null ) {
            ++i;
            curr = curr.next;
        }
        int sizel2 = i;
        
        ListNode longer, shorter;
        int sizel, sizes;
        boolean sameSize = false;
        
        if ( sizel1 > sizel2 ) {
            longer = l1;
            shorter = l2;
            sizel = sizel1;
            sizes = sizel2;
        } else {
            if ( sizel1 == sizel2 )  sameSize = true;
            longer = l2;
            shorter = l1;
            sizel = sizel2;
            sizes = sizel1;
        }
        
        /* add */
        ListNode currl, currs;
        currl = longer;
        currs = shorter;
    
        int tmp;
        int carry = 0;
        ListNode tmpNode;
        ListNode sumhead = new ListNode(0);
        ListNode currNode = sumhead;
        
        for ( i = 0 ; i < sizes ; ++i ) {
            tmp = currl.val + currs.val + carry;
            if (tmp >= 10) {
                tmp -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            tmpNode = new ListNode(tmp);
            currNode.next = tmpNode;
            
            currNode = currNode.next;            
            currl = currl.next;
            currs = currs.next;
        }
        
        if ( !sameSize ) {
            tmp = currl.val + carry;
            if (tmp >= 10) {
                tmp -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            tmpNode = new ListNode(tmp);
            currNode.next = tmpNode;
            currNode = currNode.next;            
            currl = currl.next;
            i++;
            for (; i < sizel ; ++i ) {
                tmp = currl.val + carry;
                if (tmp >= 10) {
                    tmp -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                tmpNode = new ListNode(tmp);
                currNode.next = tmpNode;
                currNode = currNode.next;            
                currl = currl.next;
            }
        }
        /* check highest bit */
        if ( carry == 1 ) {
            tmpNode = new ListNode(1);  
            currNode.next = tmpNode;
        }
        return sumhead.next;
    }
}
