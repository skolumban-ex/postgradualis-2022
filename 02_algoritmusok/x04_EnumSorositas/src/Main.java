import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

enum Allapotok {
    Allapot1,
    Allapot2
}

public class Main {
    public static void main(String[] args) throws IOException {

        WtieValueToFile("adat2.bin", Allapotok.Allapot2);

        Allapotok x = ReadValueFromFile("adat.bin");
    }

    private static void WtieValueToFile(String fileName,  Allapotok a) throws IOException {
        Path eleresiUt = Paths.get(fileName);
        File adatFile = eleresiUt.toFile();
        FileOutputStream fos = new FileOutputStream(adatFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.write(a.ordinal());

        oos.close();
        fos.close();
    }

    private static Allapotok ReadValueFromFile(String fileName) throws IOException {
        Path eleresiUt = Paths.get(fileName);
        File adatFile = eleresiUt.toFile();
        FileInputStream fis = new FileInputStream(adatFile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        int enumAsOrdinal = ois.read();

        ois.close();
        fis.close();

        return  Allapotok.values()[enumAsOrdinal];
    }
}