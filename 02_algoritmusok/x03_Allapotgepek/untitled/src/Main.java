enum ForgovillaAllapot {
    Nyitva,
    Zarva
}

enum ForgovillaEsemeny {
    AthaladasiKiserlet,
    PenzBedobas ,
    Belerugas
}

public class Main {
    public static void main(String[] args) {

        ForgovillaAllapot eszakiKapuAllapota = ForgovillaAllapot.Nyitva;

        // valami tortenik
        eszakiKapuAllapota = ForgovillaKovetkezoAllapota(eszakiKapuAllapota,
                ForgovillaEsemeny.Belerugas);

        eszakiKapuAllapota = ForgovillaKovetkezoAllapota(eszakiKapuAllapota,
                ForgovillaEsemeny.AthaladasiKiserlet);

        eszakiKapuAllapota = ForgovillaKovetkezoAllapota(eszakiKapuAllapota,
                ForgovillaEsemeny.AthaladasiKiserlet);

        eszakiKapuAllapota = ForgovillaKovetkezoAllapota(eszakiKapuAllapota,
                ForgovillaEsemeny.PenzBedobas);

    }

    private static ForgovillaAllapot ForgovillaKovetkezoAllapota(
            ForgovillaAllapot aktualisAllapot,
            ForgovillaEsemeny aktualisEsemeny
    ) {
        switch (aktualisAllapot) {
            case Nyitva:
                switch (aktualisEsemeny) {
                    case AthaladasiKiserlet:
                        return ForgovillaAllapot.Zarva;
                    case PenzBedobas:
                        return ForgovillaAllapot.Nyitva;
                    case Belerugas:
                        return ForgovillaAllapot.Nyitva;
                    default:
                        throw new IllegalArgumentException();
                }
            case Zarva:
                switch (aktualisEsemeny) {
                    case AthaladasiKiserlet:
                        return ForgovillaAllapot.Zarva;
                    case PenzBedobas:
                        return ForgovillaAllapot.Nyitva;
                    case Belerugas:
                        return ForgovillaAllapot.Zarva;
                    default:
                        throw new IllegalArgumentException();
                }
            default:
                throw new IllegalArgumentException();
        }
    }
}