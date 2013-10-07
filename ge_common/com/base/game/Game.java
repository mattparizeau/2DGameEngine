package com.base.game;

import com.base.engine.Engine;
import com.base.engine.IGame;
import com.base.engine.controller.ArrowController;
import com.base.engine.controller.WASDController;
import com.base.engine.math.Vector2f;
import com.base.engine.render.RenderManager;

public class Game implements IGame
{
    private Player player;
    
    public Game()
    {
        player = new Player();
        player.attachController(new WASDController(player));
        RenderManager.getCamera().attachController(new ArrowController(RenderManager.getCamera()));
    }

    @Override
    public void update()
    {
        player.update();
    }

    @Override
    public void render()
    {
        RenderManager.drawRect(new Vector2f(0,0), new Vector2f(Engine.width, Engine.height), 0x00FF00);
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
