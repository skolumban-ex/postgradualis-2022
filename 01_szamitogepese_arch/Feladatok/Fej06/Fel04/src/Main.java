public class Main {
    // Rendes palindrom teszt: Írjon programot amely beolvas egy karakterláncot
    // és arról eldönti, hogy palindróm-e (egy karakterlánc akkor palindróm,
    // ha visszafelé olvasva is ugyan az mint előre, pl: Rád rohan a hordár).
    // A kis- és nagybetűk ne jelentsenek különbséget, valamint a szóközök és punktiációs karakterek
    // se számítsanak.
    // Olyan megoldást adjon, amiben nem használ csak egy karakterláncot,
    // az eredeti bemenetet (újabb karakterláncokba való átalakítás nélkül oldja meg a feladatot).

    private static String szoveg = "a cápa ette apáca.";

    public static void main(String[] args) {

        boolean palindrom = PalindromEAGlobalisSzoveg();

        if (palindrom)
            System.out.println("Palindorm a: " + szoveg);
        else
            System.out.println("Nem palindorm a: " + szoveg);
    }

    private static boolean PalindromEAGlobalisSzoveg() {

        int karPozElsoFeleben = 0;
        int karPozHatsoFeleben = szoveg.length() - 1;

        boolean palindrom = true;
        while (karPozElsoFeleben < karPozHatsoFeleben) {
            // ha az elso pozicio nem erdekes karakter
            if (palindromsagSzempontjabolErdektelenKarakter(szoveg.charAt(karPozElsoFeleben))) {
                karPozElsoFeleben++;
                continue;
            }
            // ha a hatso pozicio nem erdekes karakter
            if (palindromsagSzempontjabolErdektelenKarakter(szoveg.charAt(karPozHatsoFeleben))) {
                karPozHatsoFeleben--;
                continue;
            }

            // ha ket karakteren van a ket pozicio, akkor karaktereket kell hasonlitani
            if (szoveg.charAt(karPozElsoFeleben) != szoveg.charAt(karPozHatsoFeleben)) {
                // nem palindrom
                palindrom = false;
                break;
            } else {
                // azonos karakterek
                ++karPozElsoFeleben;
                --karPozHatsoFeleben;
            }
        }

        return palindrom;
    }

    private static boolean palindromsagSzempontjabolErdektelenKarakter(char c) {
        String nemErdekesKarakterek = " .";
        return nemErdekesKarakterek.indexOf(c) >= 0;
    }
}