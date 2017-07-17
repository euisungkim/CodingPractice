package Easy;
/*
Name: Eui Sung Kim
Date: July 16 2017
From: LeetCode

Problem: Given an array of integers, every element appears twice except for one. Find that single one.

Requirements: O(n) time complexity
Optional: O(1) space complexity
*/

public class SingleNumber {
  /*
    uses XOR to find the unique integer.
    since 1 XOR 1 == 0 and 0 XOR 0 == 1, (commutative)
    We will be able to find that unique integer with O(1) space complexity.

    Time Complexity: O(n)
      * It goes through every element in the integer array.
    Space Complexity: O(1)
      * It does not require extra space since we just need result variable to store
        the unique integer.
  */
  public int singleNumber(int[] nums) {
    // Given an array of integers, every element appears twice except for one. Find that single one.
    // Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    int result = 0;

    for (int num : nums)
      // n XOR n = 0
      result ^= num;

    return result;
  }
}
