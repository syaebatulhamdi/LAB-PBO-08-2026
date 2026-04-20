package H071251079.tugas_4.soal_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;

        pembatas();
        System.out.println("   ==== BANGUN RUANG ====");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");
        System.out.println("3. Bola");
        System.out.println("4. Tabung");

        System.out.println();

        System.out.println("   ==== BANGUN DATAR ====");
        System.out.println("5. Persegi");
        System.out.println("6. Persegi Panjang");
        System.out.println("7. Lingkaran");
        System.out.println("8. Trapesium");
        pembatas();

        System.out.print("Pilihan: ");
        try {
            pilihan = input.nextInt();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            pembatas();
            input.close();
            return;
        }

        pembatas();
        if (pilihan == 1) {
            Kubus kubus = new Kubus(input);
            kubus.hitungLuas();
            kubus.hitungVolume();
        } else if (pilihan == 2) {
            Balok balok = new Balok(input);
            balok.hitungLuas();
            balok.hitungVolume();
        } else if (pilihan == 3) {
            Bola bola = new Bola(input);
            bola.hitungLuas();
            bola.hitungVolume();
        } else if (pilihan == 4) {
            Tabung tabung = new Tabung(input);
            tabung.hitungLuas();
            tabung.hitungVolume();
        } else if (pilihan == 5) {
            Persegi persegi = new Persegi(input);
            persegi.hitungLuas();
            persegi.hitungKeliling();
        } else if (pilihan == 6) {
            PersegiPanjang persegiPanjang = new PersegiPanjang(input);
            persegiPanjang.hitungLuas();
            persegiPanjang.hitungKeliling();
        } else if (pilihan == 7) {
            Lingkaran lingkaran = new Lingkaran(input);
            lingkaran.hitungLuas();
            lingkaran.hitungKeliling();
        } else if (pilihan == 8) {
            Trapesium trapesium = new Trapesium(input);
            trapesium.hitungLuas();
            trapesium.hitungKeliling();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        pembatas();
        input.close();
    }

    public static void pembatas() {
        System.out.println("========================================");
    }
}