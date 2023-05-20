package net.geekhour.problems.p00300.p00399;

import java.util.*;

/**
 * ID: 00399
 * Title: Evaluate Division
 * Difficulty: Medium
 * Description: You are given an array of variable pairs equations and an array
 * of real numbers values, where equations[i] = [A i, B i ] and values[i]
 * represent the equation A i / B i = values[i]. Each A i or B i is a string
 * that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [C j, D j ] represents
 * the j th query where you must find the answer for C j / D j = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] Output:
 * [6.00000,0.50000,-1.00000,1.00000,-1.00000] Explanation: Given: a / b = 2.0,
 * b / c = 3.0 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x =
 * ? return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]] Output:
 * [3.75000,0.40000,5.00000,0.20000]
 *
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]] Output:
 * [0.50000,2.00000,-1.00000,-1.00000]
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= A i.length, B i.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= C j.length, D j.length <= 5
 * A i, B i, C j, D j consist of lower case English letters and digits.
 */
class Solution00399 {

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    double[] result = new double[queries.size()];
    Map<String, Map<String, Double>> graph = new HashMap<>();

    return result;
  }

  public static void test_00399() {
    Solution00399 solution = new Solution00399();
    List<List<String>> equations = new ArrayList<>();
    List<String> equation1 = new ArrayList<>();
    equation1.add("a");
    equation1.add("b");
    equations.add(equation1);
    List<String> equation2 = new ArrayList<>();
    equation2.add("b");
    equation2.add("c");
    equations.add(equation2);
    double[] values = { 2.0, 3.0 };
    List<List<String>> queries = new ArrayList<>();
    List<String> query1 = new ArrayList<>();
    query1.add("a");
    query1.add("c");
    queries.add(query1);
    List<String> query2 = new ArrayList<>();
    query2.add("b");
    query2.add("a");
    queries.add(query2);
    List<String> query3 = new ArrayList<>();
    query3.add("a");
    query3.add("e");
    queries.add(query3);
    List<String> query4 = new ArrayList<>();
    query4.add("a");
    query4.add("a");
    queries.add(query4);
    List<String> query5 = new ArrayList<>();
    query5.add("x");
    query5.add("x");
    queries.add(query5);
    double[] result = solution.calcEquation(equations, values, queries);
    System.out.println(Arrays.toString(result));
  }

  public static void main(String[] args) {
    Solution00399.test_00399();
  }
}
