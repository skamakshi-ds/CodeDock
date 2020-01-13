package com.test.proj;

public class testSearchSortedArray {
	public int searchInsert(int[] nums, int target) {
		
		int index = 0;
		
		if(target < nums[0] || target == nums[0]) {
			return 0;
		}
		
		for(int i = 1; i < nums.length ; i++) {
			if(target == nums[i] || (target > nums[i-1] && target < nums[i])) {
					return i;
				}
		}
		
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
