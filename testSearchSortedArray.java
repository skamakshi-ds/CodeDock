package com.test.proj;

/*
* @author : CodeDock
* @date : 01/04/2020
* Used to search the target position at given sorted array or can 
* be used to search what might be the anticipated position if the target
* is not included in the given array.
*/

public class testSearchSortedArray {
	public int searchInsert(int[] nums, int target) {
		
		int index = 0;
		
		// If the given target is smaller than or equal to the first element or 
		if(target < nums[0] || target == nums[0]) {
			return 0;
		}
		
		// If the target present among the array elements
		for(int i = 1; i < nums.length ; i++) {
			if(target == nums[i] || (target > nums[i-1] && target < nums[i])) {
					return i;
				}
		}
		
		// if the target is greater than the array element.
		if(target > nums[nums.length-1])
			return nums.length;
		
		return index;
    }
	
	public static void main(String str[]) {
		
		testSearchSortedArray obj = new testSearchSortedArray();
		int[] nums = {1,3,4,6,7};
		int target = 0;
		
		System.out.println("The position of the :" + obj.searchInsert(nums, target));
		
	}
}
