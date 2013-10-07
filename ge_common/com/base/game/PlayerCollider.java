package com.base.game;

import com.base.engine.entity.Entity;
import com.base.engine.entity.collision.ICollider;

public class PlayerCollider implements ICollider
{

    @Override
    public void onCollision(Entity entity)
    {
        System.out.println("Collided with: " + entity.getName());
    }

}
