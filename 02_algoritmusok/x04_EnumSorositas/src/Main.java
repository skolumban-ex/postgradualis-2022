import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

enum Allapotok {
    Allapot1,
    UjAllpot,
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

        oos.writeUTF(a.name());

        oos.close();
        fos.close();
    }

    private static Allapotok ReadValueFromFile(String fileName) throws IOException {
        Path eleresiUt = Paths.get(fileName);
        File adatFile = eleresiUt.toFile();
        FileInputStream fis = new FileInputStream(adatFile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        String enumName = ois.readUTF();

        ois.close();
        fis.close();

        return  Allapotok.valueOf(enumName);
    }
}