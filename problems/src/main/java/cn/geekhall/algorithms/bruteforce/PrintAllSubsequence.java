package cn.geekhall.algorithms.bruteforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrintAllSubsequence {
    /**
     * 递归打印子字符串
     * @param s
     * @return
     */
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process(str, 0 , ans, path);
        return ans;
    }

    /**
     * 递归打印子字符串
     * @param str
     * @param index
     * @param ans
     * @param path
     */
    public static void process(char[] str, int index, List<String> ans, String path) {
//        System.out.println(index + path);
        if (index == str.length) {
            ans.add(path); // 沿途所形成的答案放入ans中
            return;
        }
        String no = path;
        process(str, index + 1, ans, no);//index此时来到的位置，要or不要

        String yes = path + String.valueOf(str[index]);
        process(str, index + 1, ans, yes);//index此时来到的位置，要or不要
    }

    public static HashSet<String> subs1(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> ans = new HashSet<>();
        process1(str, 0 , ans, path);
        return ans;
    }


    public static void process1(char[] str, int index, HashSet<String> ans, String path) {
//        System.out.println(index + path);
        if (index == str.length) {
            ans.add(path); // 沿途所形成的答案放入ans中
            return;
        }
        String no = path;
        process1(str, index + 1, ans, no);//index此时来到的位置，要or不要

        String yes = path + String.valueOf(str[index]);
        process1(str, index + 1, ans, yes);//index此时来到的位置，要or不要
    }

    /**
     * 分支限界的暴力全排列方法。（剪枝？）
     * 执行前先判断分支是否有必要，没有必要不执行。
     *
     * @param str
     * @return
     */
    public static ArrayList<String> permutationNoRepeat(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process2(chs, 0, res);
        return res;
    }

    /**
     *
     * @param chs  chs[0..i-1] 已经做好决定的，chs[i..] 都有机会来到i位置
     * @param i    终止位置，chs当前的样子，就是一种结果=> res
     * @param res  排列后的数组
     */
    private static void process2(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']) {     // chs[j]没出现过
                visit[chs[j] - 'a'] = true; // 登记chs[j]
                swap(chs, i, j);
                process2(chs, i+1, res);
                swap(chs, i, j);
            }
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
//        System.out.println(subs("abc"));
//        System.out.println(subs1("abca"));
        System.out.println(permutationNoRepeat("abca"));
    }
}
