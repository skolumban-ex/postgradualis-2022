public class Main {
    private static int[] A;
    private static int[] B;
    private static int[] C;

    public static void main(String[] args) {

        KezdetiErtekBeallitas(5);

        AllapotKirajzolas();

    }

    private static void AllapotKirajzolas(){
        for (int i = A.length-1; i >= 0 ; i--) {
            // az oszlop i. szintje kiirodik
        }

        // foldszint
        System.out.println("_________");

        // oszlopok neve
        System.out.println(" A  B  C ");
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