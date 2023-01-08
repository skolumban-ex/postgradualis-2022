import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        IntSor sor = new IntSor();
        sor.SorbaAll(1);
        sor.SorbaAll(100);
        sor.SorbaAll(73);
        int elsoKilepo = sor.SortElhagy(); // 1
        int masodikKilepo = sor.SortElhagy(); // 100
        sor.SorbaAll(10);
        int negyedikKilepo = sor.SortElhagy(); // 73

        IntVerem verem = new IntVerem();
        verem.Betesz(1);
        verem.Betesz(2);
        verem.Betesz(3);
        int elsoVeremElhagyo = verem.Kivesz(); // 3
        int masodikVeremElhagyo = verem.Kivesz(); // 2
        verem.Betesz(4);
        int harmadikVeremElhagyo = verem.Kivesz(); // 4

    }
}

// Pozitiv szamok sora
class IntSor {
    public IntSor() {

    }

    public void SorbaAll(int id) {

    }

    // Ki all a sorbol valaki, ha ures a sor, akkor -1.
    public int SortElhagy() {
        return -1;
    }

    public boolean Ures() {
        return false;
    }
}

// Pozitiv szamok verme
class IntVerem {
    public IntVerem() {

    }

    public void Betesz(int adat) {

    }

    public int Kivesz() {
        return 0;
    }

    public int Kukucska() {
        return 0;
    }

    public boolean Ures() {
        return false;
    }
}