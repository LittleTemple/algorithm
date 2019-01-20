/*

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

