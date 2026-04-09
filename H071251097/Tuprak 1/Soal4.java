import java.util.Scanner;

public class Soal4 {

    public static int faktorial(int n) {
        if (n == 1 || n == 0) {
            return 1; 
        } else {
            return n * faktorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int n = input.nextInt();

        System.out.println("Hasil: " + faktorial(n));
    }
}
