package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sugamagarwal
 */
public class StringSort {



    

    static void sortVersions(List<String> vers) {
        Collections.sort(vers);
        vers.forEach(System.out::println);
    }

    public static void main(String[] args) {
        String[] s = {"1.2", "0.8.1", "1.0"};
        sortVersions(Arrays.asList(s));
    }
}
