package com.mygdx.daemonquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity {
    public final float speed = 200;
    private double shootTimer = 0.d;

    Player(String texPath)
    {
        super(texPath);
    }

    @Override
    public void update(double dt) {
        pos.x += speed * dt * (
            (Gdx.input.isKeyPressed(Input.Keys.A) ? -1 : 0) +
            (Gdx.input.isKeyPressed(Input.Keys.D) ?  1 : 0)
        );
        pos.y += speed * dt * (
            (Gdx.input.isKeyPressed(Input.Keys.S) ? -1 : 0) +
            (Gdx.input.isKeyPressed(Input.Keys.W) ?  1 : 0)
        );
        shootTimer -= dt;
        if (shootTimer <= 0 && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            new Bullet("bullet.png")
            .setPos(-9 + pos.x + size.x / 2, pos.y + size.y)
            .setSize(18,46)
            ;
            shootTimer = 0.04;
        }
    }
}
