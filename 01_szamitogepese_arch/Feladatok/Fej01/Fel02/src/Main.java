import java.util.Scanner;

public class Main {

    // 2. Olvass be két tört számot
    // és írd ki hogy egyenlőek-e vagy sem.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Adj egy tort szamot: ");
        double d1 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Adj meg egyet: ");
        double d2 = sc.nextDouble();
        sc.nextLine();

        boolean bEgyenloeke = d1 == d2;

        System.out.println("A ket szam egyenlo-e: " + bEgyenloeke);
    }
}