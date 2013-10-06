package com.base.engine;

public abstract class GameObject
{
    protected Transform transform;
    protected String name;

    public GameObject(String name)
    {
        this.name = name;
        this.transform = new Transform();
    }
    
    public abstract void update();
    public abstract void render();

    public String getName()
    {
        return this.name;
    }
    
    public Transform getTransform()
    {
        return this.transform;
    }

}
