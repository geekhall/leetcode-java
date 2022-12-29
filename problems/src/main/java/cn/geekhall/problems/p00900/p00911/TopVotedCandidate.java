package cn.geekhall.problems.p00900.p00911;

import java.util.Arrays;

/**
 * ID:    00911
 * Title: Online Election
 * Difficulty: Medium
 * Description: You are given two integer arrays persons and times. In an election, the i th vote was cast for persons[i] at time times[i].
 *
 * For each query at a time t, find the person that was leading the election at time t. Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.
 *
 * Implement the TopVotedCandidate class:
 *
 * TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
 * int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.
 *
 * Example 1:
 *
 * Input ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"] [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]] Output [null, 0, 1, 1, 0, 0, 1] Explanation TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]); topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading. topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading. topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.) topVotedCandidate.q(15); // return 0 topVotedCandidate.q(24); // return 0 topVotedCandidate.q(8); // return 1
 *
 * Constraints:
 *
 * 1 <= persons.length <= 5000
 * times.length == persons.length
 * 0 <= persons[i] < persons.length
 * 0 <= times[i] <= 10 9
 * times is sorted in a strictly increasing order.
 * times[0] <= t <= 10 9
 * At most 10 4 calls will be made to q.
 */
class TopVotedCandidate {

  int[] persons;
  int[] times;
  int[] cumulate;
  public TopVotedCandidate(int[] persons, int[] times) {
    this.persons = persons;
    this.times = times;
    this.cumulate = new int[persons.length];
    int[] count = new int[persons.length];
    int max = 0;
    for (int i = 0; i < persons.length; i++) {
      count[persons[i]]++;
      if (count[persons[i]] >= max) {
        max = count[persons[i]];
        cumulate[i] = persons[i];
      } else {
        cumulate[i] = cumulate[i - 1];
      }
    }
  }

  public int q(int t) {
    int index = binarySearch(times, t);
    return cumulate[index];
  }

  private int binarySearch(int[] times2, int t) {
    int left = 0;
    int right = times2.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (times2[mid] == t) {
        return mid;
      } else if (times2[mid] < t) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }

  public static void test_00911() {
    System.out.println("test_00911");
    int[] persons = {0, 1, 1, 0, 0, 1, 0};
    int[] times = {0, 5, 10, 15, 20, 25, 30};
    TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
    System.out.println(topVotedCandidate.q(3)); // return 0, At time 3, the votes are [0], and 0 is leading.
    System.out.println(topVotedCandidate.q(12)); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
    System.out.println(topVotedCandidate.q(25)); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
    System.out.println(topVotedCandidate.q(15)); // return 0
    System.out.println(topVotedCandidate.q(24)); // return 0
    System.out.println(topVotedCandidate.q(8)); // return 1
  }

  public static void main(String[] args) {
    TopVotedCandidate.test_00911();
  }
}

