package xin.developer97.plane;

import xin.developer97.util.Constant;
import xin.developer97.util.GameUtil;
import xin.developer97.util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

public class PlaneGameFrame extends MyFrame {
    Image bg = GameUtil.getImage("images/bg.jpg");
    Plane p = Plane.getPlane("images/plane.png",50,50);
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    Explode explode = null;

    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
        p.drow(g);


        for (int i = 0;i < bullets.size();i++){
            Bullet bullet = (Bullet)bullets.get(i);
            bullet.draw(g);

            //检测跟飞机的碰撞
            boolean boom = bullet.getRect().intersects(p.getRect());
            if (boom){
                p.setLive(false);

                if (explode == null){
                    p.setEndTime(new Date());
                    explode = new Explode(p.x,p.y);
                }
                explode.draw(g);
            }
            if (!p.isLive()){
                int period = (int)(p.getEndTime().getTime() - p.getStarTime().getTime())/1000;
                printfInfo(g,"GAME OVER",100,100,200,Color.WHITE);
                printfInfo(g,"生存时间"+period+"秒",20,120,260,Color.ORANGE);
                switch (period/10){
                    case 0:
                    case 1:
                        printfInfo(g,"菜鸟",30,120,300,Color.WHITE);
                        break;
                    case 2:
                        printfInfo(g,"小鸟",30,120,300,Color.WHITE);
                        break;
                    case 3:
                        printfInfo(g,"大鸟",30,120,300,Color.WHITE);
                        break;
                    case 4:
                        printfInfo(g,"鸵鸟",30,120,300,Color.WHITE);
                        break;
                    default:
                        printfInfo(g,"鸟人",30,120,300,Color.WHITE);
                        break;
                }
            }
        }
    }

    public void printfInfo(Graphics g,String str,int size,int x,int y,Color color){
        Color c = g.getColor();
        g.setColor(color);
        Font font = new Font("微软雅黑",Font.BOLD,size);
        g.setFont(font);
        g.drawString(str,x,y);
        g.setColor(c);
    }

    public static void main(String[] args) {
        new  PlaneGameFrame().lunchFrame();
    }

    public void lunchFrame(){
        super.lunchFrame();
        //增加键盘监听
        addKeyListener(new KeyMonitor());
        p.setStarTime(new Date());

        //生成一堆子弹
        for (int i = 0;i < 30;i++){
            Bullet bullet = new Bullet();
            bullets.add(bullet);
        }
    }

    //定义为内部类，可以方便的使用外部类的普通属性
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("按下："+e.getKeyCode());
            p.changrDir(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
//            System.out.println("释放："+e.getKeyCode());
            p.reDir(e);
        }
    }
}
