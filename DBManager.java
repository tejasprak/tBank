package tejasp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DBManager {

    public static String extension = "tdb";
    
    private static boolean isValidFile(File file) {
        return file.getName().endsWith(extension);
    }
    
    public static boolean addObject(File file, Object object) throws IOException
    {

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            pw.println(object.toString());
            pw.close();
            return true;
    }

    public static boolean containsObject(File file, Object object) throws IOException
    {
       
            BufferedReader br = new BufferedReader(new FileReader(file));
            boolean foundMatch = false;
            while(br.ready())
            {
                String line = br.readLine();
                if(line.trim().equals(object.toString()))
                {
                    foundMatch = true;
                    break;
                }
            }
            br.close();
            return foundMatch;      
        
      
    }

    public static boolean removeObject(File file, Object object) throws IOException
    {
       
            BufferedReader br = new BufferedReader(new FileReader(file));
            boolean foundMatch = false;
            ArrayList<String> linestoadd = new ArrayList<String>();
            while(br.ready())
            {
                String line = br.readLine();
                if(!line.trim().equals(object.toString()))
                {
                    linestoadd.add(line.trim());
                }
                else
                {
                    foundMatch = true;
                }
            }
            br.close();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for(String linetoadd : linestoadd)  
            {
                pw.println(linetoadd);
            }
            pw.close();
            return foundMatch;      

        }
        
    

    public static ArrayList<String> getContents(File file) throws IOException
    {
        ArrayList<String> contents = new ArrayList<String>();
       
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready())
            {
                contents.add(br.readLine());
            }
            br.close();
        
        return contents;
    }
    public static String getContentsInt(File file) throws IOException
    {
        String contents = new String();
       
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.ready())
            {
                contents = (br.readLine());
            }
            br.close();
        
        return contents;
    }
}