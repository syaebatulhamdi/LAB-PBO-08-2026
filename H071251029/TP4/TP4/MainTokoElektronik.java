package TP4;

import java.util.*;

public class MainTokoElektronik {

    static ArrayList<Produk> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    tambah();
                    break;
                case 2:
                    tampil();
                    break;
                case 3:
                    beli();
                    break;
                case 4:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);
    }

    static void tambah() {
        System.out.println("\n=== Tambah Produk ===");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Kamera");
        System.out.print("Pilih jenis: ");
        int jenis = sc.nextInt();
        sc.nextLine();

        System.out.print("Merek: ");
        String m = sc.nextLine();

        System.out.print("Nomor Seri: ");
        String n = sc.nextLine();

        System.out.print("Harga: ");
        double h = sc.nextDouble();

        if (jenis == 1) {
            System.out.print("Ukuran Layar: ");
            double layar = sc.nextDouble();

            System.out.print("Storage: ");
            int s = sc.nextInt();

            list.add(new Smartphone(m, n, h, layar, s));

        } else if (jenis == 2) {
            System.out.print("RAM: ");
            int r = sc.nextInt();
            sc.nextLine();

            System.out.print("Processor Type: "); // ✅ WAJIB ADA
            String p = sc.nextLine();

            list.add(new Laptop(m, n, h, r, p));

        } else if (jenis == 3) {
            System.out.print("Resolusi (MP): ");
            int mp = sc.nextInt();

            list.add(new Kamera(m, n, h, mp));
        }

        System.out.println("Produk berhasil ditambahkan!");
    }

    static void tampil() {
        System.out.println("\n=== Daftar Produk ===");

        if (list.isEmpty()) {
            System.out.println("Tidak ada produk.");
        } else {
            for (Produk p : list) {
                System.out.println("--------------------");
                p.tampil();
            }
        }
    }

    static void beli() {
        sc.nextLine();
        System.out.print("\nMasukkan Nomor Seri: ");
        String cari = sc.nextLine();

        boolean ditemukan = false;

        for (Produk p : list) {
            if (p.nomorSeri.equalsIgnoreCase(cari)) {
                System.out.println("\nProduk ditemukan:");
                p.tampil();
                System.out.println("Pembelian berhasil!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk tidak ditemukan!");
        }
    }
}