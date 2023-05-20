package net.geekhour.problems.p01400.p01482;

/**
 * ID: 01482
 * Title: Minimum Number of Days to Make m Bouquets
 * Difficulty: Medium
 * Description: You are given an integer array bloomDay, an integer m and an
 * integer k.
 *
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 *
 * The garden consists of n flowers, the i th flower will bloom in the
 * bloomDay[i] and then can be used in exactly one bouquet.
 *
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets return -1.
 *
 * Example 1:
 *
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1 Output: 3 Explanation: Let us
 * see what happened in the first three days. x means flower bloomed and _ means
 * flower did not bloom in the garden. We need 3 bouquets each should contain 1
 * flower. After day 1: [x, _, _, _, _] // we can only make one bouquet. After
 * day 2: [x, _, _, _, x] // we can only make two bouquets. After day 3: [x, _,
 * x, _, x] // we can make 3 bouquets. The answer is 3.
 *
 * Example 2:
 *
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2 Output: -1 Explanation: We need
 * 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5
 * flowers so it is impossible to get the needed bouquets and we return -1.
 *
 * Example 3:
 *
 * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3 Output: 12 Explanation: We
 * need 2 bouquets each should have 3 flowers. Here is the garden after the 7
 * and 12 days: After day 7: [x, x, x, x, _, x, x] We can make one bouquet of
 * the first three flowers that bloomed. We cannot make another bouquet from the
 * last three flowers that bloomed because they are not adjacent. After day 12:
 * [x, x, x, x, x, x, x] It is obvious that we can make two bouquets in
 * different ways.
 *
 * Constraints:
 *
 * bloomDay.length == n
 * 1 <= n <= 10 5
 * 1 <= bloomDay[i] <= 10 9
 * 1 <= m <= 10 6
 * 1 <= k <= n
 */
class Solution01482 {

    // wrong answer
    // public int minDays(int[] bloomDay, int m, int k) {
    // int n = bloomDay.length;
    // if (m * k > n) {
    // return -1;
    // }
    // int left = 1, right = (int) 1e9;
    // while (left < right) {
    // int mid = (left + right) / 2;
    // if (canMake(bloomDay, m, k, mid)) {
    // right = mid;
    // } else {
    // left = mid + 1;
    // }
    // }
    // return left;
    // }

    // private boolean canMake(int[] bloomDay, int m, int k, int mid) {
    // int bouquets = 0, flowers = 0;
    // for (int day : bloomDay) {
    // if (day <= mid) {
    // flowers++;
    // if (flowers == k) {
    // bouquets++;
    // flowers = 0;
    // }
    // } else {
    // flowers = 0;
    // }
    // }
    // return bouquets >= m;
    // }

    // wrong answer 2
    // TreeSet<Integer> treeSetOfRemovedIndexes;
    // int totalPossibleBanquets;
    // public int minDays(int[] bloomDay, int m, int k) {
    // int n = bloomDay.length;
    // if (m * k > n) {
    // return -1;
    // }
    // TreeMap<Integer, TreeSet<Integer>> tm = buildTreeMap(bloomDay); // new
    // TreeMap<>();
    // Integer high = tm.lastKey();
    // treeSetOfRemovedIndexes = new TreeSet<>();
    // treeSetOfRemovedIndexes.add(-1);
    // treeSetOfRemovedIndexes.add(n);
    // totalPossibleBanquets = n /k;
    // while (high != null) {
    // TreeSet<Integer> ts = tm.get(high);
    // if (cannotMakeDesiredBanquets(ts, m, k)) {
    // return high;
    // }
    // high = tm.lowerKey(high);
    // }
    // return tm.firstKey();
    // }

    // private TreeMap<Integer, TreeSet<Integer>> buildTreeMap(int[] bloomDay) {
    // TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();
    // for (int i = 0; i < bloomDay.length; ++i) {
    // int n = bloomDay[i];
    // if (!tm.containsKey(n)) {
    // tm.put(n, new TreeSet<>());
    // }
    // tm.get(n).add(i);
    // }
    // return tm;
    // }

    // private boolean cannotMakeDesiredBanquets(TreeSet<Integer> ts, int m, int k)
    // {
    // for (int i : ts) {
    // int higherKey = treeSetOfRemovedIndexes.higher(i);
    // int lowerKey = treeSetOfRemovedIndexes.lower(i);
    // totalPossibleBanquets -= (higherKey - lowerKey - 1) / k;
    // totalPossibleBanquets += (higherKey - i - 1) / k;
    // totalPossibleBanquets += (i - lowerKey - 1) / k;
    // treeSetOfRemovedIndexes.add(i);
    // }
    // return totalPossibleBanquets < m;
    // }

    public int minDays(int[] bloomDay, int m, int k) {
        int lo = 1;
        int hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isFeasible(bloomDay, m, k, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == Integer.MAX_VALUE) {
            return -1;
        }
        return lo;
    }

    public boolean isFeasible(int[] bloomDay, int m, int k, int d) {
        int n = bloomDay.length;
        int max = 0;
        int cLen = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= d) {
                cLen++;
                if (cLen == k) {
                    max++;
                    cLen = 0;
                }
            } else {
                cLen = 0;
            }
        }
        return max >= m;
    }

    public static void test_01482() {
        Solution01482 solution = new Solution01482();
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        int result = solution.minDays(bloomDay, m, k);
        System.out.println(result);
        int[] bloomDay2 = { 1, 10, 3, 10, 2 };
        int m2 = 3;
        int k2 = 2;
        int result2 = solution.minDays(bloomDay2, m2, k2);
        System.out.println(result2);
        int[] bloomDay3 = { 7, 7, 7, 7, 12, 7, 7 };
        int m3 = 2;
        int k3 = 3;
        int result3 = solution.minDays(bloomDay3, m3, k3);
        System.out.println(result3);
        int[] bloomDay4 = { 1000000000, 1000000000 };
        int m4 = 1;
        int k4 = 1;
        int result4 = solution.minDays(bloomDay4, m4, k4);
        System.out.println(result4);

    }

    public static void main(String[] args) {
        Solution01482.test_01482();
    }
}
