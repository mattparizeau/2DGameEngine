package com.base.engine;

import com.base.engine.math.Vector2f;

public class Transform
{
    private Vector2f position;
    private float rotation;
    private Vector2f scale;
    
    public Transform()
    {
        this(new Vector2f(0, 0));
    }
    
    public Transform(Vector2f position)
    {
        this(position, 0);
    }

    public Transform(Vector2f position, float rotation)
    {
        this(position, rotation, new Vector2f(1, 1));
    }

    public Transform(Vector2f position, float rotation, Vector2f scale)
    {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Vector2f getPosition()
    {
        return this.position;
    }

    public void setPosition(Vector2f position)
    {
        this.position = position;
    }

    public void setPosition(float x, float y)
    {
        this.position = new Vector2f(x, y);
    }

    public float getRotation()
    {
        return this.rotation;
    }

    public void setRotation(float rotation)
    {
        this.rotation = rotation;
    }

    public Vector2f getScale()
    {
        return this.scale;
    }

    public void setScale(Vector2f scale)
    {
        this.scale = scale;
    }

    public void setScale(float x, float y)
    {
        this.scale = new Vector2f(x, y);
    }
}
