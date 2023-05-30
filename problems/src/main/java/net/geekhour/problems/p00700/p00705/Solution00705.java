package net.geekhour.problems.p00700.p00705;

import java.util.*;

/**
 * ID: 00705
 * Title: Design HashSet
 * Difficulty: Easy
 * Description: Design a HashSet without using any built-in hash table
 * libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or
 * not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist
 * in the HashSet, do nothing.
 *
 * Example 1:
 *
 * Input ["MyHashSet", "add", "add", "contains", "contains", "add", "contains",
 * "remove", "contains"] [[], [1], [2], [1], [3], [2], [2], [2], [2]] Output
 * [null, null, null, true, false, null, true, null, false] Explanation
 * MyHashSet myHashSet = new MyHashSet(); myHashSet.add(1); // set = [1]
 * myHashSet.add(2); // set = [1, 2] myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found) myHashSet.add(2); // set
 * = [1, 2] myHashSet.contains(2); // return True myHashSet.remove(2); // set =
 * [1] myHashSet.contains(2); // return False, (already removed)
 *
 * Constraints:
 *
 * 0 <= key <= 10 6
 * At most 10 4 calls will be made to add, remove, and contains.
 */
class MyHashSet {
  private int size;
  private List<List<Integer>> buckets;

  public MyHashSet() {
    size = 1000;
    buckets = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      buckets.add(new LinkedList<>());
    }
  }

  public void add(int key) {
    int index = hash(key);
    List<Integer> bucket = buckets.get(index);
    if (!bucket.contains(key)) {
      bucket.add(key);
    }
  }

  public void remove(int key) {
    int index = hash(key);
    List<Integer> bucket = buckets.get(index);
    bucket.remove(Integer.valueOf(key));
  }

  public boolean contains(int key) {
    int index = hash(key);
    List<Integer> bucket = buckets.get(index);
    return bucket.contains(key);
  }

  private int hash(int key) {
    return key % size;
  }

}

class Solution00705 {
  /**
   * Your MyHashSet object will be instantiated and called as such:
   * MyHashSet obj = new MyHashSet();
   * obj.add(key);
   * obj.remove(key);
   * boolean param_3 = obj.contains(key);
   */
  public static void test_00705() {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1); // set = [1]
    myHashSet.add(2); // set = [1, 2]
    System.out.println(myHashSet.contains(1)); // return True
    System.out.println(myHashSet.contains(3)); // return False, (not found)
    myHashSet.add(2); // set = [1, 2]
    System.out.println(myHashSet.contains(2)); // return True
    myHashSet.remove(2); // set = [1]
    System.out.println(myHashSet.contains(2)); // return False, (already removed)
  }

  public static void main(String[] args) {
    Solution00705.test_00705();
  }
}
