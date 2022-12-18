package cn.geekhall.algorithms.greedy;

import cn.geekhall.datastructures.linkedlist.Problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 安排会议室使得举行会议场次最多。
 * 要求：同一时间只能安排同一场会议。
 */
public class BestArrangeProblem {
    /**
     * 会议对象
     */
    public static class Program{
        public int start;
        public int end;
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 安排会议室使得举行会议场次最多。(暴力解)
     * @param programs 会议
     * @return 可以安排的会议场次
     */
    public static int bestArrange(Program[] programs) {
        if (programs == null || programs.length == 0) return 0;
        return process(programs, 0, 0);
    }

    /**
     * 目前来到timeline时间点，已经安排了done这么多会会议。
     * 返回能安排的最多会议数量
     * @param programs 还剩什么会议
     * @param done     之前已经安排过的会议数量
     * @param timeLine 目前来到时间点
     * @return 能安排的最多会议数量
     */
    public static int process(Program[] programs, int done, int timeLine) {
        if (programs.length == 0) return done;
        int max = done; // 还有会议可以选择
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeLine) {
                Program[] next = copyButExcept(programs, i);
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }
        return max;
    }

    /**
     * 复制源数组programs中除第i个元素以外的所有元素，返回复制后的新数组。
     *
     * @param programs 源数组
     * @param i        要排除的元素索引值
     * @return         排除后的数组
     */
    public static Program[] copyButExcept(Program[] programs, int i) {
        Program[] ans = new Program[programs.length - 1];
        int index = 0;
        for (int k = 0; k < programs.length; k ++) {
            if (k != i) {
                ans[index++] = programs[k];
            }
        }
        return ans;
    }

    /**
     * 安排会议室使得举行会议场次最多。(贪心解)
     * @param programs
     * @return
     */
    public static int bestArrangeGreedy(Program[] programs) {
        Arrays.sort(programs, new ProgramComparator());
        int timeline = 0;
        int result = 0;
        for (Program program : programs) {
            if (timeline <= program.start) {
                result++;
                timeline = program.end;
            }
        }
        return result;
    }

    /**
     * Program比较器类，按照会议结束时间从早到晚排序。
     */
    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            // 根据谁的结束时间早排序。
            return o1.end - o2.end;
        }
    }

    /**
     * 随机会议生成器
     * 测试用
     *
     * @param programSize 最大会议数量
     * @param timeMax     最大会议时间
     * @return            Program[] 会议数组
     */
    public static Program[] generatePrograms(int programSize, int timeMax) {
        Program[] ans = new Program[(int)(Math.random() * (programSize + 1))];
        for (int i = 0; i < ans.length; i++){
            int start = (int)(Math.random() * (timeMax));
            int end = (int)(Math.random() * (timeMax - start + 1)) + start + 1;
            ans[i] = new Program(start, end);
        }
        return ans;
    }

    /**
     * 会议打印方法
     * @param programs 需要打印的会议
     */
    public static void printPrograms(Program[] programs) {
        for (Program p : programs) {
            System.out.println("["+ p.start + " - " + p.end + "]");
        }
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Program[] programs = generatePrograms(5, 18);
            int resultBruteForce = bestArrange(programs);
            int resultGreedy = bestArrangeGreedy(programs);
            if (resultBruteForce != resultGreedy) {
                System.out.println("Oops!");
                printPrograms(programs);
                System.out.println(resultBruteForce);
                System.out.println(resultGreedy);
            }
        }
        System.out.println("test end!");
    }
}
