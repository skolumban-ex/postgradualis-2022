public class Main {
    public static void main(String[] args) {
        boolean hargitai = false;
        boolean gyerekakocsiban = false;
        boolean vanberlete = false;

        boolean sorompoNyilik = sorompoNyilikE1(hargitai, gyerekakocsiban, vanberlete);

        if (sorompoNyilik        ) {
            System.out.println("Nyilik a sorompo");
        } else {
            System.out.println("nem nyilik");
        }
    }

    private static boolean sorompoNyilikE1(boolean hargitai, boolean gyerekakocsiban, boolean vanberlete) {
        boolean sorompoNyilik =
                (!hargitai && !gyerekakocsiban && vanberlete)
                || (!hargitai && gyerekakocsiban && !vanberlete)
                || (!hargitai && gyerekakocsiban && vanberlete)
                || (hargitai && !gyerekakocsiban && vanberlete)
                || (hargitai && gyerekakocsiban && vanberlete);

        return sorompoNyilik;
    }
}