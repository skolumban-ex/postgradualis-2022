import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> szuletesiTelepules = new HashMap<>();
        HashMap<String, Integer> magassagCmben = new HashMap<>();

        szuletesiTelepules.put("Kolumban Sandor", "Udvarhely");
        magassagCmben.put("Kolumban Sandor", 186);

        szuletesiTelepules.put("Tamasi Aron", "Farkaslaka");
        magassagCmben.put("Tamasi Aron", 180);

        System.out.println("Adj meg egy nevet: ");
        Scanner sc = new Scanner(System.in);
        String nev = sc.nextLine();

        System.out.println(nev +" szuletesi helye:" + szuletesiTelepules.get(nev));
        System.out.println(nev +" magassaga:" + magassagCmben.get(nev));
    }
}