package com.nekox.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile
{
  protected int x, y, w, h;
  private final TextureRegion texture;
  
  public Tile(int x, int y, int w, int h, TextureRegion texture)
  {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.texture = texture;
  }
  
  public void tick() {}
  
  public int getX()
  {
    return x;
  }
  
  public int getY()
  {
    return y;
  }
  
  public void setX(int x)
  {
    this.x = x;
  }
  
  public void setY(int y)
  {
    this.y = y;
  }
  
  public int getW()
  {
    return w;
  }
  
  public void draw(SpriteBatch batch)
  {
    batch.draw(texture, x, y, w, h);
  }
}
