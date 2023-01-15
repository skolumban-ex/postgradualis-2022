import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static String[] nevek;

    private static HashMap<String, Integer> nevekGrafIndexe;

    private static GrafSzomszMx padsorKapcsolatok;

    public static void main(String[] args) throws IOException {
        BemenetBeolvasasa(args);

        Scanner sc = new Scanner(System.in);
        String nev;
        do {
            System.out.print("Addj meg egy nevet: ");
            nev = sc.nextLine();

            if (nevekGrafIndexe.containsKey(nev)) {
                ValahaEgyPadsorbanUltDiakokNeveinekKiirasa(nev);
            } else
                System.out.println("Nem ismerjuk az egyent.");
        } while (!nev.equals("*"));

    }

    private static void ValahaEgyPadsorbanUltDiakokNeveinekKiirasa(String nev) {
        int[] szomszedokGrafindexei = padsorKapcsolatok.Szomszedok(nevekGrafIndexe.get(nev));

        System.out.println(nev + " valaha volt padtarsai: ");

        for (int i = 0; i < szomszedokGrafindexei.length; i++) {
            System.out.print(nevek[szomszedokGrafindexei[i]]);
            if (i < szomszedokGrafindexei.length -1)
                System.out.print(", ");
        }

        System.out.println();
    }

    private static void BemenetBeolvasasa(String[] args) throws IOException {
        Path bemenetUtja = Paths.get(args[0]);
        File bemenetiFile = bemenetUtja.toFile();
        FileReader fis = new FileReader(bemenetiFile);
        Scanner scBemenet = new Scanner(fis);

        DiaknevekBeolvasasa(scBemenet);

        PadsorKombinaciokBeolvasasa(scBemenet);

        fis.close();
    }

    private static void DiaknevekBeolvasasa(Scanner scBemenet) {
        int diakokSzama = scBemenet.nextInt();
        scBemenet.nextLine();

        padsorKapcsolatok = new GrafSzomszMx(diakokSzama);

        nevek = new String[diakokSzama];
        nevekGrafIndexe = new HashMap<>();
        for (int i = 0; i < diakokSzama; i++) {
            nevek[i] = scBemenet.nextLine();
            nevekGrafIndexe.put(nevek[i], i);
        }
    }

    private static void PadsorKombinaciokBeolvasasa(Scanner scBemenet) {
        int padsorKombinaciokSzama = scBemenet.nextInt();
        scBemenet.nextLine();

        for (int i = 0; i < padsorKombinaciokSzama; i++) {
            String padsorKombinacio = scBemenet.nextLine();
            PadsorKombinacioFeldolgozas(padsorKombinacio);
        }
    }

    private static void PadsorKombinacioFeldolgozas(String padsorKombinacio) {
        String[] nevekAKombinacioban = padsorKombinacio.split(",");
        for (int j = 0; j < nevekAKombinacioban.length; j++) {
            for (int k = j + 1; k < nevekAKombinacioban.length; k++) {
                String nev1 = nevekAKombinacioban[j].trim();
                String nev2 = nevekAKombinacioban[k].trim();
                padsorKapcsolatok.ElHozzaad(nevekGrafIndexe.get(nev1),
                        nevekGrafIndexe.get(nev2));
            }
        }
    }
}

class GrafSzomszMx {
    int[][] szmx;

    public GrafSzomszMx(int n) {
        szmx = new int[n][n];
    }

    public void ElHozzaad(int i, int j) {
        szmx[i][j] = 1;
        szmx[j][i] = 1;
    }

    public int[] Szomszedok(int i) {
        // szomszedok szamanak masolasa
        int iSzomszedainakSzama = 0;
        for (int j = 0; j < szmx.length; j++) {
            if (szmx[i][j] == 1)
                ++iSzomszedainakSzama;
        }

        int[] szomszedok = new int[iSzomszedainakSzama];
        int kovetkezoSzomszedHelye = 0;
        for (int j = 0; j < szmx.length; j++) {
            if (szmx[i][j] == 1) {
                szomszedok[kovetkezoSzomszedHelye] = j;
                ++kovetkezoSzomszedHelye;
            }
        }
        return szomszedok;
    }

    public HashSet<Integer> SzomszedokHalmaza(int i) {
        HashSet<Integer> szomszedok = new HashSet<>();
        for (int j = 0; j < szmx.length; j++) {
            if (szmx[i][j] == 1) {
                szomszedok.add(j);
            }
        }
        return szomszedok;
    }
}