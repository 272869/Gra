package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;


public class Player implements Runnable, ActionListener {

    private final int w = 40,h=40;
    private int delay;
    private Graphics2D buf;

    private Color color;
    private Shape shape;
    private Area area;
    private AffineTransform transform;
    private int x=10,y=490;

    public Player(Graphics2D buf, int del) {
        this.delay = del;
        this.buf = buf;

        color = Color.BLACK;
        shape = new Ellipse2D.Float(x,y,20,20);
        transform = new AffineTransform();
        area = new Area(shape);


    }

    @Override
    public void run() {
        /*transform.translate(10, 500);
        area.transform(transform);
        shape = area;*/
        System.out.println("run playera");
        //dodać

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buf.setColor(color);
        buf.fill(shape);
        buf.setColor(color.darker());
        buf.draw(shape);
    }
}
