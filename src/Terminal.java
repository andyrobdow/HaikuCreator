import java.util.Scanner;

/**
 * A class with a main method that allows interaction with the Haiku Maker.
 */

/**
 * @author Andrew Dow
 *
 */
public class Terminal {
	public static void main (String[] args){
		HaikuMaker hk = new HaikuMaker();
		Scanner sc = new Scanner(System.in);
	    System.out.println("In ONE word what do you want your Haiku to be about?");
	    String input1 = sc.next();
	    hk.pushToLineTwo(input1);
	    System.out.println("Can you give me another word for " + input1 + "?");
	    String input2 = sc.next();
		hk.pushToLineOne(input2);
		System.out.println("And one similar to " + input2 + "?");
		String input3 = sc.next();
		hk.pushToLineThree(input3);
		System.out.println("Thanks, now can I have a word that describes " + input1 +"?");
	    String input4 = sc.next();
	    hk.pushToLineTwo(input4);
	    System.out.println("Can you give me a word that enhances " + input2 + "?");
	    String input5 = sc.next();
		hk.pushToLineOne(input5);
		System.out.println("And one that compliments " + input3 + "?");
		String input6 = sc.next();
		hk.pushToLineThree(input6);
		System.out.println("Perfect, here is your Haiku: ");
		hk.generate();
		sc.close();
	}
	

}
