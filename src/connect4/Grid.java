package connect4;

public class Grid {

    public String grid[][];

    public int row = 0;
    public int column = 0;

    Grid(int row, int column) {
        this.row = row;
        this.column = column;
        this.grid = new String[row][column];
    }

    public int getrow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getgrid() {
        return grid;
    }

    public void initialize_Board() {

        for (int j = 0; j < this.grid.length; j++) {
            for (int k = 0; k < this.grid[j].length; k++) {

                this.grid[j][k] = " ";

            }
        }
    }

    public void update(int column, String gamer) {


        for (int j = this.grid.length - 1; j >= 0; j--) {

            if (this.grid[j][column - 1].equals(" ")) {
                this.grid[j][column - 1] = gamer;
                break;
            }
        }
    }


    public void printGrid() {

        for (int j = 1; j <= this.grid.length; j++) {

            System.out.print(" ");
            
        }
        System.out.println("");

        for (int j = 0; j < this.grid.length; j++) {
        	System.out.print("|");
            for (int k = 0; k < this.grid[j].length; k++) {
                System.out.print(this.grid[j][k]);
                System.out.print("|");
            }

            System.out.println();

            
        }
        System.out.println("-------------");
    }


}