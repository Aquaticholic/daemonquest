package com.mygdx.game;

public class Ammobox extends Entity{
    Ammobox(String texPath){
        super(texPath);
    }

    @Override
    public void update(double dt){
        if (checkCollision(GameState.daemon)){
            GameState.ammo += 40;
            if (GameState.ammo > 100)
                GameState.ammo = 100;
            EntityManager.removeEntity(this);
            Sounds.ammoPickupSound.play(0.8f, (float)(0.95f + Math.random() * 0.1f), 0);
        }
    }
    
}
