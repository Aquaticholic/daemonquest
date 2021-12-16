package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Bomb extends Entity{
    ArrayList<Texture> textures = new ArrayList<Texture>();
    double lifeTime = 1;
    Bomb(String texPath){
        super(texPath);
        textures.add(new Texture("bomb01.png"));
        textures.add(new Texture("bomb02.png"));
        textures.add(new Texture("bomb03.png"));
        textures.add(new Texture("bomb04.png"));
        textures.add(new Texture("bomb05.png"));
    }

    @Override
    public void update(double dt){
        super.tex = textures.get(
            (int)(Math.random() * textures.size())
        );
        lifeTime -= dt;
        if (lifeTime <= 0){
            EntityManager.removeEntity(this);
            new Explosion("expl1.png", 
            7 * (size.x / 48) - 5.5,
            0.05 * (size.x/48)
            )
            .setPos(pos.x, pos.y)
            .setSize(size.x, size.y)
            ;
        }
    }
    
}
