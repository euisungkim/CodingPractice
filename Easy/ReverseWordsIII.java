package Easy;

/*
Name: Eui Sung Kim
Date: July 12 2017
From: Leetcode

Problem: Given a string, you need to reverse the order of characters in each word
within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Note:
  * In the string, each word is separated by single space
  * and there will not be any extra whitespace in the string.
*/

public class ReverseWordsIII {
  /*
    Reverses String without taking advantage of reverse() built-in method.
    It first splits the string into an array indicated by whitespace,
    then reverses each String in each index.

    Time Complexity: O(st * n).
      * Let longest string in string array st be n,
      * Let length of the string array be st. (In other words, number of words in String s)
      * First for loop runs for st.length times,
      * Second for loop runs for each character in each index.
      * Then it runs for st * n times.
    Space Complexity: O(st).
      * Number of words in String s will be stored in String array st.
  */
  public static String reverseWordsIII(String s)
  {
    String[] st = s.split(" ");
    StringBuilder reversedS = new StringBuilder();

    for (int j = 0; j < st.length; j++)
    {
      for (int i = st[j].length() - 1; i >= 0; i--)
      {
        reversedS.append(st[j].charAt(i));
      }
      if (j != st.length - 1) reversedS.append(" ");
    }

    return reversedS.toString();
  }
}
