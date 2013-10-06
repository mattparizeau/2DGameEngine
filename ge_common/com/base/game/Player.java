package com.base.game;

import com.base.engine.GameObject;
import com.base.engine.math.Vector2f;
import com.base.engine.render.RenderManager;

public class Player extends GameObject
{

    public Player()
    {
        super("Player");
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render()
    {
        RenderManager.fillRect(getTransform().getPosition(), new Vector2f(10, 10), 0xFF0044);
    }
    
}
