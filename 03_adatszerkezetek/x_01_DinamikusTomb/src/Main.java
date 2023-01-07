public class Main {

    private static int Eletkor = 23;

    public static void main(String[] args) {

        DinDoubleTomb dinTomb = new DinDoubleTomb();
        DinDoubleTomb dinTomb2 = new DinDoubleTomb();
        System.out.println("Hossz: " + dinTomb.Hossz());

        dinTomb.PozicioraBeszur(0, 3.4); // [3.4]
        dinTomb.PozicioraBeszur(0, -2); // [-2, 3.4]
        dinTomb.PozicioraBeszur(1, 6); // [-2, 6, 3.4]

        System.out.println("A 2-es pozicion levo ertek: " + dinTomb.AdottPozicioLekerdezese(2));

        dinTomb.AdottPozicionErtekadas(2, 100); // [-2, 6, 100]

        System.out.println("A 2-es pozicion levo ertek: " + dinTomb.AdottPozicioLekerdezese(2));

        dinTomb.PoziciorolTorol(0); // [6, 100]

        System.out.println("A 1-es pozicion levo ertek: " + dinTomb.AdottPozicioLekerdezese(1));
    }
}

class DinDoubleTomb {

    // tagvaltozok
    private double[] taroltErtekek;

    // konstruktor
    public DinDoubleTomb() {
        taroltErtekek = new double[0];
    }

    public int Hossz() {
        return taroltErtekek.length;
    }

    public void AdottPozicionErtekadas(int poz, double adat) {
        taroltErtekek[poz] = adat;
    }

    public double AdottPozicioLekerdezese(int poz) {
        return taroltErtekek[poz];
    }

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

