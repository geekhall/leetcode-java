package net.geekhour.problems.p00300.p00332;

import java.util.*;

/**
 * ID: 00332
 * Title: Reconstruct Itinerary
 * Difficulty: Hard
 * Description: You are given a list of airline tickets where tickets[i] = [from
 * i, to i ] represent the departure and the arrival airports of one flight.
 * Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the
 * itinerary must begin with "JFK". If there are multiple valid itineraries, you
 * should return the itinerary that has the smallest lexical order when read as
 * a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 *
 * You may assume all tickets form at least one valid itinerary. You must use
 * all the tickets once and only once.
 *
 * Example 1:
 *
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 *
 * Example 2:
 *
 * Input: tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible
 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in
 * lexical order.
 *
 * Constraints:
 *
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * from i.length == 3
 * to i.length == 3
 * from i and to i consist of uppercase English letters.
 * from i!= to i
 */
class Solution00332 {

  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    for (List<String> ticket : tickets) {
      String from = ticket.get(0);
      String to = ticket.get(1);
      PriorityQueue<String> pq = map.getOrDefault(from, new PriorityQueue<>());
      pq.add(to);
      map.put(from, pq);
    }
    List<String> result = new ArrayList<>();
    dfs(map, "JFK", result);
    Collections.reverse(result);
    return result;
  }

  private void dfs(Map<String, PriorityQueue<String>> map, String string, List<String> result) {
    PriorityQueue<String> pq = map.get(string);
    while (pq != null && !pq.isEmpty()) {
      dfs(map, pq.poll(), result);
    }
    result.add(string);
  }

  public static void test_00332() {
    Solution00332 solution = new Solution00332();
    List<List<String>> tickets = new ArrayList<>();
    tickets.add(Arrays.asList("MUC", "LHR"));
    tickets.add(Arrays.asList("JFK", "MUC"));
    tickets.add(Arrays.asList("SFO", "SJC"));
    tickets.add(Arrays.asList("LHR", "SFO"));
    System.out.println(solution.findItinerary(tickets));
    tickets.clear();
    tickets.add(Arrays.asList("JFK", "SFO"));
    tickets.add(Arrays.asList("JFK", "ATL"));
    tickets.add(Arrays.asList("SFO", "ATL"));
    tickets.add(Arrays.asList("ATL", "JFK"));
    tickets.add(Arrays.asList("ATL", "SFO"));
    System.out.println(solution.findItinerary(tickets));

  }

  public static void main(String[] args) {
    test_00332();
  }
}
