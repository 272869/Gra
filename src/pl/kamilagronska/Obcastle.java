package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Obcastle extends Item {

    private final int w=30,h=30;
    private int dx=0,dy=0;


    public Obcastle(int delay, Graphics2D buf) {
        super(delay, buf);
        x=random.nextInt(600);
        y=20;
        color = Color.RED;
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
        while (true) {
            // przygotowanie nastepnego kadru
            shape = nextFrame();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }


    }

    public Shape nextFrame(){
        if (AnimationPanel.isIsRunning()) {
            dy = random.nextInt(10);
            transform = new AffineTransform();
            area = new Area(area);
            transform.translate(dx, dy);
            area.transform(transform);
        }
        return area;
    }
}
