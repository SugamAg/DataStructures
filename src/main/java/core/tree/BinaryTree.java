package core.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* Max no. of node at a level (considering root at level 1)  = 2^(i -1)
* Max no. of node of a tree with height i = 2^i - 1
* Max height of tree with node N  = log2(N+1)
* */
public class BinaryTree {

    private static Node root;

    //a+b
    static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    //+ab
    static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    //ab+
    static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    static void insert(int element, Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();

            if(temp.left == null) {
                temp.left = new Node(element);
                break;
            } else {
                queue.add(temp.left);
            }
            if(temp.right == null) {
                temp.right = new Node(element);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    /* It works in 2 steps:
        Find the key node and the deepest node which has to be deleted
        delete the depeest node and copy deepest node data in key node
    */
    static Node delete(int key, Node node) {

        if(node == null) {
            return null;
        }
        if(node.left == null && node.right == null) {
            if(node.data == key) {
                node = null;
            } else {
                return node;
            }
        }

        Node keyNode = null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Node temp = null;
        while (!queue.isEmpty()) {
            temp = queue.remove();
            if(temp.data == key) {
                keyNode = temp;
            }
            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }
        if(keyNode != null){
            int x = temp.data;
            deleteDeepest(temp, node);
            keyNode.data = x;
        }
        return node;
    }

    //Delete Deepest Node from right to left
    private static void deleteDeepest(Node dNode, Node node) {
       Queue<Node> queue = new ArrayDeque<>();
       queue.add(node);
       while (!queue.isEmpty()) {
           Node temp = queue.remove();
           if(temp == dNode) {
               temp = null;
               return;
           }
           if(temp.right != null) {
               if(temp.right == dNode) {
                   temp.right = null;
                   return;
               } else {
                   queue.add(temp.right);
               }
           }
           if(temp.left != null) {
               if(temp.left == dNode) {
                   temp.left = null;
                   return;
               } else {
                   queue.add(temp.left);
               }
           }
       }
    }


    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print( "Inorder traversal before insertion:");
        inOrder(root);

        int key = 12;
        insert(key,root);

        System.out.print("\nInorder traversal after insertion:");
        inOrder(root);
        System.out.print("\nDeletion :");
        inOrder(delete(11, root));

    }
}