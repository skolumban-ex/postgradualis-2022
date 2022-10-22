import java.util.Random;

public class Main {
    public static void main(String[] args) {

        char c = '(';
        char c2 = 'B';

        String s = "alma";

        int charOsszeg = c + c2;
        System.out.println(charOsszeg);

        char charOsszegMintChar = (char) charOsszeg;
        System.out.println(charOsszegMintChar);

        System.out.println(c - c2);

        System.out.println(c * c2);

        System.out.println(c / c2);

        System.out.println(s + c2);

        //System.out.println(s-c2);

        //System.out.println(s*c2);

        //System.out.println(s/c2);

        Random r = new Random();
        double x1 = r.nextDouble();
        double x2 = r.nextDouble();
        double x3 = r.nextDouble();

        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));
        System.out.println(r.nextInt(0, 6));

        Math.random();
        // nagy betu generalas
        //A
        char nbA = (char) r.nextInt(65, 91);
        char nbA2 = (char) r.nextInt('A', 'Z' + 1);

        //B
        char nbB = (char) (65 + Math.random() * (91 - 65));

        // beirt karakterek alapjan
        String lehetsegesKarakterek = "abcdexyzABCDEXYZ12";
        int veletlenPozicio = r.nextInt(lehetsegesKarakterek.length());
        char vc = lehetsegesKarakterek.charAt(veletlenPozicio);

        // veletlen kategoria alapjan
        int kategoria = r.nextInt(3);
        switch (kategoria) {
            case 0:
                vc = (char) r.nextInt('A', 'Z' + 1);
                break;
            case 1:
                vc = (char) r.nextInt('a', 'z' + 1);
                break;
            case 2:
                vc = (char) r.nextInt('0', '9' + 1);
                break;
        }

        // karakter tartomaynzok alapjan
        int szamokSzama = '9' - '0' + 1;
        int nagybetukSzama = 'Z' - 'A' + 1;
        int kisbetukSzama = 'z' - 'a' + 1;
        int osszesLehetsegesKarakter = szamokSzama + kisbetukSzama + nagybetukSzama;
        int veletlenKarakterPozicio = r.nextInt(osszesLehetsegesKarakter);
        char velC;
        if (veletlenKarakterPozicio < szamokSzama)
            velC = (char) ('0' + veletlenKarakterPozicio);
        else if (veletlenKarakterPozicio < szamokSzama + nagybetukSzama)
            velC = (char) ('A' + veletlenKarakterPozicio - szamokSzama);
        else
            velC = (char) ('a' + veletlenKarakterPozicio - szamokSzama - nagybetukSzama);
    }
}