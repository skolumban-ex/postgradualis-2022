package com.company;

public class Main {

    public static void main(String[] args) {
        PadtarsKapcsolatGraf g = new PadtarsKapcsolatGraf();
        int aksdjf = 0;
    }
}

class PadtarsKapcsolatGraf {

    private Diak[] diakok;

    public PadtarsKapcsolatGraf() {
        diakok = new Diak[3];

        Diak d0 = new Diak("Pista", 0);
        Diak d1 = new Diak("Juli", 1);
        Diak d2 = new Diak("Agi", 2);

        diakok[0] = d0;
        diakok[1] = d1;
        diakok[2] = d2;

        padtarsHozzaad(0, 2);
        padtarsHozzaad(0, 1);

    }

    public void padtarsHozzaad(int i, int j) {
        diakok[i].PadtarsHozzaad(j);
        diakok[j].PadtarsHozzaad(i);
    }

}

class Diak {
    private String nev;
    private int id;
    private int[] voltPadtarsak;

    public Diak(String nev, int id) {
        this.nev = nev;
        this.id = id;
        this.voltPadtarsak = new int[0];
    }

    public void PadtarsHozzaad(int ujPadtarsId) {
        int[] ujPadtarsak = new int[voltPadtarsak.length + 1];
        for (int j = 0; j < voltPadtarsak.length; j++) {
            ujPadtarsak[j] = voltPadtarsak[j];
        }
        ujPadtarsak[ujPadtarsak.length - 1] = ujPadtarsId;
        voltPadtarsak = ujPadtarsak;
    }
}
