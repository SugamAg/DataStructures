package calculator;

import java.util.*;

/**
 * @author sugamagarwal
 */
public class IntCalc implements Operation<Integer> {


    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        return x - y;
    }

    @Override
    public Integer multiplly(Integer x, Integer y) {
        return x * y;
    }




    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        Stack<Node> stack = new Stack<>();

        ArrayList<String> out = new ArrayList<>();
        if(inputArray.isEmpty()) {
            return out;
        }

        stack.push(new Node(inputArray.get(0)));
        for(int i = 1; i<inputArray.size(); i++) {
            Node peek = stack.peek();
            if(peek != null && peek.getC().equalsIgnoreCase(inputArray.get(i))) {
                peek.incrementFrequency();
            } else {
                stack.push(new Node(inputArray.get(i)));
            }
            if(i < inputArray.size() - 1 && !inputArray.get(i).equalsIgnoreCase(inputArray.get(i+1)) && burstLength <= stack.peek().getFrequency()) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if(pop.getFrequency() < burstLength)
            while (pop.getFrequency() >0){
                out.add(pop.getC());
                pop.decreaseFrequency();
            }
        }
        Collections.reverse(out);
        return out;
    }


    static int countSpecialElements(List<List<Integer>> matrix) {

        if(matrix.isEmpty())
            return 0;

        int m = matrix.size();
        int n = matrix.get(0).size();
        int[] rmax = new int[m];
        int[] rmin = new int[m];
        int[] cmax = new int[n];
        int[] cmin = new int[n];

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            HashMap<Integer, Integer> rowOccur = new HashMap<>();
            List<Integer> row = matrix.get(i);
            for (Integer c : row) {
                max = Math.max(c, max);
                min = Math.min(c, min);
                rowOccur.put(c, rowOccur.getOrDefault(c, 0) +1);
            }
            if(rowOccur.get(max) > 1 || rowOccur.get(min) > 1)
                return -1;
            rowOccur.clear();
            rmax[i] = max;
            rmin[i] = min;
        }

        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            HashMap<Integer, Integer> colOccur  = new HashMap<>();
            for (List<Integer> row : matrix) {
                max = Math.max(row.get(j), max);
                min = Math.min(row.get(j), min);
                colOccur.put(row.get(j), colOccur.getOrDefault(row.get(j), 0) +1);
            }
            if(colOccur.get(max) > 1 || colOccur.get(min) > 1)
                return -1;
            colOccur.clear();
            cmax[j] = max;
            cmin[j] = min;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix.get(i).get(j) == rmax[i]) || (matrix.get(i).get(j) == rmin[i]) || (matrix.get(i).get(j) == cmax[j]) || (matrix.get(i).get(j) == cmin[j])) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

    }

}

class Node {
    private String c;
    private int frequency;

    public Node(String c) {
        this.c = c;
        this.frequency = 1;
    }

    public void incrementFrequency() {
        this.frequency += 1;
    }

    public void decreaseFrequency() {
        this.frequency -= 1;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getC() {
        return c;
    }
}
