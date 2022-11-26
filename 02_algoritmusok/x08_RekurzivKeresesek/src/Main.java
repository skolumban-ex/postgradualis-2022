public class Main {
    public static void main(String[] args) {
        int[] v = {1, 5, 88, 8, 23, -43, 7};

        int poz = Keres(v, 11);
    }

    private static int Keres(int[] v, int x) {
        // 1 * comp (Keres, n)
        return Keres(v, x, 0);
    }

    private static int Keres(int[] v, int x, int rangeStartInclusive) {
        // ha mar kis feladat a kerdes, azt oldjuk meg
        // 1
        if (rangeStartInclusive == v.length - 1)
            return -1;

        // a kisebb megoldasokbol az eredmeny osszeraksas
        if (v[rangeStartInclusive] == x)
            // 1
            return rangeStartInclusive;
        else {
            // visszavezetes kisebb feladatok
            // kisebb feladatok megoldasa
            // 1 + comp (Keres, n-1)
            int pos = Keres(v, x, rangeStartInclusive + 1);
            return pos;
        }
    }

    // tombben hanzadik elem a kert szam
    private static int KeresNNegyzetTaron(int[] v, int x) {
        // ha mar kis feladat a kerdes, azt oldjuk meg
        if (v.length == 0)
            return -1;

        // a kisebb megoldasokbol az eredmeny osszeraksas
        if (v[0] == x)
            return 0;
        else {
            // visszavezetes kisebb feladatok
            int[] vVege = new int[v.length - 1];
            for (int i = 0; i < vVege.length; i++) {
                vVege[i] = v[i + 1];
            }

            // kisebb feladatok megoldasa
            int indexAVegben = KeresNNegyzetTaron(vVege, x);

            if (indexAVegben != -1) {
                return indexAVegben + 1;
            } else {
                return -1;
            }
        }
    }
}