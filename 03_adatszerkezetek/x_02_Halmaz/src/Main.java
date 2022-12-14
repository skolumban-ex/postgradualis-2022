public class Main {
    public static void main(String[] args) {
        // 16/2. Implementálja a halmaz adattípust
        //• statikus tömbök használatával,
        //• dinamikus tömbök használatával,
        //• dinamikus tömbök használatával, de hatékonyan (számokra).

        StringHalmazDinamikusTombbel halmaz1 = new StringHalmazDinamikusTombbel();
        StringHalmazDinamikusTombbel halmaz2 = new StringHalmazDinamikusTombbel();

        halmaz1.HozzaAd("alma"); //{a}
        halmaz1.HozzaAd("korte"); //{a,k}
        halmaz1.HozzaAd("banan"); //{a,k,b}
        halmaz1.HozzaAd("eper"); //{a,k,b,e}
        halmaz1.Kivesz("banan"); //{a,k,e}

        halmaz2.HozzaAd("2"); // {2}
        halmaz2.HozzaAd("3"); // {2,3}
        halmaz2.HozzaAd("3"); // {2,3}
        halmaz2.HozzaAd("3"); // {2,3}

        halmaz1.HozzaAd("c"); //{a,k,e,c}
        halmaz1.HozzaAd("d"); //{a,k,e,c,d}
        halmaz1.HozzaAd("2"); //{a,k,e,c,d, 2}
        halmaz1.Kivesz("eper"); // {a,k,c,d}
        StringHalmazDinamikusTombbel halmaz3 = halmaz1.Egyesit(halmaz2); //{k,e, c,d, 2,3}
        StringHalmazDinamikusTombbel h1Minh2 = halmaz1.Kivon(halmaz2); // {k,e}
        halmaz3.Metszet(halmaz2);
        halmaz3.Urit();
        halmaz3.BenneVan("2");
        halmaz3.uresE();
    }
}

class StringHalmazStatikusTombbel {
    private String[] taroltErtekek;

    public StringHalmazStatikusTombbel() {
        taroltErtekek = new String[0];
    }

    // nem bent levo elem eseten O(n) + O(n + 2)
    public boolean HozzaAd(String elem) {
        // O(n)
        if (BenneVan(elem))
            return false;

        // O(1)
        String[] ujTaroltErtekek = new String[this.taroltErtekek.length + 1];
        // O(n)
        for (int i = 0; i < this.taroltErtekek.length; i++) {
            ujTaroltErtekek[i] = this.taroltErtekek[i];
        }
        // O(1)
        ujTaroltErtekek[ujTaroltErtekek.length - 1] = elem;
        this.taroltErtekek = ujTaroltErtekek;
        return true;
    }

    public int Szamossag() {
        return taroltErtekek.length;
    }

    public boolean Kivesz(String elem) {
        if (!BenneVan(elem))
            return false;

        String[] ujTaroltElemek = new String[taroltErtekek.length - 1];
        boolean atugrottukeMarAkivevendot = false;
        for (int i = 0; i < taroltErtekek.length; i++) {
            if (taroltErtekek[i].equals(elem)) {
                atugrottukeMarAkivevendot = true;
                continue;
            }

            if (!atugrottukeMarAkivevendot)
                ujTaroltElemek[i] = taroltErtekek[i];
            else
                ujTaroltElemek[i - 1] = taroltErtekek[i];
        }
        taroltErtekek = ujTaroltElemek;
        return true;
    }

    public StringHalmazStatikusTombbel Kivon(StringHalmazStatikusTombbel kivonando) {
        // minden elemet beteszek az aktualis halmazbol
        // majd kivesszuk a kivonando elemeit

        StringHalmazStatikusTombbel eredmeny = new StringHalmazStatikusTombbel();
        for (int i = 0; i < this.taroltErtekek.length; i++) {
            eredmeny.HozzaAd(this.taroltErtekek[i]);
        }

        for (int i = 0; i < kivonando.taroltErtekek.length; i++) {
            eredmeny.Kivesz(kivonando.taroltErtekek[i]);
        }
        return eredmeny;
    }

    public StringHalmazStatikusTombbel Egyesit(StringHalmazStatikusTombbel halmaz) {
        StringHalmazStatikusTombbel eredmeny = new StringHalmazStatikusTombbel();

        // az összes elem megjelenik benne (csak egyszer)
        // ami legalabb az egyik halmazban benne van
        // O(n1 negyzet)
        for (int i = 0; i < this.taroltErtekek.length; i++) {
            eredmeny.HozzaAd(this.taroltErtekek[i]);
        }

        // O(n2 negyzet)
        for (int i = 0; i < halmaz.taroltErtekek.length; i++) {
            eredmeny.HozzaAd(halmaz.taroltErtekek[i]);
        }

        return eredmeny;
    }

    public StringHalmazStatikusTombbel Metszet(StringHalmazStatikusTombbel metszendo) {
        // az eredmeny halmaz elemei a this es a metszendoben is benne kell legyenek
        // az aktualis halmaz elemeit megnezzuk, hogy benne vannak-e
        // a metszendoben
        StringHalmazStatikusTombbel metszet = new StringHalmazStatikusTombbel();
        for (int i = 0; i < this.taroltErtekek.length; i++) {
            if (metszendo.BenneVan(this.taroltErtekek[i]))
                metszet.HozzaAd(this.taroltErtekek[i]);
        }
        return metszet;
    }

    public void Urit() {
        String[] halmaz = new String[0];
    }

    // O(n)
    public boolean BenneVan(String elem) {
        for (int i = 0; i < taroltErtekek.length; i++) {
            if (taroltErtekek[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    public boolean uresE() {
        return Szamossag() == 0;
    }

    public String[] Ertekek() {
        String[] elemek = new String[this.taroltErtekek.length];
        for (int i = 0; i < this.taroltErtekek.length; i++) {
            elemek[i] = this.taroltErtekek[i];
        }
        return elemek;
    }
}

class StringHalmazDinamikusTombbel {
    private DinStringTomb taroltErtekek;

    public StringHalmazDinamikusTombbel() {
        taroltErtekek = new DinStringTomb();
    }

    // nem bent levo elem eseten O(n) + O(n + 2)
    public boolean HozzaAd(String elem) {
        // O(n)
        if (BenneVan(elem))
            return false;

        taroltErtekek.PozicioraBeszur(taroltErtekek.Hossz(), elem);
        return true;
    }

    public int Szamossag() {
        return taroltErtekek.Hossz();
    }

    public boolean Kivesz(String elem) {
        if (!BenneVan(elem))
            return false;

        int torlendoPozicio = -1;
        for (int i = 0; i < taroltErtekek.Hossz(); i++) {
            if (taroltErtekek.AdottPozicioLekerdezese(i).equals(elem)){
                torlendoPozicio=i;
                break;
            }
        }

        taroltErtekek.PoziciorolTorol(torlendoPozicio);
        return true;

    }

    public StringHalmazDinamikusTombbel Kivon(StringHalmazDinamikusTombbel kivonando) {
        // minden elemet beteszek az aktualis halmazbol
        // majd kivesszuk a kivonando elemeit

        StringHalmazDinamikusTombbel eredmeny = new StringHalmazDinamikusTombbel();
        for (int i = 0; i < this.taroltErtekek.Hossz(); i++) {
            eredmeny.HozzaAd(this.taroltErtekek.AdottPozicioLekerdezese(i));
        }

        for (int i = 0; i < kivonando.taroltErtekek.Hossz(); i++) {
            eredmeny.Kivesz(kivonando.taroltErtekek.AdottPozicioLekerdezese(i));
        }
        return eredmeny;
    }

    public StringHalmazDinamikusTombbel Egyesit(StringHalmazDinamikusTombbel halmaz) {
        StringHalmazDinamikusTombbel eredmeny = new StringHalmazDinamikusTombbel();

        // az összes elem megjelenik benne (csak egyszer)
        // ami legalabb az egyik halmazban benne van
        // O(n1 negyzet)
        for (int i = 0; i < this.taroltErtekek.Hossz(); i++) {
            eredmeny.HozzaAd(this.taroltErtekek.AdottPozicioLekerdezese(i));
        }

        // O(n2 negyzet)
        for (int i = 0; i < halmaz.taroltErtekek.Hossz(); i++) {
            eredmeny.HozzaAd(halmaz.taroltErtekek.AdottPozicioLekerdezese(i));
        }

        return eredmeny;
    }

    public StringHalmazDinamikusTombbel Metszet(StringHalmazDinamikusTombbel metszendo) {
        // az eredmeny halmaz elemei a this es a metszendoben is benne kell legyenek
        // az aktualis halmaz elemeit megnezzuk, hogy benne vannak-e
        // a metszendoben
        StringHalmazDinamikusTombbel metszet = new StringHalmazDinamikusTombbel();
        for (int i = 0; i < this.taroltErtekek.Hossz(); i++) {
            if (metszendo.BenneVan(this.taroltErtekek.AdottPozicioLekerdezese(i)))
                metszet.HozzaAd(this.taroltErtekek.AdottPozicioLekerdezese(i));
        }
        return metszet;
    }

    public void Urit() {
        String[] halmaz = new String[0];
    }

    // O(n)
    public boolean BenneVan(String elem) {
        for (int i = 0; i < taroltErtekek.Hossz(); i++) {
            if (taroltErtekek.AdottPozicioLekerdezese(i).equals(elem)) {
                return true;
            }
        }
        return false;
    }

    public boolean uresE() {
        return Szamossag() == 0;
    }

    public String[] Ertekek() {
        String[] elemek = new String[this.taroltErtekek.Hossz()];
        for (int i = 0; i < this.taroltErtekek.Hossz(); i++) {
            elemek[i] = this.taroltErtekek.AdottPozicioLekerdezese(i);
        }
        return elemek;
    }
}

class DinStringTomb {

    // tagvaltozok
    private String[] taroltErtekek;

    // konstruktor
    public DinStringTomb() {
        taroltErtekek = new String[0];
    }

    public int Hossz() {
        return taroltErtekek.length;
    }

    public void AdottPozicionErtekadas(int poz, String adat) {
        taroltErtekek[poz] = adat;
    }

    public String AdottPozicioLekerdezese(int poz) {
        return taroltErtekek[poz];
    }

    public void PoziciorolTorol(int poz) {
        String[] valtozottErtekek = new String[taroltErtekek.length - 1];
        for (int i = 0; i < poz; i++) {
            valtozottErtekek[i] = taroltErtekek[i];
        }
        for (int i = poz + 1; i < taroltErtekek.length; i++) {
            valtozottErtekek[i - 1] = taroltErtekek[i];
        }
        taroltErtekek = valtozottErtekek;
    }

    public void PozicioraBeszur(int poz, String adat) {
        String[] valtozottErtekek = new String[taroltErtekek.length + 1];
        for (int i = 0; i < poz; i++) {
            valtozottErtekek[i] = taroltErtekek[i];
        }

        valtozottErtekek[poz] = adat;

        for (int i = poz; i < taroltErtekek.length; i++) {
            valtozottErtekek[i + 1] = taroltErtekek[i];
        }
        taroltErtekek = valtozottErtekek;
    }
}