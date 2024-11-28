/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String afterStr1 = preProcess(str1);
		String afterStr2 = preProcess(str2);

		while(afterStr1.length() > 0){
			int count = 0;
			if(afterStr2.indexOf(afterStr1.charAt(count)) == -1){
				return false;
			}
				count ++;
				afterStr1 = afterStr1.substring(count);
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String allowString = "abcdefghijklmnopqrstuvwxyz ";
		String newStr = str.toLowerCase();
		String newestString  = "";
		for(int i = 0; i < newStr.length(); i++){
			char currentChar = newStr.charAt(i);
			if (allowString.indexOf(currentChar) > -1) {
				newestString += currentChar;
			}
		}
		return newestString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		char[] charArray = str.toCharArray();
	
		for (int i = charArray.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
		}
		return new String(charArray);
	}
}

