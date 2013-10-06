package com.base.engine.sprite;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Sprite
{
    private int width;
    private int height;
    private int[] pixels;
    
    protected Sprite(int width, int height, int[] pixels)
    {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }
    
    public static Sprite loadSprite(String file)
    {
        int width = 0;
        int height = 0;
        int[] pixels = null;
        
        try {
            File f = new File("sprites/" + file);
            
            BufferedImage bi = ImageIO.read(f);
            
            width = bi.getWidth();
            height = bi.getHeight();
            
            pixels = bi.getRGB(0, 0, width, height, null, 0, width);
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return new Sprite(width, height, pixels);
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public int getPixel(int x, int y)
    {
        return this.pixels[x + y * width];
    }
    
    public int[] getPixels()
    {
        return this.pixels;
    }
}
