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
        // ha van az aktualis szinten tovabbi probalhato megoldas
        //  akkor a kovetkezot allitja elo
        // hanem null
        return null;
    }

    private static int[] EgySzinttelKiterjeszt(int[] reszlegesMegoldas) {
        // ha lehet kiterjeszteni, akkor egy uj reszmegoldast allit elo
        // a kovetkező szint első reszmegoldasaval
        // hanem null
        return null;
    }


    private static void MegoldasKiirasa(int[] reszlegesMegoldas) {

    }

    private static boolean TeljesMegoldas(int[] reszlegesMegoldas) {
        return true;
    }

    private static boolean EldobandoReszmegoldas(int[] reszlegesMegoldas) {

       return true;
    }
}