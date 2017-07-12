package Easy;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
Name: Eui Sung Kim
Date: July 12 2017
From: LeetCode

Problem: Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.

Solution1: O(n) Time Complexity, O(n) Space Complexity
Solution2: O(n) Time Complexity, O(1) Space Complexity
*/

public class FindDisappearedNumbers {
  /*
  First Try: Using HashMap
    from 1 ≤ a[i] ≤ n,
    If no such number exists in the HashMap then it does not exist.

    Time Complexity: O(n).
      * Checks through the whole array by using containsKey() method.
    Space Complexity: O(n).
      * HashMap takes O(n) space.
  */
  public List<Integer> findDisappearedNumbersSol1(int[] nums)
  {
    List<Integer> list = new ArrayList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // remove duplicates and order them
    for (int i = 0; i < nums.length; i++)
      map.put(nums[i], 1);

    for (int i = 1; i <= nums.length; i++)
    {
      if (!map.containsKey(i))
        list.add(i);
    }

    return list;
  }

  /*
  Second Try: Realized this question was very similar to ./FirstDuplicate.java
    Since one of the guaranteed constraints is 1 ≤ a[i] ≤ n,
    We can use this as an advantage and indicate the repeated numbers by using indice.
    Therefore, we need an indicator to check for disappeared numbers: Negating an existing number.

    Time Complexity: O(n).
      * If there is no "disappeared number", it checks through the whole array
    Space Complexity: O(1).
      * The value of i is temporary in the array.
      * Conditional check does not require "non-temporary" space.
      * Negating the number does not require "non-temporary" space.
  */
  public List<Integer> findDisappearedNumbersSol2(int[] nums)
  {
    List<Integer> list = new ArrayList<Integer>();

    // Negating existing numbers by using indice
    for (int i : nums)
    {
      if (nums[i - 1] > 0)
        nums[i - 1] *= -1;
    }

    // All existing numbers are negative;
    // As long as the numbers are positive,
    for (int i = 1; i <= nums.length; i++)
    {
      if (nums[i - 1] > 0)
        list.add(i);
    }

    return list;
  }
}
