package com.eduardtarassov.gameobjects;

import java.util.Random;

/**
 * Created by Eduard on 2/27/14.
 */
public class Pipe extends Scrollable {

    private Random r;

    // When Pipe's constructor is invoked, invoke the super (Scrollable) constructor
    public Pipe(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        // Initialize a Random object for Random number generation
        r = new Random();
    }

    @Override
    public void reset(float newX) {
        // Call the reset method in the superclass (Scrollable)
        super.reset(newX);
        // Change the height to a random number
        height = r.nextInt(90) + 15;
    }

}
