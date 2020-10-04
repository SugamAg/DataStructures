package core.linkedlist;




import java.util.Collection;

class Node<K> {

    K data;
    Node next;

    Node(K data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList<K> {

    private Node head;
    private int size;

    public LinkedList(){
        size = 0;
    }

    public LinkedList(Collection<? extends K> collection) {
        this();
        addAll(collection);
    }

    /**
     *
     * @param data
     * @return
     */
    public Node add(K data) {
        if (null == head) {
            size++;
            return head = new Node<>(data, null);

        }
        Node node = new Node<>(data, head);
        size++;
        return head = node;
    }

    /**
     *
     * @param dataCollection
     * @return
     */
    public Node addAll(Collection<? extends K> dataCollection) {
        for (K k : dataCollection) {
            add(k);
        }
        return head;
    }

    /**
     *
     * @return
     */

    public int size() {
        return size;
    }

    /**
     *
     * @param data
     * @return
     */
    public Node remove(K data) {

        //if head is null
        if (null == head) {
            System.out.println("List is empty");
            return null;
        }
        //if head is equal to data
        if(head.data.equals(data)){
            Node node  = head;
            head = head.next;
            node.next = null;
            size--;
            return node;
        }
        Node prev = head;
        while (prev.next != null && !prev.next.data.equals(data)) {
            prev = prev.next;
        }

        if (prev.next == null) {
            System.out.println("Element is not found");
            return null;
        }
        Node<K> matchedNode = prev.next;
        prev.next = matchedNode.next;
        matchedNode.next = null;
        size--;
        return matchedNode;
    }

    /**
     *
     * @param data
     * @return
     */
    public Node find(K data) {
        Node temp = head;
        while (temp != null && !temp.data.equals(head)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Data is not present");
            return null;
        }
        return temp;
    }

    public Node peek() {
        return head;
    }

}
