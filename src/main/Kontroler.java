package main;

public class Kontroler {
    private boolean stanDzialania;
    private int max_powt;
    private int sleep;
    private int POWT_LIMIT = 250; //wyznaczony symulacyjnie limit, dla którego rysowanie na konstelacji ma znaczenie

    private Model model;
    private Widok widok;

    public Kontroler(Model model, Widok widok) {
        this.model = model;
        this.widok = widok;
        widok.getStartPrzyciskUI().addActionListener(actionEvent -> start());
        widok.getStopPrzyciskUI().addActionListener(actionEvent -> stop());
    }

    private void start() {
        if (!stanDzialania) {
            try {
                max_powt = Integer.parseInt(widok.getPowtorzeniaUI().getText());
                sleep = Integer.parseInt(widok.getCzasUI().getText());
                if (max_powt > POWT_LIMIT) {
                    return;
                }
            } catch (NumberFormatException ex) {
                return;
            }
            stanDzialania = true;
            model.wyczysc();
            odswiezWidok();
            zacznijPetle();
            widok.getStartPrzyciskUI().setEnabled(false);
        }
    }

    private void stop() {
        stanDzialania = false;
        widok.getStartPrzyciskUI().setEnabled(true);
    }

    private void pojedynczyKrok() {
        model.pobierzPunkty();
        if (model.getLicznikPowtorzen() > max_powt) {
            stanDzialania = false;
            widok.getStartPrzyciskUI().setEnabled(true);
            return;
        }
        odswiezWidok();
    }

    private void zacznijPetle() {
        new Thread(() -> {
            while (stanDzialania) {
                try {
                    Thread.sleep(sleep);
                    pojedynczyKrok();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public void odswiezWidok() {
        if (model.getPunkty() != null) {
            widok.getCiagUI().setText("Obecny ciąg: " + Integer.toHexString(model.getPunkty().getCiag()));
        } else {
            widok.getCiagUI().setText("");
        }
        int licznik = model.getLicznik();
        if (licznik == 0)
            widok.getSymboleUI().setText("");
        else {
            String punktyListString = widok.getSymboleUI().getText();
            punktyListString += "Symbol: " + Integer.toBinaryString(model.getPunkty().getBufor_tab()[licznik]) + "\n";
            widok.getSymboleUI().setText(punktyListString);
        }
        widok.getRysowanie1().setPunktyList(model.getPunktyList());
        widok.getRysowanie1().repaint();
    }

}