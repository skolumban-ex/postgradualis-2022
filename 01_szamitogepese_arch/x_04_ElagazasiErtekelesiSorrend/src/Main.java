public class Main {
    public static void main(String[] args) {

        boolean jogosultParkolasra = true;

        int iParkolokSzama = 10;

        int iAktualisanParkoloAutokSzama = 10;

        if (jogosultParkolasra) {
            if (iAktualisanParkoloAutokSzama < iParkolokSzama) {

            } else {
                // nem nyitjuk a sorompot
            }
        } else {
            // nem nyitjuk a sorompot
        }

        if (jogosultParkolasra && (iAktualisanParkoloAutokSzama++ < iParkolokSzama)) {
            System.out.println("Gyere be");
        } else {
            System.out.println("NE Gyere be");
        }
    }
}