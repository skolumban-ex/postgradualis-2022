import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    //
    // Írjon egy programot, ami a parancssori argumentumaként kapott fájlból
    // feltölt egy egész számokból álló tömböt.
    // A fájl első sorában a feltöltendő tömb hossza van.
    // Utána egy üress sor. Majd a tömb elemei szóközzel elválasztva.
    public static void main(String[] args) throws IOException {

        Path bemenetiEleresiUt = Paths.get(args[0]);
        File bemenetiFile = bemenetiEleresiUt.toFile();
        FileReader fr = new FileReader(bemenetiFile);
        Scanner scBemenet = new Scanner(fr);

        int tombMerete = scBemenet.nextInt();
        String tmp = scBemenet.nextLine();
        tmp = scBemenet.nextLine();

        int[] beolvasottTomb = new int[tombMerete];
        for (int i = 0; i < beolvasottTomb.length; i++) {
            beolvasottTomb[i] = scBemenet.nextInt();
        }

        fr.close();
    }
}