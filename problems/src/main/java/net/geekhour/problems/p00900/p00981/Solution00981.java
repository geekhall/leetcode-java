package net.geekhour.problems.p00900.p00981;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ID: 00981
 * Title: Time Based Key-Value Store
 * Difficulty: Medium
 * Description: Design a time-based key-value data structure that can store
 * multiple values for the same key at different time stamps and retrieve the
 * key's value at a certain timestamp.
 *
 * Implement the TimeMap class:
 *
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the
 * value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was
 * called previously, with timestamp_prev <= timestamp. If there are multiple
 * such values, it returns the value associated with the largest timestamp_prev.
 * If there are no values, it returns "".
 *
 * Example 1:
 *
 * Input ["TimeMap", "set", "get", "get", "set", "get", "get"] [[], ["foo",
 * "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo",
 * 5]] Output [null, null, "bar", "bar", null, "bar2", "bar2"] Explanation
 * TimeMap timeMap = new TimeMap(); timeMap.set("foo", "bar", 1); // store the
 * key "foo" and value "bar" along with timestamp = 1. timeMap.get("foo", 1); //
 * return "bar" timeMap.get("foo", 3); // return "bar", since there is no value
 * corresponding to foo at timestamp 3 and timestamp 2, then the only value is
 * at timestamp 1 is "bar". timeMap.set("foo", "bar2", 4); // store the key
 * "foo" and value "bar2" along with timestamp = 4. timeMap.get("foo", 4); //
 * return "bar2" timeMap.get("foo", 5); // return "bar2"
 *
 * Constraints:
 *
 * 1 <= key.length, value.length <= 100
 * key and value consist of lowercase English letters and digits.
 * 1 <= timestamp <= 10 7
 * All the timestamps timestamp of set are strictly increasing.
 * At most 2 * 10 5 calls will be made to set and get.
 */
class TimeMap {

  // HashMap of key(String) corresponding of TreeMap<TimeStamp,Value>>
  HashMap<String, TreeMap<Integer, String>> map;

  public TimeMap() {
    map = new HashMap<String, TreeMap<Integer, String>>();
  }

  public void set(String key, String value, int timestamp) {
    TreeMap<Integer, String> tree_map;
    // if key is not present create a new instance otherwise get that treemap which
    // is already there in hashmap corresponding to key.
    if (map.get(key) != null)
      tree_map = map.get(key);
    else
      tree_map = new TreeMap<>(Collections.reverseOrder());
    // finally put key value in treemap and then in hashmap.
    tree_map.put(timestamp, value);
    map.put(key, tree_map);
  }

  public String get(String key, int timestamp) {
    // Iterate in hashmap first.
    for (Map.Entry m : map.entrySet()) {
      // if key is equal to our hashmap key
      if (m.getKey().equals(key)) {
        // get the value which is treemap correspond to given key.
        TreeMap<Integer, String> tmap = (TreeMap<Integer, String>) m.getValue();
        // Iterate in treemap
        for (Map.Entry tm : tmap.entrySet()) {
          if ((int) tm.getKey() <= timestamp)
            return String.valueOf(tm.getValue());
        }
      }
    }
    return "";
  }

  public static void test_00981() {
    TimeMap timeMap = new TimeMap();
    timeMap.set("foo", "bar", 1);
    System.out.println(timeMap.get("foo", 1));
    System.out.println(timeMap.get("foo", 3));
    timeMap.set("foo", "bar2", 4);
    System.out.println(timeMap.get("foo", 4));
    System.out.println(timeMap.get("foo", 5));

    timeMap.set("love", "high", 10);
    timeMap.set("love", "low", 20);
    System.out.println(timeMap.get("love", 5)); // Expected: ""
    System.out.println(timeMap.get("love", 10));
    System.out.println(timeMap.get("love", 15));
    System.out.println(timeMap.get("love", 20));
    System.out.println(timeMap.get("love", 25));
  }

  public static void main(String[] args) {
    TimeMap.test_00981();
  }
}
