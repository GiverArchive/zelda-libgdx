package com.nekox.Main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nekox.Entity.BulletShoot;
import com.nekox.Entity.Enemy;
import com.nekox.Entity.Entity;
import com.nekox.Entity.Player;
import com.nekox.World.Map;
import java.util.ArrayList;
import java.util.Random;
import me.giverplay.forsaken.InputHandler;

public class GameController
{
  private static OrthographicCamera camera;
  private static InputHandler input;
  private static Player player;
  private static final Random random = new Random();
  
  private Map map;
  //private Ui ui = new Ui();
  private int level = 1;
  private static String state = "N";
  
  public GameController(InputHandler input, OrthographicCamera camera)
  {
    Textures.init();
    GameController.input = input;
    GameController.camera = camera;
    
    restartGame("map1");
  }
  
  public void tick()
  {
    if(state.equals("N"))
    {
      player.tick();
      
      for(int i = 0; i < Arrays.getEntities().size(); i++)
      {
        Arrays.getEntities().get(i).tick();
      }
      for(int i = 0; i < Arrays.getEnemies().size(); i++)
      {
        Arrays.getEnemies().get(i).tick();
      }
      for(int i = 0; i < Arrays.getBulletShoots().size(); i++)
      {
        Arrays.getBulletShoots().get(i).tick();
      }
      if(Arrays.getEnemies().size() <= 0)
      {
        if(level == 1)
        {
          level = 2;
        }
        restartGame("map" + level);
      }
      if(player.getLife() <= 0)
      {
        setState("G");
      }
    }
  }
  
  public void render(SpriteBatch batch)
  {
    camera.update();
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    
    if(state.equals("N") || state.equals("G"))
    {
      map.draw(batch);
      player.render(batch);
      
      for(int i = 0; i < Arrays.getEntities().size(); i++)
      {
        Arrays.getEntities().get(i).render(batch);
      }
      for(int i = 0; i < Arrays.getEnemies().size(); i++)
      {
        Arrays.getEnemies().get(i).render(batch);
      }
      for(int i = 0; i < Arrays.getBulletShoots().size(); i++)
      {
        Arrays.getBulletShoots().get(i).render(batch);
      }
    }

    /* TODO
    if(state.equals("N"))
    {
      ui.ui(graphics);
    } else if(state.equals("G"))
    {
      ui.gamerOver(graphics);
    }
    */
    
    batch.end();
  }
  
  private void restartGame(String path)
  {
    player = new Player(0, 0, 48, 48, 3);
    Arrays.setEntities(new ArrayList<Entity>());
    Arrays.setEnemies(new ArrayList<Enemy>());
    Arrays.setBulletShoots(new ArrayList<BulletShoot>());
    map = new Map(path);
  }
  
  public static OrthographicCamera getCamera()
  {
    return camera;
  }
  
  public static InputHandler getInput()
  {
    return input;
  }
  
  public static Player getPlayer()
  {
    return player;
  }
  
  public static Random getRandom()
  {
    return random;
  }
  
  public static void setState(String state)
  {
    GameController.state = state;
  }
}
