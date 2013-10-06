package com.base.engine;

public class Screen
{
    
    private int width;
    private int height;
    private int[] pixels;
    private int[] nextPixels;
    
    public Screen(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
        this.nextPixels = new int[width * height];
    }
    
    public void clear(int color)
    {
        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i] = color;
        }
    }
    
    public void render()
    {
        this.pixels = nextPixels;
    }
    
    public void setPixel(int x, int y, int color)
    {
        this.pixels[x + y * width] = color;
    }
    
    public int getPixel(int x, int y)
    {
        return this.pixels[x + y * width];
    }
    
    public void setNextPixel(int x, int y, int color)
    {
        if (x < 0 || y < 0 || x >= width || y >= height) return;
        this.nextPixels[x + y * width] = color;
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
