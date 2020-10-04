package calculator;

import java.util.LinkedList;
import java.util.Stack;

class Graph
{

    // An array representing the graph as an adjacency list
    private final LinkedList<Integer>[] adjacencyList;

    Graph(int nVertices)
    {
        adjacencyList = new LinkedList[nVertices];
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            adjacencyList[vertexIndex] = new LinkedList<>();
        }
    }

    // function to add an edge to graph
    void addEdge(int startVertex, int endVertex)
    {
        adjacencyList[startVertex].add(endVertex);
    }

    private int getNoOfVertices()
    {
        return adjacencyList.length;
    }

    private void topologicalSortUtil(int currentVertex, boolean[] visited,
                                     Stack<Integer> stack)
    {
        visited[currentVertex] = true;

        for (int adjacentVertex : adjacencyList[currentVertex])
        {
            if (!visited[adjacentVertex])
            {
                topologicalSortUtil(adjacentVertex, visited, stack);
            }
        }
        stack.push(currentVertex);
    }

    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[getNoOfVertices()];
        for (int i = 0; i < getNoOfVertices(); i++)
        {
            visited[i] = false;
        }

        for (int i = 0; i < getNoOfVertices(); i++)
        {
            if (!visited[i])
            {
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty())
        {
            System.out.print((char)('a' + stack.pop()) + " ");
        }
    }
}

public class OrderOfCharacters
{
    private static void printOrder(String[] words, int alpha)
    {
        Graph graph = new Graph(alpha);

        for (int i = 0; i < words.length - 1; i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                if (word1.charAt(j) != word2.charAt(j))
                {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a');
                    break;
                }
            }
        }
        graph.topologicalSort();
    }

    public static void main(String[] args)
    {

        int[] ar = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int d = 5;
        double winSum = 0;
        for (int i = 0; i< d; i++)
            winSum += ar[i];
        System.out.println(winSum/d);
        int s = 0, e = d-1;
        while (e < ar.length-1){
            winSum = winSum - ar[s++] + ar[++e];
            System.out.println(winSum/d);
        }
    }
} 