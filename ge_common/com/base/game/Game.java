package com.base.game;

import com.base.engine.Engine;
import com.base.engine.IGame;
import com.base.engine.controller.WASDController;

public class Game implements IGame
{
    private Player player;
    
    public Game()
    {
        player = new Player();
        player.attachController(new WASDController(player));
    }

    @Override
    public void update()
    {
        player.update();
    }

    @Override
    public void render()
    {
        player.render();
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
