package main;

import java.util.Random;

public class Algorytm {

    public Punkty wygenerujPunkty() {
        int i, j, bufor, bufor_x, bufor_y, bufor_wskaznik;
        int[] bufor_tab = new int[7]; //tablica przechowująca bufor
        int[] pos_x_tab = new int[7]; //inicjalizacja tablicy przechowującej koordynaty x
        int[] pos_y_tab = new int[7]; //inicjalizacja tablicy przechowującej koordynaty y
        int ciag_wskaznik = 0x8000000; //inicjalizacja ciągu do modulatora
        int ciag;// 0x7FFFFFFF maksymalna wielkosc int dla liczb dodatnich
        int szumWartosc;
        Random generator = new Random();
        ciag = generator.nextInt(0xFFFFFFF);
        Random szum = new Random();

        System.out.println("Wchodząca wartość w hex: " + Integer.toHexString(ciag));
        System.out.println("Wchodząca wartość w bin: " + Integer.toBinaryString(ciag));

        //if blokujacy przekroczenie zakresu

        for (i = 0; i < 7; i++) //pętla napęłniająca 7 buforów do tablicy
        {
            bufor = 0;
            for (j = 0; j < 4; j++) //pętla budująca pojedyczy bufor
            {
                if ((ciag & ciag_wskaznik) == ciag_wskaznik) {
                    bufor = bufor + (int) Math.pow(2, (3 - j));
                }
                ciag_wskaznik = ciag_wskaznik >> 1;
            }
            bufor_tab[i] = bufor;
        }

        for (i = 0; i < 7; i++) //pętla wybierająca koordynaty punktu na konstelacji
        {
            System.out.println("Wartość tablicy dla bufora " + i + " = " + Integer.toBinaryString(bufor_tab[i]));
            bufor_x = 0;
            bufor_wskaznik = 0x8;
            for (j = 0; j < 2; j++) //koordynat x
            {
                if ((bufor_tab[i] & bufor_wskaznik) == bufor_wskaznik) {
                    bufor_x = bufor_x + (int) Math.pow(2, (1 - j));
                }
                bufor_wskaznik = bufor_wskaznik >> 1;
            }
            //TimeUnit.SECONDS.sleep(1);
            switch (bufor_x) {
                case 0: //00xx
                    szumWartosc = szum.nextInt(20);
                    pos_x_tab[i] = 45 + szumWartosc - 10;
                    System.out.printf("Koordynat x (00) wynosi wartość: " + pos_x_tab[i] + ", ");
                    break;
                case 1: //01xx
                    szumWartosc = szum.nextInt(20);
                    pos_x_tab[i] = 145 + szumWartosc - 10;
                    ;
                    System.out.printf("Koordynat x (01) wynosi wartość: " + pos_x_tab[i] + ", ");
                    break;
                case 2: //10xx
                    szumWartosc = szum.nextInt(20);
                    pos_x_tab[i] = 245 + szumWartosc - 10;
                    System.out.printf("Koordynat x (10) wynosi wartość: " + pos_x_tab[i] + ", ");
                    break;
                case 3: //11xx
                    szumWartosc = szum.nextInt(20);
                    pos_x_tab[i] = 345 + szumWartosc - 10;
                    System.out.printf("Koordynat x (11) wynosi wartość: " + pos_x_tab[i] + ", ");
                    break;
            }
            bufor_y = 0;
            for (j = 0; j < 2; j++) // koordynat y
            {
                if ((bufor_tab[i] & bufor_wskaznik) == bufor_wskaznik) {
                    bufor_y = bufor_y + (int) Math.pow(2, (1 - j));
                }
                bufor_wskaznik = bufor_wskaznik >> 1;
            }

            switch (bufor_y) {
                case 0: //xx00
                    szumWartosc = szum.nextInt(20);
                    pos_y_tab[i] = 45 + szumWartosc - 10;
                    System.out.println("Koordynat y (00) wynosi wartość: " + pos_y_tab[i] + " ");
                    break;
                case 1: //xx01
                    szumWartosc = szum.nextInt(20);
                    pos_y_tab[i] = 145 + szumWartosc - 10;
                    System.out.println("Koordynat y (01) wynosi wartość: " + pos_y_tab[i] + " ");
                    break;
                case 2: //xx10
                    szumWartosc = szum.nextInt(20);
                    pos_y_tab[i] = 245 + szumWartosc - 10;
                    System.out.println("Koordynat y (10) wynosi wartość: " + pos_y_tab[i] + " ");
                    break;
                case 3: //xx11
                    szumWartosc = szum.nextInt(20);
                    pos_y_tab[i] = 345 + szumWartosc - 10;
                    System.out.println("Koordynat y (11) wynosi wartość: " + pos_y_tab[i] + " ");
                    break;
            }
        }
        return new Punkty(bufor_tab, pos_x_tab, pos_y_tab, ciag);
    }
}