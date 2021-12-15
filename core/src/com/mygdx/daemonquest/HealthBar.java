package com.mygdx.daemonquest;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HealthBar extends Entity {
    Double m_Health;
    public HealthBar(String texPath, Double health)
    {
        super(texPath);
        m_Health = health;
    }
    
    @Override
    public void update(double dt)
    {
    }
    
    @Override
    public void batchDraw(double dt, SpriteBatch batch)
    {
		batch.draw(tex, pos.x, pos.y, size.x, size.y,
        0,0,(int)(132.f * m_Health), 10,
        //0,0,grade,1
        false, false
        );
    }
}
