package com.mygdx.game;

public interface AttackPattern {
    public void update(double dt);
    public boolean isFinished();
    public void end();
}
