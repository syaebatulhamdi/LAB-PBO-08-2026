package Tuprak5.Soal1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
//        KARYAWAN KONTRAK
        KaryawanKontrak a = new KaryawanKontrak("anies", "I345", 500000);
        System.out.print("how much present : ");int absenKK = c.nextInt();
        for (int i = 0; i < absenKK; i++ ){
            a.hadir();
        }
        a.tampilkanInfo();

//        KARYAWAN TETAP
        KaryawanTetap b = new KaryawanTetap("afdhol","H0712", 2000000, 500000);
        System.out.print("how much present : ");int absenKT = c.nextInt();
        for (int i = 0; i < absenKT; i++ ){
            b.hadir();
        }
        b.tampilkanInfo();

    }
}