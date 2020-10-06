package com.nekox.Entity;

import com.nekox.Main.Textures;

public class Bullet extends Entity
{
    public Bullet(int x, int y, int w, int h) {
        super(x, y, w, h, 0, Textures.bullet);
    }
}
