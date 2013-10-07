package com.base.game;

import com.base.engine.Engine;
import com.base.engine.IGame;
import com.base.engine.controller.ArrowController;
import com.base.engine.controller.WASDController;
import com.base.engine.math.Vector2f;
import com.base.engine.render.RenderManager;
import com.base.engine.sprite.SpriteSheet;

public class Game implements IGame
{
    private Player player;
    private Box box;
    public static SpriteSheet sprites = new SpriteSheet("test.png");
    
    public Game()
    {
        box = new Box();
        player = new Player();
        player.attachController(new WASDController(player));
        player.attachCollider(new PlayerCollider());
        RenderManager.getCamera().attachController(new ArrowController(RenderManager.getCamera()));
    }

    @Override
    public void update()
    {
        player.update();
        box.update();
    }

    @Override
    public void render()
    {
        RenderManager.drawRect(new Vector2f(0,0), new Vector2f(Engine.width, Engine.height), 0x00FF00);
        player.render();
        box.render();
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
