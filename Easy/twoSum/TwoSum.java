package Easy.twoSum;

import java.util.HashMap;
import java.util.Arrays;

/*
Name: Eui Sung Kim
Date: July 8 2017
From: LeetCode

Problem:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Guaranteed constraints:
 * Each input would have exactly one solution
*/

public class TwoSum {
  /*
  TwoSum method uses HashMap to store value and index together,
  and finds the sum between two indices by finding the difference between target and current value.

    Time Complexity: O(n).
      * If no such sum exists, then it goes through the whole array.
    Space Complexity: O(n).
      * HashMap stores (value, index) n times at worst case.
   */
  public static int[] twoSum(int[] nums, int target)
  {
    int[] result = new int[2];

    // We can use HashMap since keys must be unique
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // We can get the other "index" by finding the difference between target and nums[i].
    for (int i = 0; i < nums.length; i++)
    {
      if (map.containsKey(target - nums[i]))
      {
        // It was not specified that array was sorted or not,
        // thus we need to be careful on which index to put in this result array.
        result[0] = Math.min(map.get(target - nums[i]), i);
        result[1] = Math.max(map.get(target - nums[i]), i);
        return result;
      }
      // map does not contain the sum with nums[i] yet so we put into hash map
      map.put(nums[i], i);
    }

    // Each input would have exactly one solution, but we need this for the compiler
    return result;
  }
  public static void main(String[] args)
  {
    int[] nums = { 2, 7, 11, 15 };
    System.out.println(Arrays.toString(twoSum(nums, 9)));
  }
}
