public class Main {
    //Írjon rekurzív algotmust, ami egy tört számot megszoroz egy egész számmal,
    // kizárólag összeadás művelet használatával.
    public static void main(String[] args) {
        double sz1 = Szorzat(0.3, -5);
        System.out.println(sz1);
    }

    private static double Szorzat(double szorzando, int szorzo) {
        if (szorzo < 0){
            szorzo = -szorzo;
            szorzando = -szorzando;
        }

        return SzorzatNemnegativSzorzoval(szorzando, szorzo);
    }

    private static double SzorzatNemnegativSzorzoval(double szorzando, int szorzo) {
        // ha mar kis feladat szorzando kerdes, azt oldjuk meg
        if (szorzo == 0)
            return 0;

        // visszavezetes kisebb feladatokra
        double kisebbSzorzando = szorzando;
        int kisebbSzorzo = szorzo - 1;

        // kisebb feladatok megoldasa
        double kisebbSzorat = SzorzatNemnegativSzorzoval(kisebbSzorzando, kisebbSzorzo);

        // szorzando kisebb megoldasokbol az eredmeny osszeraksas
        return kisebbSzorat + szorzando;
    }
}