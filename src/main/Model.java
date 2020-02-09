package main;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Punkty punkty;
    private int licznik = 0;
    private int licznikPowtorzen = 1;
    private List<int[]> punktyList = new ArrayList<>();
    private Algorytm algorytm;


    public Model() {
        algorytm = new Algorytm();
    }

    public void wyczysc() {
        punktyList = new ArrayList<>();
        punkty = null;
        licznik = 0;
        licznikPowtorzen = 1; // wprowadzając liczbę powtórzeń, chcemy, aby np. 2=2, a nie 0,1,2==>3
    }


    public void pobierzPunkty() {
        if (licznik == 0) {
            this.punkty = algorytm.wygenerujPunkty();
        }
        int[] koordynaty = {punkty.getPos_x_tab()[licznik], punkty.getPos_y_tab()[licznik]};
        punktyList.add(koordynaty);
        licznik++;
        if (licznik > 6) {
            licznik = 0;
            licznikPowtorzen++;
        }
    }

    public int getLicznikPowtorzen() {
        return licznikPowtorzen;
    }

    public Punkty getPunkty() {
        return punkty;
    }

    public int getLicznik() {
        return licznik;
    }

    public List<int[]> getPunktyList() {
        return punktyList;
    }
}