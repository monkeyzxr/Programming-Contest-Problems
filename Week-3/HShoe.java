/*
 * CodeWarmer Assignment 3
 * Xiangru Zhou
 * 10/8/2016
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * SAMPLE INPUT (file hshoe.in):
4
(())
()((
(()(
))))
 */

public class HShoe {
	static char [][] array;
	static int size = 0;
	static int maxLength = 0;
	
	static void searchOpen(int x, int y, int openSoFar) {

		// check whether x and y are valid
		if((x < 0) || (x >= size) || (y < 0) || (y >= size))
			return;
		
		//	have we visited current spot?	
		if(array[x][y] == ' ')
			return;
		// check array[x][y] == ')'		
		if(array[x][y] == ')')
			searchClose(x, y, openSoFar, 0);
		
		// if it is '(', go deeper & continue search
		// at this point, array[x][y] is '('
		// let's overwrite with space to avoid infinite recursion
		if(array[x][y] == '(') {
			array[x][y] = ' ';
			searchOpen(x-1, y, openSoFar+1);
			searchOpen(x+1, y, openSoFar+1);
			searchOpen(x, y-1, openSoFar+1);
			searchOpen(x, y+1, openSoFar+1);
			array[x][y] = '(';
		}
	}
	
	static void searchClose(int x, int y, int openCount, int closeSoFar) {
		if((openCount == closeSoFar) && (openCount + closeSoFar > maxLength)) {
			maxLength = openCount + closeSoFar;
			return;
		}
		
		// check whether x and y are valid
		if((x < 0) || (x >= size) || (y < 0) || (y >= size))
			return;
		
		//	check whether it is '(' or ' '
		if(array[x][y] != ')')
			return;
				
		// at this point, array[x][y] is ')'
		// let's overwrite with space to avoid infinite recursion
		array[x][y] =' ';
		searchClose(x-1, y, openCount, closeSoFar+1);
		searchClose(x+1, y, openCount, closeSoFar+1);
		searchClose(x, y-1, openCount, closeSoFar+1);
		searchClose(x, y+1, openCount, closeSoFar+1);
		array[x][y] = ')';		
	}
	


	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(new File("src/hshoe.in.txt"));
		PrintWriter output = new PrintWriter("src/hshoe.out.txt");
		// read input data
		size = input.nextInt();
		array = new char [size][size];
		for (int i = 0; i < size; i++){
			String temp = input.next(); // read a string row ")(()"
			for(int j = 0; j < size; j++)
				array[i][j] = temp.charAt(j);						
		}
		
		// ready for processing
		searchOpen(0, 0, 0);
		
		// output
		output.println(maxLength);
        output.close();
	}

}
