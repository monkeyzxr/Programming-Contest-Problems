import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/* Pseudocode:
 * 
 * string names[MAX]
 * int incoming[MAX]; outgoing[MAX];
 * 
 * read # of friends 
 * read and load names of friends to array names[]
 * 
 * we need to process same # of transactions
 * for each transaction
 *     read giver, incoming[giver's index], # of of receivers
 *     amountToEachReceiver = incoming[giver's index] / # of receivers
 *     for each receiver
 *         read receiver's name   
 *         deposit amountToEachReceiverto that  outgoing[that receiver's index]
 *     endFor
 * endFor
 * 
 * for each friend
 *     print name and net amount(outgoing - incoming)
 * 
 */



public class Gift1 {
	
	static int numFriends;
	static String [] names;
	static int [] incoming;
	static int [] outgoing;
		
	static int findIndex(String person) {
		for(int i = 0; i < numFriends; i++){
			//if(person == names[i]) C++ 
			if(person.equals(names[i]))
				return i;
		}
		return 0;		
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("src/gift1.in.txt"));
		PrintWriter output = new PrintWriter("src/gift1.out.txt");
		
		// read # of friends
		numFriends = input.nextInt();
		// allocate arrays
		names = new String [numFriends];
		incoming = new int [numFriends];
		outgoing = new int [numFriends];
		// read friends' names
		for (int i = 0; i < numFriends; i++) {
			names[i] = input.next();  // get a string			
		}
		
		for (int i = 0; i < numFriends; i++) {
			// process one transaction
			String giver = input.next();
			int giverIndex = findIndex(giver);			
			incoming[giverIndex] = input.nextInt();
			int numReceivers = input.nextInt();
			if(numReceivers == 0)
				continue;	// continue from a new loop		
			int giftAmount = incoming[giverIndex] / numReceivers;
			outgoing[giverIndex] += incoming[giverIndex] % numReceivers;
			
			// give gift amount to each receiver			
			for (int j = 0; j < numReceivers; j++) {
				String receiver = input.next();
				outgoing[findIndex(receiver)] += giftAmount;				
			}			
		}
		
		for (int i = 0; i < numFriends; i++) {
			output.println(names[i] + ' ' + (outgoing[i] - incoming[i]));
		}
				
		output.close();	
	}

}
