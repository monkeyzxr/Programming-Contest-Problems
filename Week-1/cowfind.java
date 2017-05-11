// CodeWarmers
// Assignment 1
// Xiangru Zhou

import java.io.*;

public class cowfind {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/cowfind.in.txt");
		FileWriter fw = new FileWriter("src/cowfind.out.txt");
		BufferedReader bufr = new BufferedReader(fr);
		BufferedWriter bufw = new BufferedWriter(fw);
		
		PrintWriter out = new PrintWriter(bufw);
		
		int count = 0;
		String input = bufr.readLine();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(' && input.charAt(i+1) =='(')
				for(int j = i + 2; j < input.length() - 1; j++) {
					if(input.charAt(j) == ')' && input.charAt(j+1) ==')')
						count++;
				}			
		}
		
		out.println(count);
		out.close();

	}

}
