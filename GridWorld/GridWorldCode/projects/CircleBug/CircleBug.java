import info.gridworld.actor.Bug;

//It's behavior is different from BoxBug in that it turns only once instead of twice, creating a octoganal figure that looks similar to a circle with a radius slightly larger than sideLength.

public class CircleBug extends Bug {

    private int steps;
    private int sideLength;

    public CircleBug (int length) {
	steps=0;
	sideLength=length;
    }
    
    public void act () {
	if (steps < sideLength && canMove () ) {
	    move ();
	    steps ++;
	}

	else {
	    turn ();
	    steps = 0;
	}
    }
}
