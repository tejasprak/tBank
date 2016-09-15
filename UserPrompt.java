package tejasp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import tejasp.DBManager;
import tejasp.Bank;
import tejasp.findLineNum;

public class UserPrompt {
	public static void userPrompt() throws IOException {
		Scanner in = new Scanner(System.in);
		int input;
		String temp;
		int currentUID;
		int nextUID;
		String UIDdeposit;
		String nextUIDstr;
		String details;
		String firstName;
		String lastName;
		String deposit;
		int lineNumFound;
		File uid = new File("lastUID.tdb");
		File db = new File("people.tdb");
		/*if (!file.exists()) {
			file.createNewFile();
		}*/
		System.out.println("1. Add New User");
		System.out.println("2. Deposit Money for Current User");
		System.out.println("3. Withdraw Money for Current User");
		System.out.println("4. View User Details");
		System.out.println("5. Remove User");
		input = in.nextInt();
		if(input == 1) {
			temp = DBManager.getContentsInt(uid);
			currentUID = Integer.parseInt(temp);
			nextUID = currentUID + 1;
			DBManager.removeObject(uid, currentUID);
			DBManager.addObject(uid, nextUID);
			nextUIDstr = Integer.toString(nextUID);
			System.out.println("Enter first name of new user.");
			firstName = in.next();
			System.out.println("Enter last name of new user.");
			lastName = in.next();
			System.out.println("Initial deposit?");
			deposit = in.next();
			details = "UID: " + nextUIDstr + ". Name: " + firstName + " " + lastName + ". Balance: " + deposit + ".";
			DBManager.addObject(db, details);
			System.out.println("Added user " + firstName + " " + lastName + " UID: " + nextUIDstr + " Balance: " + deposit);
		} else if (input == 2) {
			System.out.println("Enter UID of user");
			UIDdeposit = in.next();
			System.out.println("Enter amount of money deposited");
			deposit = in.next();
			lineNumFound = tejasp.findLineNum.findLineNum(db, UIDdeposit);
			//tejasp.ReplaceSelected.replaceSelected("Balance: ", type, file2);
		}
		
	}
}
