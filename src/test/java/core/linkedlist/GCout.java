package core.linkedlist;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sugamagarwal
 */

interface test{
    String getVal();
}


public class GCout {

    String data;

    public GCout(String data) {
        this.data = data;
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityQueue

        Map<GCout, Integer> a =new HashMap<>();
        System.gc();
       /* gCout1 = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("End");*/



    }


    boolean patternMatch() {
        String line = "This order was placed for QT3000! OK?";
        String pattern = "['p','r','r']";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);

    }

}
