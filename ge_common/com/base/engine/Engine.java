package com.base.engine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.base.engine.input.Input;

public class Engine extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;

    private static Engine instance;
    public static int width = 300;
    public static int height = width / 16 * 9;
    private static int scale = 3;

    private IGame game;
    private String title;
    private boolean isRunning;
    private Thread mainThread;
    private Screen screen;
    private BufferedImage image;
    private JFrame frame;

    private Engine(IGame game)
    {
        this.game = game;
        this.title = game.getTitle();
        this.setPreferredSize(new Dimension(width * scale, height * scale));
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.screen = new Screen(width, height);
        this.frame = new JFrame();
        this.addKeyListener(Input.getInput());
        this.initFrame();
    }

    public static final void init(IGame game)
    {
        Engine.instance = new Engine(game);
        Engine.instance.start();
    }
    
    public void initFrame()
    {
        this.frame.setTitle(title);
        this.frame.setResizable(false);
        this.frame.add(this);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public void start()
    {
        mainThread = new Thread(this);
        mainThread.setPriority(Thread.MAX_PRIORITY);
        mainThread.start();
        
        this.requestFocus();
    }

    @Override
    public void run()
    {
        isRunning = true;
        while (isRunning)
        {
            update();
            render();
        }
        stop();
    }

    public void update()
    {
        game.update();
    }

    public void render()
    {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null)
        {
            createBufferStrategy(3);
            return;
        }
        
        screen.clear(0);
        
        game.render();
        
        screen.render();
        
        image.setRGB(0, 0, width, height, screen.getPixels(), 0, width);
        
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, width * scale, height * scale, null);
        bs.show();
    }

    public void stop()
    {
        try {
            mainThread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        isRunning = false;
        System.exit(0);
    }

    public int getScale()
    {
        return Engine.scale;
    }

    public String getTitle()
    {
        return this.title;
    }
    
    public Screen getScreen()
    {
        return this.screen;
    }
    
    public IGame getGame()
    {
        return this.game;
    }

    public static Engine getInstance()
    {
        return Engine.instance;
    }

}
