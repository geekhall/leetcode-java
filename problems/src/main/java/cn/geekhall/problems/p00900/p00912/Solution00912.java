package cn.geekhall.problems.p00900.p00912;

import java.util.Arrays;

/**
 * ID: 00912
 * Title: Sort an Array
 * Difficulty: Medium
 * Description: Given an array of integers nums, sort the array in ascending
 * order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n))
 * time complexity and with the smallest space complexity possible.
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1] Output: [1,2,3,5] Explanation: After sorting the
 * array, the positions of some numbers are not changed (for example, 2 and 3),
 * while the positions of other numbers are changed (for example, 1 and 5).
 *
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0] Output: [0,0,1,1,2,5] Explanation: Note that the
 * values of nums are not necessairly unique.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 10 4
 * -5 * 10 4 <= nums[i] <= 5 * 10 4
 */
class Solution00912 {

  public int[] sortArray(int[] nums) {
    int[] temp = new int[nums.length];
    mergeSort(nums, 0, nums.length - 1, temp);
    return nums;
  }

  private void mergeSort(int[] nums, int i, int j, int[] temp) {
    if (i < j) {
      int mid = (i + j) / 2;
      mergeSort(nums, i, mid, temp);
      mergeSort(nums, mid + 1, j, temp);
      merge(nums, i, mid, j, temp);
    }
  }

  private void merge(int[] nums, int i, int mid, int j, int[] temp) {
    int left = i;
    int right = mid + 1;
    int t = 0;
    while (left <= mid && right <= j) {
      if (nums[left] <= nums[right]) {
        temp[t++] = nums[left++];
      } else {
        temp[t++] = nums[right++];
      }
    }
    while (left <= mid) {
      temp[t++] = nums[left++];
    }
    while (right <= j) {
      temp[t++] = nums[right++];
    }
    t = 0;
    while (i <= j) {
      nums[i++] = temp[t++];
    }
  }

  public static void test_00912() {
    Solution00912 solution = new Solution00912();
    int[] nums = { 5, 2, 3, 1 };
    int[] result = solution.sortArray(nums);
    System.out.println(Arrays.toString(result));
    int[] nums2 = { 5, 1, 1, 2, 0, 0 };
    int[] result2 = solution.sortArray(nums2);
    System.out.println(Arrays.toString(result2));
  }

  public static void main(String[] args) {
    Solution00912.test_00912();
  }
}
