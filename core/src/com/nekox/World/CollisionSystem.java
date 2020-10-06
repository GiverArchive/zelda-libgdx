package com.nekox.World;

import com.badlogic.gdx.math.Rectangle;
import com.nekox.Entity.*;
import com.nekox.Main.Arrays;
import com.nekox.Main.GameController;

public class CollisionSystem {

    public boolean collisionWithWall(int x, int y, int maskSize, int spriteSize) {
        int[] XY = {x / spriteSize, y / spriteSize, (x + maskSize) / spriteSize, y / spriteSize,
                x / spriteSize, (y + maskSize) / spriteSize, (x + maskSize) / spriteSize, (y + maskSize) / spriteSize};

        return !(Map.tiles[XY[0] + (XY[1] * Map.getWIDTH())] instanceof WallTiles ||
                Map.tiles[XY[2] + (XY[3] * Map.getWIDTH())] instanceof WallTiles ||
                Map.tiles[XY[4] + (XY[5] * Map.getWIDTH())] instanceof WallTiles ||
                Map.tiles[XY[6] + (XY[7] * Map.getWIDTH())] instanceof WallTiles);
    }

    public boolean enemyCollisionWithEnemy(int x, int y, Enemy enemy) {
        Rectangle current = new Rectangle(x, y, enemy.getW(), enemy.getH());
        for (int i = 0; i < Arrays.getEnemies().size(); i++) {
            Enemy e = Arrays.getEnemies().get(i);
            if (e == enemy) {
                continue;
            }
            Rectangle enemies = new Rectangle(e.getX(), e.getY(), e.getW(), e.getH());
            if (current.overlaps(enemies)) {
                return true;
            }
        }
        return false;
    }

    public boolean collision(Entity e1, Entity e2) {
        Rectangle r1 = new Rectangle(e1.getX(), e1.getY(), e1.getW(), e1.getH());
        Rectangle r2 = new Rectangle(e2.getX(), e2.getY(), e2.getW(), e2.getH());
        return r1.overlaps(r2);
    }

    public void collisionWithItem() {
        for (int i = 0; i < Arrays.getEntities().size(); i++) {
            Entity e = Arrays.getEntities().get(i);
            if (collision(e, GameController.getPlayer())) {
                if (e instanceof LifePack) {
                    if (GameController.getPlayer().getLife() < 100){
                        Arrays.getEntities().remove(e);
                        GameController.getPlayer().setLife(GameController.getPlayer().getLife() + GameController.getRandom().nextInt(20));
                        if (GameController.getPlayer().getLife() >= 100){
                            GameController.getPlayer().setLife(100);
                        }
                    }
                } else if (e instanceof Bullet){
                    if (GameController.getPlayer().getAmmo() < 200){
                        Arrays.getEntities().remove(e);
                        GameController.getPlayer().setAmmo(GameController.getPlayer().getAmmo() + GameController.getPlayer().getAmmo() + 20);
                        if (GameController.getPlayer().getAmmo() > 200){
                            GameController.getPlayer().setAmmo(200);
                        }
                    }
                } else if (e instanceof Weapon){
                    Arrays.getEntities().remove(e);
                    GameController.getPlayer().setHasGun(true);
                    GameController.getPlayer().setAmmo(GameController.getPlayer().getAmmo() + GameController.getRandom().nextInt(15));
                    if (GameController.getPlayer().getAmmo() > 200){
                        GameController.getPlayer().setAmmo(200);
                    }
                }
            }
        }
    }
}
