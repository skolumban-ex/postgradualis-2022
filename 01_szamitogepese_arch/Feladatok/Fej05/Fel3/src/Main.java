import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    // Írj programot, ami be kér egy számot 1 és 5 között,
    // majd pontosan ennyi keresztnevet kér be és ezeket kiírja fordított sorrendben.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg, hogy hany nevet szeretnel beirni [1-5]: ");
        int nevekSzama = sc.nextInt();
        sc.nextLine();

        String[] nevek = new String[nevekSzama];
        for (int beolvasandoNevSorszama = 0; beolvasandoNevSorszama < nevekSzama; beolvasandoNevSorszama++) {
            System.out.println("Addj meg az " + (beolvasandoNevSorszama + 1) + ". nevet: ");
            nevek[nevekSzama -1 - beolvasandoNevSorszama] = sc.nextLine();
        }

        // kiiras
        for (int i = 0; i < nevek.length;i++) {
            String iDikNev = nevek[i];
            System.out.println(iDikNev);
        }

        for (String iDikNev:nevek){
            System.out.println(iDikNev);
        }
    }
}