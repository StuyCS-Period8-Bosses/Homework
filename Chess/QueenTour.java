/*======================================
  class MazeSolver
  ======================================*/

import java.io.*;
import java.util.*;

//Note that this file is not named MazeSolver.java. 
//Q: What do you make of this?
//1. That it is not named MazeSolver.java
//2. That MazeSolver.java is jealous.
//3. MazeSolver is a nested class inside of Maze, a protect class of sorts, and is here to save space and provide organazational convienience. 

class TourFinder {

    private int[][] board;
    private int h, w; //height, width of maze
    private boolean solved;
    private int squares;


    public TourFinder(int x, int y ) {

	board = new int [x+1][y+1];
	w = x+1;
	h = y+1;
	
	for (int i = 0; i < board[0].length; i++) {

	    board [0][i] = -1;
	    board [i][0] = -1;
	    board [i][y] = -1;
	    board [x][i] = -1;
	}

	squares = w*h;
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
		return;
	}
	//other base cases
	else if (board [x][y]!= 0 ) {
	    return;
	}

	else {

	    if (!solved) {
		findTour (x+1, y, moves + 1);
		//	board [x][y] = moves;
		System.out.println(this);
		    }

		if (!solved) {
		    findTour (x, y + 1, moves + 1);
		    //board [x][y] = moves;
		      System.out.println(this);
		}

		    if (!solved) {
			findTour (x, y-1, moves +1);
			//  	  board [x][y] = moves;
			   System.out.println(this);
		    }
		    
		    if (!solved) {
			findTour (x-1, y, moves +1);
			//	  board [x][y] = moves;
			   System.out.println(this);
		    }
    
		    board [x][y] = moves;
		    // System.out.println (this);
     
	}
    }

}//end class MazeSolver

public class QueenTour {

    public static void main( String[] args ) {
	/*
	if ( args.length != 1) {
	    System.out.println ("I'm tired. Enter it right okay?");
	}

	TourFinder tf = new TourFinder (Integer.parseInt(args[0]), Integer.parseInt(args));
	*/

	TourFinder tf = new TourFinder (9, 9);

	//clear screen
	//	System.out.println( "[2J" ); 


	//display maze 
	System.out.println( tf );

	tf.findTour (7, 7, 1);

	System.out.println(tf);
	//drop our hero into the maze at pos known to be on path
	//ms.solve(4, 2 ); 
	//ms.solve();


    }

}//end class Maze
