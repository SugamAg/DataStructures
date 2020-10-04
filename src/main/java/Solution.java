import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * @author sugamagarwal
 */
public class Solution {


    //-3, -5, -10, -20, -2
    //-3,-5, 4, 5, 8, -10, 1, 2
    int maxSubArray(int[] arr) {

        int index = 0;
        int max = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;

        while (index < arr.length) {
            if(currentMax < (currentMax + arr[index])) {
                currentMax = currentMax + arr[index];
            } else if(currentMax > (currentMax + arr[index])) {
                currentMax = arr[index];
            } else {
                currentMax = 0;
            }
            max = Math.max(currentMax, max);
            index++;
        }
        return max;
    }


   // [2,1,4,3] --> [12,24,6,8]
    static void test(int[] arr) {

        int multiply = 1;
        for(int x: arr) {
            multiply *= x;
        }
        for (int y : arr) {
            System.out.print(multiply/y + " ");

        }
    }

    static void containers(int[] ar) {

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(ar).forEach(value -> map.put(value, map.getOrDefault(value, 0) + 1));
        int containersNeeded = 0;

       while (!map.isEmpty()) {
           Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
           while (iterator.hasNext()) {
               Map.Entry<Integer, Integer> next = iterator.next();
               if (map.get(next.getKey()) == 1) {
                   iterator.remove();
               } else {
                   map.put(next.getKey(), map.get(next.getKey()) - 1);
               }
           }
           containersNeeded++;
       }
        System.out.println(containersNeeded);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 3, 3, 3};
        containers(array);
     }

}
