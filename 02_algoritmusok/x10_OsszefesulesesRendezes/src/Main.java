public class Main {
    public static void main(String[] args) {

        int[] v = {38, 27, 43, 3, 9, 82, 10};

        int[] v1 = {3, 27, 38, 43};
        int[] v2 = {9, 10, 82};
        int[] osszef = RendezettTomboketOsszefesul(v1, v2);

        MergeSort(v);
    }

    private static void MergeSort(int[] v) {

        // vagd kette a tombot

        // rendezd a ket altombot

        // fesuld ossze az eredmenyeket

    }

    private static int[] RendezettTomboketOsszefesul(int[] v1, int[] v2) {
        int[] osszefesult = new int[v1.length + v2.length];

        int aktualisanFeltoltendoElemHelye = 0;
        int szabadElemV1Ben = 0;
        int szabadElemV2Ben = 0;

        // valasztunk a ket szabadbol, amig van mindkettoben szabad
        while (szabadElemV1Ben < v1.length && szabadElemV2Ben < v2.length) {
            if (v1[szabadElemV1Ben] <= v2[szabadElemV2Ben]) {
                osszefesult[aktualisanFeltoltendoElemHelye] = v1[szabadElemV1Ben];
                szabadElemV1Ben++;
            } else {
                osszefesult[aktualisanFeltoltendoElemHelye] = v2[szabadElemV2Ben];
                szabadElemV2Ben++;
            }
            aktualisanFeltoltendoElemHelye++;
        }

        // ha meg v1 van, az osszeset atmasoljuk
        while (szabadElemV1Ben < v1.length) {
            osszefesult[aktualisanFeltoltendoElemHelye] = v1[szabadElemV1Ben];
            szabadElemV1Ben++;
            aktualisanFeltoltendoElemHelye++;
        }

        // ha meg v2 van, az osszeset atmasoljuk
        while (szabadElemV2Ben < v2.length) {
            osszefesult[aktualisanFeltoltendoElemHelye] = v2[szabadElemV2Ben];
            szabadElemV2Ben++;
            aktualisanFeltoltendoElemHelye++;
        }

        return osszefesult;
    }
}