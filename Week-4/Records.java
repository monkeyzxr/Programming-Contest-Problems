/*
 *  CodeWarmers Assignment4
 *  Xiangru Zhou
 *  10/8/2016
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Records {
	
	static int numLines;
	static String [] lines;
	public static String sortNames(String n1, String n2, String n3) {		
		// is n1 the smallest?
		if((n1.compareTo(n2) < 0) && (n1.compareTo(n3) < 0))
			return n1 + " " + ((n2.compareTo(n3) < 0) ? n2 + " " + n3 : n3 + " " + n2);
		// is n2 the smallest?
		if((n2.compareTo(n1) < 0) && (n2.compareTo(n3) < 0))
			return n2 + " " + ((n1.compareTo(n3) < 0) ? n1 + " " + n3 : n3 + " " + n1);
		// is n3 the smallest?
		if((n3.compareTo(n2) < 0) && (n3.compareTo(n1) < 0))
			return n3 + " " + ((n1.compareTo(n2) < 0) ? n1 + " " + n2 : n2 + " " + n1);		
		return "";		
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("src/records.in.txt"));
		PrintWriter output = new PrintWriter("src/records.out.txt");
		
		// read the input
		String name1, name2, name3;
		numLines = input.nextInt();
		lines = new String [numLines];
		for (int i = 0; i < numLines; i++){
			name1 = input.next();
			name2 = input.next();
			name3 = input.next();
			lines[i] = sortNames(name1, name2, name3);
			//System.out.println(lines[i]);
		}
		
		// process
		int maxFrequency = 0;
		for (int i = 0; i < numLines; i++){
			// find out how many times line[i] occur
			int count = 1; // already count oneself
			// check the reaming rows
			for (int j = i + 1; j < numLines; j++){
				if(lines[i].equals(lines[j]))
					count++;				
			}
			if(maxFrequency < count)
				maxFrequency = count;			
		}
		
		output.println("The number of occurrences most often is: " + maxFrequency);
		output.close();
	}

}
