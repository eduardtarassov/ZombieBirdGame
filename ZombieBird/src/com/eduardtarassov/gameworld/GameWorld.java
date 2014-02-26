package com.eduardtarassov.gameworld;

import com.badlogic.gdx.math.Rectangle;
import com.eduardtarassov.gameobjects.Bird;

/**
 * Created by Eduard on 2/25/14.
 * This class is responsible for updating our game objects.
 */
public class GameWorld {

    private Bird bird;

    public GameWorld(int midPointY){
             bird = new Bird(33, midPointY - 5, 17, 12);//initialize bird here
    }

    public void update(float delta) {
             bird.update(delta);
    }

    public Bird getBird(){
        return bird;
    }
}
