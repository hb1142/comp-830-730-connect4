package connect4;

import java.util.Random;
import java.util.Scanner;

public class Computer {
 
	  public String[][] creategrid() {
	 
	    String[][] grid = new String[7][15];
	 
	    for (int j =0;j<grid.length;j++) {
	 
	       for (int k =0;k<grid[j].length;k++) {
	        if (k% 2 == 0){
	        	grid[j][k] ="|";
	        } else {
	        	grid[j][k] = " ";
	        }
	 
	        if (j==6) grid[j][k]= "-";
	      }
	 
	    }
	    return grid;
	  }
	 
	  public void displaygrid(String[][] grid) {
	    for (int j =0;j<grid.length;j++) {
	      for (int k=0;k<grid[j].length;k++) {
	        System.out.print(grid[j][k]);
	      }
	      System.out.println();
	    }
	  }
	 
	  public void CompChance(String[][] grid) {
	    System.out.print("Computer enters a column number between 0 to 6");
	    
	    System.out.println();
	    
	    Random rand = new Random();
	    int int_random = rand.nextInt(7);
	    int compRand = 2*int_random+1;
	    for (int j =5;j>=0;j--) {
	      if (grid[j][compRand] == " ") {
	    	  grid[j][compRand] = "R";
	        break;
	      }
	    }
	  }
	 
	  public void gamerChance(String[][] grid) {
	    System.out.print("Player2 enter a column number between 0 to 6");
	    Scanner input = new Scanner (System.in);
	    int playerinp = 2*input.nextInt()+1;
	    for (int j =5;j>=0;j--) {
	      if (grid[j][playerinp] == " ") {
	    	  grid[j][playerinp] = "B";
	        break;
	      }
	    }
	  }
	 
	 
	  public String logic(String[][] grid) {
	    for (int k =0;k<6;k++) {
	      for (int i=0;i<7;i+=2) {
	        if ((grid[k][i+1] != " ")
	        && (grid[k][i+3] != " ")
	        && (grid[k][i+5] != " ")
	        && (grid[k][i+7] != " ")
	        && ((grid[k][i+1] == grid[k][i+3])
	        && (grid[k][i+3] == grid[k][i+5])
	        && (grid[k][i+5] == grid[k][i+7])))
	 
	          return grid[k][i+1]; 
	      }
	    }
	 
	    for (int k=1;k<15;k+=2) {
	      for (int i =0;i<3;i++) {
	            if((grid[i][k] != " ")
	            && (grid[i+1][k] != " ")
	            && (grid[i+2][k] != " ")
	            && (grid[i+3][k] != " ")
	            && ((grid[i][k] == grid[i+1][k])
	            && (grid[i+1][k] == grid[i+2][k])
	            && (grid[i+2][k] == grid[i+3][k])))
	              return grid[i][k]; 
	      } 
	    }
	 
	    for (int k=0;k<3;k++) {
	 
	      for (int i=1;i<9;i+=2) {
	            if((grid[k][i] != " ")
	            && (grid[k+1][i+2] != " ")
	            && (grid[k+2][i+4] != " ")
	            && (grid[k+3][i+6] != " ")
	            && ((grid[k][i] == grid[k+1][i+2])
	            && (grid[k+1][i+2] == grid[k+2][i+4])
	            && (grid[k+2][i+4] == grid[k+3][i+6])))
	              return grid[k][i]; 
	      } 
	    }
	 
	    for (int k=0;k<3;k++) {
	      for (int i=7;i<15;i+=2) {
	            if((grid[k][i] != " ")
	            && (grid[k+1][i-2] != " ")
	            && (grid[k+2][i-4] != " ")
	            && (grid[k+3][i-6] != " ")
	            && ((grid[k][i] == grid[i+1][i-2])
	            && (grid[k+1][i-2] == grid[i+2][i-4])
	            && (grid[k+2][i-4] == grid[i+3][i-6])))
	              return grid[k][i]; 
	      } 
	    }
	 
	    return null;
	  }
	 
	}