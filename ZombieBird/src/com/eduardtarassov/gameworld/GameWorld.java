package com.eduardtarassov.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.eduardtarassov.gameobjects.Bird;
import com.eduardtarassov.gameobjects.ScrollHandler;
import com.eduardtarassov.zbhelpers.AssetLoader;

/**
 * Created by Eduard on 2/25/14.
 * This class is responsible for updating our game objects.
 */
public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;

    private int score = 0;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);//initialize bird here
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    public void update(float delta) {


        // Add a delta cap so that if our game takes too long
        // to update, we will not break our collision detection.

        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);


        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
        }
    }

    public void addScore(int increment) {
        score += increment;
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public int getScore() {
        return score;
    }

}
