package com.base.engine.controller;

import com.base.engine.GameObject;
import com.base.engine.input.Input;
import com.base.engine.math.Vector2f;

public class WASDController extends Controller
{

    public WASDController(GameObject object)
    {
        super(object);
    }

    @Override
    public void update()
    {
        int moveX = 0;
        int moveY = 0;
        
        if (Input.getKey(Input.KEY_W))
            moveY = -1;
        else if (Input.getKey(Input.KEY_S))
            moveY = 1;
        if (Input.getKey(Input.KEY_A))
            moveX = -1;
        else if (Input.getKey(Input.KEY_D))
            moveX = 1;
        
        if (moveX != 0 || moveY != 0)
            move(new Vector2f(moveX, moveY));
    }

}
