package com.eduardtarassov.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Eduard on 2/26/14.
 */
public class Bird {
    /*
     Vector2 is built-in LibGDX system that can hold two values: X component and Y component.
     Position.x refers to the X coordinate, and position.y to the Y coordinate respectively.
     Velocity.x would correspond to the speed in the X direction, and velocity.y to the speed in the Y direction respectively.
     Acceleration just means change in velocity.
    */
    private Vector2 position, velocity, acceleration;

    private float rotation; // For handling bird rotation
    private int width;
    private int height;

    public Bird(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));  //We add our scaled acceleration vector to our velocity vector. In other words we multiply the acceleration vector by the delta, which is the amount of time that has passed since the update method was previously called.

        if (velocity.y > 200) {  //Here we set the Bird max velocity cap.
            velocity.y = 200;
        }

        position.add(velocity.cpy().scl(delta));  //We add our scaled velocity to the bird's position (this gives us new position).

    }

    public void onClick() {
        velocity.y = -140;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }

}
