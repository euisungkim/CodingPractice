package Easy;

/*
Name: Eui Sung Kim
Date: July 16 2017
From: LeetCode

Problem:
Invert a binary tree.

Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew),
but you can’t invert a binary tree on a whiteboard so f*** off.
*/

public class InvertTree {
  /*
  Simple recursive method to invert a binary tree.
  It sets left -> right and right -> left for every node in the tree recursively.

  Time Complexity: O(n).
    * Let n = numbers of nodes in a binary tree.
    * example worst case scenario for [1, 2, 3, 4] is similar to:
      1
       \ -------------------- level 0: O(1)
        2
         \ -------------------- level 1: O(1)
          3
           \ -------------------- level 2: O(1)
            4
             \ -------------------- level 3: O(1)
             null
       it takes constant time per level. O(n * 1) is still O(n).
  Space Complexity: O(n).
    * Though space complexity is O(h) where h = height,
      as seen above n (number of nodes) is stacked. Thus, O(n).
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

  // invert tree through recursion
  public TreeNode recursiveInvertTree(TreeNode root)
  {
    // base case, return when we hit end of tree (one after leaf node)
    if (root == null) return null;

    TreeNode left = recursiveInvertTree(root.left);
    // set root's left to inverted Tree (right)
    root.left = recursiveInvertTree(root.right);
    // set root's right to inverted Tree (left)
    root.right = left;

    return root;
  }
}
