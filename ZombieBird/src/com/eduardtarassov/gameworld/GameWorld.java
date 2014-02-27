package com.eduardtarassov.gameworld;

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
    private boolean isAlive = true;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);//initialize bird here
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);

        if (isAlive && scroller.collides(bird)) {
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
