package Medium;

/*
Name: Eui Sung Kim
Date: July 8 2017
From: LeetCode

Problem:

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Guaranteed constraints:
 * The two numbers do not contain any leading zero, except the number 0 itself.
*/

public class AddTwoNumbers {
  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode( int x )
    {
      val = x;
    }
  }

  /*
  Definition for singly-linked list was already given

    Time Complexity: O(n).
      * Let n be longer list between l1 and l2.
      * We go through the list until we reach end of the longer list.
    Space Complexity: O(n).
      * Newly created list will store the sum between the numbers in l1 and l2
  */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2)
  {
    // header = sentinel for the singly linked list, will return at the end
    // headerFollower = "current" node. Need this to create connected list
    ListNode header = new ListNode(0);
    ListNode headerFollower = header;

    // will use sum variable to store remainder and divisor
    int sum = 0;

    // need to check if l1 is null or l2 is null
    while (l1 != null || l2 != null)
    {
      // If result was >= 10, sum = 1. If less, sum = 0.
      // Carryover variable
      sum /= 10;
      if (l1 != null)
      {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null)
      {
        sum += l2.val;
        l2 = l2.next;
      }

      headerFollower.next = new ListNode(sum % 10);

      // setting "current" node to created above Node
      headerFollower = headerFollower.next;
    }

    // If there are only 1 node for each list and they add up >= 10,
    // Then we need to create another node for the carryover
    sum /= 10;
    if (sum > 0)
      headerFollower.next = new ListNode(sum);

    // returning next because header is a sentinel not an actual node that contains data
    return header.next;
  }
}
