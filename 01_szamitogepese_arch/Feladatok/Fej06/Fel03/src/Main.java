import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg a tesztelendo szoveget: ");
        String szoveg = sc.nextLine();

        String megforditottSzoveg = "";
        for (int kovetkezoBetuPozicioja = szoveg.length() - 1;
             kovetkezoBetuPozicioja >= 0;
             kovetkezoBetuPozicioja--) {
            megforditottSzoveg = megforditottSzoveg + szoveg.charAt(kovetkezoBetuPozicioja);
        }

        boolean bASzovegPalindrom = true;
        for (int i = 0; i < szoveg.length(); i++) {
            if (szoveg.charAt(i) != megforditottSzoveg.charAt(i))
                bASzovegPalindrom = false;
        }

        if (bASzovegPalindrom)
            System.out.println("Palindrom");
        else
            System.out.println("Nem Palindrom");
    }
}