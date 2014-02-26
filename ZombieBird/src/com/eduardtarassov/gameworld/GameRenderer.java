package com.eduardtarassov.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.eduardtarassov.gameobjects.Bird;
import com.eduardtarassov.zbhelpers.AssetLoader;

/**
 * Created by Eduard on 2/25/14.
 * This class is responsible for rendering game objects into graphics task.
 */
public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam; //this is camera that sets 2D world view in the 3D game engine (LibGDX)
    private ShapeRenderer shapeRenderer; //this object will draw shapes and lines for us. Provided by LibGDX!

    private SpriteBatch batcher;  //this object will draw images for us

    private int midPointY;
    private int gameHeight;

    public GameRenderer(GameWorld world, int gameHeight, int midPointY){
        myWorld = world;

        // parameters passed in from GameScreen.
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;


        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight); //first argument asks whether we want Orthographic projection, second - width of game world, third - height of game world

        batcher = new SpriteBatch();
        // Attach batcher to camera
        batcher.setProjectionMatrix(cam.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined); //attaching shapeRenderer to our camera
    }

    public void render(float runTime){  //we need this parameter to determine which frame the bird animation should display. The Animation object will use this value (and the previously determined frame duration) to determine which TextureRegion to display.

        //We will move these outside of the loop for performance later
        Bird bird = myWorld.getBird();

        //We draw a black background. This prevents flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        //Begin ShapeRenderer
        shapeRenderer.begin(ShapeType.Filled);

        //Draw Background color
        shapeRenderer. setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();

        // Disable transparency
        // This is good for performance when drawing images that do not require transparency.
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        // The bird needs transparency, so we enable that again.
        batcher.enableBlending();

        // Draw bird at its coordinates. Retrieve the Animation object from AssetLoader
        // Pass in the runTime variable to get the current frame.
        batcher.draw(AssetLoader.birdAnimation.getKeyFrame(runTime),
                bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        // End SpriteBatch
        batcher.end();
    }
}
