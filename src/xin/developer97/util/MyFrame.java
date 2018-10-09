package xin.developer97.util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    /**
     * 加载窗口
     */

    //利用双缓冲解决屏幕闪烁
    private Image offScreenImage = null;
    public void update(Graphics g){
        if ((offScreenImage == null))
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGH);
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }

    public void  lunchFrame(){
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGH);
        setLocation(100,100);
        setVisible(true);

        new PaintThread().start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 定义一个重画窗口的线程类，是一个内部类
     */
    class PaintThread extends Thread{
        public  void run(){
            while (true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
