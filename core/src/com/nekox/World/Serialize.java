package com.nekox.World;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.imageio.ImageIO;

public class Serialize
{
  // Apenas desktop
  public static void serialize() throws Throwable
  {
    BufferedImage map1, map2;
    
    map1 = ImageIO.read(Serialize.class.getResource("/sprites/map1.png"));
    map2 = ImageIO.read(Serialize.class.getResource("/sprites/map2.png"));
    
    BufferedWriter w1 = new BufferedWriter(new FileWriter(new File("D:\\", "map1.txt")));
    BufferedWriter w2 = new BufferedWriter(new FileWriter(new File("D:\\", "map2.txt")));
    
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    
    int[] pixels1 = new int[map1.getWidth() * map1.getHeight()];
    map1.getRGB(0, 0, map1.getWidth(), map1.getHeight(),pixels1, 0, map1.getWidth());
    
    int[] pixels2 = new int[map2.getWidth() * map2.getHeight()];
    map2.getRGB(0, 0, map2.getWidth(), map2.getHeight(),pixels2, 0, map2.getWidth());
    
    for(int x = 0; x < map1.getWidth(); x++)
    {
      for(int y = 0; y < map1.getHeight(); y++)
      {
        int pixel = pixels1[x + y * map1.getWidth()];
        sb1.append(getComponent(x, y, pixel));
        sb1.append(";");
      }
    }
    
    for(int x = 0; x < map2.getWidth(); x++)
    {
      for(int y = 0; y < map2.getHeight(); y++)
      {
        int pixel = pixels2[x + y * map2.getWidth()];
        sb2.append(getComponent(x, y, pixel));
        sb2.append(";");
      }
    }
    
    w1.write(sb1.toString());
    w2.write(sb2.toString());
    
    w1.close();
    w2.close();
  }
  
  public static String getComponent(int x, int y, int pixel)
  {
    StringBuilder sb = new StringBuilder();
    sb.append(x).append(":").append(y).append(":");
    
    switch(pixel)
    {
      case 0xFF000000: //Grama
        sb.append("grass");
        break;
      case 0xFF00FFFF: //Água
        sb.append("water");
        break;
      case 0xFFFFFFFF: //parede
        sb.append("wall");
        break;
      case 0xFF0026FF: //Player
        sb.append("player");
        break;
      case 0xFFFF0000: //Inimigo
        sb.append("enemy");
        break;
      case 0xFFFFD800: //Metralhadora
        sb.append("weapon");
        break;
      case 0xFFFF6A00: // Munição
        sb.append("bullet");
        break;
      case 0xFFB200FF: // Vida
        sb.append("lifepack");
        break;
      default:
        sb.append("grass");
        break;
    }
    
    return sb.toString();
  }
}
