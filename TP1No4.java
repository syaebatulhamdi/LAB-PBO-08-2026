import java.util.Scanner;



public class TP1No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        try {
            System.out.print("Masukkan angka: ");
            int n = sc.nextInt();
            
            if (n < 0) {
                System.out.println("Input harus bilangan non negatif.");
            } else {
                long hasil = hitungFaktorial(n);
                System.out.println("Output: " + hasil);
            }
        } catch (Exception e) {
            System.out.println("Input harus berupa angka!");
        }
    }


    public static long hitungFaktorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * hitungFaktorial(n - 1);
    }
}

        



