public class Main {

    //Írjuk ki egy 𝑛 pozitív egész szám összes összegfelbontását,
    // vagyis az osszes olyan felbontást, amiben pozitív egész számok összegeként előállítható.
    //Pl.: 4=1+1+1+1=1+1+2=1+3=2+2
    private static int[] aktualisReszmegoldas;

    private static int EldobandoErekelesekSzama = 0;

    public static void main(String[] args) {

        int helyesMegoldasokSzama = 0;
        KezdetiReszmegoldadBeallitasa(20);

        // backtracking iterativan
        int aktualisSzint = 0;
        while (aktualisSzint >= 0) {
            boolean azonosSzintenVoltUjKezdemeny = false;
            boolean ujKezdemenyEldobando = false;
            do {
                azonosSzintenVoltUjKezdemeny = SzintenBelulUjReszmegoldas(aktualisSzint);
                if (azonosSzintenVoltUjKezdemeny)
                    ujKezdemenyEldobando = EldobandoReszmegoldas(aktualisSzint);
            } while (azonosSzintenVoltUjKezdemeny && ujKezdemenyEldobando);

            if (!ujKezdemenyEldobando && azonosSzintenVoltUjKezdemeny) {
                if (TeljesMegoldas(aktualisSzint)) {
                    // dolgozzuk
                    ++helyesMegoldasokSzama;
                    MegoldasKiirasa(helyesMegoldasokSzama, aktualisReszmegoldas);
                } else {
                    // szintlepes
                    ++aktualisSzint;
                    // reszmegoldas specifikalasa
                }
            } else {
                // backtrack
                // szint lepes lefele
                --aktualisSzint;
                aktualisReszmegoldas[aktualisSzint + 1] = 0;
            }
        }

        System.out.println("Osszes eldobando ertekelesek szama: " + EldobandoErekelesekSzama);
    }

    private static void KezdetiReszmegoldadBeallitasa(int n) {
        aktualisReszmegoldas = new int[n];
    }

    private static boolean TeljesMegoldas(int aktualisSzint) {
        int osszeg = 0;
        for (int rmi : aktualisReszmegoldas) {
            osszeg += rmi;
        }

        return (osszeg == aktualisReszmegoldas.length);
    }

    private static boolean EldobandoReszmegoldas(int aktualisSzint) {
        ++EldobandoErekelesekSzama;

        int osszeg = 0;
        for (int rmi : aktualisReszmegoldas) {
            osszeg += rmi;
        }

        if (osszeg > aktualisReszmegoldas.length)
            return true;

        for (int i = 0; i < aktualisSzint; i++) {
            if (aktualisReszmegoldas[i] > aktualisReszmegoldas[i + 1])
                return true;
        }

        return false;
    }

    private static boolean SzintenBelulUjReszmegoldas(int aktualisSzint) {
        int osszeg = 0;
        for (int rmi : aktualisReszmegoldas) {
            osszeg += rmi;
        }

        if (osszeg >= aktualisReszmegoldas.length)
            return false;

        aktualisReszmegoldas[aktualisSzint]++;
        return true;
    }

    private static void MegoldasKiirasa(long megoldasiTippekSzama, int[] megoldasTipp) {
        System.out.print("#" + megoldasiTippekSzama + ": ");
        for (int i = 0; i < aktualisReszmegoldas.length - 1; ++i) {
            System.out.print(aktualisReszmegoldas[i] + " + ");
        }
        System.out.println(aktualisReszmegoldas[aktualisReszmegoldas.length - 1]);
    }
}