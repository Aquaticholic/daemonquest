package com.mygdx.daemonquest;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityManager {
    private static ArrayList<Entity> m_Entities = new ArrayList<Entity>();
    private static ArrayList<Entity> m_RemoveQueue = new ArrayList<Entity>();
    private static ArrayList<Entity> m_AddQueue = new ArrayList<Entity>();
    public static void addEntity(Entity e) {m_AddQueue.add(e);}
    public static void removeEntity(Entity e) {m_RemoveQueue.add(e);}
    public static void defferedActions()
    {
        for (Entity e : m_AddQueue)
            m_Entities.add(e);
        for (Entity e : m_RemoveQueue)
            m_Entities.remove(e);
        m_AddQueue.clear();
        m_RemoveQueue.clear();
    }
    public static void updateEntities(double dt) 
    {
        for (Entity e : m_Entities)
            e.update(dt);
    }
    public static void drawEntities(double dt) 
    {
        for (Entity e : m_Entities)
            e.draw(dt);
    }
    public static void batchDrawEntities(double dt, SpriteBatch batch) 
    {
        for (Entity e : m_Entities)
            e.batchDraw(dt, batch);
    }
}
