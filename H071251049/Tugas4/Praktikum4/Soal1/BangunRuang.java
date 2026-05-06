package Praktikum4.Soal1;
import java.util.Scanner;

// ===== BANGUN RUANG =====
class Kubus {
    double sisi;

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

class Balok extends PersegiPanjang {
    private double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public double volume() {
        return sisi * lebar * tinggi;
    }

    public double luasPermukaan() {
        return 2 * ((sisi * lebar) + (sisi * tinggi) + (lebar * tinggi));
    }
}

class Bola extends Lingkaran {
    public Bola(double jari) {
        super(jari);
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * jari * jari * jari;
    }

    public double luasPermukaan() {
        return 4 * Math.PI * jari * jari;
    }
}

class Tabung extends Lingkaran {
    private double tinggi;

    public Tabung(double jari, double tinggi) {
        super(jari);
        this.tinggi = tinggi;
    }

    public double volume() {
        return Math.PI * jari * jari * tinggi;
    }

    public double luasPermukaan() {
        return 2 * Math.PI * jari * (jari + tinggi);
    }
}


// ===== CLASS MENU =====
class Menu {

    public void tampilkanMenu() {
        System.out.println("===BANGUN RUANG===");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG\n");

        System.out.println("===BANGUN DATAR===");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM\n");
    }

    public void jalankan() {
        Scanner input = new Scanner(System.in);

        tampilkanMenu();
        System.out.print("Pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {

            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double s = input.nextDouble();
                Kubus k = new Kubus(s);
                System.out.println("Volume kubus: " + k.volume());
                System.out.println("Luas permukaan kubus: " + k.luasPermukaan());
                break;

            case 2:
                System.out.print("Masukkan panjang: ");
                double p = input.nextDouble();
                System.out.print("Masukkan lebar: ");
                double l = input.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double t = input.nextDouble();
                Balok b = new Balok(p, l, t);
                System.out.println("Volume balok: " + b.volume());
                System.out.println("Luas permukaan balok: " + b.luasPermukaan());
                break;

            case 3:
                System.out.print("Masukkan jari-jari bola: ");
                double r1 = input.nextDouble();
                Bola bola = new Bola(r1);
                System.out.println("Volume bola: " + bola.volume());
                System.out.println("Luas permukaan bola: " + bola.luasPermukaan());
                break;

            case 4:
                System.out.print("Masukkan jari-jari tabung: ");
                double r2 = input.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tt = input.nextDouble();
                Tabung tabung = new Tabung(r2, tt);
                System.out.println("Volume tabung: " + tabung.volume());
                System.out.println("Luas permukaan tabung: " + tabung.luasPermukaan());
                break;

            case 5:
                System.out.print("Masukkan sisi persegi: ");
                double sp = input.nextDouble();
                Persegi ps = new Persegi(sp);
                System.out.println("Luas persegi: " + ps.luas());
                System.out.println("Keliling persegi: " + ps.keliling());
                break;

            case 6:
                System.out.print("Masukkan panjang: ");
                double pj = input.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lb = input.nextDouble();
                PersegiPanjang pp = new PersegiPanjang(pj, lb);
                System.out.println("Luas persegi panjang: " + pp.luas());
                System.out.println("Keliling persegi panjang: " + pp.keliling());
                break;

            case 7:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double rl = input.nextDouble();
                Lingkaran lk = new Lingkaran(rl);
                System.out.println("Luas lingkaran: " + lk.luas());
                System.out.println("Keliling lingkaran: " + lk.keliling());
                break;

            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double a = input.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double b2 = input.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double c = input.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double d = input.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tg = input.nextDouble();

                Trapesium tr = new Trapesium(a, b2, c, d, tg);
                System.out.println("Luas trapesium: " + tr.luas());
                System.out.println("Keliling trapesium: " + tr.keliling());
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}