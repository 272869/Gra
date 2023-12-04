package pl.kamilagronska;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public abstract class Obstacle implements Runnable, ActionListener {

    protected Graphics2D buf;
    protected Area area;
    protected Shape shape;
    protected AffineTransform transform;


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
