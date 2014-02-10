import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class SpiralBugRunner {
    public static void main (String [] args) {
	ActorWorld world = new ActorWorld();
	SpiralBug alice = new SpiralBug (3);
	alice.setColor(Color.ORANGE);
	// CircleBug bob = new SpiralBug (3);
	world.add(new Location (9,9), alice);
	//world.add(new Location (5,5), bob);
	world.show();
    }
}

