package main;

import javax.swing.*;

public class Widok {
    private JPanel programField;
    private Rysowanie rysowanie1;
    private JButton startPrzyciskUI;
    private JButton stopPrzyciskUI;
    private JLabel ciagUI;
    private JTextPane symboleUI;
    private JTextField powtorzeniaUI;
    private JTextField czasUI;

    private void createUIComponents() {
        rysowanie1 = new Rysowanie();
    }

    public JPanel getProgramField() {
        return programField;
    }

    public JButton getStartPrzyciskUI() {
        return startPrzyciskUI;
    }

    public JButton getStopPrzyciskUI() {
        return stopPrzyciskUI;
    }

    public JTextField getPowtorzeniaUI() {
        return powtorzeniaUI;
    }

    public JTextField getCzasUI() {
        return czasUI;
    }

    public Rysowanie getRysowanie1() {
        return rysowanie1;
    }

    public JLabel getCiagUI() {
        return ciagUI;
    }

    public JTextPane getSymboleUI() {
        return symboleUI;
    }
}
