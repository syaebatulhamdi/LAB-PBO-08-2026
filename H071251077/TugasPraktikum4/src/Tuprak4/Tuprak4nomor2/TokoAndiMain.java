package Tuprak4nomor2.Tuprak4nomor2;

import java.util.ArrayList;
import java.util.Scanner;

public class TokoAndiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList< Product > daftarProduk = new ArrayList<>();
        int pilihan = 0;

        while (pilihan != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama produk: ");
                    String brand = scanner.nextLine();
                    System.out.print("Masukkan nomor seri: ");
                    int sn = scanner.nextInt();
                    System.out.print("Masukkan harga: ");
                    double price = scanner.nextDouble();
                    
                    System.out.println("Pilih tipe produk:");
                    System.out.println("1. Smartphone\n2. Laptop\n3. Camera");
                    System.out.print("Pilih tipe produk (1-3): ");
                    int tipe = scanner.nextInt();

                    if (tipe == 1) {
                        System.out.print("Masukkan ukuran layar (inci): ");
                        double screen = scanner.nextDouble();
                        System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                        int storage = scanner.nextInt();
                        daftarProduk.add(new Smartphone(brand, sn, price, screen, storage));
                    } else if (tipe == 2) {
                        System.out.print("Masukkan RAM (GB): ");
                        int ram = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Masukkan tipe prosesor: ");
                        String proc = scanner.nextLine();
                        daftarProduk.add(new Laptop(brand, sn, price, ram, proc));
                    } else if (tipe == 3) {
                        System.out.print("Masukkan resolusi (MP): ");
                        int res = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Masukkan tipe lensa: ");
                        String lens = scanner.nextLine();
                        daftarProduk.add(new Camera(brand, sn, price, res, lens));
                    }
                    break;

                case 2:
                    System.out.println("\nDaftar Produk:");
                    if (daftarProduk.isEmpty()) {
                        System.out.println("Stok kosong.");
                    } else {
                        for (Product p : daftarProduk) {
                            p.displayInfo();
                            System.out.println("-----------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                    int cariSn = scanner.nextInt();
                    boolean ditemukan = false;

                    for (int i = 0; i < daftarProduk.size(); i++) {
                        if (daftarProduk.get(i).seriesNumber == cariSn) {
                            System.out.println("Anda telah membeli produk:");
                            daftarProduk.get(i).displayInfo();
                            daftarProduk.remove(i);
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}