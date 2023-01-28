import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        BinarisFaCsomopont Janos = new BinarisFaCsomopont("Janos");
        BinarisFaCsomopont Laszlo = new BinarisFaCsomopont("Laszlo");
        BinarisFaCsomopont Matyas = new BinarisFaCsomopont("Matyas");
        BinarisFaCsomopont Erzebet = new BinarisFaCsomopont("Erzsebet");
        BinarisFaCsomopont Kristof = new BinarisFaCsomopont("Kristof");

        Janos.SetJobb(Laszlo);
        Janos.SetBal(Matyas);

        Matyas.SetJobb(Erzebet);
        Matyas.SetBal(Kristof);

        BinarisFa hunyadiak = new BinarisFa(Janos);

        BinarisFa betuk = BetusFaLetrahozas();
        if (betuk.TartalmazKortMelysegiIterativ()){
            System.out.println("Van kor");
            return;
        }

        //System.out.println("Melysegi iterativ");
        betuk.CimkeKiirasMelysegiBejarassal();
        System.out.println();
        System.out.println("Melysegi rekurzio");
        betuk.CimkeKiirasMelysegiBejarassalRek();
        System.out.println();
        System.out.println("Szelessegi iterativ");
        betuk.CimkeKiirasSzelessegiBejarassal();
        System.out.println();

        BinarisFaCsomopont kCimkevel = betuk.Keres("k");

        BinarisFa kLeszarmazottai = new BinarisFa(kCimkevel);
        kLeszarmazottai.CimkeKiirasSzelessegiBejarassal();
    }

    private static BinarisFa BetusFaLetrahozas() {
        BinarisFaCsomopont a = new BinarisFaCsomopont("a");
        BinarisFaCsomopont b = new BinarisFaCsomopont("b");
        BinarisFaCsomopont c = new BinarisFaCsomopont("c");
        BinarisFaCsomopont d = new BinarisFaCsomopont("d");
        BinarisFaCsomopont e = new BinarisFaCsomopont("e");
        BinarisFaCsomopont f = new BinarisFaCsomopont("f");
        BinarisFaCsomopont g = new BinarisFaCsomopont("g");
        BinarisFaCsomopont h = new BinarisFaCsomopont("h");
        BinarisFaCsomopont i = new BinarisFaCsomopont("i");
        BinarisFaCsomopont j = new BinarisFaCsomopont("j");
        BinarisFaCsomopont k = new BinarisFaCsomopont("k");
        BinarisFaCsomopont m = new BinarisFaCsomopont("m");
        BinarisFaCsomopont s = new BinarisFaCsomopont("s");
        a.SetBal(b);
        a.SetJobb(f);
        b.SetBal(k);
        b.SetJobb(g);
        k.SetBal(j);
        k.SetJobb(i);
        g.SetBal(h);
        f.SetJobb(e);
        e.SetBal(d);
        e.SetJobb(s);
        d.SetBal(c);
        d.SetJobb(m);

        // fa elrontasa
        c.SetBal(a);

        BinarisFa betuk = new BinarisFa(a);
        return betuk;
    }
}

class BinarisFa {
    private BinarisFaCsomopont gyoker;

    public BinarisFa(BinarisFaCsomopont gyoker) {
        this.gyoker = gyoker;
    }

    public BinarisFaCsomopont Keres(String nev){
        LinkedList<BinarisFaCsomopont> feldolgozandoElemek = new LinkedList<>();
        feldolgozandoElemek.add(gyoker);

        while (!feldolgozandoElemek.isEmpty()) {
            BinarisFaCsomopont elsoCsp = feldolgozandoElemek.removeFirst();

            if (elsoCsp.GetNev().equals(nev))
                return elsoCsp;

            if (elsoCsp.GetBal() != null)
                feldolgozandoElemek.addLast(elsoCsp.GetBal());
            if (elsoCsp.GetJobb() != null)
                feldolgozandoElemek.addLast(elsoCsp.GetJobb());
        }

        // no node with given name
        return  null;
    }

    public void CimkeKiirasSzelessegiBejarassal() {
        LinkedList<BinarisFaCsomopontGyokerTavolsaggal> feldolgozandoElemek = new LinkedList<>();
        feldolgozandoElemek.add(new BinarisFaCsomopontGyokerTavolsaggal(gyoker, 0));

        while (!feldolgozandoElemek.isEmpty()) {
            BinarisFaCsomopontGyokerTavolsaggal elsoElem = feldolgozandoElemek.removeFirst();

            BinarisFaCsomopont elsoCsp = elsoElem.GetCsp();
            int elsoElemTavolsaga = elsoElem.GetTavolsagGyokertol();

            System.out.print(elsoCsp.GetNev() + "("+elsoElemTavolsaga+") ");

            if (elsoCsp.GetBal() != null)
                feldolgozandoElemek.addLast(new BinarisFaCsomopontGyokerTavolsaggal(elsoCsp.GetBal(),
                        elsoElemTavolsaga + 1));
            if (elsoCsp.GetJobb() != null)
                feldolgozandoElemek.addLast(new BinarisFaCsomopontGyokerTavolsaggal(elsoCsp.GetJobb(),
                        elsoElemTavolsaga+1));
        }
    }

    public void CimkeKiirasMelysegiBejarassal() {
        Stack<BinarisFaCsomopont> feldolgozandoCsomopontok = new Stack<>();
        HashSet<BinarisFaCsomopont> marFeldolgozottCsomopontok = new HashSet<>();

        feldolgozandoCsomopontok.push(gyoker);

        while (!feldolgozandoCsomopontok.empty()) {
            BinarisFaCsomopont veremTetejen = feldolgozandoCsomopontok.peek();

            if (marFeldolgozottCsomopontok.contains(veremTetejen)) {
                // ha mar fel volt dolgozva, akkor irjuk ki és felejtsük el
                System.out.print(veremTetejen.GetNev());
                feldolgozandoCsomopontok.pop();
            } else {
                // tegyuk be a gyerekeit es jeloljuk meg feldolgozottnak
                if (veremTetejen.GetJobb() != null)
                    feldolgozandoCsomopontok.push(veremTetejen.GetJobb());
                if (veremTetejen.GetBal() != null)
                    feldolgozandoCsomopontok.push(veremTetejen.GetBal());
                marFeldolgozottCsomopontok.add(veremTetejen);
            }
        }
    }

    public boolean TartalmazKortMelysegiIterativ() {
        Stack<BinarisFaCsomopont> feldolgozandoCsomopontok = new Stack<>();
        HashSet<BinarisFaCsomopont> marFeldolgozottCsomopontok = new HashSet<>();
        HashSet<BinarisFaCsomopont> feldolgozasraMarMegjeloltCsomopontok = new HashSet<>();

        feldolgozandoCsomopontok.push(gyoker);
        feldolgozasraMarMegjeloltCsomopontok.add(gyoker);

        while (!feldolgozandoCsomopontok.empty()) {
            BinarisFaCsomopont veremTetejen = feldolgozandoCsomopontok.peek();

            if (marFeldolgozottCsomopontok.contains(veremTetejen)) {
                // ha mar fel volt dolgozva, akkor irjuk ki és felejtsük el
                System.out.print(veremTetejen.GetNev());
                feldolgozandoCsomopontok.pop();
            } else {
                // tegyuk be a gyerekeit es jeloljuk meg feldolgozottnak
                if (veremTetejen.GetJobb() != null) {
                    if (feldolgozasraMarMegjeloltCsomopontok.contains(veremTetejen.GetJobb()))
                        return true;
                    else {
                        feldolgozasraMarMegjeloltCsomopontok.add(veremTetejen.GetJobb());
                        feldolgozandoCsomopontok.push(veremTetejen.GetJobb());
                    }
                }
                if (veremTetejen.GetBal() != null){
                    if (feldolgozasraMarMegjeloltCsomopontok.contains(veremTetejen.GetBal()))
                        return true;
                    else {
                        feldolgozasraMarMegjeloltCsomopontok.add(veremTetejen.GetBal());
                        feldolgozandoCsomopontok.push(veremTetejen.GetBal());
                    }
                }
                marFeldolgozottCsomopontok.add(veremTetejen);
            }
        }

        // mindenkit feldolgoztunk es nem volt kor
        return false;
    }

    public void CimkeKiirasMelysegiBejarassalRek() {
        gyoker.CimkeKiirasMelysegiBejarassalRek();
    }
}

class BinarisFaCsomopont {

    private String nev;

    private BinarisFaCsomopont jobb;

    private BinarisFaCsomopont bal;

    public BinarisFaCsomopont(String nev) {
        this.nev = nev;
        this.bal = null;
        this.jobb = null;
    }

    public String GetNev() {
        return this.nev;
    }

    public BinarisFaCsomopont GetJobb() {
        return jobb;
    }

    public BinarisFaCsomopont GetBal() {
        return bal;
    }

    public void SetJobb(BinarisFaCsomopont ujJobb) {
        this.jobb = ujJobb;
    }

    public void SetBal(BinarisFaCsomopont ujBal) {
        this.bal = ujBal;
    }

    public void CimkeKiirasMelysegiBejarassalRek() {
        if (this.bal != null)
            bal.CimkeKiirasMelysegiBejarassalRek();
        if (this.jobb != null)
            jobb.CimkeKiirasMelysegiBejarassalRek();
        //System.out.print(this.nev);
    }
}

class BinarisFaCsomopontGyokerTavolsaggal {
    private BinarisFaCsomopont csp;

    private int tavolsagGyokertol;

    public BinarisFaCsomopontGyokerTavolsaggal(BinarisFaCsomopont csp, int tavolsagGyokertol) {
        this.csp = csp;
        this.tavolsagGyokertol = tavolsagGyokertol;
    }

    public BinarisFaCsomopont GetCsp() {
        return this.csp;
    }

    public int GetTavolsagGyokertol() {
        return this.tavolsagGyokertol;
    }
}