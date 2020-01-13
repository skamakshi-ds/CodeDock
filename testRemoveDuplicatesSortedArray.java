package com.test.proj;

/*
* @author : CodeDock
* @date : 12/30/2019
* Used to remove duplicates in an sorted array and 
* returns number of distinct element.
*
*/
public class testRemoveDuplicatesSortedArray {
	
	public int removeDuplicates(int[] a) {
			
		if(a.length == 0) {
			return 0;
		}
		if(a.length == 1) {
			return 1;
		}else {
			// Storing the first value in the temp varieble, comparing with the non-equal element
			// and swapping the position which pushes the duplicate elements to the end. Thus remains 
			// with new array with all the distinct element at the intial part of the array.
			int temp = a[0];
			int index = 1;
			for(int i = 1; i < a.length ; i++) {
				{
					if(temp != a[i]) {
						temp = a[i];
						swap(a, index,i);
						index++;				
					}
					
				}
			}			
			return index;
		}
	}
	
	public void swap(int[] a, int index, int i) {
		int temp = a[index];
		a[index] = a[i] ;
		a[i] = temp;
	}
	
	public static void main(String str[]) {
		testRemoveDuplicatesSortedArray obj = new testRemoveDuplicatesSortedArray();
		int[] a = {0,1,1,1,2,2,3,4,4,4};
		
		System.out.println(obj.removeDuplicates(a));
		
		
	}

}
