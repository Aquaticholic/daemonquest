package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Explosion extends Entity{
    ArrayList<Texture> textures = new ArrayList<Texture>();
    private static final double lifeTime = 0.3;
    double lifeTimer = lifeTime;
    double damage = 0.05;
    Explosion(String texPath, double power, double damage){
        super(texPath);
        System.out.println(super.size.x);
		GameState.screenShake += power;
        this.damage = damage;
        textures.add(new Texture("expl3.png"));
        textures.add(new Texture("expl2.png"));
        textures.add(new Texture("expl1.png"));
        Sounds.explosionSound.play(0.2f, (float)(0.95f + Math.random() * 0.1f), 0.f);
    }

    @Override
    public void update(double dt){
        int stage = (int)((lifeTimer / lifeTime) * 3);
        if (stage > 2)
        {
            if (checkCollision(GameState.daemon)){
                GameState.screenShake += 40;
                GameState.daemonHealth.setValue(GameState.daemonHealth.getValue() - damage);
                Sounds.daemonHurtSound.play();
            }
            stage = 2;
        }
        if (stage < 0)
            stage = 0;
        lifeTimer -= dt;
        super.tex = textures.get(stage);
        if (lifeTimer <= 0)
        {
            EntityManager.removeEntity(this);
        }
    }
    
}
