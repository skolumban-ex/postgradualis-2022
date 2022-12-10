public class Main {
    public static void main(String[] args) {

        long megoldasiTippekSzama = 0;
        int joMegoldasokSzama = 0;
        int n = 10;
        // össszes megoldás felsorolása
        int[] megoldasTipp = new int[n];

        do {
            // megoldas kiiras
            ++megoldasiTippekSzama;

            // megoldas ellenorzese
            if (JoMegoldas(megoldasTipp)) {
                MegoldasKiirasa(megoldasiTippekSzama, megoldasTipp);
                ++joMegoldasokSzama;
            }

        } while (KovetkezoMegoldasraAllit(megoldasTipp));

        System.out.println("Osszes lehetseges megoldasok szama: "+megoldasiTippekSzama);
        System.out.println("Jo megoldasok szama:" + joMegoldasokSzama);
    }

    private static boolean JoMegoldas(int[] megoldasTipp) {
        // azonos sorban levo utkozest nem kell ellenorizni

        // azonos oszlop ellenorzes
        // a tombben nem lehet ket azonos elem
        // -- rendezzuk, ket egymasmelletti elem ha azonos - O(n log n) + O (n)
        // dupla iteracio
        if (TartalmazAzonosElemet(megoldasTipp))
            return false;

        // atlon utkozes ellenorzese
        boolean vanAtlosUtkozes = false;
        for (int i = 0; i < megoldasTipp.length && !vanAtlosUtkozes; i++) {
            for (int j = i + 1; j < megoldasTipp.length && !vanAtlosUtkozes; j++) {
                if (Math.abs(megoldasTipp[i] - megoldasTipp[j]) == Math.abs(i - j)) {
                    vanAtlosUtkozes = true;
                }
            }
        }
        return !vanAtlosUtkozes;
    }

    private static boolean TartalmazAzonosElemet(int[] megoldasTipp) {
        boolean vanAzonosElem = false;
        for (int i = 0; i < megoldasTipp.length; i++) {
            for (int j = i + 1; j < megoldasTipp.length; j++) {
                if (megoldasTipp[i] == megoldasTipp[j]) {
                    vanAzonosElem = true;
                    break;
                }
            }
        }
        return vanAzonosElem;
    }

    private static void MegoldasKiirasa(long megoldasiTippekSzama, int[] megoldasTipp) {
        System.out.print("#" + megoldasiTippekSzama + ": ");
        for (int i = 0; i < megoldasTipp.length; i++) {
            System.out.print(megoldasTipp[i]);
            if (i < megoldasTipp.length - 1)
                System.out.print(", ");
            else
                System.out.println();
        }
    }

    private static boolean KovetkezoMegoldasraAllit(int[] v) {
        // megkeresem az utolso nem n-1 értéket és azt növelemá
        // HF:irjatok at while-ra
        int novelhetoPozicio = v.length - 1;
        for (; novelhetoPozicio >= 0; novelhetoPozicio--) {
            if (v[novelhetoPozicio] != v.length - 1)
                break;
        }

        if (novelhetoPozicio < 0)
            return false;

        v[novelhetoPozicio] = v[novelhetoPozicio] + 1;

        for (int i = novelhetoPozicio + 1; i < v.length; i++) {
            v[i] = 0;
        }

        return true;
    }
}