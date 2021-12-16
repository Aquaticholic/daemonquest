package com.mygdx.game;

public class GameState {
    static MutableDouble rufferHealth = new MutableDouble(1.f);
    static MutableDouble daemonHealth = new MutableDouble(1.f);
    //static Integer ammo = Integer.valueOf(10);
    public static Entity daemon;
    public static Entity ruffer;
    public static Entity playField;
    public static Text ammoText;

    static double screenShake = 0;
    static int ammo = 20;
}
