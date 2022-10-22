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
        int aktualisanBekerendoNevSorszama = 1;
        switch (nevekSzama){
            case 5:
                System.out.println("Addj meg az " + aktualisanBekerendoNevSorszama +". nevet: ");
                nevek[4] = sc.nextLine();
                ++aktualisanBekerendoNevSorszama;
            case 4:
                System.out.println("Addj meg az " + aktualisanBekerendoNevSorszama +". nevet: ");
                nevek[3] = sc.nextLine();
                ++aktualisanBekerendoNevSorszama;
            case 3:
                System.out.println("Addj meg az " + aktualisanBekerendoNevSorszama +". nevet: ");
                nevek[2] = sc.nextLine();
                ++aktualisanBekerendoNevSorszama;
            case 2:
                System.out.println("Addj meg az " + aktualisanBekerendoNevSorszama +". nevet: ");
                nevek[1] = sc.nextLine();
                ++aktualisanBekerendoNevSorszama;
            case 1:
                System.out.println("Addj meg az " + aktualisanBekerendoNevSorszama +". nevet: ");
                nevek[0] = sc.nextLine();
        }

        // kiiras
        int kiirandoNevPozicioja = 0;
        switch (nevekSzama){
            case 5:
                System.out.println(nevek[kiirandoNevPozicioja]);
                kiirandoNevPozicioja++;
            case 4:
                System.out.println(nevek[kiirandoNevPozicioja]);
                kiirandoNevPozicioja++;
            case 3:
                System.out.println(nevek[kiirandoNevPozicioja]);
                kiirandoNevPozicioja++;
            case 2:
                System.out.println(nevek[kiirandoNevPozicioja]);
                kiirandoNevPozicioja++;
            case 1:
                System.out.println(nevek[kiirandoNevPozicioja]);
                kiirandoNevPozicioja++;
        }
    }
}