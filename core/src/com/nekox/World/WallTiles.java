package com.nekox.World;

import com.nekox.Main.Textures;

public class WallTiles extends Tile{
    public WallTiles(int x, int y, int w, int h) {
        super(x, y, w, h, Textures.bricks);
    }
}
