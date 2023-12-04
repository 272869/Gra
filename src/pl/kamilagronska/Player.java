package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;


public class Player implements Runnable, ActionListener/*, KeyListener*/ {

    private final int w = 40,h=40;
    private int delay;
    private Graphics2D buf;

    private Color color;
    private Shape shape;
    private Area area;
    private AffineTransform transform;
    private int x=10,y=490;
    int x1 =x,y1=y;
    private int dx=10,dy=-10;

    //do obsługi myszy
    private ML ml;

    private boolean isPressed = false;

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public Player(Graphics2D buf, int del, ML ml) {
        this.delay = del;
        this.buf = buf;
        this.ml = ml;

        color = Color.BLACK;
        shape = new Ellipse2D.Float(x,y,20,20);
        transform = new AffineTransform();
        area = new Area(shape);


    }

    @Override
    public void run() {
        System.out.println("run playera");
        while (true) {
            // przygotowanie nastepnego kadru
            shape = nextFrame();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }

    }
    private Shape nextFrame(){//zmienić na podążanie gracza za myszką
        area = new Area(area);
        transform = new AffineTransform();
//        Rectangle bounds = area.getBounds();
        System.out.println(x1);
        if (x1<80){//zmoienić na aktualne współrzędne
            if (ml.mousePressed) {
                transform.translate(dx, dy);
                x1=x1+dx;
                y1=y1+dy;
            }else if (ml.mouseDragged){


            }else {
                if (y1<y){
                    transform.translate(dx,-dy);
                    y1 = y1 -dy;
                }else {
                    transform.translate(dx,0);

                }

            }
            area.transform(transform);

        }

        /*if (ml.mousePressed) {
            transform.translate(dx, dy);
            x1=x1+dx;
            y1=y1+dy;
        }else if (ml.mouseDragged){


        }else {
            if (y1<y){
                transform.translate(dx,-dy);
                y1 = y1 -dy;
            }else {
                transform.translate(dx,0);

            }

        }
        area.transform(transform);*/
        return area;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buf.setColor(color);
        buf.fill(shape);
        /*buf.setColor(color.darker());
        buf.draw(shape);*/
    }

/*    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("strzałka");
        if (e.getKeyCode() == KeyEvent.VK_UP){
            transform = new AffineTransform();
            area = new Area(area);
            transform.translate(dx,dy);
            area.transform(transform);
            isPressed = true;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
       *//* transform.translate(dx,-dy);*//*
        isPressed = false;
        System.out.println("strzałka koniec");

    }*/
}
