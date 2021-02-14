package connect4;

import java.util.Scanner;

public class NewGame {
	
	
	static int count = 1;
		
	public static void newgame() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Do you want to play another game");
		System.out.println("Type 'yes' or 'no ");
		
		String userinput = in.nextLine(); 
		
		
		if(userinput.equals("yes")) {
			
			count = count + 1;
			
			Connect4 c = Connect4.createInstance();
		    c.play();
			
			
		}
		
		else {
			
			
			System.out.println("Total number of games played " + count);
			System.out.println("Thank you for playing the game!!!!!!!!!!!!!!!!!!");
			System.exit(0);
		}
	}

}
