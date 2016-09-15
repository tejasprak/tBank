package tejasp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class findLineNum {
	public static int findLineNum(File file, String UIDdeposit) {
		int lineNumFound = 0;
		try {
		    Scanner scanner = new Scanner(file);
		    int lineNum = 0;
		    
		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        lineNum++;
		        if(line.startsWith("UID: " + UIDdeposit)) { 
		           lineNum = lineNumFound;
		        }
		    }
		} catch(FileNotFoundException e) { 
		    //handle this
		}
		return lineNumFound;
	}
}
