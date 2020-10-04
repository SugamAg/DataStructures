package core.tree;

import java.util.*;

/**
 * @author sugamagarwal
 */

public class TreeTraversal {

    //a+b
    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    //+ab
    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    //ab+
    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    static void inOrderUsingStack(Node node) {
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data);
            current = current.right;
        }
    }

    static void preOrderUsingStack(Node node) {
        Stack<Node> stack = new Stack();
        if (node == null)
            return;
        stack.push(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.print(pop.data);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
    }

    static void postOrderUsingStack(Node node) {
        if (node == null)
            return;
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visited = new HashSet<>();
        String s = "";
        stack.push(node);
        Node cur = node.left;
        while (!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node peek = stack.peek();
            if (visited.contains(peek)) {
                s += stack.pop().data;
            } else if (peek.right != null) {
                cur = peek.right;
                visited.add(peek);
            } else {
                Node pop = stack.pop();
                s += pop.data;
            }
        }
        System.out.println(s);
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            System.out.print(remove.data + ",");
            if (remove.left != null) {
                queue.add(remove.left);
            }
            if (remove.right != null) {
                queue.add(remove.right);
            }
        }
    }

    static void zigzag(Node node) {
        if (node == null)
            return;
        Stack<Node> cur = new Stack();
        Stack<Node> nxt = new Stack<>();
        List<List<Integer>> lists = new ArrayList<>();
        boolean ltr = true;
        cur.push(node);
        List<Integer> list = new ArrayList<>();
        while (!cur.isEmpty()) {
            Node pop = cur.pop();
            list.add(pop.data);
            if (ltr) {
                if (pop.left != null) {
                    nxt.push(pop.left);
                }
                if (pop.right != null) {
                    nxt.push(pop.right);
                }
            } else {
                if (pop.right != null) {
                    nxt.push(pop.right);
                }
                if (pop.left != null) {
                    nxt.push(pop.left);
                }
            }
            if (cur.isEmpty()) {
                lists.add(list);
                list = new ArrayList<>();
                ltr = !ltr;
                Stack tmp = nxt;
                nxt = cur;
                cur = tmp;
            }
        }
    }
    //To check shortest path from the root node to the nearest leaf node
    static int minDepth(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return -1;
        int lht = 0;
        int rht = 0;
        lht += minDepth(node.left) - 1;
        rht += minDepth(node.right) - 1;
        return Math.abs(Math.max(lht, rht));
    }

    //Height of the binary tree
    static int height(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int lht = 0;
        int rht = 0;
        lht += height(node.left) + 1;
        rht += height(node.right) + 1;
        return Math.max(lht, rht);
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
       // root.right.left = new Node(6);
        //root.right.left.right = new Node(7);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);

        System.out.println("Height of tree is : " +
                minDepth(root));
       // System.out.println("Height of tree is : " +
              //  height(root));
    }

   /* public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inOrder(root);
        System.out.println();
        inOrderUsingStack(root);
        System.out.println();
        System.out.println("----");
        postOrder(root);
        System.out.println();
        postOrderUsingStack(root);
        System.out.println("----");
        preOrder(root);
        System.out.println();
        preOrderUsingStack(root);

    }*/

}
