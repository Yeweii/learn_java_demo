package org.yewei.alg.algpart.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的遍历（层序、前序、中序、后序）
 */
public class BinaryTreeDfs {

    /**
     * 层序遍历,先进先出，使用队列
     */
    public static List<Integer> BinaryTreeBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> bfsList = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 队列出列
            TreeNode node = queue.poll();
            // 添加节点值
            bfsList.add(node.val);
            if (node.left != null) {
                // 左子节点入队
                queue.offer(node.left);
            }
            if (node.right != null) {
                // 右子节点入队
                queue.offer(node.right);
            }
        }

        return bfsList;
    }

    /**
     * 前序遍历
     */
    public static void frontDfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 顺序： 根节点 -> 左子树 -> 右子树
        res.add(root.val);
        frontDfs(root.left, res);
        frontDfs(root.right, res);
    }

    /**
     * 中序遍历
     */
    public static void inorderDfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 顺序： 左子树 -> 根节点 -> 右子树
        frontDfs(root.left, res);
        res.add(root.val);
        frontDfs(root.right, res);
    }

    /**
     * 后序遍历
     */
    public static void postOrderDfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        // 顺序： 左子树 -> 右子树 -> 根节点
        frontDfs(root.left, res);
        frontDfs(root.right, res);
        res.add(root.val);
    }
}
