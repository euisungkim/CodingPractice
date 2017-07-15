package Easy;

/*
Name: Eui Sung Kim
Date: July 15 2017
From: CodeFights

Problem:
Given a singly linked list of integers l and an integer k,
remove all elements from list l that have a value equal to k.

Requirements:
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  * where n is the number of elements.
*/

public class RemoveKFromList {
  // Definition for singly-linked list:
  class ListNode<T> {
    ListNode( T x )
    {
      value = x;
    }

    T value;
    ListNode<T> next;
  }

  /*
1. Create one head node to be "previous" of first element of the ListNode.
2. Set header node location to be l^th - 1
3. If element == k, we only need to set l to next:
    a. Example: [3, 1, 2, 3, 4, 5]
      If 3 is removed, then list will be [1, 2, 3, 4, 5]
      Thus, cur.next will be 1 and l.next will also be 1.
      We strictly need to set cur to be l^th-1.
3. Repeat until reaching end of l, then return header.next to return the whole list.

Time Complexity: O(n).
  * It goes through the list one time.
Space Complexity: O(1).
  * Though we create fake head node called header, that only adds 1 to the
  * overall complexity. That is still constant.
*/

  void remove( ListNode<Integer> predecessor, ListNode<Integer> successor )
  {
    predecessor.next = successor.next;
  }

  ListNode<Integer> removeKFromList( ListNode<Integer> l, int k )
  {
    // given integers l & integer k, remove all elements from list l that have a value equal to k.
    ListNode<Integer> header = new ListNode<Integer>(0);
    header.next = l; // new head ("dummy") node
    ListNode<Integer> cur = header;
    while (l != null)
    {
      //
      if (l.value == k)
        remove(cur, l);
      else
        cur = cur.next;
      l = l.next;
    }
    return header.next;
  }
}
