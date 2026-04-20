package H071251079.tugas_4.soal_1;

import java.util.Scanner;

class BangunDatar {
    Scanner input;
    String tipeBangunDatar;

    BangunDatar(String tipeBangunDatar, Scanner input) {
        this.tipeBangunDatar = tipeBangunDatar;
        this.input = input;
    }

    void hitungLuas(double hasil) {
        System.out.println("Luas " + tipeBangunDatar + ": " + String.format("%.1f", hasil));
    }

    void hitungKeliling(double hasil) {
        System.out.println("Keliling " + tipeBangunDatar + ": " + String.format("%.1f", hasil));
    }
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(Scanner input) {
        super("persegi", input);
        System.out.print("Masukkan sisi persegi: ");
        sisi = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(sisi * sisi);
    }

    void hitungKeliling() {
        super.hitungKeliling(4 * sisi);
    }
}

class PersegiPanjang extends BangunDatar {
    double panjang, lebar;

    PersegiPanjang(Scanner input) {
        super("persegi panjang", input);
        System.out.print("Masukkan panjang: ");
        panjang = input.nextDouble();
        System.out.print("Masukkan lebar: ");
        lebar = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(panjang * lebar);
    }

    void hitungKeliling() {
        super.hitungKeliling(2 * (panjang + lebar));
    }
}

class Lingkaran extends BangunDatar {
    double jariJari;

    Lingkaran(Scanner input) {
        super("lingkaran", input);
        System.out.print("Masukkan jari-jari lingkaran: ");
        jariJari = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(Math.PI * jariJari * jariJari);
    }

    void hitungKeliling() {
        super.hitungKeliling(2 * Math.PI * jariJari);
    }
}

class Trapesium extends BangunDatar {
    double sisi1, sisi2, sisi3, sisi4, tinggi;

    Trapesium(Scanner input) {
        super("trapesium", input);
        System.out.print("Masukkan sisi 1: ");
        sisi1 = input.nextDouble();
        System.out.print("Masukkan sisi 2: ");
        sisi2 = input.nextDouble();
        System.out.print("Masukkan sisi 3: ");
        sisi3 = input.nextDouble();
        System.out.print("Masukkan sisi 4: ");
        sisi4 = input.nextDouble();
        System.out.print("Masukkan tinggi: ");
        tinggi = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(0.5 * (sisi1 + sisi2) * tinggi);
    }

    void hitungKeliling() {
        super.hitungKeliling(sisi1 + sisi2 + sisi3 + sisi4);
    }
}