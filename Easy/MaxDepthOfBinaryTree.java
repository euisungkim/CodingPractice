package Easy;

/*
Name: Eui Sung Kim
Date: July 11 2017
From: LeetCode

Problem:
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public class MaxDepthOfBinaryTree {
  /*
  Simple recursive method to find maximum depth of a binary tree.
  It will start from root then check for every single existing node.

  Time Complexity: O(n).
    * It will check for every single existing node.
  Space Complexity: O(n).
    * It will need O(n) memory to hold recursive methods until it reaches its base case.
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

  /*
    Simple recursive method to find its maximum number of Nodes.
    When it reaches base case, it returns 0, then adds 1 each time it sees a node.
  */
  public static int maxDepth(TreeNode root) {
    // base case
    if ( root == null ) return 0;

    int maxLeft = maxDepth(root.left) + 1;
    int maxRight = maxDepth(root.right) + 1;

    return Math.max(maxLeft, maxRight);
  }

  // Shortened Solution.
  public static int maxDepthShortenedSol(TreeNode root) {
    // base case
    if ( root == null ) return 0;
    return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
  }
}
