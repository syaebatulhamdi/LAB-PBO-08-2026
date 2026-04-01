
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] bulan = {"Januari","Februari","Maret","April","Mei","Juni",
                          "Juli","Agustus","September","Oktober","November","Desember"};

        System.out.print("Masukkan tanggal: ");
        String[] t = input.nextLine().split("-");

        int hari = Integer.parseInt(t[0]);
        int b = Integer.parseInt(t[1]) - 1;
        int tahun = Integer.parseInt(t[2]);

        if (tahun <= 30) tahun += 2000;
        else tahun += 1900;

        System.out.println(hari + " " + bulan[b] + " " + tahun);
        input.close();
    }
}