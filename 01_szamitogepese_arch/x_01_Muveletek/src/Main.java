public class Main {

    // muveletek probalgatasa

    public static void main(String[] args) {

        boolean bIgaz = true;
        boolean bHamis = false;

        boolean bIgazEsHamis = bIgaz && bHamis;
        boolean bIgayVagyHamis = bIgaz || false;
        boolean bHamisNegalva = !bHamis;

        int iOp1 = -3;
        int iOp2 = 10;
        double dOp1 = -3.2;
        double dOp2 = 10.4;
        double dOp3 = -3.1;

        // izaz/hamis = valami szamosdi
        boolean iOp1KisebbiEOp2 = iOp1 < iOp2;
        boolean iOp1EgyenloEdOp3 = iOp1 == dOp3;

        // szam eredmenyu, szam bemenetu muveletek
        int iOsszeg = iOp1 + iOp2;
        int iKulonbseg = iOp1 - iOp2;
        int iSzorzat = iOp1 * iOp2;
        int iHanyados = iOp1 / iOp2;
        int iMaradekosOsztas = iOp1 % iOp2;
        int iPlusz1 = ++iOp1;
        int iMinusz1 = iOp1--;


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