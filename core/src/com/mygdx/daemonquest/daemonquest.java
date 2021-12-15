package com.mygdx.daemonquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class daemonquest extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		GameState.ruffer =  new Entity("Ruffer/1.png")
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
		new HealthBar("healthbar.png", GameState.daemonHealth)
		.setPos(40, 10)
		.setSize(560, 30)
		;
	}

	@Override
	public void render () {
		double dt = Gdx.graphics.getDeltaTime();
		EntityManager.defferedActions();
		EntityManager.updateEntities(dt);
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		EntityManager.batchDrawEntities(dt, batch);
		batch.end();
		EntityManager.drawEntities(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
