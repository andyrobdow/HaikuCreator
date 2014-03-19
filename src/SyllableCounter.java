/**
 * A class that counts the number of syllables in words passed to it as Strings
 */

/**
 * @author Andrew Dow
 *
 */
public class SyllableCounter {
	private static int syllableCount;

	/**
	 * a constructor for the class.
	 */
	public SyllableCounter() {
		syllableCount = 0;
	}
	
	/**
	 * a static method that takes a string and counts the syllables.
	 * @param String
	 */
	
	public static int countSyllables(String wordToCount){
		wordToCount.toLowerCase();
		syllableCount = 0;
		int numberOfLetters = wordToCount.length();
		int numberOfVowels = 0;
		for(int i=0; i < numberOfLetters; i++){
			char c = wordToCount.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
				numberOfVowels++;
				if(numberOfVowels == 2){
					syllableCount++;
					numberOfVowels = 0;
				}else{syllableCount++;}
			}
		}
		return syllableCount;
	}
	
	public static void main (String[] args){
		String wordToCount = "misty";
		System.out.println("Number of syllables: " + SyllableCounter.countSyllables(wordToCount));
	}
}
