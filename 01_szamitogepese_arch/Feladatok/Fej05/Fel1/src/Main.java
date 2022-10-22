import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nevek = new String[3];

        System.out.println("Add meg az elso nevet:");
        nevek[0] = sc.nextLine();
        System.out.println("Add meg az elso nevet:");
        nevek[1] = sc.nextLine();
        System.out.println("Add meg az elso nevet:");
        nevek[2] = sc.nextLine();

        System.out.println("Nevek forditott sorrendben:");
        System.out.println(nevek[2]);
        System.out.println(nevek[1]);
        System.out.println(nevek[0]);

        System.out.println("Ennyi nev volt: ");
        System.out.println(nevek.length);
    }
}