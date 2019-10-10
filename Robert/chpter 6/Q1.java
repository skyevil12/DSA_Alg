/*package whatever //do not write package name here */
// 1. user Object replace count ,OBject singleObject = new Object Object mulitObject .....
// 2. string.codePointAt()

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		String inputString = "";
		char firstChar = findFirstNotRepeatedChar(inputString);

	}

	private static Character findFirstNotRepeatedChar(String input) {
		char[] charArray = input.toCharArray();
		Map<Character,Integer> charCountMap = new LinkedHashMap<>();

		for(char mChar:charArray) {
			Object object == charCountMap.get(mChar);
			if(object == null){
				charCountMap.put(mChar,singleObject);
			}else if(object == singleObject){
				charCountMap.put(mChar,mulitObject);
			}
)			Integer count = charCountMap.get(mChar);
			if(count == null) {
				charCountMap.put(mChar,1);

			} else {
				charCountMap.put(mChar,++count);
			}
		}

		for(Character key:charCountMap.keyset()) {
			Integer count = charCountMap.get(key);
			if(count <=1) {
				return key;
			}
		}

		return null;
	}

}