package com.mygdx.daemonquest;

public class Bullet extends Entity{
    static final double speed = 900.d;
    public Bullet(String texPath)
    {
        super(texPath);
    }

    @Override
    public void update(double dt)
    {
        this.pos.y += speed * dt;
        if (checkCollision(GameState.ruffer))
        {
            EntityManager.removeEntity(this);
        }
        if (pos.y > 900)
            EntityManager.removeEntity(this);

    }
    
}
