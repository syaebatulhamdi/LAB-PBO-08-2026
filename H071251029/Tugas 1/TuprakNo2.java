import java.util.Scanner;

public class TuprakNo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Input tanggal (dd-mm-yy): ");
        String input = sc.nextLine();

        // Pisahkan tanggal
        String[] bagian = input.split("-");

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        // Array nama bulan
        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        // Konversi tahun
        if (tahun <= 25) {
            tahun += 2000;
        } else {
            tahun+= 1900 ;
        }

        // Output
        System.out.println("Output: " + hari + " " + namaBulan[bulan - 1] + " " + tahun);
    }
}