import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * read start & stop times into arrays
 * sort the data based on start times
 * process stop times & throw away any cross-over data set
 */


public class Crossing {
	
	public static void main(String[] args) throws Exception {
		

		Scanner input = new Scanner(new File("src/crossings.in.txt"));
		PrintWriter output = new PrintWriter("src/crossings.out.txt");
		
		final int MAXSIZE = 2000002;
		final int DELTA = 1000001;
		
		int stop[] = new int[MAXSIZE];
		int numCows = input.nextInt();
		for(int i = 0; i < numCows; i++){
			int start = input.nextInt() + DELTA;
			stop[start] = input.nextInt() + DELTA;		
		}
		
		int safeCowStop[] = new int [numCows];
		int safeInsert = 0;
		int maxStop = 0;
		for(int i = 0; i < MAXSIZE; i++)
			if(stop[i] > 0) {
				if(maxStop < stop[i])
					safeCowStop[safeInsert++] = stop[i];
				else
					while((safeInsert > 0) && (safeCowStop[safeInsert-1] > stop[i]))
						safeInsert--;
				
				if(maxStop < stop[i])
					maxStop = stop[i];
			}
		
		output.println(safeInsert);
		output.close();
			
	}
		
}