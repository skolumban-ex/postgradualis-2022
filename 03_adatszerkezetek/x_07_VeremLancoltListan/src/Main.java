public class Main {
    public static void main(String[] args) {
        System.out.println("Verem");
        IntVerem verem = new IntVerem();
        verem.Betesz(3);
        verem.Betesz(2);
        verem.Betesz(5);
        System.out.println("Kijon: " + verem.Kivesz());
        System.out.println("Kijon: " + verem.Kivesz());
        verem.Betesz(9);
        System.out.println("Kijon: " + verem.Kivesz());
        System.out.println("Kukucska: " + verem.Kukucska());
        System.out.println("Kijon: " + verem.Kivesz());
        System.out.println("Ures: " + verem.Ures());

        System.out.println();

        System.out.println("Sor");
        IntSor sor = new IntSor();
        sor.SorbaAll(3);
        sor.SorbaAll(2);
        sor.SorbaAll(5);
        System.out.println("Kijon: " + sor.Sorelhagy());
        System.out.println("Kijon: " + sor.Sorelhagy());
        sor.SorbaAll(9);
        System.out.println("Kijon: " + sor.Sorelhagy());
        System.out.println("Kukucska: " + sor.Kukucska());
        System.out.println("Kijon: " + sor.Sorelhagy());
        System.out.println("Ures: " + sor.Ures());
    }
}

class IntSor{
    LancoltLista adatokASorban;

    public IntSor() {
        adatokASorban = new LancoltLista();
    }

    public void SorbaAll(int adat) {
        adatokASorban.VegereBeszur(adat);
    }

    public int Sorelhagy() {
        int elsoErtek = adatokASorban.AdottPozicioLekerdezese(0);
        adatokASorban.ElejerolTorol();
        return  elsoErtek;
    }

    public boolean Ures() {
        return adatokASorban.Hossz() == 0;
    }

    public int Kukucska() {
        return adatokASorban.AdottPozicioLekerdezese(0);
    }
}

class IntVerem {

    LancoltLista adatokAVeremben;

    public IntVerem() {
        adatokAVeremben = new LancoltLista();
    }

    public void Betesz(int adat) {
        adatokAVeremben.ElejereBeszur(adat);
    }

    public int Kivesz() {
        int elsoErtek = adatokAVeremben.AdottPozicioLekerdezese(0);
        adatokAVeremben.ElejerolTorol();
        return  elsoErtek;
    }

    public boolean Ures() {
        return adatokAVeremben.Hossz() == 0;
    }

    public int Kukucska() {
        return adatokAVeremben.AdottPozicioLekerdezese(0);
    }
}

class Lancszem {
    private Lancszem kovetkezo;
    private int adat;

    public void SetKovetkezo(Lancszem kovetkezo) {
        this.kovetkezo = kovetkezo;
    }

    public Lancszem GetKovetkezo() {
        return this.kovetkezo;
    }

    public void SetAdat(int adat) {
        this.adat = adat;
    }

    public int GetAdat() {
        return adat;
    }
}

class LancoltLista {
    private Lancszem elso;

    private Lancszem utolso;

    public LancoltLista() {
        this.elso = null;
        this.utolso = null;
    }

    public int Hossz() {
        Lancszem aktualisLancszem = this.elso;
        int elemszam = 0;
        while (aktualisLancszem != null) {
            ++elemszam;
            aktualisLancszem = aktualisLancszem.GetKovetkezo();
        }
        return elemszam;
    }

    public void AdottPozicionErtekadas(int poz, int adat) {
        Lancszem adottPozicionLevoSzem = this.elso;
        for (int i = 0; i < poz; i++) {
            adottPozicionLevoSzem = adottPozicionLevoSzem.GetKovetkezo();
        }
        adottPozicionLevoSzem.SetAdat(adat);
    }

    public int AdottPozicioLekerdezese(int poz) {
        Lancszem adottPozicionLevoSzem = this.elso;
        for (int i = 0; i < poz; i++) {
            adottPozicionLevoSzem = adottPozicionLevoSzem.GetKovetkezo();
        }
        return adottPozicionLevoSzem.GetAdat();
    }

    public void ElejerolTorol() {
        this.elso = this.elso.GetKovetkezo();
        if (this.elso == null)
            this.utolso = null;
    }

    public void PoziciorolTorol(int poz) {
        if (poz == 0) {
            ElejerolTorol();
            return;
        }

        Lancszem adottPozicioElottiSzem = this.elso;
        for (int i = 0; i < poz - 1; i++) {
            adottPozicioElottiSzem = adottPozicioElottiSzem.GetKovetkezo();
        }
        adottPozicioElottiSzem.SetKovetkezo(adottPozicioElottiSzem.GetKovetkezo().GetKovetkezo());

        // ha a lista vegerol toroltunk
        if (adottPozicioElottiSzem.GetKovetkezo().GetKovetkezo() == null){
            this.utolso = adottPozicioElottiSzem;
        }
    }

    public void ElejereBeszur(int adat) {
        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        ujElem.SetKovetkezo(this.elso);
        this.elso = ujElem;

        // ures listabol 1 elemu lista
        if (ujElem.GetKovetkezo() == null){
            this.utolso = ujElem;
        }
    }

    public void VegereBeszur(int adat) {
        if (this.Hossz() == 0)
        {
            ElejereBeszur(adat);
            return;
        }

        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        this.utolso.SetKovetkezo(ujElem);
        this.utolso = ujElem;
    }

    public void PozicioraBeszur(int poz, int adat) {
        if (poz == 0) {
            ElejereBeszur(adat);
        } else {
            Lancszem ujElem = new Lancszem();
            ujElem.SetAdat(adat);

            // utolso elem a pozicio elott
            Lancszem beszurandoElotti = this.elso;
            for (int i = 1; i < poz; i++) {
                beszurandoElotti = beszurandoElotti.GetKovetkezo();
            }

            ujElem.SetKovetkezo(beszurandoElotti.GetKovetkezo());
            beszurandoElotti.SetKovetkezo(ujElem);

            // ha a lista vegere szurtunk, az utolsot is allitani kell
            if (ujElem.GetKovetkezo() == null){
                this.utolso = ujElem;
            }
        }
    }
}