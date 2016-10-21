
public class Solution {
    static public void main (String Argv[] ){
        int capacity;
        // 2,[set(2,1),set(2,2),get(2),set(1,1),set(4,1),get(2)]
        capacity = 2;
        LRUCache cache = new LRUCache(capacity);
        cache.set(2,1);
        cache.set(2,2);
        System.out.println(cache.get(2));
        cache.set(1,1);
        cache.set(4,1);
        System.out.println(cache.get(2));
    }
}
