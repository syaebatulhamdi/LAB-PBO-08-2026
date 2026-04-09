import java.util.Scanner;

public class Tugas1_5 {

    // NO.1
    public static String kapitalAwal(String kalimat) {
        String[] kata = kalimat.split(" ");
        StringBuilder hasil = new StringBuilder();

        for (String k : kata) {
            if (!k.isEmpty()) {
                hasil.append(Character.toUpperCase(k.charAt(0)))
                     .append(k.substring(1).toLowerCase())
                     .append(" ");
            }
        }
        return hasil.toString().trim();
    }

    // NO.2
    public static String ubahTanggal(String tgl) {
        String[] bagian = tgl.split("-");

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]) + 2000;
      


        String[] namaBulan = {
            "Januari","Februari","Maret","April","Mei","Juni",
            "Juli","Agustus","September","Oktober","November","Desember"
        };

        return hari + " " + namaBulan[bulan - 1] + " " + tahun;
    }

    // NO.3
    public static boolean validPassword(String pwd) {
        if (pwd.length() < 8) return false;

        boolean adaBesar = false, adaKecil = false, adaAngka = false;

        for (char c : pwd.toCharArray()) {
            if (Character.isUpperCase(c)) adaBesar = true;
            if (Character.isLowerCase(c)) adaKecil = true;
            if (Character.isDigit(c)) adaAngka = true;
        }

        return adaBesar && adaKecil && adaAngka;
    }

    // NO.4
    public static int faktorial(int n) {
        if (n <= 1) return 1;
        return n * faktorial(n - 1);
    }

    // NO.5
    public static void cariArray2D(int[][] arr, int cari) {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        return;
                    }
                }
            }
            System.out.println("Angka tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nomor 1
        System.out.println("NO.1");
        System.out.print("Masukkan kalimat: ");
        String kalimat = sc.nextLine();
        System.out.println(kapitalAwal(kalimat));

        // Nomor 2
        System.out.println("\n NO.2");
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String tgl = sc.next();
        System.out.println(ubahTanggal(tgl));

        // Nomor 3
        System.out.println("\n NO.3");
        System.out.print("Masukkan password: ");
        String pwd = sc.next();
        System.out.println(validPassword(pwd) ? "Password valid" : "Password tidak valid");

        // Nomor 4
        System.out.println("\n NO.4");
        System.out.print("Masukkan n: ");
        int n = sc.nextInt();
        System.out.println(faktorial(n));

        // Nomor 5
        System.out.println("\n NO.5");
        int[][] nums = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        System.out.print("Masukkan angka yang dicari: ");
        int cari = sc.nextInt();
        cariArray2D(nums, cari);

        sc.close();
    }
}