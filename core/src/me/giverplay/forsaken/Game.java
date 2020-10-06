package me.giverplay.forsaken;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nekox.Main.GameController;

public class Game extends ApplicationAdapter
{
	private OrthographicCamera camera;
	private GameController game;
	private InputHandler input;
	private SpriteBatch batch;
	private Viewport viewport;
	
	private double unprocessed;
	private double nsTick;
	
	private long lastTime;
	private long timer;
	private long now;
	
	private int ticks;
	private int tps;
	
	@Override
  public void create()
  {
		Gdx.graphics.setResizable(false);
		Gdx.graphics.setWindowedMode(840, 480);
		
  	batch = new SpriteBatch();
  	input = new InputHandler(batch);
  	camera = new OrthographicCamera(840, 480);
  	viewport = new ScalingViewport(Scaling.stretch, 840, 840, camera);

  	//viewport = new FitViewport(840, 480, camera);
  	game = new GameController(input, camera);
  	
		lastTime = TimeUtils.nanoTime();
		timer = TimeUtils.millis();
		nsTick = 1_000_000_000 / 60.0D;
  }
	
	@Override
	public void dispose()
	{
		batch.dispose();
		System.gc();
	}
	
	@Override
  public void render()
  {
  	tick();
    clear();
  	draw();
  }
	
	private void tick()
	{
		now = TimeUtils.nanoTime();
		unprocessed += (now - lastTime) / nsTick;
		lastTime = now;
		
		while(unprocessed >= 1)
		{
			game.tick();
			++ticks;
			--unprocessed;
		}
		
		if(TimeUtils.millis() - timer >= 1000)
		{
			tps = ticks;
			ticks = 0;
			timer += 1000;
		}
	}
	
  private void clear()
	{
		Gdx.gl.glClearColor(0, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	private void draw()
	{
		game.render(batch);
		input.draw();
	}
}
