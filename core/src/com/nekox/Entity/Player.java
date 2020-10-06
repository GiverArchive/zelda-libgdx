package com.nekox.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nekox.Main.Arrays;
import com.nekox.Main.GameController;
import com.nekox.Main.Textures;
import com.nekox.World.CollisionSystem;
import me.giverplay.forsaken.InputHandler;

public class Player extends Entity
{
  private final CollisionSystem collisionSystem = new CollisionSystem();
  private final InputHandler input = GameController.getInput();
  private final Sound bullet = Gdx.audio.newSound(Gdx.files.internal("Sounds/Bow_Fire.wav"));
  
  private boolean hasGun;
  
  private long lastShoot = System.currentTimeMillis();
  
  private int position = 1, index, frames, life = 100, ammo;
  
  public Player(int x, int y, int w, int h, int speed)
  {
    super(x, y, w, h, speed, null);
  }
  
  @Override
  public void tick()
  {
    boolean moved = false;
    if(input.isUpPressed() && collisionSystem.collisionWithWall(x, y + speed, 45, 48))
    {
      position = 0;
      moved = true;
      this.y += speed;
    } else if(input.isDownPressed() && collisionSystem.collisionWithWall(x, y - speed, 45, 48))
    {
      position = 1;
      moved = true;
      this.y -= speed;
    }
    if(input.isLeftPressed() && collisionSystem.collisionWithWall(x - speed, y, 45, 48))
    {
      position = 2;
      moved = true;
      this.x -= speed;
    } else if(input.isRightPressed() && collisionSystem.collisionWithWall(x + speed, y, 45, 48))
    {
      position = 3;
      moved = true;
      this.x += speed;
    }
    if(moved)
    {
      frames++;
      if(frames == 2)
      {
        frames = 0;
        index++;
        if(index >= 24)
        {
          index = 0;
        }
      }
    }
    
    collisionSystem.collisionWithItem();
    
    if(input.isShootPressed() && ammo > 0 && hasGun)
    {
      if(System.currentTimeMillis() - lastShoot < 250)
      {
        return;
      }
      
      lastShoot = System.currentTimeMillis();
      int pX = 0, pY = 0, dX = 0, dY = 0, w = 0, h = 0;
      ammo--;
      bullet.play();
      
      switch(position)
      {
        case 0:
          pX = 7 * 3;
          pY = 24 * 3;
          dX = 0;
          dY = +2;
          w = 1;
          h = 2;
          break;
        case 1:
          pX = 7 * 3;
          pY = -7 * 3;
          dX = 0;
          dY = -2;
          w = 1;
          h = 2;
          break;
        case 2:
          pX = -7 * 3;
          pY = 7 * 3;
          dX = -2;
          dY = 0;
          w = 2;
          h = 1;
          break;
        case 3:
          pX = 24 * 3;
          pY = 7 * 3;
          dX = 2;
          dY = 0;
          w = 2;
          h = 1;
          break;
      }
      
      Arrays.getBulletShoots().add(new BulletShoot(x + pX, y + pY, w * 3, h * 3, dX, dY, 5));
    }
  
    OrthographicCamera camera = GameController.getCamera();
    
//    int sw = Gdx.graphics.getWidth() / 3;
//    int sh = Gdx.graphics.getHeight() / 3;
//    int cx = clamp(getX() - (sw / 2),sw / 2,Map.getWIDTH() * 48 - sw);
//    int cy = clamp(getY() - (sh / 2),sh / 2, Map.getHEIGHT() * 48 - sh);
  
    camera.position.set(getX(), getY(), 0);
    camera.update();
  }
  
  public static int clamp(int c, int min, int max)
  {
    if(c < min)
    {
      c = min;
    }
    
    if(c > max)
    {
      c = max;
    }
    
    return c;
  }
  
  public void life()
  {
    if(GameController.getRandom().nextInt(100) < 11)
    {
      life -= GameController.getRandom().nextInt(3);
    }
  }
  
  @Override
  public void render(SpriteBatch batch)
  {
    switch(position)
    {
      case 0:
        if(hasGun)
        {
          batch.draw(Textures.weaponUp, x, y + 10, w, h);
        }
        batch.draw(Textures.UP_PLAYER.get(index), x, y, w, h);
        break;
      case 1:
        batch.draw(Textures.DOWN_PLAYER.get(index), x, y, w, h);
        if(hasGun)
        {
          batch.draw(Textures.weaponDown, x, y - 10, w, h);
        }
        break;
      case 2:
        batch.draw(Textures.LEFT_PLAYER.get(index), x, y, w, h);
        if(hasGun)
        {
          batch.draw(Textures.weaponLeft, x - 10, y, w, h);
        }
        break;
      case 3:
        batch.draw(Textures.RIGHT_PLAYER.get(index), x, y, w, h);
        if(hasGun)
        {
          batch.draw(Textures.weaponRight, x + 10, y, w, h);
        }
        break;
    }
  }
  
  public void setXeY(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  public int getLife()
  {
    return life;
  }
  
  public void setLife(int life)
  {
    this.life = life;
  }
  
  public int getAmmo()
  {
    return ammo;
  }
  
  public void setAmmo(int ammo)
  {
    this.ammo = ammo;
  }
  
  public void setHasGun(boolean hasGun)
  {
    this.hasGun = hasGun;
  }
}
