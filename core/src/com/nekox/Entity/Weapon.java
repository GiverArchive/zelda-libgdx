package com.nekox.Entity;

import com.nekox.Main.Textures;

public class Weapon extends Entity{
    public Weapon(int x, int y, int w, int h) {
        super(x, y, w, h, 0, Textures.weaponRight);
    }
}
