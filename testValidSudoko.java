package com.test.proj;

import java.util.HashMap;

/**
 * 
 * @author : Kamakshi
 * @date : 01/05/2020
 * 
 * This will validate if the Given Sudoko puzzle is valid
 * or not. This only validate the predefined entries in the sudoko slots.
 * 
 */
public class testValidSudoko {
	public boolean isValidSudoku(char[][] board) {
        
		if(board.length != 9 || board[0].length != 9)
			return false;
		
		
		// Data loading for the box validation
		HashMap<Integer,HashMap<Integer,Integer>> mapArray = new HashMap<Integer,HashMap<Integer,Integer>>();
		for(int i= 0; i < 9; i++) {
			HashMap<Integer,Integer> lst = new HashMap<Integer,Integer>();
			mapArray.put(i,lst);
		}
		
		// For checking duplicate Vertically & Horizontal 
		HashMap<Integer,Integer> verticalMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> horizontalMap = new HashMap<Integer,Integer>();
		
		
		
		for(int i = 0; i < board.length ; i++) {
			verticalMap.clear();
			horizontalMap.clear();
				
			for(int j = 0; j < board[0].length ; j++) {
				
				if(board[i][j] != '.') {
					Integer vertVal = Integer.parseInt(board[i][j]+"");
					
					if(verticalMap.containsKey(vertVal) || vertVal < 1 || vertVal > 9)
						return false;
					else
						verticalMap.put(vertVal,1);
				}
				
				if(board[j][i] != '.') {
					Integer horiVal = Integer.parseInt(board[j][i] + "");
					
					if(horizontalMap.containsKey(horiVal) || horiVal < 1 || horiVal > 9)
						return false;
					else
						horizontalMap.put(horiVal,1);
				}
				
				// -----Validating the box data-----
				
				
				if(board[i][j] != '.') {
					
					int boardIndex = ((i/3)*3) + j/3; // Row Major Algorithm
					Integer boxVal = Integer.parseInt(board[i][j]+"");
					HashMap<Integer,Integer> mapBox = mapArray.get(boardIndex);
					
					
					if(mapBox.containsKey(boxVal) || boxVal < 1 || boxVal > 9)
						return false;
					else
						mapBox.put(boxVal,1);
					
					mapArray.replace(boardIndex,mapBox);
				}
			}
		}
		
		return true;
    }
	
	
	
	public static void main(String str[]) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
		                  {'6','.','.','1','9','5','.','.','.'},
		                  {'.','9','8','.','.','.','.','6','.'},
		                  {'8','.','.','.','6','.','.','.','3'},
		                  {'4','.','.','8','.','3','.','.','1'},
		                  {'7','.','.','.','2','.','.','.','6'},
		                  {'.','6','.','.','.','.','2','8','.'},
		                  {'.','.','.','4','1','9','.','.','5'},
		                  {'.','.','.','.','8','.','.','7','9'}};
		
		testValidSudoko obj = new testValidSudoko();
		System.out.println("Given Sudoko's validity is :" + obj.isValidSudoku(board));
	}
}
