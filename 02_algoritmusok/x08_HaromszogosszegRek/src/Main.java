public class Main {
    public static void main(String[] args) {
        int[] v = {1, 2, 7, -1, 9};

        int ho = HaromszogOsszegRek(v);
    }

    private static int HaromszogOsszegRek(int[] v) {
        // ha mar kis feladat a kerdes, azt oldjuk meg
        if (v.length == 1)
            return v[0];

        // visszavezetes kisebb feladatokra
        int[] vRovidebb = new int[v.length - 1];
        for (int i = 0; i < vRovidebb.length; i++) {
            vRovidebb[i] = v[i] + v[i + 1];
        }

        // kisebb feladatok megoldasa
        int hoRovidebb = HaromszogOsszegRek(vRovidebb);

        // a kisebb megoldasokbol az eredmeny osszeraksas
        int ho = hoRovidebb;
        return ho;
    }
}