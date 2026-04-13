import java.util.Scanner;

public class TuprakNo4 {

    public static int faktorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * faktorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int n = sc.nextInt();

        System.out.println("Hasil: " + faktorial(n));
    }
}    

