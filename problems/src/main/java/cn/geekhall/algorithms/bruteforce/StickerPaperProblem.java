package cn.geekhall.algorithms.bruteforce;

import java.util.HashMap;

/**
 * 给定一个字符串str，给定一个字符串类型的数组arr。
 * arr里的每一个字符串，代表一张贴纸，你可以把单个字符剪开使用，目的是拼出str来。
 * 返回需要至少多少张贴纸可以完成这个任务。例子:str="babac",arr ={"ba","c","abcd
 * 至少需要两张贴纸"ba和"abcd"，因为使月用这两张贴纸，把每一个字符单独剪开，含有2个a、2个b、1个c。是可以拼出 str的。所以返回2。
 */
public class StickerPaperProblem {

    public static int getAnswer(String target, String[] stickers){
        int n = stickers.length;
        // 每个sticker中每个字母都有多少个。
        int[][] stickerMap = new int[n][26];
        HashMap<String, Integer> dp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                stickerMap[i][c - 'a']++;
            }
        }

        dp.put("", 0);
        return process(target, stickerMap, dp);
    }

    public static int process( String rest, int[][] stickersMap, HashMap<String, Integer> dp){
        if (dp.containsKey(rest)) return dp.get(rest);

        int ans = Integer.MAX_VALUE;
        int n = stickersMap.length;
        int[] targetMap = new int[26];
        char[] target = rest.toCharArray();

        // targetMap初始化
        for (char c : target) {
            targetMap[c - 'a']++;
        }

        // 逐个sticker遍历
        for (int i = 0; i < n; i++) {
            // 若该sticker中不包含target的第一个字母，则跳过
            if (stickersMap[i][target[0] - 'a'] == 0) {
                continue;
            }

            // 用于存储本轮遍历后剩余的字符。
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) { // 遍历26个字母
                if (targetMap[j] > 0) { // target中包含char('a'+j)这个字符
                    // targetMap[j] : 需要多少个该字符
                    // stickersMap[i][j] : 第i个sticker中有多少个该字符
                    for (int k = 0; k < Math.max(0, targetMap[j] - stickersMap[i][j]); k++) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            String s = sb.toString();
            int tmp = process(s, stickersMap, dp);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
        System.out.println(rest+ " : " + ans);

        return dp.get(rest);
    }

    public static void main(String[] args) {
        String str = new String("aaaabbcccc");
        String[] stickers = new String[]{"aa", "ab","bb", "cc", "abc"};
        System.out.println(getAnswer(str, stickers));
    }
}
