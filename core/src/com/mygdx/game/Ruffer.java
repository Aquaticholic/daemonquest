package com.mygdx.game;

public class Ruffer extends Entity{
    AttackPattern currentAttack = null;
    double attackTimeout = 7;
    public Ruffer(String texPath){
        super(texPath);
    }
    boolean gameEndPattern = false;

    @Override
    public void update(double dt){
        attackTimeout -= dt;
        if (!gameEndPattern)
        {
            if (GameState.rufferHealth.getValue() <= 0) {
                currentAttack = new DeadPattern();
                gameEndPattern = true;
            }
            if (GameState.daemonHealth.getValue() <= 0) {
                currentAttack = new WinPattern();
                gameEndPattern = true;
            }
        }
        if (currentAttack == null){
            if (attackTimeout <= 0){
                int newPatternID = (int)(Math.random() * 3);
                switch (newPatternID)
                {
                    case 0:
                    currentAttack = new BombPattern();
                    break;

                    case 1:
                    currentAttack = new BigBombPattern();
                    break;

                    case 2:
                    currentAttack = new CarPattern();
                    break;
                }
            }
        }else{
            currentAttack.update(dt);
            if (currentAttack.isFinished())
            {
                attackTimeout = 0.3 + Math.random() * 0.4;
                currentAttack.end();
                currentAttack = null;
                gameEndPattern = false;
            }
        }
    }
    
}
