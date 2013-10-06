package com.base.engine.render;

import com.base.engine.Engine;
import com.base.engine.math.Vector2f;

public class RenderManager
{
    
    private static Vector2f getOffset(Vector2f position)
    {
        // TODO: get offset based on camera position.
        return position;
    }
    
    public static void fillRect(Vector2f position, Vector2f size, int color)
    {
        Vector2f offset = getOffset(position);
        
        for (int x = (int)offset.getX(); x < (int)offset.getX() + (int)size.getX(); x++)
        {
            for (int y = (int)offset.getY(); y < (int)offset.getY() + (int)size.getY(); y++)
            {
                Engine.getInstance().getScreen().setNextPixel(x, y, color);
            }
        }
    }
    
    public static void drawRect(Vector2f position, Vector2f size, int color)
    {
        Vector2f offset = getOffset(position);
        
        for (int x = (int)offset.getX(); x < (int)offset.getX() + (int)size.getX(); x++)
        {
            for (int y = (int)offset.getY(); y < (int)offset.getY() + (int)size.getY(); y++)
            {
                if (x == (int)offset.getX() || x == (int)offset.getX() + (int)size.getX() - 1 ||
                    y == (int)offset.getY() || y == (int)offset.getY() + (int)size.getY() - 1)
                    Engine.getInstance().getScreen().setNextPixel(x, y, color);
            }
        }
    }
    
}
