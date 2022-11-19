import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    // Írja ki a program aktuális könyvtárában lévő összes könyvtár és fájl nevét.
    // Egyszer a könyvtrárakat, utána a fájlokat.

    // Írja ki a program prancssori argumentumaként megkapott könyvtárban lévő összes
    // könyvtár és fájl nevét. Egyszer a könyvtrárakat, utána a fájlokat.
    public static void main(String[] args) {
        Path listazandoKonyvtarUtja = Paths.get(args[0]);

        konyvtarAlkonyvtarainakListazasa(listazandoKonyvtarUtja);

        konyvtarFaljainakListazasa(listazandoKonyvtarUtja);
    }

    private static void konyvtarAlkonyvtarainakListazasa(Path aktKonyvtarEleres) {
        File aktKonyvtarInfo = aktKonyvtarEleres.toFile();

        File[] aktKonyvtarTartalma = aktKonyvtarInfo.listFiles();

        System.out.println("Az aktualis konyvtar alkonyvtarai: ");
        for (int i = 0; i < aktKonyvtarTartalma.length; i++) {
            if (aktKonyvtarTartalma[i].isDirectory())
                System.out.println(aktKonyvtarTartalma[i].getName());
        }

        System.out.println();
    }

    private static void konyvtarFaljainakListazasa(Path aktKonyvtarEleres) {
        File aktKonyvtarInfo = aktKonyvtarEleres.toFile();

        File[] aktKonyvtarTartalma = aktKonyvtarInfo.listFiles();

        System.out.println("Az aktualis konyvtar faljai: ");
        for (int i = 0; i < aktKonyvtarTartalma.length; i++) {
            if (aktKonyvtarTartalma[i].isFile())
                System.out.println(aktKonyvtarTartalma[i].getName());
        }

        System.out.println();
    }
}