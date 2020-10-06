package com.nekox.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nekox.Main.Arrays;
import com.nekox.Main.GameController;
import com.nekox.Main.Textures;
import com.nekox.World.CollisionSystem;

public class Enemy extends Entity
{
  private int index, frames, life = 10;
  private final CollisionSystem collisionSystem = new CollisionSystem();
  
  public Enemy(int x, int y, int w, int h, int speed)
  {
    super(x, y, w, h, speed, null);
  }
  
  @Override
  public void tick()
  {
    frames++;
    if(frames == 4)
    {
      frames = 0;
      index++;
      if(index >= 4)
      {
        index = 0;
      }
    }
    if(!collisionSystem.collision(this, GameController.getPlayer()))
    {
      if(GameController.getRandom().nextInt(100) > 70)
      {
        if(x < GameController.getPlayer().getX() && collisionSystem.collisionWithWall(x + speed, y, 14 * 3, 48)
            && !collisionSystem.enemyCollisionWithEnemy(x + speed, y, this))
        {
          x += speed;
        } else if(x > GameController.getPlayer().getX() && collisionSystem.collisionWithWall(x - speed, y, 14 * 3, 48)
            && !collisionSystem.enemyCollisionWithEnemy(x - speed, y, this))
        {
          x -= speed;
        }
        if(y < GameController.getPlayer().getY() && collisionSystem.collisionWithWall(x, y + speed, 14 * 3, 48)
            && !collisionSystem.enemyCollisionWithEnemy(x, y + speed, this))
        {
          y += speed;
        } else if(y > GameController.getPlayer().getY() && collisionSystem.collisionWithWall(x, y - speed, 14 * 3, 48)
            && !collisionSystem.enemyCollisionWithEnemy(x, y - speed, this))
        {
          y -= speed;
        }
      }
    } else
    {
      GameController.getPlayer().life();
    }
    bulletCollisionEnemy();
  }
  
  private void bulletCollisionEnemy()
  {
    for(int i = 0; i < Arrays.getBulletShoots().size(); i++)
    {
      BulletShoot bulletShoot = Arrays.getBulletShoots().get(i);
      if(collisionSystem.collision(bulletShoot, this))
      {
        Arrays.getBulletShoots().remove(bulletShoot);
        lostLife();
      }
    }
  }
  
  private void lostLife()
  {
    life -= 2;
    if(life <= 0)
    {
      Arrays.getEnemies().remove(this);
    }
  }
  
  @Override
  public void render(SpriteBatch batch)
  {
    batch.draw(Textures.ENEMY.get(index), getX(), getY(), w, h);
    
    //Graphics2D graphics2D = (Graphics2D) graphics;
   // graphics2D.setColor(new Color(225, 0, 0, 150));
   // graphics2D.fillRect(x - Camera.getX() - 2, y - Camera.getY(), 20, 5);
   // graphics2D.setColor(Color.BLUE);
   // graphics2D.fillRect(x - Camera.getX() - 2, y - Camera.getY(), life * 2, 5);
  }
}
