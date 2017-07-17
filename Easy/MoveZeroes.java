package Easy;

/*
Name: Eui Sung Kim
Date: July 17 2017
From: LeetCode

Problem:
Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function,
nums should be [1, 3, 12, 0, 0].

Requirements:
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.
*/

public class MoveZeroes {
  /*
  Idea:
  1. Only the non-zero elements in the array order matter.
  2. When non-zero element is found, move it to count^th index (starting from 0)
  3. After it goes through the whole array, count (index) is at one after non-zero element.
     Therefore, starting from nums[count], we can assign 0 to the

  Time Complexity: O(n).
    * Let n = every element in nums[] array.
    * Worst case is that array is filled with zeroes and both loops run for nums.length times.
    * that means it will run 2n times, which is still O(n).
  Space Complexity: O(1).
    * Except variable count, variables here are all temporary variables.
  */
  public void moveZeroes(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++)
    {
      if (nums[i] != 0)
        nums[count++] = nums[i];
    }
    for (int i = count; i < nums.length; i++)
    {
      nums[i] = 0;
    }
  }
}
