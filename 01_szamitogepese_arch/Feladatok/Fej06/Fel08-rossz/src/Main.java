import java.util.Scanner;

public class Main {

    private static String[][] autokAdatai = {{"M1", "Sz1", "R4"},
            {"M2", "Sz2", "R1"},
            {"M3", "Sz3", "R3"},
            {"M4", "Sz4", "R2"}};

    // Írj egy programot ami bekeri négy autó adatait (márka, szín, rendszám).
    // Feltételezhetted, hogy a megadott adatok mindig értelmesek,
    // ezt nem kelle ellenőrizni. Tárold az adatokat tömbök tömbjeként,
    // úgy, hogy az első dimenzióban az autókat indexeljük,
    // a másodikban pedig az adataikat.
    // Beolvasás után írd is ki őket rendszám szerinti ABC sorrendben.
    public static void main(String[] args) {

        //AutoAdatBekeres();

        //String[] ertekfelvevoAuto;
        for (int i = 0; i < autokAdatai.length; i++) {
            for (int j = i + 1; j < autokAdatai.length; j++) {
                if (autokAdatai[i][2].compareTo(autokAdatai[j][2]) > 0) {
                    //ertekfelvevoAuto = autokAdatai[i];
                    autokAdatai[i] = autokAdatai[j];
                    autokAdatai[j] = autokAdatai[i] ;
                }
            }
        }


        for (int abcSorrendIndex = 0; abcSorrendIndex < autokAdatai.length; abcSorrendIndex++) {
            // irjuk ki az i. legkisebb rendszamu autot

            // ki kell probalni minden autot
            // hogz az-e az i. legkisebb rendszamu
            int aktualisJelolt = getAktualisJelolt(abcSorrendIndex);

            System.out.println(autokAdatai[aktualisJelolt][0]);
            System.out.println(autokAdatai[aktualisJelolt][1]);
            System.out.println(autokAdatai[aktualisJelolt][2]);
        }
    }

    private static int getAktualisJelolt(int abcSorrendIndex) {
        int aktualisJelolt = 0;
        for (; aktualisJelolt < autokAdatai.length; aktualisJelolt++) {

            // meg kell szamolni az ot megelozo autokat a sorrendben
            int aktualisnalKisebbAutokSzama = getAktualisnalKisebbAutokSzama(aktualisJelolt);

            if (aktualisnalKisebbAutokSzama == abcSorrendIndex)
                break;
        }
        return aktualisJelolt;
    }

    private static int getAktualisnalKisebbAutokSzama(int aktualisJelolt) {
        int aktualisnalKisebbAutokSzama = 0;
        for (int i = 0; i < autokAdatai.length; i++) {
            if (autokAdatai[i][2].compareTo(autokAdatai[aktualisJelolt][2]) < 0)
                ++aktualisnalKisebbAutokSzama;
        }
        return aktualisnalKisebbAutokSzama;
    }


    private static void AutoAdatBekeres() {
        Scanner sc = new Scanner(System.in);
        int autokSzama = 4;
        autokAdatai = new String[autokSzama][3];

        for (int i = 0; i < autokAdatai.length; i++) {
            System.out.println(" Adja meg a " + (i + 1) + " auto markajat : ");
            autokAdatai[i][0] = sc.nextLine();
            System.out.println("  Adja meg a " + (i + 1) + " auto szine : ");
            autokAdatai[i][1] = sc.nextLine();
            System.out.println("  Adja meg a " + (i + 1) + " auto rendszamat : ");
            autokAdatai[i][2] = sc.nextLine();
        }
    }
}