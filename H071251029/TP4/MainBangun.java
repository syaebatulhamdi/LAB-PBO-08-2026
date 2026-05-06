package TP4;

import java.util.Scanner;

public class MainBangun {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("===== BANGUN RUANG =====");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        System.out.println("\n===== BANGUN DATAR =====");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("----------------------------------------");

        System.out.print("Pilihan: ");
        int pilih = sc.nextInt();

        System.out.println("----------------------------------------");

        switch (pilih) {

            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double s = sc.nextDouble();
                Kubus k = new Kubus(s);
                System.out.println("Volume kubus: " + k.volume());
                System.out.println("Luas permukaan kubus: " + k.luasPermukaan());
                break;

            case 2:
                System.out.print("Masukkan panjang: ");
                double p = sc.nextDouble();
                System.out.print("Masukkan lebar: ");
                double l = sc.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double t = sc.nextDouble();
                Balok b = new Balok(p,l,t);
                System.out.println("Volume balok: " + b.volume());
                System.out.println("Luas permukaan balok: " + b.luasPermukaan());
                break;

            case 3:
                System.out.print("Masukkan jari-jari: ");
                double r = sc.nextDouble();
                Bola bo = new Bola(r);
                System.out.println("Volume bola: " + bo.volume());
                System.out.println("Luas permukaan bola: " + bo.luasPermukaan());
                break;

            case 4:
                System.out.print("Masukkan jari-jari: ");
                double rt = sc.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double tt = sc.nextDouble();
                Tabung tb = new Tabung(rt, tt);
                System.out.println("Volume tabung: " + tb.volume());
                System.out.println("Luas permukaan tabung: " + tb.luasPermukaan());
                break;

            case 5:
                System.out.print("Masukkan sisi: ");
                double sp = sc.nextDouble();
                Persegi ps = new Persegi(sp);
                System.out.println("Luas persegi: " + ps.luas());
                System.out.println("Keliling persegi: " + ps.keliling());
                break;

            case 6:
                System.out.print("Masukkan panjang: ");
                double pp = sc.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lp = sc.nextDouble();
                PersegiPanjang pj = new PersegiPanjang(pp, lp);
                System.out.println("Luas persegi panjang: " + pj.luas());
                System.out.println("Keliling persegi panjang: " + pj.keliling());
                break;

            case 7:
                System.out.print("Masukkan jari-jari: ");
                double rl = sc.nextDouble();
                Lingkaran lg = new Lingkaran(rl);
                System.out.println("Luas lingkaran: " + lg.luas());
                System.out.println("Keliling lingkaran: " + lg.keliling());
                break;

            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double a = sc.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double b2 = sc.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double c = sc.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double d = sc.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double t2 = sc.nextDouble();

                Trapesium tr = new Trapesium(a,b2,c,d,t2);
                System.out.println("Luas trapesium: " + tr.luas());
                System.out.println("Keliling trapesium: " + tr.keliling());
                break;

            default:
                System.out.println("Pilihan tidak valid");
        }

        System.out.println("----------------------------------------");
    }
}
