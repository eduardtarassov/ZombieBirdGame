package com.eduardtarassov.gameworld;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Eduard on 2/25/14.
 * This class is responsible for updating our game objects.
 */
public class GameWorld {

    private Rectangle rect = new Rectangle(0, 0, 17, 12);  // Parameters are: X Coordinates, Y Coordinates, Width, Height


    public void update(float delta) {
        System.out.println("GameWorld - update");
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
    }

    public Rectangle getRect() {
        return rect;
    }
}
