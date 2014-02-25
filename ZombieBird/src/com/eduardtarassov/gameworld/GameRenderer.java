package com.eduardtarassov.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Eduard on 2/25/14.
 * This class is responsible for rendering game objects into graphics task.
 */
public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam; //this is camera that sets 2D world view in the 3D game engine (LibGDX)
    private ShapeRenderer shapeRenderer; //this object will draw shapes and lines for us. Provided by LibGDX!

    public GameRenderer(GameWorld world){
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204); //first argument asks whether we want Orthographic projection, second - width of game world, third - height of game world

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined); //attaching shapeRenderer to our camera
    }

    public void render(){
        System.out.println("GameRenderer - render");
    }
}
