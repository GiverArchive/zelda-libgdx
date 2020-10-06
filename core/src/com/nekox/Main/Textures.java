package com.nekox.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

public class Textures
{
  public static final ArrayList<TextureRegion> ENEMY_FEEDBACK =  new ArrayList<>();
  public static final ArrayList<TextureRegion> RIGHT_PLAYER =  new ArrayList<>();
  public static final ArrayList<TextureRegion> LEFT_PLAYER =  new ArrayList<>();
  public static final ArrayList<TextureRegion> DOWN_PLAYER =  new ArrayList<>();
  public static final ArrayList<TextureRegion> UP_PLAYER =  new ArrayList<>();
  public static final ArrayList<TextureRegion> ENEMY =  new ArrayList<>();
  public static final ArrayList<TextureRegion> WATER =  new ArrayList<>();
  
  public static TextureRegion playerFeedbackRight;
  public static TextureRegion playerFeedbackLeft;
  public static TextureRegion playerFeedbackDown;
  public static TextureRegion playerFeedbackUp;
  
  public static TextureRegion weaponRight;
  public static TextureRegion weaponLeft;
  public static TextureRegion weaponDown;
  public static TextureRegion weaponUp;
  
  public static TextureRegion lifePack;
  public static TextureRegion bullet;
  
  public static TextureRegion bricks;
  public static TextureRegion grass;
  
  public static void init()
  {
    TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("sprites/Spritesheet.atlas"));
    
    for(int i = 0; i < 24; i++)
    {
      RIGHT_PLAYER.add(atlas.findRegion("PlayerRight" + i));
      LEFT_PLAYER.add(atlas.findRegion("PlayerLeft" + i));
      DOWN_PLAYER.add(atlas.findRegion("PlayerDown" + i));
      UP_PLAYER.add(atlas.findRegion("PlayerUp" + i));
    }
    
    for(int i = 0; i < 4; i++)
    {
      ENEMY_FEEDBACK.add(atlas.findRegion("EnemyFeedback" + i));
      ENEMY.add(atlas.findRegion("Enemy" + i));
      WATER.add(atlas.findRegion("Water" + i));
    }
    
    playerFeedbackRight = atlas.findRegion("PlayerFeedbackRight");
    playerFeedbackLeft = atlas.findRegion("PlayerFeedbackLeft");
    playerFeedbackDown = atlas.findRegion("PlayerFeedbackDown");
    playerFeedbackUp = atlas.findRegion("PlayerFeedbackUp");
    
    weaponRight = atlas.findRegion("WeaponRight");
    weaponLeft = atlas.findRegion("WeaponLeft");
    weaponDown = atlas.findRegion("WeaponDown");
    weaponUp = atlas.findRegion("WeaponUp");
    
    lifePack = atlas.findRegion("Lifepack");
    bullet = atlas.findRegion("Bullet");
    bricks = atlas.findRegion("Bricks");
    grass = atlas.findRegion("Grass");
  }
}
