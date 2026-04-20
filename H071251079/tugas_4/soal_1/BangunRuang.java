package H071251079.tugas_4.soal_1;

import java.util.Scanner;

class BangunRuang {
    Scanner input;
    String tipeBangunRuang;

    BangunRuang(String tipeBangunRuang, Scanner input) {
        this.tipeBangunRuang = tipeBangunRuang;
        this.input = input;
    }

    void hitungLuas(double hasil) {
        System.out.println("Luas " + tipeBangunRuang + ": " + String.format("%.1f", hasil));
    }

    void hitungVolume(double hasil) {
        System.out.println("Volume " + tipeBangunRuang + ": " + String.format("%.1f", hasil));
    }
}

class Kubus extends BangunRuang {
    double sisi;

    Kubus(Scanner input) {
        super("kubus", input);
        System.out.print("Masukkan sisi kubus: ");
        sisi = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(6 * sisi * sisi);
    }

    void hitungVolume() {
        super.hitungVolume(sisi * sisi * sisi);
    }
}

class Balok extends BangunRuang {
    double panjang, lebar, tinggi;

    Balok(Scanner input) {
        super("balok", input);
        System.out.print("Masukkan panjang balok: ");
        panjang = input.nextDouble();
        System.out.print("Masukkan lebar balok: ");
        lebar = input.nextDouble();
        System.out.print("Masukkan tinggi balok: ");
        tinggi = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(2 * (panjang * lebar + panjang * tinggi + lebar * tinggi));
    }

    void hitungVolume() {
        super.hitungVolume(panjang * lebar * tinggi);
    }
}

class Bola extends BangunRuang {
    double jariJari;

    Bola(Scanner input) {
        super("bola", input);
        System.out.print("Masukkan jari-jari bola: ");
        jariJari = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(4 * Math.PI * jariJari * jariJari);
    }

    void hitungVolume() {
        super.hitungVolume((4.0 / 3.0) * Math.PI * jariJari * jariJari * jariJari);
    }
}

class Tabung extends BangunRuang {
    double jariJari, tinggi;

    Tabung(Scanner input) {
        super("tabung", input);
        System.out.print("Masukkan jari-jari tabung: ");
        jariJari = input.nextDouble();
        System.out.print("Masukkan tinggi tabung: ");
        tinggi = input.nextDouble();
    }

    void hitungLuas() {
        super.hitungLuas(2 * Math.PI * jariJari * (jariJari + tinggi));
    }

    void hitungVolume() {
        super.hitungVolume(Math.PI * jariJari * jariJari * tinggi);
    }
}