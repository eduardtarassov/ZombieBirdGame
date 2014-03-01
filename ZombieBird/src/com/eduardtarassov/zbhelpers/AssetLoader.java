package com.eduardtarassov.zbhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Eduard on 2/26/14.
 */
public class AssetLoader {

    public static Texture texture;
    public static TextureRegion bg, grass;
    public static Animation birdAnimation;
    public static TextureRegion bird, birdDown, birdUp;
    public static TextureRegion skullUp, skullDown, bar;
    public static Sound dead, flap, coin;
    public static BitmapFont font, shadow;
    public static Preferences prefs;

    public static void load() {


        /*
        setting texture's minification and magnification filters (used when resizing to a smaller or larger image) to the enum
        constant TextureFilter.Nearest.
        This is important because when our small pixel art is stretched to a larger size, each pixel will retain its
        shape rather than becoming blurry!
        */
        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        bg = new TextureRegion(texture, 0, 0, 136, 43);
        bg.flip(false, true);

        grass = new TextureRegion(texture, 0, 43, 143, 11);
        grass.flip(false, true);

        birdDown = new TextureRegion(texture, 136, 0, 17, 12);
        birdDown.flip(false, true);

        bird = new TextureRegion(texture, 153, 0, 17, 12);
        bird.flip(false, true);

        birdUp = new TextureRegion(texture, 170, 0, 17, 12);
        birdUp.flip(false, true);

        TextureRegion[] birds = {birdDown, bird, birdUp}; //creating an arrey of TextureRegion objects
        birdAnimation = new Animation(0.06f, birds); // Creating a new Animation in which each frame is 0.06 seconds long, using the above array.
        birdAnimation.setPlayMode(Animation.LOOP_PINGPONG); // Sets play mode to be ping pong, in which we will see a bounce.

        skullUp = new TextureRegion(texture, 192, 0, 24, 14);
        // Create by flipping existing skullUp
        skullDown = new TextureRegion(skullUp);
        skullDown.flip(false, true);

        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);

        dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));

        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.setScale(.25f, -.25f);
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.setScale(.25f, -.25f);


        // Create (or retrieve existing) preferences file
        prefs = Gdx.app.getPreferences("ZombieBird");

// Provide default high score of 0
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
        dead.dispose();
        flap.dispose();
        coin.dispose();
        font.dispose();
        shadow.dispose();
    }

    // Receives an integer and maps it to the String highScore in prefs
    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    // Retrieves the current high score
    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }
}
