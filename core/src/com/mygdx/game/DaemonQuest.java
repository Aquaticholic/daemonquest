package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class DaemonQuest extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {

		//play music
		Sounds.music.setLooping(true);
		Sounds.music.setVolume(0.5f);
		Sounds.music.play();

		//Create sprite batch
		batch = new SpriteBatch();

		//intialize entities
		GameState.ruffer =  new Ruffer("Ruffer/1.png")
		.setPos(170,330)
		.setSize(300,150)
		;
		GameState.playField = new Entity("area.png")
		.setPos(70,50)
		.setSize(500,250)
		;
		GameState.daemon = new Player("player.png")
		.setPos(270,100)
		.setSize(20,65)
		;
		GameState.ammoText = new Text("area.png", "100");
		GameState.ammoText.setPos(300, 320);
		new HealthBar("healthbar.png", GameState.daemonHealth)
		.setPos(40, 10)
		.setSize(560, 30)
		;
		new HealthBar("healthbar.png", GameState.rufferHealth)
		.setPos(40, 450)
		.setSize(560, 30)
		;
	}

	@Override
	public void render () {
		double dt = Gdx.graphics.getDeltaTime();
		//set color of ammo text
		if (GameState.ammo > 50){
			Fonts.font.setColor(1.f, 1.f, 1.f, 1.f);
		} else if (GameState.ammo > 15){
			Fonts.font.setColor(1.f, 1.f, 0.f, 1.f);
		} else {
			Fonts.font.setColor(1.f, 0.f, 0.f, 1.f);
		}
		//set ammo text
		GameState.ammoText.text = Integer.toString(GameState.ammo) + "/100";

		EntityManager.defferedActions();
		EntityManager.updateEntities(dt);
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		EntityManager.batchDrawEntities(dt, batch);
		batch.end();
		EntityManager.drawEntities(dt);

		//dampen screenshake
		GameState.screenShake *= Math.pow(0.05, dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
