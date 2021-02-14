package connect4;

import java.util.Scanner;

public class Game {

    	public static void main (String[] args) {
    		
    		
    		
    		Scanner in = new Scanner(System.in);
    		System.out.println("WELCOME TO CONNECT 4!!!!!!");
    		System.out.println("Do you want to know rules of the game");
    		System.out.println("If so, Type 'yes' else 'no' ");
    		
    		String userinput = in.nextLine(); 
    	   	
        	if(userinput.equals("yes")) {
        		
        		
        		Fileread file = new Fileread();
        		file.start();
        	}
        	
        	
        	Connect4 connect = Connect4.createInstance();
            connect.play();
        	

    	  }
    	
    	

    }