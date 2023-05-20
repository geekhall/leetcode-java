package net.geekhour.problems.p00100.p00134;

/**
 * ID: 00134
 * Title: Gas Station
 * Difficulty: Medium
 * Description: There are n gas stations along a circular route, where the
 * amount of gas at the i th station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from the i th station to its next (i + 1) th station. You begin the
 * journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's
 * index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be
 * unique
 *
 * Example 1:
 *
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2] Output: 3 Explanation: Start at
 * station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8 Travel to station 0. Your tank
 * = 8 - 2 + 1 = 7 Travel to station 1. Your tank = 7 - 3 + 2 = 6 Travel to
 * station 2. Your tank = 6 - 4 + 3 = 5 Travel to station 3. The cost is 5. Your
 * gas is just enough to travel back to station 3. Therefore, return 3 as the
 * starting index.
 *
 * Example 2:
 *
 * Input: gas = [2,3,4], cost = [3,4,3] Output: -1 Explanation: You can't start
 * at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 =
 * 4 Travel to station 0. Your tank = 4 - 3 + 2 = 3 Travel to station 1. Your
 * tank = 3 - 3 + 3 = 3 You cannot travel back to station 2, as it requires 4
 * unit of gas but you only have 3. Therefore, you can't travel around the
 * circuit once no matter where you start.
 *
 * Constraints:
 *
 * n == gas.length == cost.length
 * 1 <= n <= 10 5
 * 0 <= gas[i], cost[i] <= 10 4
 */
class Solution00134 {

  // Timelimit Exceeded
  public int canCompleteCircuit1(int[] gas, int[] cost) {
    int result = -1;
    int n = gas.length;
    for (int i = 0; i < n; i++) {
      int sumOfGas = 0;
      int sumOfCost = 0;
      int count = 0;
      for (int j = i; count < n; j = (j + 1) % n) {
        sumOfGas += gas[j];
        sumOfCost += cost[j];
        if (sumOfCost > sumOfGas) {
          break;
        }
        count++;
      }
      if (count == n) {
        result = i;
        break;
      }
    }
    return result;
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int totalTank = 0;
    int currTank = 0;
    int startingStation = 0;
    for (int i = 0; i < n; ++i) {
      totalTank += gas[i] - cost[i];
      currTank += gas[i] - cost[i];
      // If one couldn't get here,
      if (currTank < 0) {
        // Pick up the next station as the starting one.
        startingStation = i + 1;
        // Start with an empty tank.
        currTank = 0;
      }
    }
    return totalTank >= 0 ? startingStation : -1;
  }

  public static void test_00134() {
    Solution00134 solution = new Solution00134();
    int[] gas = { 1, 2, 3, 4, 5 };
    int[] cost = { 3, 4, 5, 1, 2 };
    int result = solution.canCompleteCircuit(gas, cost);
    System.out.println(result);
    int[] gas2 = { 2, 3, 4 };
    int[] cost2 = { 3, 4, 3 };
    int result2 = solution.canCompleteCircuit(gas2, cost2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution00134.test_00134();
  }
}
