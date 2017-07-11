package Easy;
/*
Name: Eui Sung Kim
Date: July 11 2017
From: Leetcode

Problem: Given two binary trees and imagine that when you put one of them to cover the other,
some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree.
The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
Otherwise, the NOT null node will be used as the node of new tree.

Constraints:
  * The merging process must start from the root nodes of both trees.
*/

public class MergeTwoBinaryTrees {
  /*
  Simple recursive algorithm to merge two binary trees.
  Base case: Both tree 1 and tree 2 are null
  Otherwise, depending on the condition,

  Time Complexity: O(t1 * t2).
    * Since number of nodes are not specified,
    * it takes t1 * t2 amount of time to merge.
  Space Complexity: O(t1 * t2).
    * Since this is a recursive algorithm -
    * It needs to save the information in memory until
    * It reaches the base case for both binary trees.
  */

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode( int x )
    {
      val = x;
    }
  }

  public TreeNode mergeTrees( TreeNode t1, TreeNode t2 )
  {
    if (t1 == null && t2 == null) return null;

    TreeNode mergedTree = new TreeNode(0);
    if (t1 != null && t2 != null)
    {
      mergedTree.val = t1.val + t2.val;
      mergedTree.left = mergeTrees(t1.left, t2.left);
      mergedTree.right = mergeTrees(t1.right, t2.right);
    }
    else if (t1 != null)
    {
      mergedTree.val = t1.val;
      mergedTree.left = mergeTrees(t1.left, null);
      mergedTree.right = mergeTrees(t1.right, null);
    }
    else
    {
      mergedTree.val = t2.val;
      mergedTree.left = mergeTrees(null, t2.left);
      mergedTree.right = mergeTrees(null, t2.right);
    }

    return mergedTree;
  }
}
