package net.geekhour.problems.p01400.p01470;

import java.util.Arrays;

/**
 * ID: 01470
 * Title: Shuffle the Array
 * Difficulty: Easy
 * Description: Given the array nums consisting of 2n elements in the form [x
 * 1,x 2,...,x n,y 1,y 2,...,y n ].
 *
 * Return the array in the form [x 1,y 1,x 2,y 2,...,x n,y n ].
 *
 * Example 1:
 *
 * Input: nums = [2,5,1,3,4,7], n = 3 Output: [2,3,5,4,1,7] Explanation: Since x
 * 1 =2, x 2 =5, x 3 =1, y 1 =3, y 2 =4, y 3 =7 then the answer is
 * [2,3,5,4,1,7].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4 Output: [1,4,2,3,3,2,4,1]
 *
 * Example 3:
 *
 * Input: nums = [1,1,2,2], n = 2 Output: [1,2,1,2]
 *
 * Constraints:
 *
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */
class Solution01470 {

  public int[] shuffle(int[] nums, int n) {
    int[] result = new int[nums.length];
    int i = 0;
    int j = n;
    int k = 0;
    while (i < n && j < nums.length) {
      result[k++] = nums[i++];
      result[k++] = nums[j++];
    }
    return result;
  }

  public static void test_01470() {
    Solution01470 solution = new Solution01470();
    int[] nums = { 2, 5, 1, 3, 4, 7 };
    int n = 3;
    int[] result = solution.shuffle(nums, n);
    System.out.println(Arrays.toString(result));
    System.out.println();
    int[] nums2 = { 1, 2, 3, 4, 4, 3, 2, 1 };
    int n2 = 4;
    int[] result2 = solution.shuffle(nums2, n2);
    System.out.println(Arrays.toString(result2));
    int[] nums3 = { 1, 1, 2, 2 };
    int n3 = 2;
    int[] result3 = solution.shuffle(nums3, n3);
    System.out.println(Arrays.toString(result3));
  }

  public static void main(String[] args) {
    Solution01470.test_01470();
  }
}
