package core.tree;

/**
 * @author sugamagarwal
 */
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
