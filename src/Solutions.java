import java.util.ArrayList;
import java.util.List;

public class Solutions {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /* Problem 450. #Delete Node in a BST# #MEDIUM#
     * https://leetcode.com/problems/delete-node-in-a-bst/
     *  Problem description:
     *  Given a root node reference of a BST and a key, delete the node with the given key in the BST.
     * Return the root node reference (possibly updated) of the BST.
     * Basically, the deletion can be divided into two stages:
     *    Search for a node to remove.
     *    If the node is found, delete the node.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = root.left;
            root = root.right;
        }
        return root;
    }

    /* Problem 701. #Insert into a Binary Search Tree# # #MEDIUM#
     * https://leetcode.com/problems/insert-into-a-binary-search-tree/
     *  Problem description:
     *  You are given the root node of a binary search tree (BST) and a value to insert into the tree.
     *  Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
     *  Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
     *  You can return any of them.
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
