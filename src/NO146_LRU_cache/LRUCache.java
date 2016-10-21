import java.util.*;
public class LRUCache {
    private int capacity;
    private int tag;
    private ArrayList<node> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.tag = 0;
        this.cache = new ArrayList<node>(capacity);
    }
    
    public int get(int key) {
        int size = this.cache.size();
        for ( int i = 0 ; i < size; ++i ) {
// System.out.println("get "+ this.cache.get(i).getkey());
// System.out.println("was "+key);
            if (this.cache.get(i).getkey() == key ) {
// System.out.println("yes, at "+i);
                this.cache.get(i).settag(this.tag++);
                return this.cache.get(i).getvalue();
            }
        }
        return -1;
    }
    
    public void set(int key, int value) {
        int size = this.cache.size();
        for ( int i = 0 ; i < size; ++i ) {
            if (this.cache.get(i).getkey() == key ) {
                this.cache.get(i).settag(this.tag++);
                this.cache.get(i).setvalue(value);
                return;
            }
        }

        if ( size < this.capacity ) { // free slot
            this.cache.add(new node(key, value, this.tag++));
        } else { // full, find the least used
            int mintag = this.tag;
            int minpos = capacity;
            for ( int i = 0 ; i < capacity ; ++i ) {
                if (this.cache.get(i).gettag() < mintag){
                    mintag = this.cache.get(i).gettag();
                    minpos = i;
                }
            }
            this.cache.get(minpos).set(key, value, this.tag++);
        }
    }
}

class node {
    int key;
    int value;
    int tag;
    node(int key, int value, int tag) {
        this.key = key;
        this.value = value;
        this.tag = tag;
    }
    
    int getkey() {
        return this.key;
    }
    int gettag() {
        return this.tag;
    }
    int getvalue() {
        return this.value;
    }
    void settag( int tag) {
        this.tag = tag;
    }
    void setvalue( int value) {
        this.value = value;
    }
    void set(int key, int value, int tag){
        this.key = key;
        this.value = value;
        this.tag = tag;
    }
}
