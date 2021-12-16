package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class DeadPattern implements AttackPattern {
    public DeadPattern(){
        GameState.ruffer.tex = new Texture("sry.png");
    }

    public void update(double dt)
    {}

    public boolean isFinished()
    {
        return false;
    }
    public void end()
    {
    }
    
}
