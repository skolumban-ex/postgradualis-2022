import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg az elso nevet:");
        String nev1 = sc.nextLine();
        System.out.println("Add meg az elso nevet:");
        String nev2 = sc.nextLine();
        System.out.println("Add meg az elso nevet:");
        String nev3 = sc.nextLine();

        System.out.println("Nevek forditott sorrendben:");
        System.out.println(nev3);
        System.out.println(nev2);
        System.out.println(nev1);
    }
}