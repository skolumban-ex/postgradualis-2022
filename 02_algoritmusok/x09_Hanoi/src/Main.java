public class Main {
    private static int[] A;
    private static int[] B;
    private static int[] C;

    public static void main(String[] args) {

        KezdetiErtekBeallitas(5);

        AllapotKirajzolas();

        // pakoljunk mindent at az A rol a C re

    }

    private static void AllapotKirajzolas() {
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
        String szintSzoveg =" ";
        if (oszlop[szint] != 0) {
            szintSzoveg += oszlop[szint];
        } else {
            szintSzoveg += " ";
        }
        szintSzoveg +=" ";
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