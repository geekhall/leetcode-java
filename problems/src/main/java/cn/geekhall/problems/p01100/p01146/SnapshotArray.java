package cn.geekhall.problems.p01100.p01146;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ID:    01146
 * Title: Snapshot Array
 * Difficulty: Medium
 * Description: Implement a SnapshotArray that supports the following interface:
 *
 * SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 *
 * Example 1:
 *
 * Input: ["SnapshotArray","set","snap","set","get"] [[3],[0,5],[],[0,6],[0,0]] Output: [null,null,0,null,5] Explanation: SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3 snapshotArr.set(0,5); // Set array[0] = 5 snapshotArr.snap(); // Take a snapshot, return snap_id = 0 snapshotArr.set(0,6); snapshotArr.get(0,0); // Get the value of array[0] with snap_id = 0, return 5
 *
 * Constraints:
 *
 * 1 <= length <= 5 * 10 4
 * 0 <= index < length
 * 0 <= val <= 10 9
 * 0 <= snap_id < (the total number of times we call snap())
 * At most 5 * 10 4 calls will be made to set, snap, and get.
 */
class SnapshotArray {

  TreeMap<Integer, HashMap<Integer,Integer>> map;
  int n=0;
  public SnapshotArray(int length) {
    map =new TreeMap<>();
  }

  public void set(int index, int val) {
    map.putIfAbsent(n,new HashMap<Integer,Integer>());
    map.get(n).put(index,val);
  }

  public int snap() {
    n++;
    return n-1;
  }

  public int get(int index, int snap_id) {
      Map.Entry<Integer,HashMap<Integer,Integer>> entry = map.floorEntry(snap_id);
      while (entry!=null&&!entry.getValue().containsKey(index))
        entry = map.lowerEntry((entry.getKey()));
      return entry==null?0:entry.getValue().get(index);
  }

  public static void test_01146() {
    SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
    snapshotArr.set(0,5); // Set array[0] = 5
    System.out.println(snapshotArr.snap()); // Take a snapshot, return snap_id = 0
    snapshotArr.set(0,6);
    System.out.println(snapshotArr.get(0,0)); // Get the value of array[0] with snap_id = 0, return 5

  }

  public static void main(String[] args) {
    SnapshotArray.test_01146();
  }
}

