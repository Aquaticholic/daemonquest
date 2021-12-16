package com.mygdx.game;

public class Car extends Entity{
    private static final double speed = 550;
    Car(String texPath){
        super(texPath);
    }
    
    @Override
    public void update(double dt){
        pos.x -= speed * dt;
        if (checkCollision(GameState.daemon)){
            EntityManager.removeEntity(this);
            new Explosion("expl1.png", 7 * (size.x / 48) - 5.5, 0.05)
            .setPos(pos.x - 10, pos.y - 10)
            .setSize(size.x, size.x)
            ;
        }
        if (pos.x <= -500){
            EntityManager.removeEntity(this);
        }
    }
}
