package core.stack;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sugamagarwal
 */

class Node {
    int data;
    int frequeuncy;

    public Node(int data) {
        this.data = data;
        this.frequeuncy = 1;
    }

    void increaseFrequency() {
        frequeuncy++;
    }
}

public class LFU {

    PriorityQueue<Node> q;
    Map<Integer, Node> nodeMap;
    int size;

    public LFU(int size) {
        this.q = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequeuncy));
        this.nodeMap = new HashMap<>();
        this.size = size;
    }

    public Node get(int key) {
        if(size == 0 || !nodeMap.containsKey(key))
            return null;
        Node node = nodeMap.get(key);
        q.remove(node);
        node.increaseFrequency();
        q.add(node);
        return node;
    }

    public void put(int key) {
        if(!nodeMap.containsKey(key)) {
            if(size == q.size()){
                Node poll = q.poll();
                nodeMap.remove(poll.data);
                System.out.println("removed Element: " + poll.data);
            }
            Node node = new Node(key);
            nodeMap.put(key, node);
            q.add(node);
        } else {
            Node node = nodeMap.get(key);
            q.remove(node);
            node.increaseFrequency();
            q.add(node);
        }
    }

    void display() {
        System.out.println(nodeMap.keySet());
    }


    public static void main(String[] args) {
        LFU lfu = new LFU(3);

        lfu.put(1);
        lfu.put(2);
        lfu.put(3);

        lfu.get(1);
        lfu.get(1);
        lfu.get(3);

        lfu.put(4);
        lfu.put(5);

        lfu.display();


    }

}
