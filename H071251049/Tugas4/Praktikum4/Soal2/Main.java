package Praktikum4.Soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");

            System.out.print(">>> Pilih menu (1-4): ");
            pilihan = input.nextInt();

            switch (pilihan) {

                // TAMBAH PRODUK
                case 1:
                    input.nextLine();

                    System.out.print("Masukkan nama produk: ");
                    String brand = input.nextLine();

                    System.out.print("Masukkan nomor seri: ");
                    int serial = input.nextInt();

                    System.out.print("Masukkan harga: ");
                    double price = input.nextDouble();

                    System.out.println("Pilih tipe produk:");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Camera");
                    System.out.print("Pilih tipe produk (1-3): ");
                    int tipe = input.nextInt();

                    switch (tipe) {
                        case 1:
                            System.out.print("Masukkan ukuran layar (inci): ");
                            double screen = input.nextDouble();
                            System.out.print("Masukkan storage (GB): ");
                            int storage = input.nextInt();

                            products.add(new Smartphone(brand, serial, price, screen, storage));
                            break;

                        case 2:
                            System.out.print("Masukkan RAM (GB): ");
                            int ram = input.nextInt();
                            input.nextLine();
                            System.out.print("Masukkan processor: ");
                            String proc = input.nextLine();

                            products.add(new Laptop(brand, serial, price, ram, proc));
                            break;

                        case 3:
                            System.out.print("Masukkan resolusi (MP): ");
                            int res = input.nextInt();
                            input.nextLine();
                            System.out.print("Masukkan jenis lensa: ");
                            String lens = input.nextLine();

                            products.add(new Camera(brand, serial, price, res, lens));
                            break;

                        default:
                            System.out.println("Tipe tidak valid!");
                    }
                    break;

                // TAMPILKAN
                case 2:
                    if (products.isEmpty()) {
                        System.out.println("Stok kosong!");
                    } else {
                        for (Product p : products) {
                            System.out.println("\n------------------");
                            p.displayInfo();
                        }
                    }
                    break;

                // BELI
                case 3:
                    System.out.print("Masukkan nomor seri produk: ");
                    int cari = input.nextInt();

                    Product found = null;

                    for (Product p : products) {
                        if (p.getSerialNumber() == cari) {
                            found = p;
                            break;
                        }
                    }

                    if (found != null) {
                        System.out.println("\nProduk ditemukan:");
                        found.displayInfo();
                        System.out.println("Pembelian berhasil!");
                        products.remove(found);
                    } else {
                        System.out.println("Produk tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        input.close();
    }
}