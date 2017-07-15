package Easy;

/*
Name: Eui Sung Kim
Date: July 15 2017
From: CodeFights

Problem:
Given a singly linked list of integers, determine whether or not it's a palindrome.

Guaranteed constraints:
  0 ≤ list size ≤ 5 * 10^5,
  -10^9 ≤ element value ≤ 10^9.

Requirements:
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  * let n = number of elements in the linked list
*/

public class IsListPalindrome {
  // Definition for singly-linked list:
  public static class ListNode<T> {
    ListNode( T x )
    {
      value = x;
    }
    T value;
    ListNode<T> next;
  }
  /*
  1. Check if list is null, make it easier for methods getMid() and reverseList()
  2. Get middle node of the list to reverse.
  3. Reverse the nodes from mid node -> last node
  4. Check if all elements are the same from first element of list & mid, etc.

  Time Complexity: O(n).
  * getMid() method takes O(n/2) time
  * reverseList() method takes O(n/2) time since only reversing last half
  * Checking if elements are the same also takes O(n/2) time since O(n/2) + O(n/2) is still O(n)
  Space Complexity: O(1).
  * Not creating new linked list to check if list is palindrome
  * Just using the existing linked list, therefore O(1).
  */

  ListNode<Integer> getMid(ListNode<Integer> l)
  {
    ListNode<Integer> mid = l;
    ListNode<Integer> last = l;
    // traverse through the list by using "runner" technique
    while (last != null && last.next != null)
    {
      last = last.next.next;
      mid = mid.next;
    }
    return mid;
  }

  ListNode<Integer> reverseList(ListNode<Integer> l)
  {
    ListNode<Integer> prev = null;

    while ( l != null )
    {
      ListNode<Integer> next = l.next;
      l.next = prev;
      prev = l;
      l = next;
    }

    return prev;
  }

  boolean isListPalindrome(ListNode<Integer> l) {
    // if list is null then it is a palindrome
    if (l == null) return true;

    // get middle node to reverse
    ListNode<Integer> mid = getMid(l);
    // reverse list from mid
    ListNode<Integer> curMid = reverseList(mid);

    while ( l != mid )
    {
      if ((int)curMid.value != l.value)
        return false;
      l = l.next;
      curMid = curMid.next;
    }

    return true;
  }
}
