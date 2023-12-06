package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public abstract class Item implements Runnable, ActionListener {

    protected Graphics2D buf;
    protected Area area;
    protected Shape shape;
    protected int delay;
    protected AffineTransform transform;

    public Item(int delay, Graphics2D buf) {
        this.delay = delay;
        this.buf = buf;

    }
}
