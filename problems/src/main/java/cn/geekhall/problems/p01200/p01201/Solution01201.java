package cn.geekhall.problems.p01200.p01201;

import java.util.Arrays;

/**
 * ID:    01201
 * Title: Ugly Number III
 * Difficulty: Medium
 * Description: An ugly number is a positive integer that is divisible by a, b, or c.
 *
 * Given four integers n, a, b, and c, return the n th ugly number.
 *
 * Example 1:
 *
 * Input: n = 3, a = 2, b = 3, c = 5 Output: 4 Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3 rd is 4.
 *
 * Example 2:
 *
 * Input: n = 4, a = 2, b = 3, c = 4 Output: 6 Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4 th is 6.
 *
 * Example 3:
 *
 * Input: n = 5, a = 2, b = 11, c = 13 Output: 10 Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5 th is 10.
 *
 * Constraints:
 *
 * 1 <= n, a, b, c <= 10 9
 * 1 <= a * b * c <= 10 18
 * It is guaranteed that the result will be in range [1, 2 * 10 9 ].
 */
class Solution01201 {

  public int smn(int a, int b){
    int tmp = Math.max(a,b);
      int i = tmp;
    while(i% Math.min(a,b) !=0 && i<2*1000000000){
      i+=tmp;
    }
    return i;
  }

  public int getNum(int a,int b,int c,int i,int d,int e,int f,int g){
    return (i/a+i/b+i/c-i/d-i/e-i/f+i/g);
  }

  public int nthUglyNumber(int n, int a, int b, int c) {
    int i = 0;
    int count =0;
    int d = smn(a,b);
    int e= smn(c,b);
    int f=smn(a,c);
    int g =smn(d,e);
    while(count<n){
      i+=n;
      count = getNum(a,b,c,i,d,e,f,g);
    }
    while(count!=n){
      i-=(count-n);

      count=getNum(a,b,c,i,d,e,f,g)    ;
    }
    while(i%a!=0 && i%b!=0 && i%c!=0){
      i-=1;
    }
    return i;
  }

  public static void test_01201() {
    Solution01201 solution = new Solution01201();
    int n = 3;
    int a = 2;
    int b = 3;
    int c = 5;
    int result = solution.nthUglyNumber(n, a, b, c);
    System.out.println(result);
    int n2 = 4;
    int a2 = 2;
    int b2 = 3;
    int c2 = 4;
    int result2 = solution.nthUglyNumber(n2, a2, b2, c2);
    System.out.println(result2);
    int n3 = 5;
    int a3 = 2;
    int b3 = 11;
    int c3 = 13;
    int result3 = solution.nthUglyNumber(n3, a3, b3, c3);
    System.out.println(result3);
    int n4 = 1000000000;
    int a4 = 2;
    int b4 = 217983653;
    int c4 = 336916467;
    int result4 = solution.nthUglyNumber(n4, a4, b4, c4);
    System.out.println(result4); // expected:1999999984
  }

  public static void main(String[] args) {
    Solution01201.test_01201();
  }
}

