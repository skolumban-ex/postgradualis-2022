public class Main {
    private static int[] A;
    private static int[] B;
    private static int[] C;

    public static void main(String[] args) {

        KezdetiErtekBeallitas(4);

        AllapotKirajzolas();

        ArolCrePakol();
    }

    private static void ArolCrePakol() {
        Atpakol(A.length, A, C, B);
    }

    private static void Atpakol(int hanyat, int[] melyikrol, int[] melyikre, int[] seged) {
        if (hanyat == 1) {
            FelsoKorongotAtpakol(melyikrol, melyikre);
        } else {

            Atpakol(hanyat - 1, melyikrol, seged, melyikre);
            FelsoKorongotAtpakol(melyikrol, melyikre);
            Atpakol(hanyat - 1, seged, melyikre, melyikrol);
        }
    }

    // egyet pakolok at
    private static void FelsoKorongotAtpakol(int[] melyikrol, int[] melyikre) {
        // meg kell keresni, hogy ki a felso korong a MELYIKROL oszlopon
        int legmagasabbKorongHelye = ElsoSzabadHelyMagassaga(melyikrol) - 1;
        // vegyuk le a korongot
        int korong = melyikrol[legmagasabbKorongHelye];
        melyikrol[legmagasabbKorongHelye] = 0;

        // az elso szabad helyre a melyikre oszlopra
        int elsoSzabadHelyACelon = ElsoSzabadHelyMagassaga(melyikre);
        melyikre[elsoSzabadHelyACelon] = korong;

        // rajzoljuk ki az allapotot
        AllapotKirajzolas();
    }

    private static int ElsoSzabadHelyMagassaga(int[] oszlop) {
        int elsoSzabadHelyMagassaga = 0;
        while (elsoSzabadHelyMagassaga < oszlop.length &&
                oszlop[elsoSzabadHelyMagassaga] != 0) {
            ++elsoSzabadHelyMagassaga;
        }
        return elsoSzabadHelyMagassaga;
    }

    private static void AllapotKirajzolas() {
        System.out.println();
        for (int i = A.length - 1; i >= 0; i--) {
            // az oszlop i. szintje kiirodik
            String szintSzoveg = SzintszovegEloallitas(i);
            System.out.println(szintSzoveg);
        }

        // foldszint
        System.out.println("_________");

        // oszlopok neve
        System.out.println(" A  B  C ");
    }

    private static String SzintszovegEloallitas(int i) {
        String szintSzoveg = "";

        szintSzoveg += SzintszovegKiegesziteseOszloppal(i, A);
        szintSzoveg += SzintszovegKiegesziteseOszloppal(i, B);
        szintSzoveg += SzintszovegKiegesziteseOszloppal(i, C);

        return szintSzoveg;
    }

    private static String SzintszovegKiegesziteseOszloppal(int szint, int[] oszlop) {
        String szintSzoveg = " ";
        if (oszlop[szint] != 0) {
            szintSzoveg += oszlop[szint];
        } else {
            szintSzoveg += " ";
        }
        szintSzoveg += " ";
        return szintSzoveg;
    }

    private static void KezdetiErtekBeallitas(int n) {
        A = TeliOszlopKeszites(n);
        B = UresOszlopKeszitese(n);
        C = UresOszlopKeszitese(n);
    }

    private static int[] UresOszlopKeszitese(int n) {
        int[] oszlop = new int[n];
        for (int i = 0; i < oszlop.length; i++) {
            oszlop[i] = 0;
        }
        return oszlop;
    }

    private static int[] TeliOszlopKeszites(int n) {
        int[] oszlop = new int[n];
        for (int i = 0; i < oszlop.length; i++) {
            oszlop[i] = n - i;
        }
        return oszlop;
    }

}