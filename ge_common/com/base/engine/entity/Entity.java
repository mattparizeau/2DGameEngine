package com.base.engine.entity;

import java.util.ArrayList;

import com.base.engine.Engine;
import com.base.engine.Transform;
import com.base.engine.controller.Controller;

public abstract class Entity
{
    protected Transform transform;
    protected String name;
    protected ArrayList<Controller> controllers;

    public Entity(String name)
    {
        this.name = name;
        this.transform = new Transform();
        this.controllers = new ArrayList<Controller>();
        Engine.getObjects().add(this);
    }
    
    public void attachController(Controller controller)
    {
        this.controllers.add(controller);
    }
    
    public void detachController(Controller controller)
    {
        this.controllers.remove(controller);
    }
    
    public void detachAll()
    {
        this.controllers.clear();
    }
    
    public void dispose()
    {
        Engine.getObjects().remove(this);
    }
    
    public final void updateControllers()
    {
        for (int i = 0; i < controllers.size(); i++)
        {
            controllers.get(i).update();
        }
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
