package xin.developer97.plane;

import xin.developer97.util.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Date;

public class Plane extends GameObject{
    private Image img ;
    private boolean live;
    private boolean left,up,right,down;
    private Date starTime;
    private Date endTime;

    private static Plane p = new Plane();

    public void drow(Graphics g){
        if (p.isLive()){
            g.drawImage(img,(int)x,(int)y,null);
        }

    }

    public void move(KeyEvent e){
        if (left){
            x -= speed;
        }
        if (right){
            x += speed;
        }
        if (up){
            y -= speed;
        }
        if (down){
            y += speed;
        }
    }

    public void changrDir(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                move(e);
                break;
            case KeyEvent.VK_UP:
                up = true;
                move(e);
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                move(e);
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                move(e);
                break;
        }
    }

    public void reDir(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                p.left = false;
                break;
            case KeyEvent.VK_UP:
                p.up = false;
                break;
            case KeyEvent.VK_RIGHT:
                p.right = false;
                break;
            case KeyEvent.VK_DOWN:
                p.down = false;
                break;
        }
    }


    public static Plane getPlane(String plane, double x, double y){
        p.img = GameUtil.getImage(plane);
        p.x = x;
        p.y = y;
        p.speed = 10;
        //用于通过getWidth方法无法获取宽高度，这里直接赋值
        p.width = 55;
        p.height = 44;
        p.live = true;
        return p;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }

    public Date getStarTime() {
        return starTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
