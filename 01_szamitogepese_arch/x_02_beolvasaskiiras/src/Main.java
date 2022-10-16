import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // kiirjuk, hogy mi kell
        System.out.print("Add meg a neved (Vezeteknek Keresztnev):");
        // beolvas
        String sVezetekNev = sc.next();
        String sKeresztNev = sc.next();

        // kiirjuk, hogy mi kell
        System.out.print("Add meg a magassagod [m]:");
        double dMagassag = sc.nextDouble();
        sc.nextLine();

        System.out.println("Nev: " + sVezetekNev + " " + sKeresztNev +
                " magassag: " + dMagassag);

        // kiirjuk, hogy mi kell
        System.out.print("Add meg a Vezeteknevet:");
        // beolvas
        sVezetekNev = sc.nextLine();

        System.out.print("Add meg a Keresztnevet:");
        // beolvas
        sKeresztNev = sc.next();

        System.out.print("Add meg a magassagod [m]:");
        dMagassag = sc.nextDouble();

        int x = 5;
        System.out.println(x);
        System.out.println(true);
        System.out.println(5.2);
        System.out.println("Hello world!");
    }
}