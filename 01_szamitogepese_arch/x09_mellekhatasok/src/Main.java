public class Main {

    private static  int g = 3;

    public static void main(String[] args) {

        String s = "alma";

        // 1 ,  O(n^2)
        karakterElofordulasStzamlalo(s);

        String megforditott= "";
        // n
        for (int i = 0; i < s.length(); i++) {
            // n
            megforditott = s.charAt(i) + megforditott;
        }
    }

    private static void karakterElofordulasStzamlalo(String s) {
        // n  n(1+1+(n * (1 + max(0, 1)))+1)   === O(n^2)
        for (int i = 0; i < s.length(); i++) {
            // 1
            char c = s.charAt(i);

            // 1
            int cElofordulasiSzama = 0;

            // n   (n * (1 + max(0, 1)))
            for (int j = 0; j < s.length(); j++) {
                // 1  (1 + max(0, 1))
                if (s.charAt(j) == c)
                    // 1
                    ++cElofordulasiSzama;
                else{
                    // 0
                }
            }

            // 1
            System.out.println(c + " elofordulasainak szama: " + cElofordulasiSzama );
        }
    }
}