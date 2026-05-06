package tuprak4;

import java.util.Scanner;

// Parent Class Bangun Datar
class BangunDatar {
    public double luas() {
        return 0;
    }

    public double keliling() {
        return 0;
    }
}

// Persegi
class Persegi extends BangunDatar {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double luas() {
        return sisi * sisi;
    }

    public double keliling() {
        return 4 * sisi;
    }
}

// Lingkaran
class Lingkaran extends BangunDatar {
    private double jari;

    public Lingkaran(double jari) {
        this.jari = jari;
    }

    public double luas() {
        return 3.14 * jari * jari;
    }

    public double keliling() {
        return 2 * 3.14 * jari;
    }
}

// Parent Class Bangun Ruang
class BangunRuang {
    public double volume() {
        return 0;
    }

    public double luasPermukaan() {
        return 0;
    }
}

// Kubus
class Kubus extends BangunRuang {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    public double volume() {
        return sisi * sisi * sisi;
    }

    public double luasPermukaan() {
        return 6 * sisi * sisi;
    }
}

// Bola
class Bola extends BangunRuang {
    private double jari;

    public Bola(double jari) {
        this.jari = jari;
    }

    public double volume() {
        return 4.0 / 3 * 3.14 * jari * jari * jari;
    }

    public double luasPermukaan() {
        return 4 * 3.14 * jari * jari;
    }
}

// Main Class
public class satu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
                

        System.out.print("Masukkan sisi persegi : ");
        double sisiPersegi = input.nextDouble();

        System.out.print("Masukkan jari-jari lingkaran : ");
        double jariLingkaran = input.nextDouble();

        System.out.print("Masukkan sisi kubus : ");
        double sisiKubus = input.nextDouble();

        System.out.print("Masukkan jari-jari bola : ");
        double jariBola = input.nextDouble();

        Persegi p = new Persegi(sisiPersegi);
        Lingkaran l = new Lingkaran(jariLingkaran);
        Kubus k = new Kubus(sisiKubus);
        Bola b = new Bola(jariBola);

        System.out.println("\n===== HASIL PERHITUNGAN =====");

        System.out.println("\n--- BANGUN DATAR ---");
        System.out.println("Luas Persegi       : " + p.luas());
        System.out.println("Keliling Persegi   : " + p.keliling());

        System.out.println("Luas Lingkaran     : " + l.luas());
        System.out.println("Keliling Lingkaran : " + l.keliling());

        System.out.println("\n--- BANGUN RUANG ---");
        System.out.println("Volume Kubus           : " + k.volume());
        System.out.println("Luas Permukaan Kubus   : " + k.luasPermukaan());

        System.out.println("Volume Bola            : " + b.volume());
        System.out.println("Luas Permukaan Bola    : " + b.luasPermukaan());
    }
}