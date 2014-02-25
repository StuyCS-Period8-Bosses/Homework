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

class MazeSolver {

    private char[][] maze;
    private int h, w; //height, width of maze
    private boolean solved;


    //Q: Significance of keyword final here?
    final private char HERO =         '@';//final means can't be changed. We don't want these variables being changed..........or do we???????
    final private char PATH =         '#';
    final private char WALL =         ' ';
    final private char EXIT =         '$';
    final private char VISITED_PATH = '.';


    public MazeSolver( String inputFile ) {

	//init 2D array to represent maze
	//Q: Significance of dimensions? It's the same size as the terminal (Actually may be one bigger, terminal may be 80 by 24) but this is so the whole maze can take up the terminal screen since we aren't creating a GUI.

	maze = new char[80][25];
	h = 0;
	w = 0;

	try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

		String line = sc.nextLine();

		if ( w < line.length() ) 
		    w = line.length();

		for( int i=0; i<line.length(); i++ )
		    maze[i][row] = line.charAt( i );

		h++;
		row++;
	    } 

	    for( int i=0; i<w; i++ )
		maze[i][row] = WALL;
	    h++;
	    row++;

	} catch( Exception e ) { System.out.println( "Error reading file" ); }


	solved = false;
    }//end constructor


    public String toString() {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	String retStr = "[0;0H";  
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC
	// (alternatively, just copy and paste from this file...)

	int i, j;
	for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
		retStr = retStr + maze[j][i];
	    retStr = retStr + "\n";
	}
	return retStr;
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
    public void solve( int x, int y ) {

	delay(50); //slow it down enough to be followable

	//Note how the three options below differ before attempting to fill in.
	//Q: Why is no screen refresh necessary in the else-if block?
	//A: Because you're not doing anything new there. That's the end of the recursion and now you'll be backtracking, but no need to refresh before backtrack. 

	//primary base case: maze is solved (hero standing on exit)
	if (maze [x][y]== '$' ) {
	    solved = true;
		System.out.println( this ); //refresh screen
		return;
	}
	//other base cases
	else if (maze [x][y] == WALL || maze [x][y] == VISITED_PATH || maze [x][y] == HERO ) {
	    return;
	}
	//otherwise, recursively solve maze from next pos over,
	//after marking current location
	else {
	    maze[x][y] = HERO; //mark current location
	    System.out.println( this ); //refresh screen

	    if (!solved) {
		solve (x+1, y);
		    }

		if (!solved) {
		    solve (x, y + 1);
		}

		    if (!solved) {
			solve (x-1, y);
		    }
		    
		    if (!solved) {
			solve (x, y-1);
		    }
    

	 
		    if (!solved) {  delay(50);}
	    maze[x][y] = VISITED_PATH;
	    System.out.println( this ); //refresh screen
    
	}
    }


 /*********************************************
     * void solve(int x,int y) -- recursively finds maze exit (depth-first)
     * @param x starting x-coord, measured from left
     * @param y starting y-coord, measured from top
     *********************************************/
public void solve() { //randomizes starting point

    Random rand = new Random ();
    int x= rand.nextInt (w);
    int y = rand.nextInt (h);

    while (maze[x][y]!= PATH) {
	x = rand.nextInt (w);
	y = rand.nextInt (h);
    }


	delay(50); //slow it down enough to be followable

	//Note how the three options below differ before attempting to fill in.
	//Q: Why is no screen refresh necessary in the else-if block?
	//A: Because you're not doing anything new there. That's the end of the recursion and now you'll be backtracking, but no need to refresh before backtrack. 

	//primary base case: maze is solved (hero standing on exit)
	if (maze [x][y]== '$' ) {
	    solved = true;
		System.out.println( this ); //refresh screen
		return;
	}
	//other base cases
	else if (maze [x][y] == WALL || maze [x][y] == VISITED_PATH || maze [x][y] == HERO ) {
	    return;
	}
	//otherwise, recursively solve maze from next pos over,
	//after marking current location
	else {
	    maze[x][y] = HERO; //mark current location
	    System.out.println( this ); //refresh screen

	    if (!solved) {
		solve (x+1, y);
		    }

		if (!solved) {
		    solve (x, y + 1);
		}

		    if (!solved) {
			solve (x-1, y);
		    }
		    
		    if (!solved) {
			solve (x, y-1);
		    }
    

	 
		    if (!solved) {  delay(50);}
	    maze[x][y] = VISITED_PATH;
	    System.out.println( this ); //refresh screen
    
	}
    }
}//end class MazeSolver

public class Maze {

    public static void main( String[] args ) {

	//TASK: Generate 3 mazes ( maze01.dat is simple, maze03.dat is crazy )
	//      Make sure there is trailing whitespace on each line
	//      and that there is an empty line at bottom.

	//TASK: Modify this class to allow input file specification via CLI
	//eg    $ java Maze maze09.dat
	if ( args.length != 1) {
	    System.out.println ("I'm tired. Enter it right okay?");
	}

	    MazeSolver ms = new MazeSolver (args[0]);


	//clear screen
	System.out.println( "[2J" ); 

	//display maze 
	System.out.println( ms );

	//drop our hero into the maze at pos known to be on path
	//ms.solve(4, 2 ); 
	ms.solve();


    }

}//end class Maze
