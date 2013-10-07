package com.base.engine.sprite;

public class SpriteSheet
{
    private int width;
    private int height;
    private int[] pixels;
    
    public SpriteSheet(String file)
    {
        load(file);
    }
    
    private void load(String file)
    {
        Sprite sprite = new Sprite(file);
        
        this.width = sprite.getWidth();
        this.height = sprite.getHeight();
        this.pixels = sprite.getPixels();
    }
    
    public Sprite getSprite(int size, int x, int y)
    {
        int x_ = x * size;
        int y_ = y * size;
        
        int width = size;
        int height = size;
        int[] pixels = new int[width * height];
        
        for (int i = x_; i < x_ + width; i++)
        {
            for (int j = y_; j < y_ + height; j++)
            {
                pixels[(i - x_) + (j - y_) * width] = this.pixels[i + j * this.width];
            }
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
    
    public int[] getPixels()
    {
        return this.pixels;
    }
}
