package tejasp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class ReplaceSelected {
	public static void replaceSelected(String replaceWith, String type, File file2) {
	    try {
	        // input the file content to the String "input"
	        BufferedReader file = new BufferedReader(new FileReader(file2));
	        String line;String input = "";

	        while ((line = file.readLine()) != null) input += line + '\n';

	        file.close();

	        System.out.println(input); // check that it's inputted right

	        // this if structure determines whether or not to replace "0" or "1"
	        if (Integer.parseInt(type) == 0) {
	            input = input.replace(replaceWith + "1", replaceWith + "0"); 
	        }
	        else if (Integer.parseInt(type) == 1) {
	            input = input.replace(replaceWith + "0", replaceWith + "1");
	        } 

	        // check if the new input is right
	        System.out.println("----------------------------------"  + '\n' + input);

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("notes.txt");
	        fileOut.write(input.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}

}
