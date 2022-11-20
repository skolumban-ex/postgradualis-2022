public class Main {
    public static void main(String[] args) {

        int[] v = {15, 753, -934, 4, 3, 2, 1};

        int _15Helye = TombbenKeres(v, 15);
        int _3Helye = TombbenKeres(v, 3);
        int _72Helye = TombbenKeres(v, 72);
    }

    // idokomplexitas: n (1 + max (1, 0)) + 1 == O(n)
    // tarkomplexitas: bemenet + O(1)
    private static int TombbenKeres(int[] miben, int mit) {
        // n (1 + max (1, 0))
        for (int i = 0; i < miben.length; i++) {
            // 1 + max (1, 0)
            if (miben[i] == mit)
                // 1
                return i;
        }

        // ha nem talalta eddig meg, akkor nincs a tombben
        // 1
        return -1;
    }
}