package com.company;

public class Main {

    public static void main(String[] args) {

        BinGrafCsP a = new BinGrafCsP(1);
        BinGrafCsP b = new BinGrafCsP(2);
        BinGrafCsP c = new BinGrafCsP(3);
        BinGrafCsP d = new BinGrafCsP(4);
        BinGrafCsP e = new BinGrafCsP(5);
        BinGrafCsP f = new BinGrafCsP(6);
        BinGrafCsP g = new BinGrafCsP(7);

        a.SetBal(b);
        a.SetJobb(f);
        b.SetBal(d);
        b.SetJobb(c);
        f.SetBal(e);
        f.SetJobb(g);


    }


}

class BinGrafCsP {
    private int adat;

    private BinGrafCsP jobb;

    private BinGrafCsP bal;

    private BinGrafCsP szulo;

    public BinGrafCsP(int adat) {
        this.adat = adat;
    }

    public void SetJobb(BinGrafCsP x) {
        this.jobb = x;
        x.szulo = this;
    }

    public void SetBal(BinGrafCsP x) {
        this.bal = x;
        x.szulo = this;
    }
}