package me.giverplay.forsaken;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by brentaureli on 10/23/15.
 */
public class InputHandler
{
  private final Viewport viewport;
  private final Stage stage;
  
  private boolean upPressed, downPressed, leftPressed, rightPressed, shoot;
  
  public InputHandler(SpriteBatch batch)
  {
    viewport = new FitViewport(840, 480, new OrthographicCamera());
    stage = new Stage(viewport, batch);
    
    stage.addListener(new InputListener()
    {
      @Override
      public boolean keyDown(InputEvent event, int keycode)
      {
        switch(keycode)
        {
          case Input.Keys.UP:
            upPressed = true;
            break;
          case Input.Keys.DOWN:
            downPressed = true;
            break;
          case Input.Keys.LEFT:
            leftPressed = true;
            break;
          case Input.Keys.RIGHT:
            rightPressed = true;
            break;
          case Input.Keys.NUM_0:
            shoot = true;
            break;
          
        }
        return true;
      }
      
      @Override
      public boolean keyUp(InputEvent event, int keycode)
      {
        switch(keycode)
        {
          case Input.Keys.UP:
            upPressed = false;
            break;
          case Input.Keys.DOWN:
            downPressed = false;
            break;
          case Input.Keys.LEFT:
            leftPressed = false;
            break;
          case Input.Keys.RIGHT:
            rightPressed = false;
            break;
          case Input.Keys.NUM_0:
            shoot = false;
            break;
        }
        return true;
      }
    });
    
    Gdx.input.setInputProcessor(stage);
    
    Table table = new Table();
    table.left().bottom();
    
    int ss = 75;
    
    Image upImg = new Image(new Texture("buttons/upArrow.png"));
    upImg.setSize(ss, ss);
    
    Image leftImg = new Image(new Texture("buttons/leftArrow.png"));
    leftImg.setSize(ss, ss);
    
    Image rightImg = new Image(new Texture("buttons/rightArrow.png"));
    rightImg.setSize(ss, ss);
    
    Image downImg = new Image(new Texture("buttons/downArrow.png"));
    downImg.setSize(ss, ss);
  
    Image shootImg = new Image(new Texture("buttons/upArrow.png"));
    shootImg.setSize(ss, ss);
  
    shootImg.addListener(new InputListener() {
    
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
      {
        shoot = true;
        return true;
      }
    
      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button)
      {
        shoot = false;
      }
    });
    
    upImg.addListener(new InputListener() {
      
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
      {
        upPressed = true;
        return true;
      }
      
      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button)
      {
        upPressed = false;
      }
    });
    
    
    downImg.addListener(new InputListener()    {
      
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
      {
        downPressed = true;
        return true;
      }
      
      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button)
      {
        downPressed = false;
      }
    });
    
    
    rightImg.addListener(new InputListener(){
      
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
      {
        rightPressed = true;
        return true;
      }
      
      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button)
      {
        rightPressed = false;
      }
    });
    
    
    leftImg.addListener(new InputListener(){
      
      @Override
      public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
      {
        leftPressed = true;
        return true;
      }
      
      @Override
      public void touchUp(InputEvent event, float x, float y, int pointer, int button)
      {
        leftPressed = false;
      }
    });
    
    table.add();
    table.add(upImg).size(upImg.getWidth(), upImg.getHeight());
    table.add();
    table.row().pad(5, 5, 5, 5);
    table.add(leftImg).size(leftImg.getWidth(), leftImg.getHeight());
    table.add();
    table.add(rightImg).size(rightImg.getWidth(), rightImg.getHeight());
    table.add().size(450, ss);
    table.add(shootImg).size(shootImg.getWidth(), shootImg.getHeight());
    table.row().padBottom(5);
    table.add();
    table.add(downImg).size(downImg.getWidth(), downImg.getHeight());
    table.add();
    
    stage.addActor(table);
  }
  
  public void draw()
  {
    stage.draw();
  }
  
  public boolean isUpPressed()
  {
    return upPressed;
  }
  
  public boolean isDownPressed()
  {
    return downPressed;
  }
  
  public boolean isLeftPressed()
  {
    return leftPressed;
  }
  
  public boolean isRightPressed()
  {
    return rightPressed;
  }
  
  public boolean isShootPressed()
  {
    return shoot;
  }
  
  public void resize(int width, int height)
  {
    viewport.update(width, height);
  }
}
