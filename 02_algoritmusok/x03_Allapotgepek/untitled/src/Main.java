enum ForgovillaAllapot {
    Nyitva,
    Zarva
}

enum ForgovillaEsemeny {
    AthaladasiKiserlet,
    PenzBedobas,
    Belerugas,
    EsoEsik
}

public class Main {
    public static void main(String[] args) {

        ForgovillaAllapot forgovillaNyiva = ForgovillaAllapot.Nyitva;

        // valami tortenik
        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva,
                ForgovillaEsemeny.Belerugas);

        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva,
                ForgovillaEsemeny.AthaladasiKiserlet);

        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva,
                ForgovillaEsemeny.AthaladasiKiserlet);

        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva,
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