package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    public Vector2 pos = new Vector2(0,0);
    public Vector2 size = new Vector2(100,100);
    public Texture tex;
    public Entity(String textureName)
    {
        EntityManager.addEntity(this);
		tex = new Texture(textureName);
    }

    public Entity setPos(float x, float y) {
        pos.x = x;
        pos.y = y;
        return this;
    }

    public Entity setSize(float x, float y) {
        size.x = x;
        size.y = y;
        return this;
    }

    public void update(double dt)
    {}

    public void draw(double dt)
    {}

    public void batchDraw(double dt, SpriteBatch batch)
    {
		batch.draw(tex, pos.x + (int)(GameState.screenShake * (Math.random() - 0.5)), 
                        pos.y + (int)(GameState.screenShake * (Math.random() - 0.5)), 
                        size.x, size.y);
    }

    public boolean checkCollision(Entity other){
        return (
            (pos.x + size.x >= other.pos.x) &&
            (pos.x <= other.pos.x + other.size.x) &&
            (pos.y + size.y >= other.pos.y) &&
            (pos.y <= other.pos.y + other.size.y)
        );
    }
}
