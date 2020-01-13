package com.test.proj;

import java.util.LinkedList;

class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
}

public class testNthNodefromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		LinkedList<ListNode> lstNode = new LinkedList<ListNode>();
		lstNode.add(head);
		ListNode node = head.next;
		int count = 1;
		while(node != null) {
			lstNode.add(node);
			node = node.next;
			count++;
		}
		int index = lstNode.size() - n;
		int totalLength = lstNode.size();
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode first = dummyNode;
		while(index != 0) {
			first = first.next;
			index--;
		}
		first.next = first.next.next;

		return dummyNode.next;			
	}

	public static void main(String str[]) {
		ListNode lst1 = new ListNode(1);
		ListNode lst2 = new ListNode(2);
		ListNode lst3 = new ListNode(3);
		ListNode lst4 = new ListNode(4);
		ListNode lst5 = new ListNode(5);

		lst1.next = lst2;
		lst2.next = lst3;
		lst3.next = lst4;
		lst4.next = lst5;

		testNthNodefromEnd obj = new testNthNodefromEnd();
		ListNode lst = obj.removeNthFromEnd(lst1, 2);
		while(lst != null) {
			System.out.println(lst.val);
			lst = lst.next;
		}
	}
}

