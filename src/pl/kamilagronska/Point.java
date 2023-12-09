package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Point extends Item {
    private final int w = 20,h=20;
    public boolean isTaken = false;


    public Point(int delay, Graphics2D buf) {
        super(delay, buf);
        x=random.nextInt(600);
        y=random.nextInt(600);
        color = Color.CYAN;
        shape = new Ellipse2D.Float(x,y,w,h);
        transform = new AffineTransform();
        area = new Area(shape);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buf.setColor(color);
        buf.fill(shape);
    }

    @Override
    public void run() {
//        if (isTaken){
//            buf.clearRect(x,y,w,h);
//        }


    }
}
