package Easy.RomanToInteger;
import java.util.HashMap;

/*
Name: Eui Sung Kim
Date: July 10 2017
From: Leetcode

Problem:
Given a roman numeral, convert it to an integer.

Guaranteed constraints:
  input: 1 <= n <= 3999
*/

public class RomanToInteger {
  /*
  First Try:
  Using HashMap to store roman numerals and its integers,
  Finds value according to roman numeral 'key'. The "bad" solution.

  Time Complexity: O(n).
    * It goes through every characters in String s.
  Space Complexity: O(n).
    * It uses romanNums character array to find its characters.
 */
  private static int romanToInt( String s )
  {
    int result = 0;
    char[] romanNums = s.toCharArray();
    // roman numerals
    final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int count = 0;
    for (int i = 1; i < romanNums.length; i++)
    {
      if (map.get(romanNums[i - 1]) < map.get(romanNums[i]))
      {
        result += map.get(romanNums[i]) - map.get(romanNums[i - 1]);
        i++;
        count++;
      } else
        result += map.get(romanNums[i - 1]);

      count++;
    }

    // in case of left-over character in above for loop, we need to make sure
    // it goes through every single character.
    if (count < romanNums.length)
    {
      result += map.get(romanNums[romanNums.length - 1]);
    }

    return result;
  }

  /*
  Second Try:
  Same logic, better, the "good" solution.
  Reason:
    1. This does not need the last condition if (count < s.length())
    2. More readable.

  Time Complexity: O(n).
  Space Complexity: O(n).
  */
  public static int romanToInt2( String s )
  {
    if (s == null || s.length() == 0)
      return -1;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int len = s.length();
    // first value will always have the maximum number, thus
    // we can safely put it into res variable.
    int res = map.get(s.charAt(len - 1));
    for (int i = len - 2; i >= 0; i--)
    {
      // if previous
      if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i)))
        res += map.get(s.charAt(i));
      else
        res -= map.get(s.charAt(i));
    }

    return res;
  }
}
