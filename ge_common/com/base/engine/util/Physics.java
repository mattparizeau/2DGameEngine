package com.base.engine.util;

import java.util.ArrayList;

import com.base.engine.Engine;
import com.base.engine.entity.Entity;
import com.base.engine.math.Vector2f;

public class Physics
{
    public static Entity checkCollision(Entity entity)
    {
        if (!entity.canCollide()) return null;
        ArrayList<Entity> entities = Engine.getEntities();
        for (int i = 0; i < entities.size(); i++)
        {
            if (!entities.get(i).canCollide() || entities.get(i).equals(entity))
                continue;
            Vector2f pos = entity.getTransform().getPosition();
            Vector2f oPos = entities.get(i).getTransform().getPosition();
            
            Vector2f distance = pos.sub(oPos).abs();
            
            if (distance.length() < entity.getSize() || distance.length() < entities.get(i).getSize())
            {
                return entities.get(i);
            }
        }
        return null;
    }
}
