package com.test.proj;


/**
 * @author: Kamakshi
 * @date : 12/23/2019
 * This is used to swap Nodes in pairs for the given Linked List
 *
 */

class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
}

public class testSwapPairs {
	
	 public ListNode swapPairs(ListNode head) {
	     
		 if(head == null) {
			 return null;
		 }
		 ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 ListNode swapNode = head;
		 
		 // This will verify for the next valid node, and swaps the pair, once done it skips the current pair
		  // and jumps to the next pair of nodes to swap and continues till no pair is left. 
		 while(swapNode.next != null) {
			 swap(swapNode,swapNode.next);
			 
			 if(swapNode.next.next != null)
				 swapNode = swapNode.next.next;
			 else 
				 break;
		 }
		 return head;
		 
	 }
	 
	 public void swap(ListNode x, ListNode y){
		 	 int temp = x.val;
		 	 x.val = y.val;
		 	 y.val = temp; 
	 }
	 
	 public static void main(String str[]) {
		 	ListNode l1 = new ListNode(1);
			ListNode l2 = new ListNode(2);
			ListNode l3 = new ListNode(3);
			ListNode l4 = new ListNode(4);
			ListNode l5 = new ListNode(5);
			
			l1.next = l2;
			l2.next = l3;
			l3.next = l4;
			l4.next = l5;
			
			testSwapPairs obj = new testSwapPairs();
			ListNode valueLst = obj.swapPairs(l1);
			
			while(valueLst != null) {
				System.out.println(valueLst.val);
				valueLst = valueLst.next;			
			}
		 
	 }
}
