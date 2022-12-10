import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        int n = 4;

        int[] reszlegesMegoldas = new int[n];

        backtrack(reszlegesMegoldas);

    }

    private static void backtrack(int[] reszlegesMegoldas) {

        if (EldobandoReszmegoldas(reszlegesMegoldas))
            return;

        if (TeljesMegoldas(reszlegesMegoldas))
            MegoldasKiirasa(reszlegesMegoldas);

        int[] kiterjesztettMegoldas = EgySzinttelKiterjeszt(reszlegesMegoldas);
        while (kiterjesztettMegoldas != null) {
            backtrack(kiterjesztettMegoldas);
            kiterjesztettMegoldas = AdottSzintenKovetkezo(kiterjesztettMegoldas);
        }
    }

    private static int[] AdottSzintenKovetkezo(int[] reszlegesMegoldas) {
        int kovetkezoSzintHely = getKovetkezoSzintHely(reszlegesMegoldas);

        int osszeg = 0;
        for (int rmi : reszlegesMegoldas) {
            osszeg += rmi;
        }

        // adott szinten mar nincs tobb megoldas
        if (osszeg >= reszlegesMegoldas.length)
            return null;

        int[] kovetkezoMegoldas = new int[reszlegesMegoldas.length];
        for (int i = 0; i < kovetkezoSzintHely; i++) {
            kovetkezoMegoldas[i] = reszlegesMegoldas[i];
        }
        kovetkezoMegoldas[kovetkezoSzintHely - 1]++;
        return kovetkezoMegoldas;
    }

    private static int[] EgySzinttelKiterjeszt(int[] reszlegesMegoldas) {
        // hol az elso nulla hely
        int kovetkezoSzintHely = getKovetkezoSzintHely(reszlegesMegoldas);

        // ez a megoldas tovabb nem terjesztheto
        if (kovetkezoSzintHely == reszlegesMegoldas.length)
            return null;

        int[] kiterjesztett = new int[reszlegesMegoldas.length];
        for (int i = 0; i < kovetkezoSzintHely; i++) {
            kiterjesztett[i] = reszlegesMegoldas[i];
        }
        kiterjesztett[kovetkezoSzintHely] = 1;
        return kiterjesztett;
    }

    private static int getKovetkezoSzintHely(int[] reszlegesMegoldas) {
        int kovetkezoSzintHely = 0;
        for (int i = 0; i < reszlegesMegoldas.length; i++) {
            if (reszlegesMegoldas[kovetkezoSzintHely] != 0)
                ++kovetkezoSzintHely;
            else
                break;
        }
        return kovetkezoSzintHely;
    }

    private static void MegoldasKiirasa(int[] reszlegesMegoldas) {
        System.out.print(reszlegesMegoldas.length + "= ");
        for (int i = 0; i < reszlegesMegoldas.length - 1; ++i) {
            System.out.print(reszlegesMegoldas[i] + " + ");
        }
        System.out.println(reszlegesMegoldas[reszlegesMegoldas.length - 1]);
    }

    private static boolean TeljesMegoldas(int[] reszlegesMegoldas) {
        int osszeg = 0;
        for (int rmi : reszlegesMegoldas) {
            osszeg += rmi;
        }

        return (osszeg == reszlegesMegoldas.length);
    }

    private static boolean EldobandoReszmegoldas(int[] reszlegesMegoldas) {

        int osszeg = 0;
        for (int rmi : reszlegesMegoldas) {
            osszeg += rmi;
        }

        if (osszeg > reszlegesMegoldas.length) return true;
        else return false;
    }
}