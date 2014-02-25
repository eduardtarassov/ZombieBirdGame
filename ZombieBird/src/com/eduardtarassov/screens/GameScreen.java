package com.eduardtarassov.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.eduardtarassov.gameworld.GameRenderer;
import com.eduardtarassov.gameworld.GameWorld;

/**
 * Created by Eduard on 2/25/14.
 * This class is the initial screen with game.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen() {
        System.out.println("GameScreen Attached");
        world = new GameWorld(); // initialize world
        renderer = new GameRenderer(world); // initialize renderer and setting for the GameRenderer the reference to the GameWorld
    }

     /*
     *   Render method is our game loop method (something similar to update method). We will update our game objects here and render our game graphics.
     *   Delta is the number of seconds that has passed since the last time that the render method was called.
     *   By printing 1/delta we show our FPS (how many times that the render method will be called in a second if that rate was sustained.
     */
    @Override
    public void render(float delta) {
        /*// Draws the RGB color 10, 15, 230, at 100% opacity
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        System.out.println(1/delta);    */

        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("GameScreen - resizing");
    }

    @Override
    public void show() {
        System.out.println("GameScreen - show called");
    }
    @Override
    public void hide() {
        System.out.println("GameScreen - hide called");
    }

    @Override
    public void pause() {
        System.out.println("GameScreen - pause called");
    }

    @Override
    public void resume() {
        System.out.println("GameScreen - resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}