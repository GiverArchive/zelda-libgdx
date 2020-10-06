package com.nekox.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nekox.Main.Textures;

public class WaterTiles extends Tile
{
  private int frames, index;
  
  public WaterTiles(int x, int y, int w, int h)
  {
    super(x, y, w, h, null);
  }
  
  @Override
  public void tick()
  {
    frames++;
    
    if(frames == 10)
    {
      frames = 0;
      index++;
      
      if(index >= 4)
      {
        index = 0;
      }
    }
  }
  
  @Override
  public void draw(SpriteBatch batch)
  {
    batch.draw(Textures.WATER.get(index), x, y, w, h);
  }
}