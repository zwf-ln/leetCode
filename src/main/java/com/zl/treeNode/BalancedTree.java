package com.zl.treeNode;

public class BalancedTree {
    /**
     * 判断是否是平衡二叉树
     * 两种方法
     * 第一种, 自上而下的判断,定义方法 height，用于计算任意一个节点 p的高度：
     * 接下来就是比较每个节点左右子树的高度。在一棵以 rr 为根节点的树
     * TT 中，只有每个节点左右子树高度差不大于 1 时，该树才是平衡的。因此可以比较每个节点左右两棵子树的高度差，然后向上递归。
     * 第二种, 自下而上的判断(最优解),使用与方法一中定义的height 方法。自底向上与自顶向下的逻辑相反，
     * 首先判断子树是否平衡，然后比较子树高度判断父节点是否平衡。算法如下：
     * 检查子树是否平衡。如果平衡，则使用它们的高度判断父节点是否平衡，并计算父节点的高度。
     * @param treeNode
     * @return
     */
    public boolean isBalanced(TreeNode treeNode) {
        if (treeNode == null) return true;
        return Math.abs(height(treeNode.left) - height(treeNode.right)) < 2
                && isBalanced(treeNode.left) && isBalanced(treeNode.right);
    }

    private int height(TreeNode node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * 自下而上, 每个节点的高度只需要计算一次
     * @param node
     * @return
     */
    public boolean isBalanced1(TreeNode node) {
        return isBalancedHelper(node).isBalanced;
    }

    public TreeInfo isBalancedHelper(TreeNode node) {
        if (node == null) return new TreeInfo(true, -1);

        TreeInfo left = isBalancedHelper(node.left);
        if (!left.isBalanced) return new TreeInfo(false, -1);

        TreeInfo right = isBalancedHelper(node.right);
        if (!right.isBalanced) return new TreeInfo(false, -1);

        if (Math.abs(left.height - right.height) < 2)
            return new TreeInfo(true, Math.max(left.height, right.height) + 1);
        return new TreeInfo(false, -1);
    }

    class TreeInfo{
        private boolean isBalanced;
        private int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }

        public boolean isBalanced() {
            return isBalanced;
        }

        public void setBalanced(boolean balanced) {
            isBalanced = balanced;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
