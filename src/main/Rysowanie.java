package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Rysowanie extends JComponent {
    private int srednicaPunktu = 5;
    private List<int[]> punktyList = new ArrayList<>();

    @Override
    public void paintComponent(Graphics sim) {
        super.paintComponent(sim);
        Graphics2D qam = (Graphics2D) sim;
        qam.setColor(Color.BLACK);
        qam.drawLine(0, 100, 400, 100);
        qam.drawLine(0, 200, 400, 200);
        qam.drawLine(0, 300, 400, 300);

        qam.drawLine(100, 0, 100, 400);
        qam.drawLine(200, 0, 200, 400);
        qam.drawLine(300, 0, 300, 400);

        qam.drawString("0000", 5, 15);
        qam.drawString("0001", 105, 15);
        qam.drawString("0010", 205, 15);
        qam.drawString("0011", 305, 15);

        qam.drawString("0100", 5, 115);
        qam.drawString("0101", 105, 115);
        qam.drawString("0110", 205, 115);
        qam.drawString("0111", 305, 115);

        qam.drawString("1000", 5, 215);
        qam.drawString("1001", 105, 215);
        qam.drawString("1010", 205, 215);
        qam.drawString("1011", 305, 215);

        qam.drawString("1100", 5, 315);
        qam.drawString("1101", 105, 315);
        qam.drawString("1110", 205, 315);
        qam.drawString("1111", 305, 315);

        qam.setColor(Color.BLUE);

        for (int[] koordynaty : punktyList)
            qam.fillOval(koordynaty[0], koordynaty[1], srednicaPunktu, srednicaPunktu);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void setPunktyList(List<int[]> punktyList) {
        this.punktyList = punktyList;
    }
}
