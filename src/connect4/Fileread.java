package connect4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Fileread {
	
		
	public static void start() {

		 try{
			 
			  FileInputStream file = new FileInputStream("rulesofgame.txt");
			  
			  
			  DataInputStream input = new DataInputStream(file);
			  
			  BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			  String Line;
			  
			  
			  while ((Line = reader.readLine()) != null)   {
				  
			  System.out.println (Line);
			  
			  }
			    
			  input.close();
			  
			    }catch (Exception e){
			  System.err.println("This is the error" + e.getMessage());
			  }
			  }
		
	}


	

