package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Widok widok = new Widok();
        Kontroler kontroler = new Kontroler(model, widok);

        JFrame frame = new JFrame("Widok modulacji QAM16");
        frame.setContentPane(widok.getProgramField());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}