public class Main {
    public static void main(String[] args) {
        int[] v1 = {5, 1, 4, 2, 8};
        int[] v2 = {1, 2, 3, 4, 5};

        BubbleSort(v2);
        BubbleSort(v1);

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
            for (int i = 0; i < utolsoNemRendezettPozicio - 1; i++) {
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