package org.tac.tests.java2d;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.Shape;

public class Rectangles extends JFrame
{
    private static final long serialVersionUID = 1L;

    public Rectangles() {
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        
        graphics2D.setPaint(Color.red);
        graphics2D.fillRect(100, 100, 100, 100);
    }

    public static void main(String args[]) {
        Rectangles application = new Rectangles();
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
