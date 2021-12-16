package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text extends Entity{
    String text;
    Text(String texPath, String text_){
        super(texPath);
        text = text_;
    }
    @Override
    public void batchDraw(double dt, SpriteBatch batch){
        Fonts.font.draw(batch, text, pos.x, pos.y);
    }
}
