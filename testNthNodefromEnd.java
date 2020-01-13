package com.test.proj;

/*
* @author : Kamakshi
* @date : 12/21/2019
*This is used to remove the Nth Node from the end of the given 
* List
*
*/



import java.util.LinkedList;

// Holds the data in the list Node format.
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
		
		// Dummy node helps to store the first node of the list
		// Which gives access to easy retrieval or removal of the node.
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

