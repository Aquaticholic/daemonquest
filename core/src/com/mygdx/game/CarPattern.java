package com.mygdx.game;

public class CarPattern implements AttackPattern{
    int carsLeft;
    double carTimer = 0;
    CarPattern(){
        carsLeft = 3 + (int)(Math.random() * 7);
    }
    public void update(double dt){
        carTimer -= dt;
        if (carTimer <= 0){
            carsLeft--;
            carTimer = 0.1 + (Math.random() * 0.3);
            new Car("car.png")
            .setPos(
                640,
                GameState.playField.pos.y + (int)(Math.random() * (GameState.playField.size.y - 30))
            )
            .setSize(80, 20);
            ;
        }

    }
    public boolean isFinished(){
        return carsLeft <= 0;
    }

    public void end() {}
    
}
