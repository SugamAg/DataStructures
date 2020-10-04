package core.tree;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author sugamagarwal
 */




public class Sample {

    //Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    //key = 3
    //Output : Found at index 8


    static int search(int[] ar, int key) {
        int pt = sea(ar);

        if(key >= ar[0] &&  key <= ar[pt-1]) {
           return Arrays.binarySearch(ar, 0, pt, key);
        } else {
            return Arrays.binarySearch(ar, pt, ar.length, key);
        }
    }

    static int sea(int[] ar) {
        int l = 0;
        int h = ar.length -1;
        while (l < h) {
            int m  = l+ (h-l)/2;
            if (ar[m] > ar[m - 1]) {
                if (ar[m] > ar[l]) {
                    l = m;
                } else {
                    h = m;
                }
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ar1 = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        int[] ar2 = {10, 1, 2, 3, 5, 6, 7, 8, 9};
        int[] ar3 = {9,10, 1, 2, 3, 5, 6, 7, 8};
        int[] ar4 = {8, 9, 10, 1, 2, 3, 5, 6, 7};
        int[] ar5 = {7, 8, 9,10, 1, 2, 3, 5, 6};

        int[] ar  = {5, 6, 7, 8, 9, 10, 1, 2, 3};


        System.out.println(search(ar, 1));
        System.out.println(search(ar, 7));
    }


}
