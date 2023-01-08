public class Main {
    public static void main(String[] args) {

        StringMultihalmaz smh = new StringMultihalmaz();
        smh.HozzaAd("a");
        smh.HozzaAd("a");
        if (smh.ElemMultiplicitasa("a") == 2)
        {
            System.out.println("Lehet, hogy jól működik az adatszerkezet");
        }
        else{
            System.out.println("Tuti rossz az adatszerkezet.");
        }
    }
}

class StringMultihalmaz {

    // A otlet
    // String[] ertekek
    // int[] multiplicitasok

    // A' otlet
    // DinStringTomb ertekek
    // DinIntTom multiplicitasok

    // A'' otlet
    // String[]
    // {"alma|5", "alma|5|1"}

    // B otlet
    // String[]
    // {a-3, b-1}
    // {"a", "a", "b", "a"}
    public StringMultihalmaz() {
    }

    public void HozzaAd(String elem) {
    }

    public int Szamossag() {
        return 0;
    }

    public boolean Kivesz(String elem) {
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
    }

    public boolean BenneVan(String elem) {
        return false;
    }

    public boolean uresE() {
        return Szamossag() == 0;
    }

    public String[] Ertekek() {
        return new String[0];
    }

    public int ElemMultiplicitasa(String elem) {
        return 0;
    }
}