package connect4;
import java.util.Scanner;

public class Connect4 {

    public Grid grid;
    public Gamer[] gamer;
    public Scanner input;
    public Instructions instruction;
    public boolean cgame = true;
    public int rows = 6;
    public int columns = 6;
    public int drop =0;
   
   	private static Connect4 singletonInstance = null;
   	public static Connect4 createInstance() 
   	{	
   		try
   		{	
   			if(singletonInstance==null)
   			{	
   				singletonInstance=new Connect4();
   				return singletonInstance;
   				
   			}
   			
   			return singletonInstance;
   		}
   		catch(Exception e)
   		{
   			
   		}
   		return singletonInstance;
   	}

    public Connect4() {
        gamer = new Gamer[2];
        grid = new Grid(this.rows, this.columns);
        instruction = new Instructions(grid);
        for (int j = 0; j < gamer.length; j++) {
        	gamer[j] = new Gamer();
        }
        
        input = new Scanner(System.in);
    }

    public void play() {

    	initialize_players();
        grid.initialize_Board();
        grid.printGrid();
        while (cgame) {

            System.out.println("Now " + gamer[0].getUserName() + " should play");
            typeinput();
            inputchance("R");
            this.drop = this.drop + 1;


            System.out.println("Now " + gamer[1].getUserName() + " should play");
            typeinput();
            inputchance("B");
            this.drop = this.drop + 1;

        }

    }

    public void typeinput(){
    	
        System.out.println("Please enter a column number between 1 to 6");
        grid.printGrid();
        instruction.Draw(this.drop);
    }


    private void inputchance(String player) {

        boolean process = true;

        while (process) {
        	
        	

            if (!input.hasNextInt()) {
                System.out.println(player + " please enter a column number between 1 to 6");
                input.next();
            }
            else {

                int input_number = input.nextInt(); 

                if (input_number > 0 && input_number <= columns) {
                    if (instruction.wronginput(input_number)) {
                        System.out.println(player + " the column " + input_number
                                + " is full, please type another column number");
                    } else {
                        grid.update(input_number, player);
                        instruction.logic(input_number,player);
                        process = false; 

                    }
                } else {
                    System.out.println(player + " please enter a column number between 1 to 6");
                }


            }

        }

    }

    private void initialize_players() {

        boolean play = true;

        while (play) {
        	Scanner in = new Scanner(System.in);

        	System.out.println("Choose number of players: ");
			System.out.println("Type in 1 or 2 ");		
			int a = in.nextInt(); 
			if(a==1) {
				
				System.out.println("Player1 is Computer");
				gamer[0].setDataType("R");
				gamer[0].setUserName("Computer");
				System.out.println("Enter Player2 name:");
				gamer[0].setDataType("B");
				gamer[1].setUserName(input.next());
				
				if (gamer[0].getUserName().length() > 0 && gamer[1].getUserName().length() > 0) {
	                play = false;
	            }
				
				Computer c = new Computer();
	    	    String[][] grid = c.creategrid();
	    	    boolean game = true;
	    	    
	    	    int x = 0;
	    	    c.displaygrid(grid);
	    	    while(game) {
	    	      if (x % 2 == 0) {
	    	    	  c.CompChance(grid);
	    	      }
	    	      else { 
	    	    	  c.gamerChance(grid);
	    	      }
	    	      x = x + 1;
	    	      c.displaygrid(grid);
	    	      
	    	      if (c.logic(grid) != null) {
	    	        if (c.logic(grid) == "R"){
	    	           System.out.println("Computer won the game");
	    	           System.out.println("*******************GAME OVER!!!!!!!!!!!!*************");
	    	           
	    	           NewGame n = new NewGame();
	    	           n.newgame();
	    	           
	    	        } else if (c.logic(grid)== "B") {
	    	          System.out.println("Player won the game");
	    	          System.out.println("*******************GAME OVER!!!!!!!!!!!!*************");
	    	          
	    	          NewGame n = new NewGame();
	    	          n.newgame();
	    	        }
	    	        
	    	        game = false;
	    	      }
	    	    }
	    	    
	    	    System.exit(0);
			
			}
			
			
			if(a==2) {
            System.out.println("Player 1 please enter your name: ");
            gamer[0].setDataType("R");
            gamer[0].setUserName(input.next());

            System.out.println("Player 2 please enter your name: ");
            gamer[1].setDataType("B");
            gamer[1].setUserName(input.next());

            if (gamer[0].getUserName().length() > 0 && gamer[1].getUserName().length() > 0) {
                play = false;
            }
        }
        }
    }

	


}