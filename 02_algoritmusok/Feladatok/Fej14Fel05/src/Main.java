public class Main {
    private static long[] FibonacciKiertekelesekSzama;

    // A Fibonacci sorozat elég természetellenes képességű nyulak szaporodását modellezi.
    // A sorozat úgy indul, hogy 𝐹2=𝐹1=1. Ezek után egy tetszőleges 𝐹𝑛 érteke úgy számolható ki,
    // hogy a sorozat két előző elemét összedadjuk 𝐹𝑛=𝐹𝑛−1+𝐹𝑛−2. (1,1,2,3,5,8,13,…)
    //Számolja ki 𝐹𝑛 értékét rekurzió segítségéve
    public static void main(String[] args) {

        for (int n = 1; n < 200; ++n) {
            FibonacciKiertekelesekSzama = new long[n + 1];

            long startTime = System.currentTimeMillis();
            long Fn = Fibonacci(n);
            long endTime = System.currentTimeMillis();
            System.out.println("--------");
            System.out.println("F" + n + " = " + Fn);
            System.out.println("Kiszamitasi ido [ms]: " + (endTime - startTime));

            KiertekelesSzamokKiirasa();
            System.out.println("--------");
        }
    }

    private static long Fibonacci(int n) {
        return Fibonacci(
                1, // F2,
                1, //F1,
                n - 2
        );
    }

    private static long Fibonacci(long utolsoIsmertF,
                                  long utolsoElottiIsmertF,
                                  int utolsoUtanHannyalAlljunkMeg) {

        if (utolsoUtanHannyalAlljunkMeg <= 0)
            return utolsoIsmertF;

        return Fibonacci(utolsoIsmertF + utolsoElottiIsmertF,
                utolsoIsmertF,
                utolsoUtanHannyalAlljunkMeg - 1);
    }

    private static void KiertekelesSzamokKiirasa() {
        System.out.println("Kiertekelesek szama:");
        for (int i = 1; i < FibonacciKiertekelesekSzama.length; i++) {
            System.out.print("F" + i + ":" + FibonacciKiertekelesekSzama[i] + "; ");
        }
    }

    private static long Fibonacci_Naiv(int n) {
        // szamoljuk, hogy hanyszor ertekeltuk ki Fn-t
        FibonacciKiertekelesekSzama[n]++;

        if (n <= 2)
            return 1;

        long Fn_1 = Fibonacci_Naiv(n - 1);
        long Fn_2 = Fibonacci_Naiv(n - 2);

        long Fn = Fn_1 + Fn_2;
        return Fn;
    }
}