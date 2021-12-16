package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
    static Sound explosionSound = Gdx.audio.newSound(Gdx.files.internal("GameSFX/Explosion/Retro Explosion Short 01.wav"));
    //static Sound bulletSound = Gdx.audio.newSound(Gdx.files.internal("GameSFX/Weapon/laser/Retro Gun Laser SingleShot 01.wav"));
    static Sound bulletSound = Gdx.audio.newSound(Gdx.files.internal("mp3/Shoot3.mp3"));
    static Sound daemonHurtSound = Gdx.audio.newSound(Gdx.files.internal("GameSFX/Impact/Retro Impact Punch Hurt 01.wav"));
    static Sound ammoPickupSound = Gdx.audio.newSound(Gdx.files.internal("mp3/ Stairs.mp3"));
    static Music music = Gdx.audio.newMusic(Gdx.files.internal("Coconut Mall - Mario Kart Wii [OST]-QY7SxnKqMmE.mp3"));
}
