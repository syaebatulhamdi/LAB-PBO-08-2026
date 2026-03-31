import java.util.Scanner;

public class TP1No1 {
    public static String kapitalAwal(String input) {
        String hasil = "";
        boolean kapital = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == ' ') {
                hasil += c;
                kapital = true;
            } else {
                if (kapital) {
                    hasil += Character.toUpperCase(c);
                    kapital = false;
                } else {
                    hasil += Character.toLowerCase(c);
                }
            }
        }

        return hasil;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String input = scanner.nextLine();

        String output = kapitalAwal(input);

        System.out.println("Output: " + output);
    }
    
}