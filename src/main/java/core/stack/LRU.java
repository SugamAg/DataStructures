package core.stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author sugamagarwal
 */
public class LRU {

    private Deque<Integer> q ;
    HashSet<Integer> set;
    int size;

    public LRU(int size) {
        this.size = size;
        this.set = new HashSet<>();
        this.q = new LinkedList<>();
    }


    public void add(int data) {
        if(!set.contains(data)) {
            if(q.size() == size) {
                Integer integer = q.removeLast();
                set.remove(integer);
            }
        } else {
            q.remove(data);
        }
        q.push(data);
        set.add(data);
    }
 }
