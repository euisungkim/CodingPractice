package Easy;

/*
Name: Eui Sung Kim
Date: July 10 2017
From: Leetcode

Problem:
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class PalindromeNumber {
  /*
  I could have gotten the absolute value of x and get "-2147447412" right,
  Negative number cannot be palindrome.

  By using this method, I can avoid overflow when dealing with MAX_INTEGER with
  reverse() method. In addition, this algorithm does not require extra space,
  compared to using, say, using parsing String, using toCharArray() etc.

  Time Complexity: O(n).
    * n being number of digits in the integer x.
  Space Complexity: O(1).
    * It does not store "each" digit to some space that requires memory.
    * It just adds to an existing variable.
  */
  public static boolean isPalindromeNumber(int x)
  {
    int original = x;
    int temp = original % 10;
    original /= 10;

    // if number is a single digit, it is a palindrome.
    if ( x < 10 && x > -1 ) return true;

    // any number cannot start with a zero
    // palindrome number cannot be negative
    if ( x % 10 == 0 || x < 0)
      return false;

    // storing "reversed" n until
    while ( original >= 10 )
    {
      temp *= 10;
      temp += original % 10;
      original /= 10;
    }
    return (temp == x / 10) && (original == x % 10);
  }

  public static void main(String[] args)
  {
    System.out.println(isPalindromeNumber(-32123));
  }
}
