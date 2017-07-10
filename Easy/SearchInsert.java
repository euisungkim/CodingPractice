package Easy;

/*
Name: Eui Sung Kim
Date: July 10 2017
From: Leetcode

Problem:
Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Guaranteed constraints:
  * No duplicates in the array.
*/

public class SearchInsert {
  /*
  Uses binary search algorithm to find target index:
    Array is sorted so we can safely divide them in half to reduce runtime (log n).

  Time Complexity: O(log n).
    * It goes through half of nums[] array.
  Space Complexity: O(1).
    * It does not depend on any instance member data
  */
  public static int searchInsert(int[] nums, int target)
  {
    int low = 0;
    int high = nums.length - 1;

    // finding the "target" if not, then it will return
    // the lowest index (low).
    while (low <= high)
    {
      int mid = (low + high) / 2;
      if ( nums[mid] == target )
        return mid;
      else if ( nums[mid] < target )
        low = mid+1;
      // else if (nums[mid] > target)
      else high = mid-1;
    }

    return low;
  }
}
