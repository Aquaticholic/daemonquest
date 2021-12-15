package com.mygdx.daemonquest;

public interface AttackPattern {
    public void start();
    public void update(double dt);
    public boolean isFinished();
    public void end();
}
