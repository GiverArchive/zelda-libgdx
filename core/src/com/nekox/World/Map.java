package com.nekox.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nekox.Entity.Bullet;
import com.nekox.Entity.Enemy;
import com.nekox.Entity.LifePack;
import com.nekox.Entity.Weapon;
import com.nekox.Main.Arrays;
import com.nekox.Main.GameController;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map
{
  private static int WIDTH, HEIGHT;
  public static Tile[] tiles;
  private BufferedImage map;
  
  public Map(String path)
  {
    // Hard coded maroto
    String dir;
    
    if(path.equals("map1"))
    {
      dir = "map1.txt";
      WIDTH = 50;
      HEIGHT = 50;
    }
    else
    {
      dir = "map2.txt";
      WIDTH = 100;
      HEIGHT = 100;
    }
  
    FileHandle file = Gdx.files.internal(dir);
  
    BufferedReader reader = new BufferedReader(file.reader());
    String line = null;
    
    try
    {
      line = reader.readLine();
      reader.close();
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  
    List<Tile> list = decode(line);
    tiles = new Tile[list.size()];
    
    for(Tile tile : list)
    {
      int xx = tile.getX() / 48;
      int yy = tile.getY() / 48;
      
      tiles[xx + yy * WIDTH] = tile;
    }
  }
  
  private List<Tile> decode(String line)
  {
    List<Tile> list = new ArrayList<>();
    
    String[] section = line.split(";");
    
    for(String s : section)
    {
      if(s.length() < 1)
      {
        continue;
      }
      
      try
      {
        String[] child = s.split(":");
  
        int x = Integer.parseInt(child[0]);
        int y = Integer.parseInt(child[1]);
        String type = child[2];
        
        switch(type.toLowerCase())
        {
          case "grass":
            list.add(new FloorTiles(x * 48, y * 48, 48, 48));
            break;
            
          case "wall":
            list.add(new WallTiles(x * 48, y * 48, 48, 48));
            break;
            
          case "enemy":
            list.add(new FloorTiles(x * 48, y * 48, 48, 48));
            Arrays.getEnemies().add(new Enemy(x * 48, y * 48, 48, 48, 2));
            break;
            
          case "player":
            list.add(new FloorTiles(x * 48, y * 48, 48, 48));
            GameController.getPlayer().setX(x * 48);
            GameController.getPlayer().setY(y * 48);
            break;
            
          case "lifepack":
            list.add(new FloorTiles(x * 48, y * 48, 48, 48));
            Arrays.getEntities().add(new LifePack(x * 48, y * 48, 48, 48));
            break;
            
          case "weapon":
            list.add(new FloorTiles(x * 48, y * 48, 48, 48));
            Arrays.getEntities().add(new Weapon(x * 48, y * 48, 48, 48));
            break;
            
          case "bullet":
            list.add(new FloorTiles(x * 48, y * 48, 48, 48));
            Arrays.getEntities().add(new Bullet(x * 48, y * 48, 48, 48));
            break;
            
          default:
            list.add(new FloorTiles(x * 48, y * 48, 48, 48));
            break;
        }
      }
      catch(Exception e)
      {
        System.out.println(s);
        e.printStackTrace();
        list.add(new Tile(0, 0, 0, 0, null));
      }
    }
    
    return list;
  }
  
  public void draw(SpriteBatch batch)
  {
    for(int i = 0; i < tiles.length; i++)
    {
      Tile tile = tiles[i];
      tile.tick();
      tile.draw(batch);
    }
  }
  
  public static int getWIDTH()
  {
    return WIDTH;
  }
  
  public static int getHEIGHT()
  {
    return HEIGHT;
  }
}
