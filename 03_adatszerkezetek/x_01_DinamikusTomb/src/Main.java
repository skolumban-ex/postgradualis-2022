import java.time.LocalDateTime;

public class Main {

    private static int Eletkor = 23;

    public static void main(String[] args) {

        DinDoubleTomb dinTomb = new DinDoubleTomb();


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
    private double[] taroltErtekek;

    // konstruktor
    // O(1)
    public DinDoubleTomb2() {
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

