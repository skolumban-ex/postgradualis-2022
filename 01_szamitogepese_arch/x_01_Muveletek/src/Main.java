public class Main {

    // muveletek probalgatasa

    public static void main(String[] args) {



        // szam eredmenyu, szam bemenetu muveletek
        int iOp1 = -3;
        int iOp2 = 10;

        int iOsszeg = iOp1 + iOp2;
        int iKulonbseg = iOp1 - iOp2;
        int iSzorzat = iOp1 * iOp2;
        int iHanyados = iOp1 / iOp2;
        int iMaradekosOsztas = iOp1 % iOp2;
        int iPlusz1 = ++iOp1;
        int iMinusz1 = iOp1--;

        double dOp1 = -3;
        double dOp2 = 10.4;

        double dOsszeg = dOp1 + dOp2;
        double dKulonbseg = dOp1 - dOp2;
        double dSzorzat = dOp1 * dOp2;
        double dHanyados = dOp1 / dOp2;
        double dMaradekosOsztas = dOp1 % dOp2;
        double dPlusz1 = dOp1++;
        double dMinusz1 = dOp1--;

        double dTortPluszEgesz = dOp1 + iOp1 * 1.1;
        int iTortPluszEgesz = (int) (dOp1 + iOp1 * 1.1);

    }
}