package cn.geekhall.algorithms.bruteforce;

/**
 * BuyAppleSample.java
 * 小明去买苹果，商店只提供两种类型的袋子，每种类型都有任意数量。
 * 1） 能装下6个苹果的袋子
 * 2） 能装下8个苹果的袋子
 * 小虎可以自由使用两种袋子来装苹果，但是小虎有强迫症，他要求自己的袋子数量必须最少，且使用的每个袋子必须装满。
 * 给定一个正整数N，返回至少使用多少袋子。如果N无法让实用的每个袋子必须装满，返回-1。
 *
 * @author yiny
 */
public class BuyAppleSample {

    /**
     * 如果剩余苹果rest能够被可以装6个苹果的袋子搞定，返回袋子数量，否则返回-1
     * @param rest
     * @return
     */
    public static int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }

    /**
     * 打表法放回最少袋子数量。
     * @param apple
     * @return
     */
    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) { // 如果是奇数返回-1。
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    /**
     * 正常暴力方法返回需要的最少袋子数量
     * @param apple
     * @return
     */
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - 8 * bag8;
        while (bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1) {
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }


    public static void main(String[] args) {
        for (int apple = 1; apple < 100; apple++) {
            System.out.println(apple + " : " + minBags(apple));
            System.out.println(apple + " : " + minBagAwesome(apple));
        }
    }
}
