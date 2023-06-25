import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class penjumlahan {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Masukkan Nama Anda [1..25 Karakter] : ");
            String nama = validateInput(1, 25);

            System.out.print("Masukkan NIM Anda [Harus 10 karakter] : ");
            String nim = validateInput(10, 10);

            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.print("\n");
            System.out.println("Registrasi Sukses..");
            System.out.println("Selamat Datang " + nama + " [NIM: " + nim + "].. ^v^");
            System.out.println("Mari Belajar macam-macam deret bilangan..");
            System.out.print("\n");
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.print("\n");
            System.out.print("Masukkan Jumlah Angka [5 - 20]: ");
            int jumlahAngka = validateNumberInput(5, 20);
            System.out.print("\n");
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Deret Bilangan");
            System.out.println("#####################\n");

            // Deret Bilangan Genap
            List<Integer> deretGenap = generateEvenNumbers(jumlahAngka);
            int sumGenap = calculateSum(deretGenap);
            System.out.println(jumlahAngka + " Deret Bilangan Genap: \n" + deretGenap);
            System.out.println("Jumlah Deret Bilangan Genap: " + sumGenap + "\n");

            // Deret Bilangan Ganjil
            List<Integer> deretGanjil = generateOddNumbers(jumlahAngka);
            int sumGanjil = calculateSum(deretGanjil);
            System.out.println(jumlahAngka + " Deret Bilangan Ganjil: \n" + deretGanjil);
            System.out.println("Jumlah Deret Bilangan Ganjil: " + sumGanjil + "\n");

            // Deret Bilangan Fibonacci
            List<Integer> deretFibonacci = generateFibonacciSequence(jumlahAngka);
            int sumFibonacci = calculateSum(deretFibonacci);
            System.out.println(jumlahAngka + " Deret Bilangan Fibonacci: \n" + deretFibonacci);
            System.out.println("Jumlah Deret Bilangan Fibonacci: " + sumFibonacci + "\n");

            System.out.println("######################################\n");

            System.out.print("Anda ingin mengulang? [y/t]: ");
            String ulang = scanner.nextLine();
            if (!ulang.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    private static String validateInput(int minLength, int maxLength) {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() < minLength || input.length() > maxLength) {
                System.out.println("Input harus memiliki panjang antara " + minLength + " dan " + maxLength + " karakter.");
            } else {
                return input;
            }
        }
    }

    private static int validateNumberInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.println("Input harus antara " + min + " dan " + max + ".");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    private static List<Integer> generateEvenNumbers(int num) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 2; i <= 2 * num; i += 2) {
            evenNumbers.add(i);
        }
        return evenNumbers;
    }

    private static List<Integer> generateOddNumbers(int num) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 1; i < 2 * num; i += 2) {
            oddNumbers.add(i);
        }
        return oddNumbers;
    }

    private static List<Integer> generateFibonacciSequence(int num) {
        List<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);
        for (int i = 2; i < num; i++) {
            int nextFibonacci = fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2);
            fibonacciSequence.add(nextFibonacci);
        }
        return fibonacciSequence;
    }

    private static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
