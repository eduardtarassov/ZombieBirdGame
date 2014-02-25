package com.eduardtarassov.zombiebird;


import com.badlogic.gdx.Game;
import com.eduardtarassov.screens.GameScreen;

public class ZBGame extends Game {

    @Override
    public void create() {
        System.out.println("Game Created!");
        setScreen(new GameScreen());
    }
}
