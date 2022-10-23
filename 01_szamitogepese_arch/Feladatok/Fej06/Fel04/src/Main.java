public class Main {

    // Rendes palindrom teszt: Írjon programot amely beolvas egy karakterláncot
    // és arról eldönti, hogy palindróm-e (egy karakterlánc akkor palindróm,
    // ha visszafelé olvasva is ugyan az mint előre, pl: Rád rohan a hordár).
    // A kis- és nagybetűk ne jelentsenek különbséget, valamint a szóközök és punktiációs karakterek
    // se számítsanak.
    // Olyan megoldást adjon, amiben nem használ csak egy karakterláncot,
    // az eredeti bemenetet (újabb karakterláncokba való átalakítás nélkül oldja meg a feladatot).
    public static void main(String[] args) {

        String szoveg = "a cápa ette apáca.";

        boolean palindrom = PalindromE(szoveg);

        if (palindrom)
            System.out.println("Palindorm a: " + szoveg);
        else
            System.out.println("Nem palindorm a: " + szoveg);
    }

    public static boolean PalindromE(String ellenorzendoSzoveg) {

        int karPozElsoFeleben = 0;
        int karPozHatsoFeleben = ellenorzendoSzoveg.length() - 1;

        boolean palindrom = true;
        while (karPozElsoFeleben < karPozHatsoFeleben) {
            // ha az elso pozicio nem erdekes karakter
            if (palindromsagSzempontjabolErdektelenKarakter(ellenorzendoSzoveg.charAt(karPozElsoFeleben))) {
                karPozElsoFeleben++;
                continue;
            }
            // ha a hatso pozicio nem erdekes karakter
            if (palindromsagSzempontjabolErdektelenKarakter(ellenorzendoSzoveg.charAt(karPozHatsoFeleben))) {
                karPozHatsoFeleben--;
                continue;
            }

            // ha ket karakteren van a ket pozicio, akkor karaktereket kell hasonlitani
            if (ellenorzendoSzoveg.charAt(karPozElsoFeleben) != ellenorzendoSzoveg.charAt(karPozHatsoFeleben)) {
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