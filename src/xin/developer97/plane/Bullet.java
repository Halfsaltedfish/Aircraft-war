package xin.developer97.plane;

import xin.developer97.util.Constant;

import java.awt.*;

public class Bullet extends GameObject{

    double degree;

    public Bullet() {
        super(Constant.GAME_WIDTH/2,Constant.GAME_WIDTH/2,10,10);
        speed = 3;
        degree = Math.random()*Math.PI*2;
    }

    public void draw(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval((int)x,(int)y,width,height);

        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);

        //自动弹回
        if (x < width/2 || x> Constant.GAME_WIDTH - width*2){
            degree = Math.PI-degree;
        }
        if (y < height/2 + 25 || y > Constant.GAME_HEIGH-height*2){
            degree = -degree;
        }
        g.setColor(color);
    }
}
