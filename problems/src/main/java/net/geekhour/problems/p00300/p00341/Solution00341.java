package net.geekhour.problems.p00300.p00341;

import java.util.*;

/**
 * ID: 00341
 * Title: Flatten Nested List Iterator
 * Difficulty: Medium
 * Description: You are given a nested list of integers nestedList. Each element
 * is either an integer or a list whose elements may also be integers or other
 * lists. Implement an iterator to flatten it.
 *
 * Implement the NestedIterator class:
 *
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with
 * the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested
 * list and false otherwise.
 *
 * Your code will be tested with the following pseudocode:
 *
 * initialize iterator with nestedList res = [] while iterator.hasNext() append
 * iterator.next() to the end of res return res
 *
 * If res matches the expected flattened list, then your code will be judged as
 * correct.
 *
 * Example 1:
 *
 * Input: nestedList = [[1,1],2,[1,1]] Output: [1,1,2,1,1] Explanation: By
 * calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,1,2,1,1].
 *
 * Example 2:
 *
 * Input: nestedList = [1,[4,[6]]] Output: [1,4,6] Explanation: By calling next
 * repeatedly until hasNext returns false, the order of elements returned by
 * next should be: [1,4,6].
 *
 * Constraints:
 *
 * 1 <= nestedList.length <= 500
 * The values of the integers in the nested list is in the range [-10 6, 10 6 ].
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a
  // nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a
  // single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested
  // list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {

  private Integer integer;
  private List<NestedInteger> list;

  public NestedIntegerImpl(Integer integer) {
    this.integer = integer;
    this.list = new ArrayList<>();
  }

  public NestedIntegerImpl(List<NestedInteger> list) {
    this.integer = null;
    this.list = list;
  }

  @Override
  public boolean isInteger() {
    return integer != null;
  }

  @Override
  public Integer getInteger() {
    return integer;
  }

  @Override
  public List<NestedInteger> getList() {
    return list;
  }
}

class NestedIterator implements Iterator<Integer> {

  private List<Integer> flattened;
  private int index;

  public NestedIterator(List<NestedInteger> nestedList) {
    flattened = new ArrayList<>();
    index = 0;
    flattened = flatten(nestedList);
  }

  private List<Integer> flatten(List<NestedInteger> nested) {
    List<Integer> result = new ArrayList<>();
    for (NestedInteger ni : nested) {
      if (ni.isInteger()) {
        result.add(ni.getInteger());
      } else {
        result.addAll(flatten(ni.getList()));
      }
    }
    return result;
  }

  public Integer next() {
    return flattened.get(index++);
  }

  public boolean hasNext() {
    return index < flattened.size();
  }

  /**
   * Your NestedIterator object will be instantiated and called as such:
   * NestedIterator i = new NestedIterator(nestedList);
   * while (i.hasNext()) v[f()] = i.next();
   */
  public static void test_00341() {
    List<NestedInteger> nestedList = new ArrayList<>();
    nestedList.add(new NestedIntegerImpl(1));
    nestedList.add(new NestedIntegerImpl(1));
    List<NestedInteger> nestedList2 = new ArrayList<>();
    nestedList2.add(new NestedIntegerImpl(1));
    nestedList2.add(new NestedIntegerImpl(1));
    nestedList.add(new NestedIntegerImpl(nestedList2));
    nestedList.add(new NestedIntegerImpl(2));
    nestedList.add(new NestedIntegerImpl(1));
    nestedList.add(new NestedIntegerImpl(1));
    NestedIterator i = new NestedIterator(nestedList);
    while (i.hasNext()) {
      System.out.println(i.next());
    }
  }

  public static void main(String[] args) {
    test_00341();
  }
}
