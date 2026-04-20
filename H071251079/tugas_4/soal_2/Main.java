package H071251079.tugas_4.soal_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> daftarProduk = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        //Product productDummy = new Smartphone("Samsung", 123456, 899.99, 6.5, 256);
        //daftarProduk.add(productDummy);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.println();

            System.out.print(">>> Pilih Menu (1-4): ");
            int pilihan = input.nextInt();
            input.nextLine(); // ngamfgfbil "\n" karena di enter
            
            if (pilihan == 1) {
                
                System.out.print("Masukkan nama produk: ");
                String brand = input.nextLine();
                System.out.print("Masukkan nomor seri: ");
                int seriesNumber = input.nextInt();
                System.out.print("Masukkan harga: ");
                double price = input.nextDouble();

                System.out.println("Pilih tipe produk:");
                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Camera");
                System.out.print("Pilih tipe produk (1-3): ");
                int tipeProduk = input.nextInt();

                Product product;

                if (tipeProduk == 1) {

                    System.out.print("Masukkan ukuran layar (inci): ");
                    double screenSize = input.nextDouble();
                    System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                    int storageCapacity = input.nextInt();
                    product = new Smartphone(brand, seriesNumber, price, screenSize, storageCapacity);
                    daftarProduk.add(product);

                } else if (tipeProduk == 2) {

                    System.out.print("Masukkan jenis prosesor: ");
                    String processorType = input.nextLine();
                    System.out.print("Masukkan ukuran RAM (GB): ");
                    int ramSize = input.nextInt();
                    product = new Laptop(brand, seriesNumber, price, processorType, ramSize);
                    daftarProduk.add(product);

                } else if (tipeProduk == 3) {

                    System.out.print("Masukkan resolusi (MP): ");
                    int resolution = input.nextInt();
                    System.out.print("Masukkan jenis lensa: ");
                    String lensType = input.nextLine();
                    product = new Camera(brand, seriesNumber, price, resolution, lensType);
                    daftarProduk.add(product);

                } else {
                    System.out.println("Pilihan tidak valid.");
                }


            } else if (pilihan == 2) {

                System.out.println("Daftar Produk:");
                if (daftarProduk.size() == 0) {
                    System.out.println("Belum ada produk yang ditambahkan.");
                } else {
                    for (Product product : daftarProduk) {
                        product.displayInfo();
                        System.out.println();
                    }
                }

            } else if (pilihan == 3) {

                System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                int seriProduk = input.nextInt();

                for (Product product : daftarProduk) {
                    if (product.seriesNumber == seriProduk) {
                        System.out.println("Anda telah membeli produk:");
                        product.displayInfo();
                        break;
                    } else {
                        System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                        //break;
                    }
                }
                
            } else if (pilihan == 4) {
                System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        input.close();
    }
}
