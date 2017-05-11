/*
 *  CodeWarmers Assignment4
 *  Xiangru Zhou
 *  10/8/2016
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Relay {
	
	static int numCows;
	static int [] receivers;
	static char [] status;
	
	public static boolean isLoopy (int num){
		status[num] = 'V';
		if(receivers[num] == 0)
			return false;
		if(status[receivers[num]] == 'V')
			return true;
		else 
			return isLoopy(receivers[num]); // tail recursion, can change to a loop
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("src/relay.in.txt"));
		PrintWriter output = new PrintWriter("src/relay.out.txt");
		
		// read input data
		numCows = input.nextInt();
		receivers = new int [numCows+1];
				
		for (int i = 1; i <= numCows; i++){
			receivers[i] = input.nextInt();
		}
		
		status = new char [numCows+1];
		int nonLoopy = 0;
		
		// check whether each cow is loopy
		for (int i = 1; i <= numCows; i++){
			// initialize status[] array
			for (int j = 1; j <= numCows; j++)
				status[j] = 'U';  // U means unvisited
			if(isLoopy(i) == false)
				nonLoopy++;			
		}
				
		output.println("The total number of non-loopy cows is: " + nonLoopy);
		output.close();
	}

}
