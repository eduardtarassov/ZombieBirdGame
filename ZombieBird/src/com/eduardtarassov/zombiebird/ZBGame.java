package com.eduardtarassov.zombiebird;


import com.badlogic.gdx.Game;
import com.eduardtarassov.screens.GameScreen;
import com.eduardtarassov.zbhelpers.AssetLoader;

//By extending game interface we will connect our code with the platform-dependent code (on IOS, Android, etc).
public class ZBGame extends Game {

    @Override
    public void create() {
        System.out.println("Game Created!");
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
