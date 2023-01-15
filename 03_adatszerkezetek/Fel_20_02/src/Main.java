import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        StringMultihalmaz smh = new StringMultihalmaz();
        smh.HozzaAd("a");
        smh.HozzaAd("a");
        if (smh.ElemMultiplicitasa("a") == 2) {
            System.out.println("Lehet, hogy jól működik az adatszerkezet");
        } else {
            System.out.println("Tuti rossz az adatszerkezet.");
        }
    }
}

class StringMultihalmaz {

    // egy stringhez asszocialjuk a halmazbeli multiplicitasat
    // 1 vagy nagyobb szamok vannak csak
    private HashMap<String, Integer> adatok;

    public StringMultihalmaz() {
        adatok = new HashMap<>();
    }

    public void HozzaAd(String elem) {
        if (this.adatok.containsKey(elem)) {
            // mar benne van
            int aktualisMultiplicitas = this.adatok.get(elem);
            this.adatok.replace(elem, aktualisMultiplicitas + 1);
        } else {
            // uj elem
            this.adatok.put(elem, 1);
        }
    }

    public int Szamossag() {
        return 0;
    }

    public boolean Kivesz(String elem) {
        // 3
        return false;
    }

    public StringMultihalmaz Kivon(StringMultihalmaz kivonando) {
        return new StringMultihalmaz();
    }

    public StringMultihalmaz Egyesit(StringMultihalmaz halmaz) {
        return new StringMultihalmaz();
    }

    public StringMultihalmaz Metszet(StringMultihalmaz metszendo) {
        return new StringMultihalmaz();
    }

    public void Urit() {
        // 2
    }

    public boolean BenneVan(String elem) {
        // 1
        return false;
    }

    public boolean uresE() {
        return Szamossag() == 0;
    }

    public String[] Ertekek() {
        return new String[0];
    }

    public int ElemMultiplicitasa(String elem) {
        if (!adatok.containsKey(elem))
            return 0;

        return adatok.get(elem);
    }
}