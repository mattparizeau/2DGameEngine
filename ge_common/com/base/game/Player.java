package com.base.game;

import com.base.engine.entity.Entity;
import com.base.engine.render.RenderManager;
import com.base.engine.sprite.Sprite;

public class Player extends Entity
{
    
    private Sprite sprite;
    public Player()
    {
        super("Player");
        this.sprite = Game.sprites.getSprite(16, 0, 0);
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render()
    {
        RenderManager.drawSprite(sprite, getTransform().getPosition());
    }

    @Override
    public float getSize()
    {
        return 16;
    }

    @Override
    public boolean canCollide()
    {
        return true;
    }
    
}
