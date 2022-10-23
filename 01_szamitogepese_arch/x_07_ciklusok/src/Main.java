import java.util.Scanner;

public class Main {
    // Írjon programot ami addig olvas be karakterláncokat ameddig azt nem adjuk meg neki, hogy Exit.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // bekerunk egy szoveget
//        System.out.println("Adjon meg egy karakterlancot: ");
//        String s = sc.nextLine();
//        while (s.compareTo("Exit") != 0){
//            // ismetelendo utasitasok
//            System.out.println("Adjon meg egy karakterlancot: ");
//            s = sc.nextLine();
//        }

//        String s = "Bármi ami nem Exit";
//        while (s.compareTo("Exit") != 0){
//            // ismetelendo utasitasok
//            System.out.println("Adjon meg egy karakterlancot: ");
//            s = sc.nextLine();
//        }

//        String s = "Bármi ami nem Exit";
//        for (;s.compareTo("Exit") != 0;) {
//            // ismetelendo utasitasok
//            System.out.println("Adjon meg egy karakterlancot: ");
//            s = sc.nextLine();
//        }

//        String s;
//        do {
//            // ismetelendo utasitasok
//            System.out.println("Adjon meg egy karakterlancot: ");
//            s = sc.nextLine();
//        } while (s.compareTo("Exit") != 0);
//
//        boolean elsoEllenorzes = true;
//        for (; elsoEllenorzes || s.compareTo("Exit") != 0; ) {
//            elsoEllenorzes = false;
//            System.out.println("Adjon meg egy karakterlancot: ");
//            s = sc.nextLine();
//        }

        // van egy tomb
        // irjuk ki a tomb elemeit az eslo kettesig
        int[] szamok = {1, 6, 2, 5, -3};
        for (int i = 0; i < szamok.length; i++) {
            if (szamok[i] == 2) {
                break;
            }
            System.out.println(szamok[i]);
        }

        System.out.println("Vege.");

    }
}