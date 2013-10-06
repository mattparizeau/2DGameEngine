package com.base.engine.math;

public class Vector2f
{
    private float x, y;
    
    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Vector2f normalized()
    {
        float len = length();
        
        float x_ = x / len;
        float y_ = y / len;
        
        return new Vector2f(x_, y_);
    }
    
    public float length()
    {
        return (float)Math.sqrt(x * x + y * y);
    }
    
    public Vector2f add(Vector2f r)
    {
        return new Vector2f(x + r.getX(), y + r.getY());
    }
    
    public Vector2f add(float r)
    {
        return new Vector2f(x + r, y + r);
    }
    
    public Vector2f sub(Vector2f r)
    {
        return new Vector2f(x - r.getX(), y - r.getY());
    }
    
    public Vector2f sub(float r)
    {
        return new Vector2f(x - r, y - r);
    }
    
    public Vector2f mul(Vector2f r)
    {
        return new Vector2f(x * r.getX(), y * r.getY());
    }
    
    public Vector2f mul(float r)
    {
        return new Vector2f(x * r, y * r);
    }
    
    public Vector2f div(Vector2f r)
    {
        return new Vector2f(x / r.getX(), y / r.getY());
    }
    
    public Vector2f div(float r)
    {
        return new Vector2f(x / r, y / r);
    }
    
    public Vector2f abs()
    {
        return new Vector2f(Math.abs(x), Math.abs(y));
    }
    
    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
    
    public float getX()
    {
        return this.x;
    }
    
    public void setX(float x)
    {
        this.x = x;
    }
    
    public float getY()
    {
        return this.y;
    }
    
    public void setY(float y)
    {
        this.y = y;
    }
}
