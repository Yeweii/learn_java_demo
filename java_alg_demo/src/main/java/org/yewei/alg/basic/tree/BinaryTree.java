package org.yewei.alg.basic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 */
public class BinaryTree {


    public static TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        return n1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree();
        List<Integer> integers = BinaryTreeDfs.BinaryTreeBfs(treeNode);
        System.out.println(integers);
        List<Integer> inorder = new ArrayList<>();
        BinaryTreeDfs.inorderDfs(treeNode, inorder);
        System.out.println(inorder);

    }

}
