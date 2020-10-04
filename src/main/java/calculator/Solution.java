package calculator;




import java.util.*;


/**
 * @author sugamagarwal
 */
public class Solution {

   /* static List<Integer> getMissingNumbers(int[] a, int k) {

        int i = 0;
        while (i < a.length) {
            if (a[i] > 0 && a[i] <= a.length && a[i] != a[a[i] - 1]) {
                swap(a, i, a[i] - 1);
            } else
                i++;
        }

        List<Integer> missing = new ArrayList<>();
        HashSet<Integer> extra = new HashSet<>();

        for (i = 0; i < a.length && missing.size() < k; i++) {
            if (a[i] != i + 1) {
                missing.add(i + 1);
                extra.add(a[i]);
            }
        }
        for (i = 1; missing.size() < k; i++) {
            int c = a.length + i;
            if (!extra.contains(c))
                missing.add(c);
        }
        return missing;

    }

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }*/


    public int solution(String S) {

        int length = S.length();
        if(length == 0)
            return 0;
        while(isSwapPossible(S)) {
            int i = 0;
            while (i < S.length() - 1) {
                if (S.charAt(i) != S.charAt(i + 1)) {
                    String regex = S.substring(i, i + 2);
                    S = S.replaceFirst(regex, getReplaceMent(regex));
                } else {
                    i++;
                }
            }
        }
        return S.length();
    }

    private boolean isSwapPossible(String s) {
        return !(s.replaceAll("a", "").length() == 0 || s.replaceAll("b", "").length() == 0 || s.replaceAll("c", "").length() == 0);
    }


    private String getReplaceMent(String s) {
        if (s.equalsIgnoreCase("ab") || s.equalsIgnoreCase("ba"))
            return "c";
        else if(s.equalsIgnoreCase("bc") || s.equalsIgnoreCase("cb"))
            return "a";
        else
            return "b";
    }

    public static int getMinDeletions(String s) {
    int count = 0;
    Set<Character> set = new HashSet<>();
    for(Character c : s.toCharArray()) {
        if(set.contains(c)) count++;
        else set.add(c);
    }
    return count;
    }


    public static String cutThemAll(List<Long> lengths, long minLength) {
        int start = 0;
        int end = lengths.size() - 1;
        long sum = lengths.stream().mapToLong(Long::longValue).sum();
        while (start < end) {
            if(lengths.get(start) <= lengths.get(end) && sum >= minLength) {
                sum -= lengths.get(start++);
            } else if(lengths.get(start) > lengths.get(end) && sum >= minLength) {
                sum -= lengths.get(end--);
            } else {
                return "Impossible";
            }
        }
        return "Possible";
    }

    public static List<Integer> constructSequence(int n, int lo, int hi) {

        List<Integer> sequence = new ArrayList<>();
        List<Integer> defaultOut = new ArrayList<>();
        defaultOut.add(-1);
        if(n == 0) {
            return defaultOut;
        }
        int dscWindow = hi - lo +1;
        int elem = hi - (n-dscWindow);
        if(dscWindow >= n){
            elem = hi -1;
        }
        boolean asc = true;
        while (sequence.size() < n) {
            if(elem < lo)
                return defaultOut;
            if(elem == hi){
                asc = false;
            }
            sequence.add(elem);
            if(asc){
                elem++;
            } else{
                elem--;
            }
        }
    return sequence;
    }

    public static void main(String[] args) {

tst();
        //System.out.println(constructSequence(6,5,10));

    }

    static void tst() {
        int c = 0;
        int a = 3;
        while (c++ < 3) {
            int b = (1+c*2)%3;
            switch (b) {
                default:
                case 0: a -= 1; break;
                case 1: a +=5;
            }

        }
        System.out.println(a);
    }
}
