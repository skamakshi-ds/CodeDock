package com.test.proj;

public class DisplayDigitsOfInt {

	// This formula will be used for printing each digit of the integer from starting
	public void displayEachDigit(int num,int size) {

		for(int i = 0; i < size;i++) {

			// For the first Digit
			if(i == 0) {
				int val = (num - (num % (int)Math.pow(10,size-1)))/(int)Math.pow(10, size-1);
				System.out.println(val);
			} 
			else if(i == size-1) // for the last Digit  
				System.out.println(num % (int)Math.pow(10,size-i));
			// For the rest of the Digit
			else {

				int rem = num % (int)Math.pow(10,(size-(i+1)));
				int div = num /(int) Math.pow(10, size-i);
				int addressee = (div *(int) Math.pow(10, size-i)) + rem;
				int val = (num - addressee)/(int) Math.pow(10,(size-(i+1)));
				System.out.println(val);
			}
		}	
	}
	
	public static void main(String str[]) {
		
		DisplayDigitsOfInt obj = new DisplayDigitsOfInt();
		int num = 232534323;
		obj.displayEachDigit(num, (num+"").length());
	}
}
