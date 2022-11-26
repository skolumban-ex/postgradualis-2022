import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] v = {1, 5, 88, 8, 23, -43, 7};

        int poz = KeresElsoElemLevagassal(v, 23);

        Arrays.sort(v);

        poz = KeresRendezettTombben(v, 23);

    }

    private static int KeresRendezettTombben(int[] v, int x) {
        // 1 * comp (Keres, n)
        return KeresRendezettTombben(v, x, 0, v.length);
    }

    private static int KeresRendezettTombben(int[] v, int x,
                                             int rangeStartInclusive, int rangeEndExclusive) {
        // legkisebb feladat, 1 elemu tartomany
        if (rangeStartInclusive == rangeEndExclusive - 1) {
            if (v[rangeStartInclusive] == x)
                return rangeStartInclusive;
            else
                return -1;
        }

        // felezo pozicio
        int felezo = rangeStartInclusive + (rangeEndExclusive - rangeStartInclusive) / 2;
        if (v[felezo] == x) {
            return felezo;
        } else if (v[felezo] < x) {
            // keress csak fent
            return KeresRendezettTombben(v, x, felezo + 1, rangeEndExclusive);
        } else {
            // keress csak leng
            return KeresRendezettTombben(v, x, rangeStartInclusive, felezo);
        }
    }

    private static int KeresElsoElemLevagassal(int[] v, int x) {
        // 1 * comp (Keres, n)
        return KeresKettevagassal(v, x, 0, v.length);
    }

    private static int KeresKettevagassal(int[] v, int x,
                                          int rangeStartInclusive, int rangeEndExclusive) {
        // legkisebb feladat, 1 elemu tartomany
        if (rangeStartInclusive == rangeEndExclusive - 1) {
            if (v[rangeStartInclusive] == x)
                return rangeStartInclusive;
            else
                return -1;
        }

        // felezo pozicio
        int felezo = rangeStartInclusive + (rangeEndExclusive - rangeStartInclusive) / 2;

        int pozicioAzAlsoFelben = KeresKettevagassal(v, x, rangeStartInclusive, felezo);
        if (pozicioAzAlsoFelben >= 0)
            return pozicioAzAlsoFelben;
        else {
            int pozicioAFelsoFeleben = KeresKettevagassal(v, x, felezo, rangeEndExclusive);
            if (pozicioAFelsoFeleben >= 0)
                return pozicioAFelsoFeleben;
            else
                return -1;
        }
    }

    private static int KeresElsoElemLevagassal(int[] v, int x, int rangeStartInclusive) {
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
            int pos = KeresElsoElemLevagassal(v, x, rangeStartInclusive + 1);
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