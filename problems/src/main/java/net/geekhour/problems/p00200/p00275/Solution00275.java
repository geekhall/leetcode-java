package net.geekhour.problems.p00200.p00275;

/**
 * ID: 00275
 * Title: H-Index II
 * Difficulty: Medium
 * Description: Given an array of integers citations where citations[i] is the
 * number of citations a researcher received for their i th paper and citations
 * is sorted in an ascending order, return compute the researcher's h -index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index
 * h if h of their n papers have at least h citations each, and the other n − h
 * papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h
 * -index.
 *
 * You must write an algorithm that runs in logarithmic time.
 *
 * Example 1:
 *
 * Input: citations = [0,1,3,5,6] Output: 3 Explanation: [0,1,3,5,6] means the
 * researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6
 * citations respectively. Since the researcher has 3 papers with at least 3
 * citations each and the remaining two with no more than 3 citations each,
 * their h-index is 3.
 *
 * Example 2:
 *
 * Input: citations = [1,2,100] Output: 2
 *
 * Constraints:
 *
 * n == citations.length
 * 1 <= n <= 10 5
 * 0 <= citations[i] <= 1000
 * citations is sorted in ascending order.
 */
class Solution00275 {

  public int hIndex(int[] citations) {
    int n = citations.length;
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (citations[mid] == n - mid) {
        return n - mid;
      } else if (citations[mid] > n - mid) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return n - left;
  }

  public static void test_00275() {
    Solution00275 solution = new Solution00275();
    int[] citations = { 0, 1, 3, 5, 6 };
    int result = solution.hIndex(citations);
    System.out.println(result);
    int[] citations2 = { 1, 2, 100 };
    int result2 = solution.hIndex(citations2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution00275.test_00275();
  }
}
