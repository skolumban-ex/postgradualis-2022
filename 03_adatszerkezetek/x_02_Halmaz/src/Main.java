public class Main {
    public static void main(String[] args) {
        // 16/2. Implementálja a halmaz adattípust
        //• statikus tömbök használatával,
        //• dinamikus tömbök használatával,
        //• dinamikus tömbök használatával, de hatékonyan (számokra).

        Halmaz halmaz1 = new Halmaz();
        Halmaz halmaz2 = new Halmaz();

        halmaz1.HozzaAd("alma"); //{a}
        halmaz1.HozzaAd("korte"); //{a,k}
        halmaz1.HozzaAd("banan"); //{a,k,b}
        halmaz1.HozzaAd("eper"); //{a,k,b,e}
        halmaz1.Kivesz("korte"); //{a,k,e}

        halmaz2.HozzaAd("2"); // {2}
        halmaz2.HozzaAd("3"); // {2,3}
        halmaz2.HozzaAd("3"); // {2,3}
        halmaz2.HozzaAd("3"); // {2,3}

        halmaz1.HozzaAd("c"); //{a,k,e,c}
        halmaz1.HozzaAd("d"); //{a,k,e,c,d}
        halmaz1.Kivesz("eper"); // {a,k,c,d}
        Halmaz halmaz3 = halmaz1.Egyesit(halmaz2); //{k,e,2,3}
        Halmaz h1Minh2 = halmaz1.Kivon(halmaz2); // {k,e}
        halmaz3.Metszet(halmaz2);
        halmaz3.Urit();
        halmaz3.BenneVan("2");
        halmaz3.uresE();
    }
}

class Halmaz {
    private String[] taroltErtekek;

    public Halmaz() {
        taroltErtekek = new String[0];
    }

    // nem bent levo elem eseten O(n) + O(n + 2)
    public boolean HozzaAd(String elem) {
        // O(n)
        if (BenneVan(elem))
            return false;

        // O(1)
        String[] ujTaroltElemek = new String[taroltErtekek.length + 1];
        // O(n)
        for (int i = 0; i < taroltErtekek.length; i++) {
            ujTaroltElemek[i] = taroltErtekek[i];
        }
        // O(1)
        ujTaroltElemek[ujTaroltElemek.length - 1] = elem;
        taroltErtekek = ujTaroltElemek;
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
            } else {
                if (!atugrottukeMarAkivevendot)
                    ujTaroltElemek[i] = taroltErtekek[i];
                else
                    ujTaroltElemek[i - 1] = taroltErtekek[i];
            }
        }
        taroltErtekek = ujTaroltElemek;
        return true;
    }

    public Halmaz Kivon(Halmaz halmaz) {
        for (int i = 0; i < taroltErtekek.length; i++) {
            for (int j = 0; j < halmaz.Szamossag(); j++) {


            }

        }
        return new Halmaz();
    }

    public Halmaz Egyesit(Halmaz halmaz) {


        return new Halmaz();
    }

    public Halmaz Metszet(Halmaz halmaz) {
        return new Halmaz();
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
}