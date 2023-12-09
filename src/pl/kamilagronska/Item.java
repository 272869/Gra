package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;

public abstract class Item implements Runnable, ActionListener {

    protected Graphics2D buf;
    protected Area area;
    protected Shape shape;
    protected int delay;
    protected Color color;
    protected AffineTransform transform;
    protected int x,y;
    Random random = new Random();

    public Item(int delay, Graphics2D buf) {
        this.delay = delay;
        this.buf = buf;

    }
}
