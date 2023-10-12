package net.geekhour.problems.p01000.p01095;

import java.util.*;

/**
 * ID: 01095
 * Title: Find in Mountain Array
 * Difficulty: Hard
 * Description: (This problem is an interactive problem.)
 *
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 *
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Given a mountain array mountainArr, return the minimum index such that
 * mountainArr.get(index) == target. If such an index does not exist, return -1.
 *
 * You cannot access the mountain array directly. You may only access the array
 * using a MountainArray interface:
 *
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 *
 * Submissions making more than 100 calls to MountainArray.get will be judged
 * Wrong Answer. Also, any solutions that attempt to circumvent the judge will
 * result in disqualification.
 *
 * Example 1:
 *
 * Input: array = [1,2,3,4,5,3,1], target = 3 Output: 2 Explanation: 3 exists in
 * the array, at index=2 and index=5. Return the minimum index, which is 2.
 *
 * Example 2:
 *
 * Input: array = [0,1,2,4,2,1], target = 3 Output: -1 Explanation: 3 does not
 * exist in the array, so we return -1.
 *
 * Constraints:
 *
 * 3 <= mountain_arr.length() <= 10 4
 * 0 <= target <= 10 9
 * 0 <= mountain_arr.get(index) <= 10 9
 */
class MountainArray {
  private int[] arr;

  public MountainArray(int[] arr) {
    this.arr = arr;
  }

  public int get(int index) {
    return arr[index];
  }

  public int length() {
    return arr.length;
  }
}

class Solution01095 {

  /**
   * // This is MountainArray's API interface.
   * // You should not implement it, or speculate about its implementation
   * interface MountainArray {
   * public int get(int index) {}
   * public int length() {}
   * }
   */

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int length = mountainArr.length();

    // Find the index of the peak element in the mountain array.
    int peakIndex = findPeakIndex(1, length - 2, mountainArr);

    // Binary search for the target in the increasing part of the mountain array.
    int increasingIndex = binarySearch(0, peakIndex, target, mountainArr, false);
    if (mountainArr.get(increasingIndex) == target)
      return increasingIndex; // Target found in the increasing part.

    // Binary search for the target in the decreasing part of the mountain array.
    int decreasingIndex = binarySearch(peakIndex + 1, length - 1, target, mountainArr, true);
    if (mountainArr.get(decreasingIndex) == target)
      return decreasingIndex; // Target found in the decreasing part.

    return -1; // Target not found in the mountain array.
  }

  private int findPeakIndex(int low, int high, MountainArray mountainArr) {
    while (low != high) {
      int mid = low + (high - low) / 2;
      if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
        low = mid + 1; // Move to the right side (increasing slope).
      } else {
        high = mid; // Move to the left side (decreasing slope).
      }
    }
    return low; // Return the index of the peak element.
  }

  private int binarySearch(int low, int high, int target, MountainArray mountainArr, boolean reversed) {
    while (low != high) {
      int mid = low + (high - low) / 2;
      if (reversed) {
        if (mountainArr.get(mid) > target)
          low = mid + 1; // Move to the right side for a decreasing slope.
        else
          high = mid; // Move to the left side for an increasing slope.
      } else {
        if (mountainArr.get(mid) < target)
          low = mid + 1; // Move to the right side for an increasing slope.
        else
          high = mid; // Move to the left side for a decreasing slope.
      }
    }
    return low; // Return the index where the target should be or would be inserted.
  }

  public static void test_01095() {
    Solution01095 solution = new Solution01095();
    int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
    int target = 3;
    int expected = 2;
    int actual = solution.findInMountainArray(target, new MountainArray(arr));
    System.out.println("expected: " + expected + ", actual: " + actual);

    arr = new int[] { 0, 1, 2, 4, 2, 1 };
    target = 3;
    expected = -1;
    actual = solution.findInMountainArray(target, new MountainArray(arr));
    System.out.println("expected: " + expected + ", actual: " + actual);
  }

  public static void main(String[] args) {
    test_01095();
  }
}
