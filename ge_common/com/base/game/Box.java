package com.base.game;

import com.base.engine.entity.Entity;
import com.base.engine.render.RenderManager;
import com.base.engine.sprite.Sprite;

public class Box extends Entity
{
    private Sprite sprite;
    public Box()
    {
        super("Arena");
        sprite = Game.sprites.getSprite(16, 1, 0);
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render()
    {
        RenderManager.drawSprite(sprite, this.getTransform().getPosition());
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
