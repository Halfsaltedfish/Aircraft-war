package xin.developer97.plane;

import xin.developer97.util.GameUtil;

import java.awt.*;

public class Explode {
    double x,y;
    static Image[] imags = new Image[16];
    int count;
    static {
        for (int i =0;i < 16;i++){
            imags[i] = GameUtil.getImage("images/explode/e" + (i + 1) +".gif");
            imags[i].getWidth(null);
        }
    }

    public void draw(Graphics g){
        if (count<=15){
            g.drawImage(imags[count],(int)x,(int)y,null);
            count++;
        }

    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
