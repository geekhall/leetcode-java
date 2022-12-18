package cn.geekhall.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 派对的最大快乐值问题
 * 某公司有举办party，你可以决定哪些员工来或者不来，规则：
 * 1. 如果某个员工来了，name这个员工的所有直接下级都不能来。
 * 2. 派对的整体快乐值是所有到厂员工快乐值的累加。
 * 3. 你的目标是让派对的整体快乐值尽量大。
 * 给定一棵多叉树的头结点boss，请返回派对的最大快乐值。
 */
public class MaxHappySample {
    public static class Employee {
        public int happy;
        public List<Employee> subordinates;
        public Employee(int happy) {
            this.happy = happy;
            subordinates = new ArrayList<>();
        }
    }

    public static int getMaxHappy(Employee boss) {
        if (boss == null) {
            return 0;
        }
        return process(boss, false);
    }

    public static int process(Employee cur, boolean up) {
        if (up) {
            int ans = 0;
            for (Employee subordinate : cur.subordinates) {
                ans += process(subordinate, false);
            }
            return ans;
        } else {
            int p1 = cur.happy;
            int p2 = 0;
            for (Employee suboridinate : cur.subordinates) {
                p1 += process(suboridinate, true);
                p2 += process(suboridinate, false);
            }
            return Math.max(p1, p2);
        }
    }

    public static int getMaxHappy2(Employee boss) {
        if (boss == null) {
            return 0;
        }
        Info all = process2(boss);
        return Math.max(all.yes, all.no);
    }

    public static class Info {
        public int yes; // 邀请头结点时整棵树的最大快乐值
        public int no;  // 不邀请头结点时整棵树的最大快乐值
        public Info (int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static Info process2(Employee x) {
        if (x.subordinates.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int yes = x.happy;
        int no = 0;
        for (Employee suboridinate : x.subordinates) {
            Info info = process2(suboridinate);
            yes += info.no; // 头结点参加时，类加上其直属下级不参加的快乐值。
            no += Math.max(info.yes, info.no);
        }
        return new Info(yes, no);
    }

}
