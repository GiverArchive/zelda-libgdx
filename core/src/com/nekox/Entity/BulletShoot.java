package com.nekox.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nekox.Main.Arrays;
import com.nekox.World.CollisionSystem;

public class BulletShoot extends Entity {
    private final int dX;
    private final int dY;

    public BulletShoot(int x, int y, int w, int h, int dx, int dy, int speed) {
        super(x, y, w, h, speed, null);
        this.dX = dx;
        this.dY = dy;
    }

    @Override
    public void tick() {
        x += dX * speed;
        y += dY * speed;

        if (!new CollisionSystem().collisionWithWall(x, y, 2, 48)){
            Arrays.getBulletShoots().remove(this);
        }
    }

    @Override
    public void render(SpriteBatch batch)
    {
        Pixmap pix = new Pixmap(w, h, Pixmap.Format.RGB565);
        pix.setColor(Color.YELLOW);
        pix.fillRectangle(x, y, w, h);
        
        batch.draw(new Texture(pix), x, y, w, h);
    }
}
