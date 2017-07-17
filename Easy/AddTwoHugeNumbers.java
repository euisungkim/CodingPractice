package Easy;

/*
Name: Eui Sung Kim
Date: July 16 2017
From: Codefights

Problem:
You're given 2 huge integers represented by linked lists.
Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits.
The represented number might have leading zeros.
Your task is to add up these huge integers and return the result in the same format.

Guaranteed constraints for both linked lists a & b:
  0 ≤ b size ≤ 10^4,
  0 ≤ element value ≤ 9999.
*/

public class AddTwoHugeNumbers {
  /*
  Time Complexity:
    remainderExists() method: O(1)
    removeLastDigit() method: O(val)
        * where val = number > 9999.
    reverse() method: O(n)
        * where n = number of nodes in a list. (could be size of a or b)
    Overall Time Complexity: O(a + b)
        * Goes through every elements of a and b, but length of lists are not defined
        * Therefore O(a + b).

  Space Complexity: O(1)
      * Only creates one "fake head node" header to link to existing nodes.
   */
  // Definition for singly-linked list:
  class ListNode<T> {
    ListNode( T x )
    {
      value = x;
    }

    T value;
    ListNode<T> next;
  }

  boolean remainderExists(int val)
  {
    // since a & b both have guaranteed constraints
    // 0 ≤ element value ≤ 9999 => max number = 19998,
    // remainder can only be 1 if n digits > 4 digits
    return val/10000 == 1;
  }

  int removeLastDigit(int val)
  {
    // If there is a carry, set remainder to 1 (carry)
    // and remove last digit.
    int temp = 0;
    int tenth = 1;
    while ( val >= 10 )
    {
      temp += (val % 10) * tenth;
      tenth *= 10;
      val /= 10;
    }
    return temp;
  }

  ListNode<Integer> reverse(ListNode<Integer> list)
  {
    // O(1) space complexity reverse
    ListNode<Integer> prev = null;
    while ( list != null )
    {
      ListNode<Integer> next = list.next;
      list.next = prev;
      prev = list;
      list = next;
    }

    return prev;
  }

  ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    ListNode<Integer> header = new ListNode<Integer>(0); // fake head
    ListNode<Integer> cur = header;
    a = reverse(a);
    b = reverse(b);
    int sum, remainder = 0;

    while ( a != null || b != null )
    {
      sum = 0;
      if (a != null)
      {
        sum += a.value;
        a = a.next;
      }
      if (b != null)
      {
        sum += b.value;
        b = b.next;
      }
      sum += remainder;
      if (remainderExists(sum))
      {
        remainder = 1;
        sum = removeLastDigit(sum);
      }
      else
        remainder = 0;
      cur.next = new ListNode<Integer>(sum);
      cur = cur.next;
    }

    // if there's carry in last digit (> 9999)
    if (remainder == 1)
      cur.next = new ListNode<Integer>(1);

    return reverse(header.next);
  }
}
