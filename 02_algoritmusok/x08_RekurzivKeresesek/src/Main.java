public class Main {
    public static void main(String[] args) {
        int[] v = {1, 5, 88, 8, 23, -43, 7};

        int poz = Keres(v, 5);
    }

    // tombben hanzadik elem a kert szam
    private static int Keres(int[] v, int x) {
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
            int indexAVegben = Keres(vVege, x);

            if (indexAVegben != -1) {
                return indexAVegben + 1;
            } else {
                return -1;
            }
        }
    }
}