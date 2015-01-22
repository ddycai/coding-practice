/*
 * 2. Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 */

import java.util.Stack;

public class Solution {

    public ListNode reverse(ListNode head) {
      ListNode prev = null;
      ListNode cur = head, next;
      while(cur != null) {
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
      }
      return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode res = null;
      
      while(l1 != null && l2 != null) {
        int sum = l1.val + l2.val;
        if(sum >= 10) {
          sum -= 10;
          if(l1.next == null) {
            l1.next = new ListNode(1);
          } else
            l1.next.val += 1;
        }
        ListNode node = new ListNode(sum);
        node.next = res;
        res = node;
        l1 = l1.next;
        l2 = l2.next;
      }

      ListNode cur;
      if(l1 != null)
        cur = l1;
      else
        cur = l2;

      while(cur != null) {
        if(cur.val >= 10) {
          cur.val -= 10;
          if(cur.next == null) {
            cur.next = new ListNode(1);
          } else
            cur.next.val += 1;
        }
        ListNode node = new ListNode(cur.val);
        node.next = res;
        res = node;
        cur = cur.next;
      }

      return reverse(res);
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
