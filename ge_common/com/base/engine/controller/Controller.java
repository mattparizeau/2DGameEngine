package com.base.engine.controller;

import com.base.engine.GameObject;
import com.base.engine.math.Vector2f;

public abstract class Controller
{
    protected GameObject object;
    
    public Controller(GameObject object)
    {
        this.object = object;
    }
    
    public void move(Vector2f mov)
    {
        Vector2f pos = this.object.getTransform().getPosition();
        
        this.object.getTransform().setPosition(pos.add(mov));
    }
    
    public abstract void update();
}
