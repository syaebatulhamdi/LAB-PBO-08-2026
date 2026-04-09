import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String tgl = input.nextLine();

        String[] bagian = tgl.split("-");

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        if (hari < 1 || hari > 31 || bulan < 1 || bulan > 12) {
            System.out.println("Input tanggal tidak valid!");
            return; 
        }

        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus",
            "September", "Oktober", "November", "Desember"
        };

        System.out.print("Masukkan abad (19 / 20): ");
        int abad = input.nextInt();

        if (abad == 20) {
            tahun += 2000;
        } else if (abad == 19) {
            tahun += 1900;
        } else {
            System.out.println("Input abad tidak valid!");
            return; 
        }

        System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahun);
    }
}
