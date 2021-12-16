package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class WinPattern implements AttackPattern {
    double timer;
    public WinPattern(){
        GameState.ruffer.tex = new Texture("adios.png");
        EntityManager.removeEntity(GameState.daemon);
        timer = 3.d;
    }

    public void update(double dt)
    {
        timer -= dt;
    }

    public boolean isFinished()
    {
        return (timer <= 0);
        //return true;
    }
    public void end()
    {
		GameState.daemon = new Player("player.png")
		.setPos(270,100)
		.setSize(20,65)
		;
        GameState.ruffer.tex = new Texture("Ruffer/1.png");
        GameState.ammo = 100;
        GameState.daemonHealth.setValue(1);
        GameState.rufferHealth.setValue(1);
    }
    
}
