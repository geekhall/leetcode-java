package net.geekhour.problems.p00400;

import org.junit.Test;

/**
 * Solution459Test
 *
 * @author yiny
 * @date 2022/12/18 20:28
 */
public class Solution459Test {

    @Test
    public void repeatedSubstringPattern() {
        Solution459 solution459 = new Solution459();
        System.out.println(solution459.repeatedSubstringPattern("abab"));
        System.out.println(solution459.repeatedSubstringPattern("aba"));
        System.out.println(solution459.repeatedSubstringPattern("abcabcabcabc"));
    }
}
