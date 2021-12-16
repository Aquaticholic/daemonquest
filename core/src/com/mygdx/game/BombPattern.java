package com.mygdx.game;

public class BombPattern implements AttackPattern{
    int bombsLeft;
    double bombTimer = 0;
    public BombPattern()
    {
        bombsLeft = 15 + (int)(Math.random() * 25);
    }

    public void update(double dt){
        bombTimer -= dt;
        if (bombTimer <= 0){
            bombsLeft--;
            bombTimer = 0.01 + (Math.random() * 0.14);
            new Bomb("bomb01.png")
            .setPos(
                GameState.playField.pos.x + (int)(Math.random() * (GameState.playField.size.x - 48)),
                GameState.playField.pos.y + (int)(Math.random() * (GameState.playField.size.y - 48))
            )
            .setSize(48, 48);
            ;
        }
    }

    public boolean isFinished(){
        return bombsLeft <= 0;
    }
    public void end(){
        
    }
    
}
