package net.geekhour.problems.p01800.p01870;

/**
 * ID: 01870
 * Title: Minimum Speed to Arrive on Time
 * Difficulty: Medium
 * Description: You are given a floating-point number hour, representing the
 * amount of time you have to reach the office. To commute to the office, you
 * must take n trains in sequential order. You are also given an integer array
 * dist of length n, where dist[i] describes the distance (in kilometers) of the
 * i th train ride.
 *
 * Each train can only depart at an integer hour, so you may need to wait in
 * between each train ride.
 *
 * For example, if the 1 st train ride takes 1.5 hours, you must wait for an
 * additional 0.5 hours before you can depart on the 2 nd train ride at the 2
 * hour mark.
 *
 * Return the minimum positive integer speed (in kilometers per hour) that all
 * the trains must travel at for you to reach the office on time, or -1 if it is
 * impossible to be on time.
 *
 * Tests are generated such that the answer will not exceed 10 7 and hour will
 * have at most two digits after the decimal point.
 *
 * Example 1:
 *
 * Input: dist = [1,3,2], hour = 6 Output: 1 Explanation: At speed 1: - The
 * first train ride takes 1/1 = 1 hour. - Since we are already at an integer
 * hour, we depart immediately at the 1 hour mark. The second train takes 3/1 =
 * 3 hours. - Since we are already at an integer hour, we depart immediately at
 * the 4 hour mark. The third train takes 2/1 = 2 hours. - You will arrive at
 * exactly the 6 hour mark.
 *
 * Example 2:
 *
 * Input: dist = [1,3,2], hour = 2.7 Output: 3 Explanation: At speed 3: - The
 * first train ride takes 1/3 = 0.33333 hours. - Since we are not at an integer
 * hour, we wait until the 1 hour mark to depart. The second train ride takes
 * 3/3 = 1 hour. - Since we are already at an integer hour, we depart
 * immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours. -
 * You will arrive at the 2.66667 hour mark.
 *
 * Example 3:
 *
 * Input: dist = [1,3,2], hour = 1.9 Output: -1 Explanation: It is impossible
 * because the earliest the third train can depart is at the 2 hour mark.
 *
 * Constraints:
 *
 * n == dist.length
 * 1 <= n <= 10 5
 * 1 <= dist[i] <= 10 5
 * 1 <= hour <= 10 9
 * There will be at most two digits after the decimal point in hour.
 */
class Solution01870 {

  public int minSpeedOnTime(int[] dist, double hour) {
    int left = 1;
    int right = 10000000;
    if (dist.length - 1 >= hour) {
      return -1;
    }
    while (left < right) {
      int mid = (left + right) / 2;
      double sum = 0;
      for (int i = 0; i < dist.length - 1; i++) {
        sum += Math.ceil(dist[i] * 1.0 / mid);
      }
      sum += dist[dist.length - 1] * 1.0 / mid;
      if (sum > hour) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public static void test_01870() {
    Solution01870 solution = new Solution01870();
    int[] dist = { 1, 3, 2 };
    double hour = 6;
    int result = solution.minSpeedOnTime(dist, hour);
    System.out.println(result);
    int[] dist2 = { 1, 3, 2 };
    double hour2 = 2.7;
    result = solution.minSpeedOnTime(dist2, hour2);
    System.out.println(result);
    int[] dist3 = { 1, 3, 2 };
    double hour3 = 1.9;
    result = solution.minSpeedOnTime(dist3, hour3);
    System.out.println(result);
    int[] dist4 = { 1, 1, 100000 };
    double hour4 = 2.01;
    result = solution.minSpeedOnTime(dist4, hour4);
    System.out.println(result); // Expect 10000000
    int[] dist5 = { 1, 3, 2 };
    double hour5 = 1.9;
    result = solution.minSpeedOnTime(dist5, hour5);
    System.out.println(result); // Expect -1
  }

  public static void main(String[] args) {
    Solution01870.test_01870();
  }
}
