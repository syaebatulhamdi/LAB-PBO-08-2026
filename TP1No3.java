import java.util.Scanner;

public class TP1No3{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        
        if (isValid(password)) {
            System.out.println("Output: Password valid");
        } else {
            System.out.println("Output: Password tidak valid");
        }
    }

    public static boolean isValid(String password) {
        if (password.length() < 8) return false;

        boolean adaAtas = false;
        boolean adaBawah = false;
        boolean adaAngka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) adaAtas = true;
            else if (Character.isLowerCase(c)) adaBawah = true;
            else if (Character.isDigit(c)) adaAngka = true;
        }

        return adaAtas && adaBawah && adaAngka;
    }
}