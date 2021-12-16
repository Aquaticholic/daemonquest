package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity {
    public final float speed = 200;
    private double shootTimer = 0.d;
    private double ammoTimer = 9.d;

    Player(String texPath)
    {
        super(texPath);
    }

    @Override
    public void update(double dt) {
        //movement
        pos.x += speed * dt * (
            (Gdx.input.isKeyPressed(Input.Keys.A) ? -1 : 0) +
            (Gdx.input.isKeyPressed(Input.Keys.D) ?  1 : 0)
        );
        pos.y += speed * dt * (
            (Gdx.input.isKeyPressed(Input.Keys.S) ? -1 : 0) +
            (Gdx.input.isKeyPressed(Input.Keys.W) ?  1 : 0)
        );
        //play bounds
        if (pos.x < GameState.playField.pos.x)
            pos.x = GameState.playField.pos.x;
        if (pos.y < GameState.playField.pos.y)
            pos.y = GameState.playField.pos.y;
        if (pos.x > GameState.playField.pos.x + GameState.playField.size.x - size.x)
            pos.x = GameState.playField.pos.x + GameState.playField.size.x - size.x;
        if (pos.y > GameState.playField.pos.y + GameState.playField.size.y - size.y)
            pos.y = GameState.playField.pos.y + GameState.playField.size.y - size.y;

        //shooting
        shootTimer -= dt;
        if (shootTimer <= 0 && Gdx.input.isKeyPressed(Input.Keys.SPACE) && GameState.ammo > 0) {
            GameState.ammo--;
            new Bullet("bullet.png")
            .setPos(-12 + pos.x + size.x / 2 + (int)(Math.random() * 6), pos.y + size.y - 16)
            .setSize(18,46)
            ;
            shootTimer = 0.04;
        }

        //Ammo boxes
        ammoTimer -= dt;
        if (ammoTimer <= 0){
            //reset timer
            ammoTimer = 1.5d + (Math.random() * 3.d);
            //Spawn ammo box
            new Ammobox("ammobox.png")
            .setPos(
                GameState.playField.pos.x + (int)(Math.random() * (GameState.playField.size.x - 48)),
                GameState.playField.pos.y + (int)(Math.random() * (GameState.playField.size.y - 48))
            )
            .setSize(48, 48);
            ;
        }
    }
}
