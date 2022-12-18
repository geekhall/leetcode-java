package cn.geekhall.algorithms.bruteforce;

/**
 *
 */
public class WashCupProblem {

    /**
     *
     * @param drinks        所有人喝完咖啡的时间，输入变量
     * @param washTime      洗一个杯子的时间，固定变量
     * @param volatileTime  自己挥发干净的事件，固定变量
     * @param index         index 之前的杯子都干净了
     * @param washLine      机器可用的时间点
     * @return
     */
    public static int process(int[] drinks, int washTime, int volatileTime, int index, int washLine){
        if (index == drinks.length - 1) // 剩最后一杯的时候
            return Math.min(
                    Math.max(washLine, drinks[index]) + washTime,   // 送去洗
                    drinks[index] + volatileTime);                  // 等挥发

        // 当前的咖啡洗完的时间。
        int wash = Math.max(washLine, drinks[index] + washTime);
        int next1 = process(drinks, washTime, volatileTime, index + 1, wash);
        int p1 = Math.max(wash,next1);

        // 当前咖啡杯不洗挥发的时间
        int dry = drinks[index] + volatileTime;
        int next2= process(drinks,washTime, volatileTime, index + 1, washLine);
        int p2 = Math.max(dry, next2);

        return Math.min(p1, p2);
    }
}
