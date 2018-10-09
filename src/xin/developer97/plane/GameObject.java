package xin.developer97.plane;

import java.awt.*;

public class GameObject {
    double x,y;
    int speed ;
    int width,height;

    public GameObject() {
    }

    public GameObject(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
