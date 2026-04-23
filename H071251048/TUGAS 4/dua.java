package tuprak4;

import java.util.ArrayList;
import java.util.Scanner;

// Parent Class
class Produk {
    protected String merek;
    protected String nomorSeri;
    protected double harga;

    public Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println("Merek       : " + merek);
        System.out.println("Nomor Seri  : " + nomorSeri);
        System.out.println("Harga       : Rp " + harga);
    }
}

// Child Smartphone
class Smartphone extends Produk {
    private double ukuranLayar;
    private int penyimpanan;

    public Smartphone(String merek, String nomorSeri, double harga,
                      double ukuranLayar, int penyimpanan) {

        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.penyimpanan = penyimpanan;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar + " inch");
        System.out.println("Storage     : " + penyimpanan + " GB");
    }
}

// Child Laptop
class Laptop extends Produk {
    private int ram;
    private String processor;

    public Laptop(String merek, String nomorSeri, double harga,
                  int ram, String processor) {

        super(merek, nomorSeri, harga);
        this.ram = ram;
        this.processor = processor;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("RAM         : " + ram + " GB");
        System.out.println("Processor   : " + processor);
    }
}

// Child Kamera
class Kamera extends Produk {
    private int resolusi;

    public Kamera(String merek, String nomorSeri, double harga, int resolusi) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Resolusi    : " + resolusi + " MP");
    }
}

// Main Class
public class dua {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Produk> stok = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\n==================================");
            System.out.println("      SISTEM TOKO ELEKTRONIK");
            System.out.println("==================================");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    System.out.println("\nJenis Produk:");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Kamera");
                    System.out.print("Pilih Jenis : ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Masukkan Merek      : ");
                    String merek = input.nextLine();

                    System.out.print("Masukkan No Seri    : ");
                    String seri = input.nextLine();

                    System.out.print("Masukkan Harga      : ");
                    double harga = input.nextDouble();

                    if (jenis == 1) {
                        System.out.print("Ukuran Layar        : ");
                        double layar = input.nextDouble();

                        System.out.print("Kapasitas Storage   : ");
                        int storage = input.nextInt();

                        stok.add(new Smartphone(merek, seri, harga, layar, storage));
                    }

                    else if (jenis == 2) {
                        System.out.print("RAM                 : ");
                        int ram = input.nextInt();
                        input.nextLine();

                        System.out.print("Processor           : ");
                        String proc = input.nextLine();

                        stok.add(new Laptop(merek, seri, harga, ram, proc));
                    }

                    else if (jenis == 3) {
                        System.out.print("Resolusi Kamera     : ");
                        int resolusi = input.nextInt();

                        stok.add(new Kamera(merek, seri, harga, resolusi));
                    }

                    System.out.println("Produk berhasil ditambahkan!");
                    break;

                case 2:
                    if (stok.size() == 0) {
                        System.out.println("Stok masih kosong.");
                    } else {
                        System.out.println("\n===== DAFTAR PRODUK =====");
                        for (Produk p : stok) {
                            System.out.println("--------------------------");
                            p.tampilkanInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan Nomor Seri Produk : ");
                    String cari = input.nextLine();

                    boolean ditemukan = false;

                    for (int i = 0; i < stok.size(); i++) {

                        if (stok.get(i).nomorSeri.equalsIgnoreCase(cari)) {

                            System.out.println("\nProduk ditemukan:");
                            stok.get(i).tampilkanInfo();
                            System.out.println("Pembelian berhasil!");

                            stok.remove(i); // hapus dari stok
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Produk tidak ditemukan.");
                    }

                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 4);
    }
}