package com.base.engine.entity;

import java.util.ArrayList;

import com.base.engine.Engine;
import com.base.engine.Transform;
import com.base.engine.controller.Controller;
import com.base.engine.entity.collision.ICollider;
import com.base.engine.util.Physics;

public abstract class Entity
{
    protected Transform transform;
    protected String name;
    protected ArrayList<Controller> controllers;
    protected ArrayList<ICollider> colliders;

    public Entity(String name)
    {
        this.name = name;
        this.transform = new Transform();
        this.controllers = new ArrayList<Controller>();
        this.colliders = new ArrayList<ICollider>();
        Engine.getEntities().add(this);
    }
    
    public void attachController(Controller controller)
    {
        this.controllers.add(controller);
    }
    
    public void detachController(Controller controller)
    {
        this.controllers.remove(controller);
    }
    
    public void detachAllControllers()
    {
        this.controllers.clear();
    }
    
    public void attachCollider(ICollider collider)
    {
        this.colliders.add(collider);
    }
    
    public void detachCollider(ICollider collider)
    {
        this.colliders.remove(collider);
    }
    
    public void detachAllColliders()
    {
        this.colliders.clear();
    }
    
    public void dispose()
    {
        Engine.getEntities().remove(this);
    }
    
    public final void updateEntity()
    {
        for (int i = 0; i < controllers.size(); i++)
        {
            controllers.get(i).update();
        }
        Entity e = Physics.checkCollision(this);
        if (e != null)
        {
            for (int i = 0; i < colliders.size(); i++)
            {
                colliders.get(i).onCollision(e);
            }
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

    public abstract float getSize();
    public abstract boolean canCollide();

}
