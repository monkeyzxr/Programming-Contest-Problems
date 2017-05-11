// CodeWarmers Assignment2
// Xiangru Zhou
// 10/8/2016

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Greetings {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (new File("src/greetings.in.txt"));
		PrintWriter output = new PrintWriter ("src/greetings.out.txt");
		
		// read number of bessie's lines & elsie's lines
		int bLines = input.nextInt();
		int eLines = input.nextInt();
		
		bMoves = new char [max];
		eMoves = new char [max];
		
		int bSteps = 0;
		int eSteps = 0;
		
		
		// process bessie's lines
		for(int i = 0; i < bLines; i++){
			// read one line
			int steps = input.nextInt();
			String direction = input.next(); // read a 'L' or a 'R'			
			//add 'L' or 'R' to the moves array
			for(int j = 0; j < steps; j++)
				bMoves[bSteps++] = direction.charAt(0); // put the 'L' or "R' into the array			
		}
		
		// process elsie's lines
		for(int i = 0; i < eLines; i++){
			// read one line
			int steps = input.nextInt();
			String direction = input.next(); // read a 'L' or a 'R'			
			//add 'L' or 'R' to the moves array
			for(int j = 0; j < steps; j++)
				eMoves[eSteps++] = direction.charAt(0); // put the 'L' or "R' into the array			
		}
		
		// ready for the simulation
		int bPosition = 0;
		int ePosition = 0;
		int crossings = 0;
		int newBPosition = 0;
		int newEPosition = 0;
		int maxSteps = Math.max(bSteps, eSteps);
		for(int i = 0; i < maxSteps; i++) {
			//bMoves[i] can be L or R or null;
			//eMoves[i] can be L or R or null;
			if(bMoves[i] == 'L')
				newBPosition = bPosition - 1;
			else if(bMoves[i] == 'R')
				newBPosition = bPosition + 1;
			
			if(eMoves[i] == 'L')
				newEPosition = ePosition - 1;
			else if(eMoves[i] == 'R')
				newEPosition = ePosition + 1;
			
			//at this point we have old position & new position
			// 2 crossing condition: 1): two cows in the same position; 
			//                       2): two cows exchange position (pass by each other)
			
			// are both cows in the same position?
			if(newBPosition == newEPosition)
				// did they start from different positions?
				if(bPosition != ePosition)
					crossings++;
			
			//check whether cows exchanged positions
			if((bPosition == newEPosition) && (ePosition == newBPosition))
				crossings++;	
			
			bPosition = newBPosition;
			ePosition = newEPosition;			
		}
		 
		
		// print the crossings
		output.println("The number of crossings for bessie and elsie is: " + crossings);				
		output.close(); 
	}
	static final int max = 1000000;
	static char [] bMoves; // move can be 'L', 'R' or null
	static char [] eMoves;
	
}
