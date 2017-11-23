import java.io.*;

class Nuke2 {
	public static void main(String[] args) throws Exception {
		BufferedReader keyboard;
		String inputLine;
		
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		inputLine = keyboard.readLine();
		
		char[] inputLineChars = inputLine.toCharArray();
		
		for(int i = 0; i < inputLineChars.length; i++) {
			if(1 == i) {
				continue;
			}
			
			System.out.print(inputLineChars[i]);
		}
	}
}