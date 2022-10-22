public class Main {
    public static void main(String[] args) {
        int[] egeszek = new int[5];
        egeszek[3] = -2;
        egeszek[0] = egeszek[3];

        int[] parosok = {2, 4, 6, 8};

        String[] nevek = new String[3];
        nevek[0] = "Kozalkalmazott";
        nevek[1] = "Kozepso";
        nevek[2] = "Bela";

        int hasonlitasiEredmeny = nevek[0].compareTo(nevek[1]);

        //if (nevek[0] <= nevek[1] && nevek[1].compareTo(nevek[2]) <= 0){
        if (nevek[0].compareTo(nevek[1]) <= 0 && nevek[1].compareTo(nevek[2]) <= 0){
            // a sorrend 0 1 2

        }
        if (nevek[0].compareTo(nevek[2]) <= 0 && nevek[2].compareTo(nevek[1]) <= 0){
            // a sorrend 0 2 1

        }

        String[] nevekDirektFeltoltve = {"A", "B", "C", "D"};

        // elso dimenzio a nap, 0/hetfp
        // masodik dimenzio az oraszelet 1 oras bontasban, 7 tol kezdve
        String[][] orarend = new String[5][7];
        orarend[0][1] = "matek"; // hetfo, 8 ora

        String[][] szamlaszamokEmberenkent = new String[18][];
        szamlaszamokEmberenkent[0] = new String[5];
        szamlaszamokEmberenkent[1] = new String[1];
        szamlaszamokEmberenkent[0][2] = "BT3";

        //szamlaszamokEmberenkent[2][4] = "valami";

        int l = szamlaszamokEmberenkent.length;
    }
}