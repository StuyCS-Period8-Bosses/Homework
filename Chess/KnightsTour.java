/*======================================
class KnightsTour
  Animates a Knight's Tour of a square board.
  Mean execution times for boards of size n*n:
  n=5   0m0.143s    over 2843485 executions
  n=6   0m0.144s    over 1605054 executions      I don't get why this is bigger?
  n=7   0m0.135s    over 1305725 executions
  n=8   0m0.576s    over 66791683 executions



All times where the real value measured by using "time java KnightsTour"
  ======================================*/

import java.io.*;
import java.util.*;


class TourFinder {

    private int[][] board;
    private int h, w; //height, width of maze
    private boolean solved;
    private int squares;
    private int executions; 


    public TourFinder(int x, int y ) {

	board = new int [x+2][y+2];
	w = x+1;
	h = y+1;
	
	for (int i = 0; i < board[0].length; i++) {

	    board [0][i] = -1;
	    board [1][i] = -1;
	    board [i][0] = -1;
	    board [i][1] = -1;
	    board [i][h] = -1;
	    board [i][h-1] = -1;
	    board [w][i] = -1;
	    board [w-1][i] = -1;
	}

	squares = (x-2)*(y-2);
	solved = false;
    }



     public String toString() {
	 /*	 	 for (int i = 0; i < board.length; i++) {
	// System.out.println(String.format("%3d",board[i][m]));
	System.out.println (Arrays.toString (board [i]));*/

	 String retStr = ""; 
	 
	 for (int i = 0; i < board.length; i++) {

	     for (int n = 0; n <board[0].length; n++) {

		 retStr = retStr + String.format ("%3d", board [i][n]);
	     }
	     retStr = retStr + "\n";
	 		     }
	  

		 return retStr;
	 /*	 for(int[] n:board){
	     for(int m:n){
		 System.out.println(String.format("%3d",n[m]));
	     }
	     System.out.println("\n");
	     }*/
	
	}



    //helper method to keep try/catch clutter out of main flow
    private void delay( int n ) {
	try {
	    Thread.sleep(n);
	}
	catch( InterruptedException e ) {
	    System.exit(0);
	}
    }


    /*********************************************
     * void solve(int x,int y) -- recursively finds maze exit (depth-first)
     * @param x starting x-coord, measured from left
     * @param y starting y-coord, measured from top
     *********************************************/
    public void findTour( int x, int y, int moves ) {
	

	if (moves > squares ) {
	    solved = true;
	    System.out.println(this);
	    System.out.println ("Executions :" + executions);
	    System.exit(0);
	}
	//other base cases
	else if (board [x][y]!= 0 ) {
	    return;
	}

	else {

	    board [x][y] = moves;

	    if (!solved) {
		executions = executions + 1;
		findTour (x+2, y+1, moves + 1);
		//System.out.println(this);
		    }

		if (!solved) {
		    	executions = executions + 1;
		    findTour (x+2, y - 1, moves + 1);
		    //   System.out.println(this);
		}

		    if (!solved) {
				executions = executions + 1;
			findTour (x+1, y+2, moves +1);
			//		   System.out.println(this);
		    }
		    
		    if (!solved) {
				executions = executions + 1;
			findTour (x+1, y-2, moves +1);
			  //	   System.out.println(this);
		    }

 if (!solved) {
     	executions = executions + 1;
			findTour (x-1, y+2, moves +1);
			  //	   System.out.println(this);
		    }

 if (!solved) {
     	executions = executions + 1;
			findTour (x-1, y-2, moves +1);
			  //	   System.out.println(this);
		    }

 if (!solved) {
     	executions = executions + 1;
			findTour (x-2, y+1, moves +1);
			  //	   System.out.println(this);
		    }

 if (!solved) {
     	executions = executions + 1;
			findTour (x-2, y-1, moves +1);
			  //	   System.out.println(this);
		    }

 if (!solved) {
     	executions = executions + 1;
     board [x][y] =0;
     }


		    //when I had board[x][y] = moves down here, everything was all 0's at the end, even when I had return in the top one. Was it because it was breaking out too soon?
     
	}
    }

}//end class MazeSolver

public class KnightsTour {

    public static void main( String[] args ) {
	/*
	if ( args.length != 1) {
	    System.out.println ("I'm tired. Enter it right okay?");
	}

	TourFinder tf = new TourFinder (Integer.parseInt(args[0]), Integer.parseInt(args));
	*/

	TourFinder tf = new TourFinder (7,7); //5X5 Square

	//clear screen
	//	System.out.println( "[2J" ); 


	//display maze 
	System.out.println( tf );

	tf.findTour (3, 3, 1);

	//	System.out.println(tf);
	//drop our hero into the maze at pos known to be on path
	//ms.solve(4, 2 ); 
	//ms.solve();


    }

}//end class Maze
