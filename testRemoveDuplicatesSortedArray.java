package com.test.proj;

public class testRemoveDuplicatesSortedArray {
	
	public int removeDuplicates(int[] a) {
			
		if(a.length == 0) {
			return 0;
		}
		if(a.length == 1) {
			return 1;
		}else {
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
