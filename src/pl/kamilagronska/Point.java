package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Point extends Item {
    private final int w = 20,h=20;
    private Color color;
    private int x=50,y=50;

    public Point(int delay, Graphics2D buf) {
        super(delay, buf);
        color = Color.CYAN;
        shape = new Rectangle(x,y,w,h);
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

    }
}
