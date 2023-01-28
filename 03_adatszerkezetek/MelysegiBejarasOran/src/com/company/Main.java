package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        BinGrafCsP a = new BinGrafCsP(1);
        BinGrafCsP b = new BinGrafCsP(2);
        BinGrafCsP c = new BinGrafCsP(3);
        BinGrafCsP d = new BinGrafCsP(4);
        BinGrafCsP e = new BinGrafCsP(5);
        BinGrafCsP f = new BinGrafCsP(6);
        BinGrafCsP g = new BinGrafCsP(7);

        a.SetBal(b);
        a.SetJobb(f);
        b.SetBal(d);
        b.SetJobb(c);
        f.SetBal(e);
        f.SetJobb(g);

        BinarisFa binFa = new BinarisFa(a);

        binFa.TraverseDeapthFirstSearchWithStack();

        binFa.TraverseDeapthFirstSearchWithRecursion();

    }


}

class BinarisFa {
    private BinGrafCsP gyoker;

    public BinarisFa(BinGrafCsP gyoker) {
        this.gyoker = gyoker;
    }

    public void TraverseDeapthFirstSearchWithStack() {
        Stack<BinGrafCsP> cspStack = new Stack<BinGrafCsP>();
        this.gyoker.TraverseDeapthFirstSearchWithStack(cspStack);
    }


    public void TraverseDeapthFirstSearchWithRecursion() {
        this.gyoker.TraverseDeapthFirstSearchWithRecursion();
    }
}

class BinGrafCsP {
    private int adat;

    private BinGrafCsP jobb;

    private BinGrafCsP bal;

    private BinGrafCsP szulo;

    public BinGrafCsP(int adat) {
        this.adat = adat;
    }

    public int GetAdat() {
        return adat;
    }

    public void SetJobb(BinGrafCsP x) {
        this.jobb = x;
        x.szulo = this;
    }

    public void SetBal(BinGrafCsP x) {
        this.bal = x;
        x.szulo = this;
    }

    public void TraverseDeapthFirstSearchWithStack(Stack<BinGrafCsP> cspStack) {

        cspStack.push(this);

        if (bal != null)
            bal.TraverseDeapthFirstSearchWithStack(cspStack);

        if (jobb != null)
            jobb.TraverseDeapthFirstSearchWithStack(cspStack);

        BinGrafCsP top = cspStack.pop();
        System.out.println(top.GetAdat());
    }

    public void TraverseDeapthFirstSearchWithRecursion() {

        // eloszor gyerekek
        if (bal != null)
            bal.TraverseDeapthFirstSearchWithRecursion();

        if (jobb != null)
            jobb.TraverseDeapthFirstSearchWithRecursion();

        // utana en
        System.out.print(adat);
    }
}