package com.base.engine.controller;

import com.base.engine.entity.Entity;
import com.base.engine.input.Input;
import com.base.engine.math.Vector2f;

public class ArrowController extends Controller
{

    public ArrowController(Entity object)
    {
        super(object);
    }

    @Override
    public void update()
    {
        int moveX = 0;
        int moveY = 0;
        
        if (Input.getKey(Input.KEY_UP))
            moveY = -1;
        else if (Input.getKey(Input.KEY_DOWN))
            moveY = 1;
        if (Input.getKey(Input.KEY_LEFT))
            moveX = -1;
        else if (Input.getKey(Input.KEY_RIGHT))
            moveX = 1;
        
        if (moveX != 0 || moveY != 0)
            move(new Vector2f(moveX, moveY));
    }

}
