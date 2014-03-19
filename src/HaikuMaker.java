import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author Andrew Dow
 *
 */
public class HaikuMaker {
	private ArrayList<String> lineOne;
	private ArrayList<String> lineTwo;
	private ArrayList<String> lineThree;
	private ArrayList<String> oneSyllableWords;
	private ArrayList<String> twoSyllableWords;
	
	/**
	 * @param lineOne
	 * @param lineTwo
	 * @param lineThree
	 */
	public HaikuMaker() {
		lineOne = new ArrayList<String>();
		lineTwo = new ArrayList<String>();
		lineThree = new ArrayList<String>();
		oneSyllableWords = new ArrayList<String>();
		twoSyllableWords = new ArrayList<String>();
		intializeOneSyllableArray();
		intializeTwoSyllableArray();
		
	}
	
	public void pushToLineOne(String word){
		lineOne.add(word);
	}
	
	public void pushToLineTwo(String word){
		lineTwo.add(word);
	}
	
	public void pushToLineThree(String word){
		lineThree.add(word);
	}
	
	public int countSyllables(ArrayList<String> line){
		int totalForLine = 0;
		for (String word: line){
			int numberOfSyllables = SyllableCounter.countSyllables(word);
			totalForLine += numberOfSyllables;
		}
		return totalForLine;	
	}
	
	public void fixOuterLines(ArrayList<String> line){
		int lineSyllables = countSyllables(line);
		if(lineSyllables < 5){
			int shortFall = 5 - lineSyllables;
			if(shortFall == 2){
				Random r = new Random();
				int i = r.nextInt(10);
				String filler = twoSyllableWords.get(i);
				line.add(2, filler);;
			}
			if(shortFall == 1){
				Random r = new Random();
				int i = r.nextInt(10);
				String filler = oneSyllableWords.get(i);
				line.add(0, filler);
			}
			if(shortFall >= 3){
				Random r = new Random();
				int i = r.nextInt(10);
				int j = r.nextInt(10);
				String filler = oneSyllableWords.get(i);
				String filler2 = twoSyllableWords.get(j);
				line.add(0, filler);
				line.add(1, filler2);
			}
		}
	}
	
	public void fixInnerLine(ArrayList<String> line){
		int lineSyllables = countSyllables(line);
		if(lineSyllables < 7){
			int shortFall = 7 - lineSyllables;
			if(shortFall == 2){
				Random r = new Random();
				int i = r.nextInt(10);
				String filler = twoSyllableWords.get(i);
				line.add(0, filler);
			}
			if(shortFall == 1){
				Random r = new Random();
				int i = r.nextInt(10);
				String filler = oneSyllableWords.get(i);
				line.add(1, filler);
			}
			if(shortFall >= 3){
				Random r = new Random();
				int i = r.nextInt(10);
				int j = r.nextInt(10);
				String filler = oneSyllableWords.get(i);
				String filler2 = twoSyllableWords.get(j);
				line.add(1, filler);
				line.add(2, filler2);
			}
		}
	}
	public void generate(){
		fixOuterLines(lineOne);
		fixInnerLine(lineTwo);
		fixOuterLines(lineThree);
		System.out.println(print(lineOne)+ ",");
		System.out.println(print(lineTwo)+ ",");
		System.out.println(print(lineThree)+ ".");
		}
	
	public String print(ArrayList<String>line){
		String completeLine ="";
		for (String word: line){
			completeLine += " " + word;
		}
		return completeLine;
	}
	public void intializeOneSyllableArray(){
		oneSyllableWords.add("a"); oneSyllableWords.add("and"); oneSyllableWords.add("the");
		oneSyllableWords.add("be"); oneSyllableWords.add("yes"); oneSyllableWords.add("no");
		oneSyllableWords.add("in"); oneSyllableWords.add("out"); oneSyllableWords.add("of");
		oneSyllableWords.add("on"); oneSyllableWords.add("up");
		}
	
	public void intializeTwoSyllableArray(){
		twoSyllableWords.add("apple"); twoSyllableWords.add("ramble"); twoSyllableWords.add("water");
		twoSyllableWords.add("whisky"); twoSyllableWords.add("borrow"); twoSyllableWords.add("whistle");
		twoSyllableWords.add("maker"); twoSyllableWords.add("farther"); twoSyllableWords.add("closer");
		twoSyllableWords.add("couple"); twoSyllableWords.add("wiggle");
	}

	public static void main (String[] args){
		HaikuMaker hk = new HaikuMaker();
		hk.lineOne.add("trees");
		hk.lineOne.add("misty");
		hk.lineTwo.add("monkey");
		hk.lineTwo.add("talking");
		hk.lineTwo.add("pie");
		hk.lineThree.add("laughs");
		hk.lineThree.add("loudly");
		hk.generate();
	}
}
