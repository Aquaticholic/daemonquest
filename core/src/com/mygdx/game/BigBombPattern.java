package com.mygdx.game;

public class BigBombPattern implements AttackPattern{
    int bombsLeft;
    double bombTimer = 0;
    public BigBombPattern()
    {
        bombsLeft = 5 + (int)(Math.random() * 10);
    }

    public void update(double dt){
        bombTimer -= dt;
        if (bombTimer <= 0){
            bombsLeft--;
            bombTimer = 0.08 + (Math.random() * 0.4);
            new Bomb("bomb01.png")
            .setPos(
                GameState.playField.pos.x + (int)(Math.random() * (GameState.playField.size.x - 128)),
                GameState.playField.pos.y + (int)(Math.random() * (GameState.playField.size.y - 128))
            )
            .setSize(128, 128);
            ;
        }
        
    }

    public boolean isFinished(){
        return bombsLeft <= 0;
    }
    public void end(){
        
    }
    
}
