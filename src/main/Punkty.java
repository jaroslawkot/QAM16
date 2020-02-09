package main;

public class Punkty {
    private int[] bufor_tab;
    private int[] pos_x_tab;
    private int[] pos_y_tab;
    private int ciag;

    public Punkty(int[] bufor_tab, int[] pos_x_tab, int[] pos_y_tab, int ciag) {
        this.bufor_tab = bufor_tab;
        this.pos_x_tab = pos_x_tab;
        this.pos_y_tab = pos_y_tab;
        this.ciag = ciag;
    }

    public int[] getBufor_tab() {
        return bufor_tab;
    }

    public int[] getPos_x_tab() {
        return pos_x_tab;
    }

    public int[] getPos_y_tab() {
        return pos_y_tab;
    }

    public int getCiag() {
        return ciag;
    }
}