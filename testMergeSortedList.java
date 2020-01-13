package com.test.proj;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author: Kamakshi
 * @date : 12/23/2019
 * This is used to Merge the K sorted Linked List Nodes
 * into single ListNode.
 *
 */

class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
}
public class testMergeSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		
		
		/* 
		 * PriorityQueue is used to sort the list based on the node value by overriding the compare function, by defining 
		 * inside the priority queue.
		 */		
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>((Integer o1, Integer o2) -> {return Integer.compare(o1, o2);});
		
		/* This is another way of defining the priority queue, where the 'listComparator' class will be explicitly defined
		 *  which implements Compartor interface and overriding the compare function.
		 */
		//PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(new listComparatorCls()); 
		
		for(ListNode lstNode : lists) {
			ListNode dummyNode = new ListNode(0);
			dummyNode.next = lstNode;
			ListNode first = dummyNode.next;
			while(first != null) {
				
				pqueue.add(first.val);
				first = first.next;
			}			
		}
		
		// dummyNode is used to hold the first Node in the List which given 
		  // easy access to the retrieval of any consecutive nodes. 
		
		ListNode dummyNode = new ListNode(0);
		ListNode result = new ListNode(pqueue.poll());
		dummyNode.next = result;
		while(!pqueue.isEmpty()) {
			result.next = new ListNode(pqueue.poll());
			result = result.next;
		}
		
		return dummyNode.next;
        
    }
	
	public static void main(String str[]) {
		testMergeSortedList obj = new testMergeSortedList();
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		

		ListNode l6 = new ListNode(5);
		ListNode l7 = new ListNode(6);		
		ListNode l8 = new ListNode(7);
		ListNode l9 = new ListNode(8);
		ListNode l10 = new ListNode(9);
		
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = l10;
		
		ListNode[] lists = {l1,l6};
		ListNode valueLst = obj.mergeKLists(lists);
		
		while(valueLst != null) {
			System.out.println(valueLst.val);
			valueLst = valueLst.next;			
		}
	}
}


/*
 * class listComparatorCls implements Comparator<Integer>{
 * 
 * @Override public int compare(Integer o1, Integer o2) { // TODO Auto-generated
 * method stub return Integer.compare(o1, o2); } }
 */