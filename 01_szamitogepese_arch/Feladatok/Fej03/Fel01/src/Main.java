import java.util.Scanner;

//1. Írj programot ami beolvas egy egész, majd eldönti, hogy az alábbi esetek közül melyik áll fenn:
//a. a szám páratlan
//b. a szám páros és osztható néggyel, de nem osztható nyolccal
//c. a szám páros és osztható nyolccal és néggyel is
//d. a szám páros de nem osztható sem nyolccal sem néggyel
//e. valami más féle szám
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Adj meg egy egesz szamot :");
        int megadottszam = sc.nextInt();
        sc.nextLine();

        String uzenet = szamtipusMeghataroz(megadottszam);

        System.out.println(uzenet);
    }

    private static String szamtipusMeghataroz(int megadottszam) {
        String uzenet;

        if ((megadottszam % 2) != 0) {
            // paratlan
            uzenet = "A megadott szam paratlan";
        } else {
            // paros
            if (megadottszam % 4 == 0) {
                // 4-el oszthat=
                if (megadottszam % 8 == 0) {
                    // 4/el
                    uzenet = "A megadott szam paros es oszthato 4-el es 8-al is";
                } else {
                    uzenet = "A megadott szam paros es oszthato 4-el de nem oszthato 8-al";
                }
            } else {
                // paros de 4/el nem
                uzenet = "A megadott szam paros, de nem oszthato 4-el vagy 8-al";
            }
        }

        return uzenet;
    }
}