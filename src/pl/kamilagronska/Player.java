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

    //wartości przemieszcznia
    private float dx=0,dy=0;
    //aktualne współrzędne gracza
    private float px=x,py=y;

    private int score=0;

    //do obsługi myszy
    private ML ml;

    public Player(Graphics2D buf, int del, ML ml) {
        this.delay = del;
        this.buf = buf;
        this.ml = ml;

        color = Color.BLACK;
        shape = new Ellipse2D.Float(x,y,w,h);
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
    private Shape nextFrame(){
        area = new Area(area);
        transform = new AffineTransform();
        area.transform(transform);

        dx = ml.x - px;
        dy = ml.y-py;
        px = ml.x;
        py=ml.y;
        transform.translate(dx,dy);
        area.transform(transform);

        return area;
    }

    private void collectPoints(){
       /* for (Point point : AnimationPanel.points){
            if (shape.contains(point.x, point.y)){
                point.isTaken = true;
                score++;
                AnimationPanel.points.remove(point);
            }
        }*/
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buf.setColor(color);
        buf.fill(shape);
        /*buf.setColor(color.darker());
        buf.draw(shape);*/
    }
}
