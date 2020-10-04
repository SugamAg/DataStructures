/*
package core.stack;

import java.util.*;

class TestClass {
    static int treedia = 0;

    public static void main(String args[]) throws Exception {
       */
/* Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        Node root = new Node(s.nextInt());
        List<Point> list = new ArrayList<>();
        for(int i =0 ; i < t-1;i++) {
            String d = s.next();
            int x = s.nextInt();
            list.add(new Point(d, x));
        }
        list.sort(Comparator.comparing(p -> p.dir));
        for(Point p : list) {
            int k = 0;
            Node temp = root;
            String d = p.dir;
            while(k < d.length() - 1){
                if(d.charAt(k) == 'L')
                    temp = temp.left;
                else
                    temp = temp.right;
                k++;
            }
            if(d.charAt(k) == 'L')
                temp.left = new Node(p.data);
            else
                temp.right = new Node(p.data);
        }


        diaOfTree(root);
        System.out.println(treedia);*//*


        Node node  = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(4);
        node.right.right = new Node(5);
        node.right.left.right = new Node(6);
        node.right.left.right.right = new Node(7);
        node.right.right.left = new Node(8);
        node.right.right.left.left = new Node(9);

        diaOfTree(node);
        System.out.println(treedia);

        Node node1 = new Node(1);
        node1.left = new Node(3);
        node1.right = new Node(2);
        node1.left.left = new Node(7);
        node1.left.right = new Node(6);
        node1.left.left.right = new Node(10);
        node1.right.left = new Node(5);
        node1.right.right = new Node(4);
        node1.right.left.left = new Node(9);
        node1.right.left.right = new Node(8);

        toPerfectBinaryTree(node1, height(node1));
        List<Integer> lfs = lfs(node1);
        mirror(node1);
        List<Integer> lfs1 = lfs(node1);


    }

    static List<Integer> lfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            l.add(poll.data);
            if (poll.left != null)
                q.add(poll.left);
            if(poll.right != null)
                q.add(poll.right);
        }
        return l;
    }


    static int diaOfTree(Node root) {
        if (root == null)
            return 0;
        int left = diaOfTree(root.left);
        int right = diaOfTree(root.right);
        int dia = left + right + 1;
        HashMap
        treedia = Math.max(dia, treedia);
        return Math.max(left, right) + 1;
    }

    static int height(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int lht = 0;
        int rht = 0;
        lht += height(node.left) + 1;
        rht += height(node.right) + 1;
        return Math.max(lht, rht);
    }

   static void toPerfectBinaryTree(Node root, int level) {
        if( level == 1)
            return ;
        if(level > 1) {
            if (root.left == null)
                root.left = new Node(-1);
            if (root.right == null)
                root.right = new Node(-1);
            toPerfectBinaryTree(root.left, level - 1);
            toPerfectBinaryTree(root.right, level - 1);
        }
    }

   static Node mirror(Node node) {
        if(node == null)
            return null;
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        node.right = left;
        node.left = right;
        return node;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class Point{
    String dir;
    int data;

    public Point(String dir, int data) {
        this.dir = dir;
        this.data = data;
    }
}
*/
