package com.zl.treeNode;

import com.zl.treeNode.TreeNode;

import java.util.*;

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

    /**
     * 判断是否是相同的树,递归解法
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        //如果当前节点的值不相等,直接返回false,
        // 如果相等,还需要比较左节点和右节点的值
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 使用迭代法
     * @param p
     * @param q
     * @return
     */
//    public static boolean isSameTree1(TreeNode p, TreeNode q) {
//
//    }

    /**
     * 二叉树的层次遍历
     * 迭代法
     */
    public static List<List<Integer>> hierarchicalTraversal (TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        //使用辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            list.add(0, new ArrayList<>());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.get(0).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return list;
    }

    /**
     * 二叉树的层次遍历
     * 递归
     */
    public static List<List<Integer>> hierarchicalTraversal1 (TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        return list;
    }
}
