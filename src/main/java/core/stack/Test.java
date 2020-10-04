package core.stack;

import java.util.Comparator;
import java.util.PriorityQueue;

class Test {
      

    static java.util.Stack<Character> st = new java.util.Stack<>();

    static void insert_at_bottom(char x) 
    { 
  
        if(st.isEmpty()) 
            st.push(x); 
  
        else
        {
            char a = st.peek(); 
            st.pop(); 
            insert_at_bottom(x); 

            st.push(a); 
        } 
    } 
      

    static void reverse() 
    { 
        if(st.size() > 0) 
        {
            char x = st.peek(); 
            st.pop(); 
            reverse(); 

            insert_at_bottom(x); 
        } 
    } 
      
    // Driver Code 
    public static void main(String[] args)  
    {
        // push elements into 
        // the stack 
        st.push('1'); 
        st.push('2'); 
        st.push('3'); 
        st.push('4'); 
          
        System.out.println("Original Stack"); 
          
        System.out.println(st); 
          
        // function to reverse  
        // the stack 
        reverse(); 
          
        System.out.println("Reversed Stack"); 
          
        System.out.println(st); 
    } 
}