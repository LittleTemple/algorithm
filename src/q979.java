/*
    遇到的问题：
    这个二叉树向数组中存储的时候，如果遇到null的情况怎么办？
    还能满足父节点是i,左子节点为2*i,右子节点为2*i+1
    现在发现这个性质是只有完全二叉树才有的性质。

    主要的思路：
    其实是通过子节点给父节点返回信息。
    看完视频之后的体会就是递归真的不能想的过细。
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}




class Solution {
    int res = 0;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        //返回左右节点的硬币数
        int left = dfs(root.left), right = dfs(root.right);
        //返
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;

    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;

    }

}

