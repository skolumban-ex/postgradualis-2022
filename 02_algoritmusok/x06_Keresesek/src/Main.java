public class Main {
    public static void main(String[] args) {
        int[] v1 = {4, 1, 8, 11, 43, 12, 19};
        int[] v2 = {1, 2, 3, 4, 5};

        BubbleSort(v1);

    }

    private static void InsertionSort(int[] v) {
        for (int elsoNemRendezettElemHelye = 1; elsoNemRendezettElemHelye < v.length; elsoNemRendezettElemHelye++) {

            int csusztatandoElemHelye = elsoNemRendezettElemHelye;

            int csusztatandoElem = v[csusztatandoElemHelye];

            while (csusztatandoElemHelye > 0
                    && v[csusztatandoElemHelye - 1] > csusztatandoElem) {
                v[csusztatandoElemHelye] = v[csusztatandoElemHelye - 1];
                csusztatandoElemHelye--;
            }

            v[csusztatandoElemHelye] = csusztatandoElem;

        }
    }

    private static void SelectionSort(int[] v) {
        for (int aktualisanKivalasztandoHely = 0; aktualisanKivalasztandoHely < v.length - 1; aktualisanKivalasztandoHely++) {

            int aktualisUtaniLegkisebbElemPozicioja = aktualisanKivalasztandoHely;
            for (int i = aktualisanKivalasztandoHely + 1; i < v.length; i++) {
                if (v[i] < v[aktualisUtaniLegkisebbElemPozicioja]) {
                    aktualisUtaniLegkisebbElemPozicioja = i;
                }
            }

            if (aktualisUtaniLegkisebbElemPozicioja != aktualisanKivalasztandoHely) {
                int tmp = v[aktualisUtaniLegkisebbElemPozicioja];
                v[aktualisUtaniLegkisebbElemPozicioja] = v[aktualisanKivalasztandoHely];
                v[aktualisanKivalasztandoHely] = tmp;
            }
        }
    }

    private static void BubbleSortSimple(int[] v) {
        for (int j = 0; j < v.length - 1; j++) {
            for (int i = 0; i < v.length - 1 - j; i++) {
                if (v[i] > v[i + 1]) {
                    int tmp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = tmp;
                }
            }
        }
    }

    private static void BubbleSort(int[] v) {
        boolean voltVegrehajtottCsereAzUtolsoBubiCiklusban;
        int utolsoNemRendezettPozicio = v.length - 1;
        do {
            voltVegrehajtottCsereAzUtolsoBubiCiklusban = false;
            for (int i = 0; i < utolsoNemRendezettPozicio; i++) {
                if (v[i] > v[i + 1]) {
                    voltVegrehajtottCsereAzUtolsoBubiCiklusban = true;
                    int tmp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = tmp;
                }
            }
            utolsoNemRendezettPozicio--;
        } while (voltVegrehajtottCsereAzUtolsoBubiCiklusban);
    }
}