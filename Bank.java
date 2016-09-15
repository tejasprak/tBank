package tejasp;

import java.io.*;
import tejasp.DBManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import tejasp.UserPrompt;

public class Bank {
	public static void main( String[] args) throws IOException {
		File file = new File("people.tdb");
		if (!file.exists()) {
			file.createNewFile();
		}
		int lol = 5;
		System.out.println("Welcome to the Bank Managing System interface.");
		tejasp.UserPrompt.userPrompt();
	}
		
	}

