import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String spath = "d:\\"+"Dropbox\\Adatok"+"CI-KolumbanSandor-2020.pdf";
        Path oneletrajzUtvonal = Paths.get("d:\\",
                "Dropbox\\Adatok", "CI-KolumbanSandor-2020.pdf");

        Path gyokerPdfUt = Paths.get("d:\\",
                "Dropbox\\Adatok", "..\\", "..\\",
                "20220922CB.pdf");

        Path relativUtvonal = Paths.get(".","CI-KolumbanSandor-2020.pdf");

        File f = oneletrajzUtvonal.toFile();
        File dropboxFolderInfo = f.getParentFile();

        Path aktualisKonyvtar = Paths.get(".");
        Path aktualisKonyvtarAbsolute = aktualisKonyvtar.toAbsolutePath().normalize();


    }
}