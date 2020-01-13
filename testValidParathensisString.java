package com.test.proj;

import java.util.ArrayList;

/**
 * @author : Kamakshi
 * @date : 12/26/2019
 * 
 * This will help to validate the parathensis pattern
 * {} , [] , () are properly used with their respective form.
 * e.g. : {()} is valid where as {(}) is invalid.
 */
import java.util.Stack;

public class testValidParathensisString {
	public boolean isValid(String s) {
		
		if(s != null && s.isEmpty()) {
			return true;
		}
		
		// The stack which helps to retrieve the data in LIFO format.
		// hence used to hold the parenthesis.
		Stack<Character> strStack = new Stack<Character>();
		boolean flag_exhausted = false;
		for(char c : s.toCharArray()) {
			
			if(c == '(' || c == '{' || c == '[') {
				strStack.push(c);
			}
			else if(c == ')' || c == '}' || c == ']') {
				
				if(!strStack.empty()) {
					char FirstElement = strStack.peek();
					if((FirstElement == '(' && c == ')') || (FirstElement == '{' && c == '}') || (FirstElement == '[' && c == ']')) {
						strStack.pop();
						flag_exhausted = true;
					}else {
						return false;
					}
				}else 
					return false;
			}
		}
		
		if(!strStack.isEmpty()) {
			return false;
		}
		return flag_exhausted;
	
	}
	
	public static void main(String str[]) {
		
		testValidParathensisString obj = new testValidParathensisString();
		System.out.println("String is valid or not : " + obj.isValid("{}([{]){}"));
	}
}
