import java.time.LocalDateTime;

public class Main {

    private static int Eletkor = 23;

    public static void main(String[] args) {

        DinDoubleTomb2 dinTomb = new DinDoubleTomb2();

        dinTomb.PozicioraBeszur(0, 1);
        dinTomb.PozicioraBeszur(0, 2);
        dinTomb.PozicioraBeszur(0, 3);
        dinTomb.PozicioraBeszur(0, 4);
        dinTomb.PozicioraBeszur(0, 5);


        for (int m = 1000; m < 30000; m = m + 1000) {
            // O(m*m)
            long start = System.currentTimeMillis();
            for (int i = 0; i < m; i++) {
                dinTomb.PozicioraBeszur(0, i);
            }
            long end = System.currentTimeMillis();
            System.out.println(m + ", " + (end - start) / 1000);
        }
    }
}

class DinDoubleTomb2 {

    // tagvaltozok

    // a taroltErtekek tomb elso hasznosElemekSzama eleme lesz relevans, a tobbi nem
    int hasznosElemekSzama;
    private double[] taroltErtekek;

    // konstruktor
    // O(1)
    public DinDoubleTomb2() {
        hasznosElemekSzama = 0;
        taroltErtekek = new double[1];
    }

    // O(1)
    public int Hossz() {
        return hasznosElemekSzama;
    }

    // O(1)
    public void AdottPozicionErtekadas(int poz, double adat) {
        taroltErtekek[poz] = adat;
    }

    // O(1)
    public double AdottPozicioLekerdezese(int poz) {
        return taroltErtekek[poz];
    }

    // O(n)
    public void PoziciorolTorol(int poz) {
        for (int i = poz; i < hasznosElemekSzama - 1; i++) {
            taroltErtekek[i] = taroltErtekek[i + 1];
        }
        --hasznosElemekSzama;
    }

    // O(n)
    public void PozicioraBeszur(int poz, double adat) {
        if (hasznosElemekSzama + 1 <= taroltErtekek.length) {
            // van hely az uj elemnek
            for (int i = hasznosElemekSzama; i > poz; --i) {
                taroltErtekek[i] = taroltErtekek[i - 1];
            }
            taroltErtekek[poz] = adat;
        } else {
            // nincs hely az uj elemnek
            double[] valtozottErtekek = new double[taroltErtekek.length * 2];
            for (int i = 0; i < poz; i++) {
                valtozottErtekek[i] = taroltErtekek[i];
            }

            valtozottErtekek[poz] = adat;

            for (int i = poz; i < taroltErtekek.length; i++) {
                valtozottErtekek[i + 1] = taroltErtekek[i];
            }
            taroltErtekek = valtozottErtekek;
        }
        ++hasznosElemekSzama;
    }
}

class DinDoubleTomb {

    // tagvaltozok
    private double[] taroltErtekek;

    // konstruktor
    // O(1)
    public DinDoubleTomb() {
        taroltErtekek = new double[0];
    }

    // O(1)
    public int Hossz() {
        return taroltErtekek.length;
    }

    // O(1)
    public void AdottPozicionErtekadas(int poz, double adat) {
        taroltErtekek[poz] = adat;
    }

    // O(1)
    public double AdottPozicioLekerdezese(int poz) {
        return taroltErtekek[poz];
    }

    // O(n)
    public void PoziciorolTorol(int poz) {
        double[] valtozottErtekek = new double[taroltErtekek.length - 1];
        for (int i = 0; i < poz; i++) {
            valtozottErtekek[i] = taroltErtekek[i];
        }
        for (int i = poz + 1; i < taroltErtekek.length; i++) {
            valtozottErtekek[i - 1] = taroltErtekek[i];
        }
        taroltErtekek = valtozottErtekek;
    }

    // O(n)
    public void PozicioraBeszur(int poz, double adat) {
        double[] valtozottErtekek = new double[taroltErtekek.length + 1];
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

