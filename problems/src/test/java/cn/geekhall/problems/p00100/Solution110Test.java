package cn.geekhall.problems.p00100;

/**
 * Solution110Test
 *
 * @author yiny
 * @date 2022/12/18 10:35
 */

import cn.geekhall.utils.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution110Test {

    @Test
    public void isBalanced() {
        TreeNode tree1 = TreeNode.create(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution110 solution110 = new Solution110();
        Assert.assertTrue(solution110.isBalanced(tree1));
        TreeNode tree2 = TreeNode.create(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        Assert.assertFalse(solution110.isBalanced(tree2));
        TreeNode tree3 = TreeNode.create(new Integer[]{});
        Assert.assertTrue(solution110.isBalanced(tree3));
    }
}

