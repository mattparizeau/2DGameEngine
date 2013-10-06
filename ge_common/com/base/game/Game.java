package com.base.game;

import com.base.engine.Engine;
import com.base.engine.IGame;

public class Game implements IGame
{
    public Game()
    {
        
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render()
    {
        
    }
    
    public static final void main(String[] args)
    {
        Engine.init(new Game());
    }

    @Override
    public String getTitle()
    {
        return "Test Game";
    }
}
