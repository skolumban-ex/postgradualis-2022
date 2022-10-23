public class Main {
    // Oldd meg a 6.12 feladatot majd refaktoráld a megoldásodat, hogy függvények
    // felhasználásával oldd meg, jelentősen csökkentve a kód mennyiségét és
    // javítva az olvashatóságot.
    //Használd az IDE beépített refaktorálási funkcióit (jobb klick, refactor, extract method).

    // Írj egy programot amely feltölt egy 10 elemű tömböt véletlen tört számokkal,
    // kiírja a tömb elemeit, megcseréli a legnagyobb és a legkisebb számot,
    // majd újra kiírja a tömböt.
    public static void main(String[] args) {
        double[] szamok = VeletlenSzamtombGeneralas(2);

        tombKiiras(szamok);

        legkisebbLegnagyobbFelcsereles(szamok);

        tombKiiras(szamok);
    }

    private static void legkisebbLegnagyobbFelcsereles(double[] szamok) {
        int legkisebbElemPozicioja = getLegkisebbElemPozicioja(szamok);
        int legnagyobbElemPozicioja = getLegnagyobbElemPozicioja(szamok);

        double ideiglenesCsere = szamok[legkisebbElemPozicioja];
        szamok[legkisebbElemPozicioja] = szamok[legnagyobbElemPozicioja];
        szamok[legnagyobbElemPozicioja] = ideiglenesCsere;
    }

    private static int getLegnagyobbElemPozicioja(double[] szamok) {
        int legnagyobbElemPozicioja = 0;
        for (int i = 0; i < szamok.length; i++) {
            if (szamok[i] > szamok[legnagyobbElemPozicioja])
            {
                legnagyobbElemPozicioja = i;
            }
        }
        return legnagyobbElemPozicioja;
    }

    private static int getLegkisebbElemPozicioja(double[] szamok) {
        int legkisebbElemPozicioja = 0;
        for (int i = 0; i < szamok.length; i++) {
            if (szamok[i] < szamok[legkisebbElemPozicioja])
            {
                legkisebbElemPozicioja = i;
            }
        }
        return legkisebbElemPozicioja;
    }

    private static void tombKiiras(double[] szamok) {
        System.out.println("A megadott tömb elemei: ");
        for (int i = 0; i < szamok.length; i++) {
            System.out.print( szamok[i]);
            if (i< szamok.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static double[] VeletlenSzamtombGeneralas(int n) {
        double[] szamok = new double[n];
        for (int i = 0; i < szamok.length; i++) {
            szamok[i] = Math.random();
        }
        return szamok;
    }
}