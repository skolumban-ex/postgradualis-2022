import java.util.Scanner;

public class Main {
    // Írj egy programot ami bekér egy karakterláncot,
    // majd kiírja ezt úgy, hogy az első és utolsó karaktert felcseréli.
    // Figyeljünk, hogy minden hosszúságú karakterláncra jól működjön
    // a program.
    public static void main(String[] args) {

        // beovlasas
        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy karakterláncot: ");
        String szoveg = sc.nextLine();

        // szamolas
        String felcsereltSzoveg;
        if (szoveg.length() > 1) {
            char elsoKarakter = szoveg.charAt(0);
            char utolsoKarakter = szoveg.charAt(szoveg.length() - 1);
            String szovegKozepe = szoveg.substring(1, szoveg.length() - 1);
            felcsereltSzoveg = utolsoKarakter + szovegKozepe + elsoKarakter;
        } else {
            felcsereltSzoveg = szoveg;
        }

        // kiiras
        System.out.println("A megcserelt vegu szoveg: " + felcsereltSzoveg);
    }
}