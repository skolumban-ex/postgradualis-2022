public class Main {
    public static void main(String[] args) {

        // true - nyitva
        // false - zarva
        boolean forgovillaNyiva = true;

        // valami tortenik
        // - belerug
        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva, 3);

        // - athaladni probal
        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva, 1);

        // - athaladni probal
        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva, 1);

        // - penzt dob be
        forgovillaNyiva = ForgovillaKovetkezoAllapota(forgovillaNyiva, 2);

    }

    // aktualisEsemeny
    // 1: athaladas
    // 2: penzbedobas
    // 3: belerugas
    private static boolean ForgovillaKovetkezoAllapota(
            boolean forgovillaAktualisanNyitva,
            int aktualisEsemeny
    ) {
        if (forgovillaAktualisanNyitva) {
            switch (aktualisEsemeny) {
                case 1:
                    return false;
                case 2:
                    return true;
                case 3:
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            switch (aktualisEsemeny) {
                case 1:
                    return false;
                case 2:
                    return true;
                case 3:
                    return false;
                default:
                   throw new IllegalArgumentException();
            }
        }
    }
}