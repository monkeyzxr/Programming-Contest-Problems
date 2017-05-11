/*
 * CodeWarmers Assignment 5
 * Xiangru Zhou
 * 10/9/2016
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
5
20
4
1
24
21
FJ's farm has 5 hills, with elevations 1, 4, 20, 21, and 24.
 */

public class Skidesign {

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(new File("src/skidesign.in.txt"));
		PrintWriter output = new PrintWriter("src/skidesign.out.txt");
		
		//read input data
		int numHills = input.nextInt();
		int [] hillHeight = new int[numHills];
		for(int i = 0; i < numHills; i++) {
			input.nextLine();
			hillHeight[i] = input.nextInt();
		}
		
		// process
		int sum = Integer.MAX_VALUE;
		for(int minHeight = 0; minHeight <= 100; minHeight++){
			int tempSum = 0;
			for(int i = 0; i < numHills; i++){
				int temp = hillHeight[i] - minHeight;
				if(temp > 17){
					temp = temp -17;
					tempSum += temp * temp;
				}
				else if(temp < 0){
					tempSum += temp * temp;
				}
			}
			sum = Math.min(sum, tempSum);
		}
		
		
		output.println(sum);
		output.close();
	}

}
