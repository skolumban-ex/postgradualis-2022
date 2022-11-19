import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Add meg a tesztelendo szoveget: ");
        int n = 4000000;
        String szoveg = "a".repeat(n);

//        String megforditottSzoveg = "";
//        for (int kovetkezoBetuPozicioja = szoveg.length() - 1;
//             kovetkezoBetuPozicioja >= 0;
//             kovetkezoBetuPozicioja--) {
//            megforditottSzoveg = megforditottSzoveg + szoveg.charAt(kovetkezoBetuPozicioja);
//        }

        long start = System.currentTimeMillis();
        boolean bASzovegPalindrom = isPalindrom2(szoveg);
        long end = System.currentTimeMillis();

        System.out.println("n: " + n);
        System.out.println( "milliseconds: " + (end-start));

        if (bASzovegPalindrom)
            System.out.println("Palindrom");
        else
            System.out.println("Nem Palindrom");
    }

    // n * n + n (3 + max(1,0)) =kb= = O(n ^ 2)
    private  static  boolean isPalindrom2(String szoveg){
        String forditott = "";
        for (int i = szoveg.length() - 1; i >= 0; i--) { // n

            forditott = forditott + szoveg.charAt(i); // forditott.length() + 1
        }
        //    System.out.println(forditott);
        //  if (szoveg.compareTo(forditott) == 0){
        //    System.out.println("A karakterlanc palindrom");
        // }else {
        //   System.out.println("A karakterlanc nem palindrom");
        //   }
        boolean palindrom = true; // 1
        for (int i = 0; i < szoveg.length() / 2 && palindrom; i++) { // n
            if (szoveg.charAt(i) != forditott.charAt(i)) // 3 + (max (1, 0))
                palindrom = false; // 1
            else
            { }
        }
        return palindrom;
    }

    // 1 + n/2 (3 + 1) = O(n)
    private static boolean isPalindrom(String szoveg) {
        boolean bASzovegPalindrom = true; // 1

        // n/2
        for (int i = 0;
             i < szoveg.length() / 2 && bASzovegPalindrom;
             i++) {
            if (szoveg.charAt(i) != szoveg.charAt(szoveg.length() - 1 - i)) // 3
                bASzovegPalindrom = false; // 1
        }
        return bASzovegPalindrom;
    }
}