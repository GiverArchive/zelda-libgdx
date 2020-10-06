package com.nekox.Ui;

import com.badlogic.gdx.Gdx;
import com.nekox.Main.Arrays;
import com.nekox.Main.GameController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Ui {
    private static BufferedImage[] sprites = new BufferedImage[2];

    public Ui(){
        //sprites[0] = GameController.getSpriteSheet().getSprite(16, 112, 16, 16);
        //sprites[1] = GameController.getSpriteSheet().getSprite(16, 144, 16, 16);
    }

//    public void ui(Graphics graphics){
//        graphics.setFont(new Font("Arial", Font.BOLD, 30));
//        graphics.setColor(Color.BLUE);
//        graphics.drawString("FPS: " + Gdx.graphics.getFramesPerSecond(), 1, 27);
//
//        Graphics2D graphics2D = (Graphics2D) graphics;
//        graphics2D.setColor(new Color(0, 0, 0, 150));
//        graphics2D.fillRect(5, Size.getHEIGHTSCALEWITH() - 125, 200, 120);
//
//        graphics2D.setColor(new Color(255, 0, 0, 150));
//        graphics2D.fillRect(5, Size.getHEIGHTSCALEWITH() - 25, 200, 20);
//        graphics2D.setColor(Color.CYAN);
//        graphics2D.fillRect(5, Size.getHEIGHTSCALEWITH() - 25, GameController.getPlayer().getLife()*2, 20);
//
//        graphics2D.setColor(Color.MAGENTA);
//        graphics.drawImage(sprites[0], 1, Size.getHEIGHTSCALEWITH() - 130, 50, 50, null);
//        graphics.drawImage(sprites[1], 1, Size.getHEIGHTSCALEWITH() - 85, 50, 50, null);
//        graphics2D.drawString("= " + GameController.getPlayer().getAmmo(), 43, Size.getHEIGHTSCALEWITH() - 83);
//        graphics2D.drawString("= " + Arrays.getEnemies().size(), 43, Size.getHEIGHTSCALEWITH() - 43);
//    }
//
//    public void gamerOver(Graphics graphics){
//        Graphics2D graphics2D = (Graphics2D) graphics;
//        graphics2D.setColor(new Color(0, 0, 0, 200));
//        graphics2D.fillRect(0, 0, Size.getWIDTHSCALEWITH(), Size.getHEIGHTSCALEWITH());
//
//        graphics.setFont(new Font("Arial", Font.BOLD, 50));
//        graphics.setColor(Color.RED);
//        graphics.drawString("Game Over", (Size.getWIDTHSCALEWITH()/2) - 125, (Size.getHEIGHTSCALEWITH()/2) - 200);
//        graphics.setFont(new Font("Arial", Font.BOLD, 25));
//        graphics.setColor(Color.WHITE);
//        graphics.drawString("Pressione R para Reiniciar", (Size.getWIDTHSCALEWITH()/2) - 150, (Size.getHEIGHTSCALEWITH()/2) - 150);
//    }
}
