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

	board = new int [x][y];
	w = x;
	h = y;
	squares = w*h;
	solved = false;
    }



    /*  public String toString() {
	for (int  []n 
	}*/


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


	if (moves < squares ) {
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
		    }

		if (!solved) {
		    findTour (x, y + 1, moves + 1);
		}

		    if (!solved) {
			findTour (x, y-1, moves +1);
		    }
		    
		    if (!solved) {
			findTour (x-1, y, moves +1);
		    }
    

	 
     
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

	TourFinder tf = new TourFinder (8, 8);

	//clear screen
	System.out.println( "[2J" ); 


	//display maze 
	System.out.println( tf );

	tf.findTour (8, 8, 0);


	//drop our hero into the maze at pos known to be on path
	//ms.solve(4, 2 ); 
	//ms.solve();


    }

}//end class Maze
