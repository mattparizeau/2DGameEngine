package com.base.engine.render;

import com.base.engine.Engine;
import com.base.engine.math.Vector2f;
import com.base.engine.sprite.Sprite;

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
    
    public static void drawSprite(Sprite sprite, Vector2f position)
    {
        Vector2f offset = getOffset(position);
        
        for (int x = (int)offset.getX(); x < (int)offset.getX() + (int)sprite.getWidth(); x++)
        {
            for (int y = (int)offset.getY(); y < (int)offset.getY() + (int)sprite.getHeight(); y++)
            {
                int x_ = x - (int)offset.getX();
                int y_ = y - (int)offset.getY();
                Engine.getInstance().getScreen().setNextPixel(x, y, sprite.getPixel(x_, y_));
            }
        }
    }
    
}
