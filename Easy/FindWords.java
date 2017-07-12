package Easy;
import java.util.HashMap;
import java.util.ArrayList;

/*
Name: Eui Sung Kim
Date: July 12 2017
From: LeetCode

Problem: Given a List of words, return the words that can be typed using letters of alphabet
on only one row's of American keyboard (QWERTY keyboard).

Guaranteed Constraints:
  1. You may use one character in the keyboard more than once.
  2. You may assume the input string will only contain letters of alphabet.
*/

public class FindWords {
  /*
  1. Put each row keys in a String array
  2. Associate each character in specific row by using HashMap
  3. Go through every words and see if:
      a. Length is less than 2
          i. Continue onto next word.
      b. All characters belong to a same row
      c. If loop reaches at the end of the word, add the word to ArrayList<String>
  4. Convert ArrayList<String> to a String[] array and return its results.

  Time Complexity: O(n * k).
    *  Let n be number of words,
    *  Let k be number of characters in each word.
  Space Complexity: O(n).
    * There is a possibility that all words belong to same row,
    * then ArrayList will be contained with n words.
    * qwertyKeyboard String array will always be fixed thus constant.
*/
  public String[] findWords( String[] words )
  {
    String[] qwertyKeyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    // Characters are associated with row number in a Hash Map
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < qwertyKeyboard.length; i++)
    {
      for (char c : qwertyKeyboard[i].toCharArray())
        map.put(c, i);
    }

    // This will be converted into String array at the end
    ArrayList<String> result = new ArrayList<String>();
    // Go through every words in the words array
    for (String s : words)
    {
      if (s.length() < 2)
      {
        result.add(s);
        continue;
      }
      String str = s.toLowerCase();
      // For every character at index i-1 & i,
      // Check value of the map. If they are not equal then
      // Go to next word available
      for (int i = 1; i < str.length(); i++)
      {
        int prev = map.get(str.charAt(i - 1));
        int cur = map.get(str.charAt(i));
        // previous character & current character are not in the same row
        if (prev != cur)
          break;
        // we reached end of our word and they are indeed in the same row, add
        if (i == str.length() - 1)
          result.add(s);
      }
    }

    return result.toArray(new String[0]);
  }
}
