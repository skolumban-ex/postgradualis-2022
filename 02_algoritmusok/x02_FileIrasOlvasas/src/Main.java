import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Path ujFajlUtja = Paths.get("_a.txt");
        File ujFajl = ujFajlUtja.toFile();
        //ujFajl.createNewFile();

        // karakteres fajl iras
        FileWriter fw = new FileWriter(ujFajl);

        fw.write("Alma");
        fw.write("\r\n");
        fw.write(""+5);
        fw.write(System.lineSeparator());
        fw.write("alszik.");

        fw.close();

        // fajl olvas
        //FileReader fr = new FileReader(Paths.get(args[0]).toFile());
        FileReader fr = new FileReader(ujFajl);
        Scanner scFileOlvaso = new Scanner(fr);
        String elsoSor = scFileOlvaso.nextLine();
        int x = scFileOlvaso.nextInt();
        fr.close();

        Path ujBinarisFajlUtja = Paths.get("_a.bin");
        File ujBinarisFile = ujBinarisFajlUtja.toFile();
        FileOutputStream fos = new FileOutputStream(ujBinarisFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeUTF("Alma");
        oos.writeInt(5);
        oos.writeUTF("alszik.");
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream(ujBinarisFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        //String binElsoSor = ois.readUTF();
        int binY = ois.readInt();
        int binX = ois.readInt();
        String binEUtolsoSor = ois.readUTF();
        ois.close();
        fis.close();

    }
}