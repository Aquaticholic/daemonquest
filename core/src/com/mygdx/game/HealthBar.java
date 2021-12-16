package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HealthBar extends Entity {
    MutableDouble m_Health;
    public HealthBar(String texPath, MutableDouble health)
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
		batch.draw(tex, pos.x, pos.y, (int)(size.x * m_Health.getValue()), size.y,
        0,0,(int)(132 * m_Health.getValue()), 10,
        //0,0,grade,1
        false, false
        );
    }
}
