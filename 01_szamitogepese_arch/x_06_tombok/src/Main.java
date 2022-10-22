public class Main {
    public static void main(String[] args) {
        int[] egeszek = new int[5];
        egeszek[3] = -2;
        egeszek[0] = egeszek[3];

        int[] parosok = {2, 4, 6, 8};

        String[] nevek = new String[3];
        nevek[1] = "Kozepso";

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