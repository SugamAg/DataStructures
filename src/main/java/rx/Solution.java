package rx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sugamagarwal
 */
public class Solution {

    static int maxSubArraySum(int a[], int size) {
        int max_so_far = 0, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        return max_so_far;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            if (set.contains(s.charAt(i))) {
                if (set.size() > max) {
                    max = set.size();
                }
                set.clear();
                i = findIndex(s.substring(0, i), s.charAt(i)) + 1;
            }
            set.add(s.charAt(i));
            i++;
        }
        return Math.max(max, set.size());
    }

    public static int findIndex(String s, char c) {
        return s.lastIndexOf(c);
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int a[] = new int[nums1.length + nums2.length];
        int count = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    a[count++] = nums1[i++];
                } else {
                    a[count++] = nums2[j++];
                }
            } else if (i < nums1.length) {
                while (i < nums1.length)
                    a[count++] = nums1[i++];
            } else {
                while (j < nums2.length)
                    a[count++] = nums2[j++];
            }
        }
        int x = a.length / 2;
        if (a.length % 2 == 0) {
            return (a[x - 1] + a[x]) / 2.0;
        } else {
            return a[x];
        }
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n = nums1.length + nums2.length;
        int a[] = new int[n];
        int x = n / 2;
        int count = 0;
        while (count <= x) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    a[count] = nums1[i++];
                } else {
                    a[count] = nums2[j++];
                }
            } else if (i < nums1.length) {
                a[count] = nums1[i++];
            } else {
                a[count] = nums2[j++];
            }
            count++;
        }
        if (n % 2 == 0) {
            return (a[x - 1] + a[x]) / 2.0;
        } else {
            return a[x];
        }
    }

    public static String longestPalindrome(String s) {
        String max = "";
        int i = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        while (i < s.length()) {
            int j = i;
            String temp = "";
            for (; j < s.length(); j++) {
                temp += s.charAt(j);
                map.computeIfAbsent(temp, s1 -> isPalindrome(s1));
                if (map.get(temp) && (max.length() < temp.length() - 1)) {
                    max = temp;
                }
            }
            i++;
        }
        return max;
    }

   static String zigZag(String s,  int numRows) {
        boolean flag = true;
        int i = 0;

        int group = 2*numRows - 2;
        int grpCol =  numRows - 1;
       int i1 = s.length() % group;
       int cols = i1 == 0 ? grpCol * s.length()/group : grpCol * (s.length() / group) + 1;

        char[][] ar = new char[numRows][cols];
        int row = 0;
        int col = 0;
        while (i < s.length()){
            if(flag) {
                ar[row++][col] = s.charAt(i++);
                if(row == numRows) {
                    flag = false;
                    row--;
                }
            } else {
                ar[--row][++col] = s.charAt(i++);
                if(row == 0) {
                    flag = true;
                    row++;
                }
            }
        }
        String  a= "";
       for(int k = 0; k < numRows; k++) {
            for(int j = 0; j < ar[k].length ; j++) {
                if(0 != ar[k][j]) {
                  a =  a +ar[k][j];
                }
            }
        }
        return a;
    }


    static boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }


    static int findMaxSum(int[] nums) {
        int start = 0;
        int end = 1;
        int max = Integer.MIN_VALUE;
        int currentMax = nums[start];
        while (end < nums.length) {
            if (currentMax < currentMax + nums[end]) {
                currentMax = currentMax + nums[end];
                //shrink the window from start
                while (currentMax - nums[start] > currentMax) {
                    currentMax = currentMax - nums[start++];
                }
            } else {
                start = end;
                currentMax = nums[start];
            }
            end++;
            max = Math.max(currentMax, max);
        }
        return max;
    }

    static int maxSubArray (int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for(int j = 1;j < nums.length; j++) {
            current = Math.max(current + nums[j], nums[j]);
            max = Math.max(current,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a1 = {-2,1,10,-3,8,-15,-2,8,9,-14};
        int[] a2 = {1, 5, -3, -6, 4, 5, 8, -10, 1, 2};
        int[] a3 = {-3,-7, -5, -23, -9, -20, -2};
       // System.out.println(maxSubArray(a1));
        //System.out.println(maxSubArray(a2));
        System.out.println(maxSubArray(a1));

    }
}
