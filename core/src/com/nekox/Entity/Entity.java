package com.nekox.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Entity {
    protected TextureRegion texture;
    protected int x, y, w, h, speed;

    public Entity(int x, int y, int w, int h, int speed, TextureRegion texture){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speed = speed;
        this.texture = texture;
    }
    
    public void tick(){}
    
    public void render(SpriteBatch batch){
        batch.draw(texture, getX(), y, w, h);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
