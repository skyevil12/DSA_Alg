/*package whatever //do not write package name here */

/*
1. print all combination for phone number
2. implement with non recursive method
time complexity O(3^n),space compexity O(n)
*/
import java.io.*;
import java.util.*;

class GFG {
	public static String[] PHONE_STRING_ARRAY = new String[] {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};

	public static void main(String[] args) {
		String input = "4556170";
		printAllPhoneNumberWord(input);
	}

	private static void printAllPhoneNumberWord(String input) {
		StringBuilder builder = new StringBuilder();

		int[] placeArray = new int[input.length()];
		int index = 0;
		while (true) {

			if (index == input.length()) {
				System.out.println(builder.toString());
				builder.setLength(builder.length() - 1);
				index -= 1;
			}

			char number = input.charAt(index);
			/*
			  if(builder.length()>index){
			    if(getCharKey(number - '0', 2)==builder.charAt(index))
			    else if(getCharKey(number - '0', 0)==builder.charAt(index)){}
			    else if(getCharKey(number - '0', 1)==builder.charAt(index)){}

			  }else{
				builder.append(getCharKey(number - '0', 0))  ;
			  }
			*/

			int place = placeArray[index];
			if (place > 2) {
				placeArray[index] = 0;
				if (index == 0) {
					break;

				} else {
					builder.setLength(builder.length() - 1);
					index -= 1;
					continue;
				}
			}

			char word = getCharKey(number - '0', place);
			builder.append(word);

			if (word == number) {  //1 or 0
				placeArray[index] = 3;

			} else {
				placeArray[index] = place + 1;
			}

			index += 1;
		}
	}

	public static char getCharKey(int telephoneKey, int place) {
		String phoneString = PHONE_STRING_ARRAY[telephoneKey];
		return phoneString.length() <= place ? (char) (telephoneKey + '0') : phoneString.charAt(place);
	}

}

