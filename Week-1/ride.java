// CodeWarmers
// Assignment 1
// Xiangru Zhou

import java.io.*;
public class ride {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/ride.in.txt");
		FileWriter fw = new FileWriter("src/ride.out.txt");
		BufferedReader bufr = new BufferedReader(fr);
		BufferedWriter bufw = new BufferedWriter(fw);
		
		PrintWriter out = new PrintWriter(bufw);
		
		String comet = bufr.readLine();
		String group = bufr.readLine();
		
		if(mod47(comet) == mod47(group))
			out.println("GO");
		else
			out.println("STAY");
		
		out.close();
			
	}
	
	public static int mod47(String s) {
		int result = 1;
		for(int i = 0; i < s.length(); i++) {
			result *= (s.charAt(i) - 'A' + 1);
		}
		return result % 47;
	}

}
