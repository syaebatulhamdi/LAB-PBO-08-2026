import java.util.Scanner;

public class TuprakNo1 {
    
    public static String kapital(String kalimat) {
        String hasil = "";
        String[] kata = kalimat.split(" ");

        for (int i = 0; i < kata.length; i++) {
            char hurufAwal = Character.toUpperCase(kata[i].charAt(0));
            String sisa = kata[i].substring(1);
            hasil = hasil + hurufAwal + sisa + " ";
        }

        return hasil;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String input = sc.nextLine();

        System.out.println("Hasil: " + kapital(input));
    }
}