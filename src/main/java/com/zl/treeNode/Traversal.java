package com.zl.treeNode;

import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);
        midTraversal(root);
    }

    /**
     * 二叉树中序遍历 非递归
     * 1. 把所有的左孩子放入站内
     * 2. 取出栈顶元素,打印, 并将当前指针指向栈顶元素的右节点
     * 3. 如果当前元素不为null 放入站内, 打印当前值, 并将当前指针继续指向栈顶元素的右节点
     *  中序遍历  左  中  右
     */
    public static void midTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root;
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || tmp != null) {
            while(tmp != null) {
                s.push(tmp);
                tmp = tmp.left;
            }
            if (!s.isEmpty()) {
                tmp = s.peek();
                System.out.println(tmp.val);
                s.pop();
                tmp = tmp.right;
            }
        }
    }

    public static void preTraversal(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preTraversal(root.left);
        preTraversal(root.right);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
