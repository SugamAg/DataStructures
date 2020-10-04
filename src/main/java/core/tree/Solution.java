package core.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class Node {
        char data;
        Node left;
        Node right;
    }

    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static Node newNode(char data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return (node);
    }


    /* Given a binary tree, print its nth nodes of inorder*/
    static void NthInorder(Node node, int n, int count) {
        if (node == null)
            return;

        if (count <= n) {
            /* first recur on left child */
            NthInorder(node.left, n, count);
            count++;

            // when count = n then print element
            if (count == n)
                System.out.println(node.data);

            /* now recur on right child */
            NthInorder(node.right, n, count);
        }
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        inOrder(node.left);
        inOrder(node.right);
    }



    static void zigzag(Node node) {
      if(node == null)
          return;
      Stack<Node> cur = new Stack();
      Stack<Node> nxt = new Stack<>();
      List<List<Integer>> lists = new ArrayList<>();
      boolean ltr = true;
      cur.push(node);
      List<Integer> list = new ArrayList<>();
      while (!cur.isEmpty()) {
          Node pop = cur.pop();
          if(ltr) {
            if(pop.left != null) {
                nxt.push(pop.left);
            }
            if(pop.right != null) {
                nxt.push(pop.right);
            }
          } else {
              if(pop.right != null) {
                  nxt.push(pop.right);
              }
              if(pop.left != null) {
                  nxt.push(pop.left);
              }
          }
          if(cur.isEmpty()) {
              ltr = !ltr;
              Stack tmp = nxt;
              nxt = cur;
              cur = tmp;
          }
      }
    }

    /* Driver program to test above functions*/
    public static void main(String args[]) {
        Node root = newNode('a');
        root.left = newNode('b');
        root.right = newNode('c');
        root.left.left = newNode('d');
        root.left.right = newNode('e');
        root.left.left.left = newNode('h');
        root.left.left.left.left = newNode('i');
        root.left.left.left.right = newNode('j');
        root.right.left = newNode('f');
        root.right.right = newNode('g');

        int n = 1;
        inOrder(root);
        System.out.println();
        /*Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter");
            int n1 = scanner.nextInt();
            NthInorder(root, n1, 0);
        }*/
        //  NthInorder(root, n);

    }
} 
  