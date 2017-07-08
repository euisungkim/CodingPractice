package Easy.firstDuplicate;
import java.util.LinkedHashSet;

/*
Name: Eui Sung Kim
Date: July 5 2017
From: Codefights

Problem:
Given an array a that contains only numbers in the range from 1 to array length,
Find the first duplicate number for which the second occurrence has the minimal index.

Note: Write a solution with O(n) time complexity and O(1) additional space complexity.

Guaranteed constraints:
  1 <= a.length <= 105,
  1 <= a[i] <= a.length.
*/

public class FirstDuplicate {
  /*
  First Try
    It uses LinkedHashSet to store integers as "key" and
    method "contains" to find any duplicate exists.

    Time Complexity: O(n).
      * If there are no duplicates, it runs through the whole array
        while adding each element to the LinkedHashSet.
    Space Complexity: O(n).
       * It will need O(n) working memory to add to the list and hold.

    Therefore, it does not qualify as an answer to this problem.
    Answer is provided below, firstDuplicateSecondSol method.
  */
  private static int firstDuplicateFirstTry(int[] a)
  {
    LinkedHashSet<Integer> map = new LinkedHashSet<>();
    for ( int number : a )
    {
      // duplicate found, return its number
      if (map.contains(number))
        return number;
      // otherwise, add this number to the HashSet
      else
        map.add(number);
    }
    // no duplicate found
    return -1;
  }

  /*
  Second Try
    Since one of the guaranteed constraints is 1 <= a[i] <= a.length,
    We can safely assume that index will never throw IndexOutOfBoundsException.
    Therefore, we need an indicator to check for duplicates: Negating an existing number.

    Time Complexity: O(n).
      * If there are no duplicates, it checks through the whole array
    Space Complexity: O(1).
      * The value of i is temporary in the array.
      * Conditional check does not require "non-temporary" space.
      * Negating the number does not require "non-temporary" space.
  */
  private static int firstDuplicateSecondTry(int[] a)
  {
    for ( int i : a )
    {
      if (a[Math.abs(i)-1] < 0)
        return Math.abs(i);
      a[Math.abs(i)-1] *= -1;
    }
    return -1;
  }

  public static void main(String[] args)
  {
    int[] array = { 5, 1, 2, 5, 3, 2 };
    System.out.println(firstDuplicateFirstTry(array));
    System.out.println(firstDuplicateSecondTry(array));
  }
}
