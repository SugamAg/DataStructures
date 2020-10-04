package core.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sugamagarwal
 */
public class BinaryHeap {

    List<Integer> data;
    int index;

    public BinaryHeap() {
        data = new ArrayList<>();
        index = -1;
    }


    public void insert(int d) {
        data.add(++index, d);
        int current = index;
        while(current > 0) {
            int parent = (current-1)/2;
           if(data.get(current) > data.get(parent))
               swap(current, parent);
           current = parent;
        }
    }

    public int  poll() {
        int output = data.get(0);
        data.set(0, data.get(index));
        data.remove(index--);
        heapify();
        return output;
    }

    private void heapify() {
        int root = 0;
        while (root <= index) {
            int left = 2 * root + 1;
            int right = 2* root +2;

            if(left <= index && right <= index) {
                if (data.get(root) > data.get(left) && data.get(root) > data.get(right)) {
                    root++;
                    continue;
                } else {
                    int i = data.get(left) > data.get(right) ? left : right;
                    swap(i, root);
                }
            } else {
                if(left <= index && data.get(left) > data.get(root))
                    swap(left, root);
                if(right <= index && data.get(right) > data.get(root))
                    swap(right, root);
            }
            root++;
        }
    }

    private void swap(int x, int y) {
        int temp = data.get(x);
        data.set(x, data.get(y));
        data.set(y, temp);
    }




    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();

        heap.insert(5);
        heap.insert(7);
        heap.insert(3);
        heap.insert(2);
        heap.insert(4);
        heap.insert(8);
        heap.insert(1);
        heap.insert(10);

        System.out.print(heap.data);

        while (heap.data.size() > 0)
            System.out.println( heap.poll());



    }


}
