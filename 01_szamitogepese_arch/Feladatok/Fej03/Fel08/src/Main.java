import java.util.Scanner;

public class Main {
    //Kérjen be egy számot 1 és 10 között és írja ki, hogy helló annyiszor. Nem megfelelő szám esetén
    //írjuk ki, hogy ejnye bejnye.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kerek egy szamot 1 - 10 kozott: ");
        int numberInput = sc.nextInt();
        sc.nextLine();
        if (numberInput >= 1 && numberInput <= 10) {
            switch (numberInput) {
                case 10:
                    System.out.println("Hello");
                case 9:
                    System.out.println("Hello");
                case 8:
                    System.out.println("Hello");
                case 7:
                    System.out.println("Hello");
                case 6:
                    System.out.println("Hello");
                case 5:
                    System.out.println("Hello");
                case 4:
                    System.out.println("Hello");
                case 3:
                    System.out.println("Hello");
                case 2:
                    System.out.println("Hello");
                case 1:
                    System.out.println("Hello");
                default:
                    break;
            }
        } else {
            System.out.println("ejnye bejnye");
        }
    }
}