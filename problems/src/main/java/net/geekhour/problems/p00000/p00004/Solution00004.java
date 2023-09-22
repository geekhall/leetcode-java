package net.geekhour.problems.p00000.p00004;

/**
 * ID: 00004
 * Title: Median of Two Sorted Arrays
 * Difficulty: Hard
 * Description: Given two sorted arrays nums1 and nums2 of size m and n
 * respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation: merged array =
 * [1,2,3] and median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4] Output: 2.50000 Explanation: merged array
 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10 6 <= nums1[i], nums2[i] <= 10 6
 */
class Solution00004 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int total = m + n;
    if (total % 2 == 1) {
      int midIndex = total / 2;
      double median = getKthElement(nums1, nums2, midIndex + 1);
      return median;
    } else {
      int midIndex1 = total / 2 - 1, midIndex2 = total / 2;
      double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
      return median;
    }
  }

  private double getKthElement(int[] nums1, int[] nums2, int i) {
    int m = nums1.length;
    int n = nums2.length;
    int index1 = 0, index2 = 0;
    while (true) {
      if (index1 == m) {
        return nums2[index2 + i - 1];
      }
      if (index2 == n) {
        return nums1[index1 + i - 1];
      }
      if (i == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }
      int half = i / 2;
      int newIndex1 = Math.min(index1 + half, m) - 1;
      int newIndex2 = Math.min(index2 + half, n) - 1;
      int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
      if (pivot1 <= pivot2) {
        i -= (newIndex1 - index1 + 1);
        index1 = newIndex1 + 1;
      } else {
        i -= (newIndex2 - index2 + 1);
        index2 = newIndex2 + 1;
      }
    }
  }

  public static void test_00004() {
    Solution00004 solution = new Solution00004();
    int[] nums1 = { 1, 3 };
    int[] nums2 = { 2 };
    double result = solution.findMedianSortedArrays(nums1, nums2);
    System.out.println(result);
    int[] nums3 = { 1, 2 };
    int[] nums4 = { 3, 4 };
    result = solution.findMedianSortedArrays(nums3, nums4);
    System.out.println(result);
  }

  public static void main(String[] args) {
    Solution00004.test_00004();
  }
}
