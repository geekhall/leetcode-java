package net.geekhour.problems.p01500.p01519;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ID: 01519
 * Title: Number of Nodes in the Sub-Tree With the Same Label
 * Difficulty: Medium
 * Description: You are given a tree (i.e. a connected, undirected graph that
 * has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n -
 * 1 edges. The root of the tree is the node 0, and each node of the tree has a
 * label which is a lower-case character given in the string labels (i.e. The
 * node with the number i has the label labels[i]).
 *
 * The edges array is given on the form edges[i] = [a i, b i ], which means
 * there is an edge between nodes a i and b i in the tree.
 *
 * Return an array of size n where ans[i] is the number of nodes in the subtree
 * of the i th node which have the same label as node i.
 *
 * A subtree of a tree T is the tree consisting of a node in T and all of its
 * descendant nodes.
 *
 * Example 1:
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels =
 * "abaedcd" Output: [2,1,1,1,1,1,1] Explanation: Node 0 has label 'a' and its
 * sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that
 * any node is part of its sub-tree. Node 1 has a label 'b'. The sub-tree of
 * node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than
 * node 1, the answer is just 1 (the node itself).
 *
 * Example 2:
 *
 * Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb" Output: [4,2,1,1]
 * Explanation: The sub-tree of node 2 contains only node 2, so the answer is 1.
 * The sub-tree of node 3 contains only node 3, so the answer is 1. The sub-tree
 * of node 1 contains nodes 1 and 2, both have label 'b', thus the answer is 2.
 * The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus
 * the answer is 4.
 *
 * Example 3:
 *
 * Input: n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab" Output:
 * [3,2,1,1,1]
 *
 * Constraints:
 *
 * 1 <= n <= 10 5
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= a i, b i < n
 * a i!= b i
 * labels.length == n
 * labels is consisting of only of lowercase English letters.
 */
class Solution01519 {
  int[] result;
  List<List<Integer>> adj;
  boolean[] visited;

  // This function takes in the number of nodes in a tree, the edges that connect
  // the nodes and the labels of the nodes
  public int[] countSubTrees(int n, int[][] edges, String labels) {
    // Creating an adjacency list to store the edges
    adj = new ArrayList<>(n);
    result = new int[n];
    // initializing the adjacency list
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    // populating the adjacency list with the edges
    for (int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    // keep track of visited nodes
    visited = new boolean[n];
    // calling the dfs function to count the subtrees starting from the root node
    dfs(0, labels);
    return result;
  }

  // dfs function to traverse the tree and count the subtrees
  int[] dfs(int node, String labels) {
    visited[node] = true;
    int[] count = new int[26];
    // visiting all the neighbours of the current node
    for (int nbr : adj.get(node)) {
      if (!visited[nbr]) {
        int[] adjCount = dfs(nbr, labels);
        // updating the count array with the count of the subtrees of the neighbours
        for (int i = 0; i < 26; i++) {
          count[i] += adjCount[i];
        }
      }
    }
    // incrementing the count of the current node label
    char ch = labels.charAt(node);
    count[ch - 'a']++;
    // storing the count of the subtrees of the current node
    result[node] = count[ch - 'a'];
    return count;
  }

  public static void test_01519() {
    Solution01519 solution = new Solution01519();
    int n = 7;
    int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
    String labels = "abaedcd";
    int[] result = solution.countSubTrees(n, edges, labels);
    System.out.println(Arrays.toString(result));
    int n2 = 4;
    int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 0, 3 } };
    String labels2 = "bbbb";
    int[] result2 = solution.countSubTrees(n2, edges2, labels2);
    System.out.println(Arrays.toString(result2));
    int n3 = 5;
    int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 0, 4 } };
    String labels3 = "aabab";
    int[] result3 = solution.countSubTrees(n3, edges3, labels3);
    System.out.println(Arrays.toString(result3));
  }

  public static void main(String[] args) {
    Solution01519.test_01519();
  }
}
