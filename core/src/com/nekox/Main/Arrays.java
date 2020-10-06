package com.nekox.Main;

import com.nekox.Entity.BulletShoot;
import com.nekox.Entity.Enemy;
import com.nekox.Entity.Entity;

import java.util.ArrayList;

public class Arrays {
    private static ArrayList<Enemy> enemies;
    private static ArrayList<Entity> entities;
    private static ArrayList<BulletShoot> bulletShoots;


    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    static void setEnemies(ArrayList<Enemy> enemies) {
        Arrays.enemies = enemies;
    }

    public static ArrayList<Entity> getEntities() {
        return entities;
    }

    static void setEntities(ArrayList<Entity> entities) {
        Arrays.entities = entities;
    }

    public static ArrayList<BulletShoot> getBulletShoots() {
        return bulletShoots;
    }

    static void setBulletShoots(ArrayList<BulletShoot> bulletShoots) {
        Arrays.bulletShoots = bulletShoots;
    }
}
