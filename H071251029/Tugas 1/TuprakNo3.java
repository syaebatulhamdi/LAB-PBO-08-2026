import java.util.Scanner;

public class TuprakNo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = sc.nextLine();

        boolean panjang = password.length() >= 8;
        boolean besar = false;
        boolean kecil = false;
        boolean angka = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                besar = true;
            } else if (Character.isLowerCase(c)) {
                kecil = true;
            } else if (Character.isDigit(c)) {
                angka = true;
            }
        }

        if (panjang && besar && kecil && angka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }
}    

