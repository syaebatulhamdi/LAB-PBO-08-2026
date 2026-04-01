
import java.util.Scanner;

public class Task01 {

    public static String kapital(String teks) {
        String[] kata = teks.split(" ");
        String hasil = "";

        for (int i = 0; i < kata.length; i++) {
            hasil += kata[i].substring(0,1).toUpperCase() + kata[i].substring(1).toLowerCase() + " ";
        }

        return hasil;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Judul Film : ");
        String teks = input.nextLine();

        System.out.println(kapital(teks));
        input.close();
    }
}