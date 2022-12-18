package cn.geekhall.algorithms.bruteforce;

import java.util.ArrayList;

/**
 * PrintAllPermutations.java
 *
 * @author yiny
 */
public class PrintAllPermutations {

    public static ArrayList<String> permutations(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        char[] chars = str.toCharArray();
        process(chars, 0, res);
        return res;
    }

    public static void process(char[] chars, int i, ArrayList<String> res) {
        if (i == chars.length) res.add(String.valueOf(chars));
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            process(chars, i + 1, res);
            swap(chars, i, j);
        }

    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        ArrayList<String> res = permutations("abcd");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
