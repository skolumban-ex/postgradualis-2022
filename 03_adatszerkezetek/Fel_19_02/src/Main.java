import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static String[] nevek;

    private static HashMap<String, Integer> nevekGrafIndexe;

    private static GrafEllistas padsorKapcsolatok;

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
            if (i < szomszedokGrafindexei.length - 1)
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

        padsorKapcsolatok = new GrafEllistas(diakokSzama);

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

class GrafEllistas {

    Csucs[] csucsok;

    public GrafEllistas(int n) {
        csucsok = new Csucs[n];
        for (int i = 0; i < csucsok.length; i++) {
            csucsok[i] = new Csucs(i);
        }
    }

    public void ElHozzaad(int i, int j) {
        csucsok[i].SzomszedHozzaadasa(j);
        csucsok[j].SzomszedHozzaadasa(i);
    }

    public int[] Szomszedok(int i) {
        return csucsok[i].Szomszedok();
    }

    public boolean Osszefuggo() {
        return false;
    }
}

class Csucs {
    private int id;

    private ArrayList<ElLeiras> elek;

    public Csucs(int id) {
        this.id = id;
        this.elek = new ArrayList<>();
    }

    public void SzomszedHozzaadasa(int ujSzomszedId) {
        for (int i = 0; i < elek.size(); i++) {
            if (elek.get(i).GetElCel() == ujSzomszedId)
                return;
        }

        // valoban uj el
        elek.add(new ElLeiras(ujSzomszedId));
    }

    public int SzomszedokSzama() {
        return this.elek.size();
    }

    public int[] Szomszedok() {
        int[] szomszedok = new int[this.elek.size()];
        for (int j = 0; j < elek.size(); j++) {
            szomszedok[j] = elek.get(j).GetElCel();
        }
        return szomszedok;
    }
}

class ElLeiras {

    private int celCsucs;

    public ElLeiras(int celCsucs) {
        this.celCsucs = celCsucs;
    }

    public int GetElCel() {
        return celCsucs;
    }
}