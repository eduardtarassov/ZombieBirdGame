package com.eduardtarassov.gameworld;

import com.badlogic.gdx.math.Rectangle;
import com.eduardtarassov.gameobjects.Bird;
import com.eduardtarassov.gameobjects.ScrollHandler;

/**
 * Created by Eduard on 2/25/14.
 * This class is responsible for updating our game objects.
 */
public class GameWorld {

    private Bird bird;
    private ScrollHandler scroller;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);//initialize bird here
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
