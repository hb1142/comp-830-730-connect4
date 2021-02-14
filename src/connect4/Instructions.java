package connect4;

public class Instructions {

    private Grid grid;

    private String matrix[][];

    public Instructions(Grid grid) {

        this.grid = grid;

        this.matrix = this.grid.getgrid();
    }


    public boolean wronginput(int column) {

        int totalcount = 0;

        for (int i = this.matrix.length - 1; i >= 0; i--) {

            if (!this.matrix[i][column - 1].equals(" ")) {
                totalcount = totalcount + 1;
            }
        }

        if (totalcount == this.matrix.length) {
            return true;
        }

        return false;


    }

    public void Draw(int totaldrop) {

        int total = this.grid.getColumn() * this.grid.getrow();

        if (totaldrop == total) {
            System.out.println("GAME OVER because it is draw");
            
            NewGame n = new NewGame();
            n.newgame();
           
        }

    }

    public void logic(int column_number, String gamer) {

        for (int i = 0; i < this.matrix.length; i++) {

            int totalcount = 0;
            int number = column_number;

            // check for horizontal
            while (number < grid.getrow() && matrix[i][number].equals(gamer)) {
                totalcount = totalcount + 1;
                number = number + 1;
            }
            number = column_number - 1;

            while (number >= 0 && matrix[i][number].equals(gamer)) {
            	totalcount = totalcount + 1;
            	number = number - 1;
            }

            result(totalcount,gamer);

            //check for vertical
            
            totalcount = 0;
            int y = i;
            while (y < grid.getColumn() && this.matrix[y][column_number - 1].equals(gamer)) {
            	totalcount = totalcount + 1;
                y = y + 1;
            }

            result(totalcount, gamer);

            //check for secondary diagonal
            
            totalcount = 0;
            number = i;
            int z = column_number;
            while (number < grid.getrow() && z < grid.getColumn() && this.matrix[number][z].equals(gamer)) {
            	totalcount = totalcount + 1;
            	number = number + 1;
            	z = z + 1;
            }
            number = i - 1;
            int a = column_number - 1;
            while (number >= 0 && a >= 0 && this.matrix[number][a].equals(gamer)) {
            	totalcount = totalcount + 1;
            	number = number - 1;
            	a = a - 1;
            }

            result(totalcount, gamer);

            //check for leading diagonal
            
            totalcount = 0;
            number = i;
            int k = column_number - 1;
            while (number < grid.getrow() && k >= 0 && this.matrix[number][k].equals(gamer)) {
            	totalcount = totalcount + 1;
            	number = number + 1;
            	k = k - 1;
            }
            number = i - 1;
            k = (column_number - 1) + 1;
            while (number >= 0 && k < grid.getColumn() && this.matrix[number][k].equals(gamer)) {
            	totalcount = totalcount + 1;
            	number = number - 1;
            	k = k + 1;
            }
            result(totalcount, gamer);

        } 
    }

    public void result(int totalcount, String gamer) {

        int total = 4;

        if (totalcount == total) {
            System.out.println("Congratulations "+gamer+"....You won the game");
            System.out.println("GAME OVER!!!!!!!!!!!!");
            grid.printGrid();
            
            NewGame n = new NewGame();
            n.newgame();
            
        }


    }
}