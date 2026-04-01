
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String pass = input.nextLine();

        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean angka = false;

        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);

            if (Character.isUpperCase(c)) hurufBesar = true;
            if (Character.isLowerCase(c)) hurufKecil = true;
            if (Character.isDigit(c)) angka = true;
        }

        if (pass.length() >= 8 && hurufBesar && hurufKecil && angka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        input.close();
    }
}