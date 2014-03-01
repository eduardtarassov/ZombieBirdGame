package com.eduardtarassov.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.eduardtarassov.gameworld.GameRenderer;
import com.eduardtarassov.gameworld.GameWorld;
import com.eduardtarassov.zbhelpers.InputHandler;

/**
 * Created by Eduard on 2/25/14.
 * This class is the initial screen with game.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime = 0;

    public GameScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
        renderer = new GameRenderer(world, (int) gameHeight, midPointY); // initialize renderer and setting for the GameRenderer the reference to the GameWorld
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
        runTime += delta;
        world.update(delta);
        renderer.render(delta, runTime);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}