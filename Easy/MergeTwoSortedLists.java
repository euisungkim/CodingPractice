package Easy;

/*
Name: Eui Sung Kim
Date: July 10 2017
From: Leetcode

Problem:
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
*/

public class MergeTwoSortedLists {
  // Definition for singly-linked list.
  public class ListNode
  {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

  /*
  This checks for every single node that exists in l1 and l2,
  while checking

  Time Complexity: O(l1 * l2).
    * It goes through every single node in l1 and l2 with unknown size,
    * therefore we have to consider both size of l1 and l2.
  Space Complexity: O(n).
    * It stores every data into merged list starting from "header."
  */

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // sentinel for the merged list
    ListNode header = new ListNode(0);
    ListNode cur = header;

    // To avoid NullPointerException, we have to stop when
    // all data of one of these lists is checked.
    while ( l1 != null && l2 != null )
    {
      if ( l1.val <= l2.val )
      {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
        cur = cur.next;
      }
      else {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
        cur = cur.next;
      }
    }

    // since we do not know which one is null
    // and size is not specified for both lists,
    // we have to make sure we got all of data stored in the list.
    while (l1 != null)
    {
      cur.next = new ListNode(l1.val);
      l1 = l1.next;
      cur = cur.next;
    }
    while (l2 != null)
    {
      cur.next = new ListNode(l2.val);
      l2 = l2.next;
      cur = cur.next;
    }

    // we have to return next because header is just a trailer.
    return header.next;
  }
}
