package com.mygdx.game;

public class Bullet extends Entity{
    static final double speed = 900.d;
    public Bullet(String texPath)
    {
        super(texPath);
        Sounds.bulletSound.play(0.2f, (float)(0.95f + Math.random() * 0.1f), 0.f);
    }

    @Override
    public void update(double dt)
    {
        this.pos.y += speed * dt;
        if (checkCollision(GameState.ruffer))
        {
            EntityManager.removeEntity(this);
            GameState.rufferHealth.setValue(GameState.rufferHealth.getValue() - 0.001d);
        }
        if (pos.y > 900)
            EntityManager.removeEntity(this);

    }
    
}
