public class Main {
    // 10 pont) Egy rekurzív algoritmus segítségével számolja meg,
    // egy karakterlánc összes részkarakterláncát, amely azonos betűvel
    // kezdődik és végződik. A rekurzív metódus burkoló függvénye egy
    // karakterláncot vár paraméterként, és egy számot ad vissza.
    //Példa 1: Bemenet: „aba”, eredmény 4 (a részkarakterláncok: a, b, aba, a).
    //Példa 2: Bemenet: „abcab”, eredmény 7 (a részkarakterláncok: a, bcab, abca,
    // b, c, a, b).
    //A példákban a részkarakterláncok sorrendje véletlenszerűen van megadva,
    // több lehetséges algoritmus is megadható a számolásra, direkt úgy adtam
    // meg a példát, hogy lehetőleg egyikkel se találjon, ezért a sorrendet
    // nem kell nézni. Ha egy részkarakterlánc többször is szerepel
    // (pl a fenti példákban „a”), annak minden elfordulását számolni kell.
    public static void main(String[] args) {
        String s = "abcab";

        int i = AzonosElejuEsVeguAllancokSzama(s);
    }

    private static  int AzonosElejuEsVeguAllancokSzama(String s){
        int eredmeny = 0;
        if (s.length() == 0)
            return eredmeny;

        // olyan allanc, ami az egeszet lefedi
        if (s.charAt(0) == s.charAt(s.length()-1))
            ++eredmeny;

        // ami nem fedi le az egeszet de az elejen indul
        eredmeny += AzonosElejuEsVeguAllancokSzamaAzElejen(s.substring(0, s.length()-1));

        // valahol van a hatso reszben, de nem az elejen
        eredmeny += AzonosElejuEsVeguAllancokSzama(s.substring(1, s.length()));

        return eredmeny;
    }

    private static  int AzonosElejuEsVeguAllancokSzamaAzElejen(String s){
        int eredmeny = 0;
        if (s.length() == 0)
            return eredmeny;

        // olyan allanc, ami az egeszet lefedi
        if (s.charAt(0) == s.charAt(s.length()-1))
            ++eredmeny;

        // az egyel rovidebben levo megoldasok
        eredmeny += AzonosElejuEsVeguAllancokSzamaAzElejen(s.substring(0, s.length()-1));

        return  eredmeny;
    }
}