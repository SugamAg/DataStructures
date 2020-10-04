package core.conversion;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author sugamagarwal
 */
public class InfixConversion {

   static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String toPostFix(String statement) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < statement.length();i++){
            char element = statement.charAt(i);
            if(Character.isLetterOrDigit(element)) {
                result += element;
                continue;
            }
            if (element == '(') {
                stack.push(element);
            } else if(element == ')') {
                while (!stack.isEmpty() &&  stack.peek() != '(') {
                    result += stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Statement";
                } else {
                    stack.pop();
                }
            } else {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(element)) {
                    if(stack.peek() == '(') {
                        return "Invalid Statement";
                    }
                        result += stack.pop();
                }
                stack.push(element);
            }
        }
        while (!stack.isEmpty()) {
            if(stack.peek() == '(') {
                return "Invalid Statement";
            }
            result += stack.pop();
        }
        return result;
    }

    static String toPreFix(String statement) {
       String temp = new StringBuilder(statement).reverse().toString();
       String reversedString = "";
       for(int i=0; i< temp.length();i++) {
           if(temp.charAt(i) == '('){
               reversedString += ")";
           } else if(temp.charAt(i) == ')') {
               reversedString += "(";
           } else {
               reversedString += temp.charAt(i);
           }
       }
       return new StringBuilder(toPostFix(reversedString)).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        //stringList.add("A+B*C+D");
        stringList.add("d+c*b+a");
        //stringList.add("(A+B)*(C+D)");
        stringList.forEach(s -> System.out.println(toPostFix(s)));
        System.out.println("-------");
        stringList.forEach(s -> System.out.println(toPreFix(s)));
    }



}
