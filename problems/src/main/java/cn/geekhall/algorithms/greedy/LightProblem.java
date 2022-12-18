package cn.geekhall.algorithms.greedy;

import java.util.HashSet;
import java.util.Random;

/**
 * 给定一个字符串str，只由"O"和"X"两种字符组成。
 * "X"表示墙，不能放灯，也不需要点亮
 * "O"表示居民，可以放灯，需要点亮
 * 灯可以照亮邻近的两个位置。
 * 返回点亮str中所有需要点亮的位置所需放置的最少的灯的数量。
 */
public class LightProblem {
    /**
     * 求最少灯的数量（暴力解）
     * @param road 路
     * @return 最少灯数
     */
    public static int minLight(String road) {
        if (road == null || road.length() == 0) return 0;
        return process(road.toCharArray(), 0, new HashSet<Integer>());
    }

    /**
     * str[index...] 位置，自由选择方凳还是不放灯
     * str[0...index-1] 位置，已经做完决定了，哪些位置放灯了保存在lights中。
     * @param str    路
     * @param index  当前已处理位置索引
     * @param lights 已经放灯的位置
     * @return
     */
    private static int process(char[] str, int index, HashSet<Integer> lights) {
        if (index == str.length) { // 结束的时候
            for (int i = 0; i < str.length; i++) {
                if (str[i] == 'O') {
                    // 是否存在没有被照亮的区域。
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i+1)){
                        return Integer.MAX_VALUE; // 无效解
                    }
                }
            }
            return lights.size();
        } else {
            // 获取index位置不放置灯的最小值
            int no = process(str, index + 1, lights);

            // 获取index位置放置灯的最小值
            int yes = Integer.MAX_VALUE;
            if (str[index] == 'O') {
                lights.add(index);
                yes = process(str, index + 1, lights);
                lights.remove(index);
            }

            return Math.min(no, yes);
        }
    }

    /**
     * 求最少灯的数量（贪心解）
     * @param road
     * @return
     */
    public static int minLightGreedy(String road) {
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == str.length) {
                    break;
                } else {
                    if (str[index + 1] == 'X') {
                        index += 2;
                    } else {
                        index += 3;
                    }
                }
            }
        }
        return light;
    }


    /**
     * 生成由"O"和"X"组成的随机字符串。
     * @param len 字符串的最大长度
     * @return 由"O"和"X"组成的随机字符串
     */
    public static String generateRandomRoad(int len) {
        char[] res = new char[(int) (Math.random() * len) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.random() > 0.5 ? 'O' : 'X';
        }
        return new String(res);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            String temp = generateRandomRoad(20);
            System.out.println(temp + " [min light] :" + minLight(temp));
            System.out.println(temp + " [min light greedy] : " + minLightGreedy(temp));
        }
    }
}
