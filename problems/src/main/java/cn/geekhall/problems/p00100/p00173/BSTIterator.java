package cn.geekhall.problems.p00100.p00173;

import java.util.ArrayList;
import java.util.List;

import cn.geekhall.utils.TreeNode;

/**
 * ID:    00173
 * Title: Binary Search Tree Iterator
 * Difficulty: Medium
 * Description: Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 *
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 *
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 *
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 *
 * Example 1:
 *
 * Input ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"] [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []] Output [null, 3, 7, true, 9, true, 15, true, 20, false] Explanation BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]); bSTIterator.next(); // return 3 bSTIterator.next(); // return 7 bSTIterator.hasNext(); // return True bSTIterator.next(); // return 9 bSTIterator.hasNext(); // return True bSTIterator.next(); // return 15 bSTIterator.hasNext(); // return True bSTIterator.next(); // return 20 bSTIterator.hasNext(); // return False
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 10 5 ].
 * 0 <= Node.val <= 10 6
 * At most 10 5 calls will be made to hasNext, and next.
 *
 * Follow up:
 *
 * Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
 */
class BSTIterator {

  List<Integer> list = new ArrayList<>();
  public BSTIterator(TreeNode root) {
    // morris in order traversal
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        list.add(cur.val);
        cur = cur.right;
      } else {
        TreeNode pre = cur.left;
        while (pre.right != null) {
          pre = pre.right;
        }
        pre.right = cur;
        TreeNode temp = cur;
        cur = cur.left;
        temp.left = null;
      }
    }
  }

  public int next() {
    return list.remove(0);
  }

  public boolean hasNext() {
    return !list.isEmpty();
  }

  public static void main(String[] args){
    TreeNode root = TreeNode.create(new Integer[]{7, 3, 15, null, null, 9, 20});
    BSTIterator iterator = new BSTIterator(root);
    System.out.println(iterator.next());    // return 3
    System.out.println(iterator.next());    // return 7
    System.out.println(iterator.hasNext()); // return True
    System.out.println(iterator.next());    // return 9
    System.out.println(iterator.hasNext()); // return True
    System.out.println(iterator.next());    // return 15
    System.out.println(iterator.hasNext()); // return True
    System.out.println(iterator.next());    // return 20
    System.out.println(iterator.hasNext()); // return False
  }
}

