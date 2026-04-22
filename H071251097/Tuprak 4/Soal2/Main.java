// package Soal2;

// import java.util.ArrayList;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {

//         Scanner input = new Scanner(System.in);

//         ArrayList<Smartphone> daftarHP = new ArrayList<>();
//         ArrayList<Laptop> daftarLaptop = new ArrayList<>();
//         ArrayList<Kamera> daftarKamera = new ArrayList<>();

//         int pilihan;

//         do {
//             System.out.println("\n=== MENU TOKO ELEKTRONIK ===");
//             System.out.println("1. Tambah Produk");
//             System.out.println("2. Tampilkan Produk");
//             System.out.println("3. Beli Produk");
//             System.out.println("4. Keluar");
//             System.out.print("Pilih: ");
//             pilihan = input.nextInt();

//             // Tambah Produk
//             if (pilihan == 1) {

//                 System.out.println("1. Smartphone");
//                 System.out.println("2. Laptop");
//                 System.out.println("3. Kamera");
//                 System.out.print("Pilih jenis: ");
//                 int jenis = input.nextInt();
//                 input.nextLine();

//                 System.out.print("Merek: ");
//                 String merek = input.nextLine();
//                 System.out.print("Nomor Seri: ");
//                 String seri = input.nextLine();
//                 System.out.print("Harga: ");
//                 double harga = input.nextDouble();

//                 if (jenis == 1) {
//                     System.out.print("Ukuran Layar: ");
//                     double layar = input.nextDouble();
//                     System.out.print("Storage: ");
//                     int storage = input.nextInt();

//                     daftarHP.add(new Smartphone(merek, seri, harga, layar, storage));

//                 } else if (jenis == 2) {
//                     input.nextLine();
//                     System.out.print("Processor: ");
//                     String proc = input.nextLine();
//                     System.out.print("size: ");
//                     int sz = input.nextInt();


//                     daftarLaptop.add(new Laptop(merek, seri, harga, proc, sz));

//                 } else if (jenis == 3) {
//                     System.out.print("Resolusi: ");
//                     int res = input.nextInt();
//                     System.out.print("lensType ");
//                     String les = input.next();

//                     daftarKamera.add(new Kamera(merek, seri, harga, res, les));
//                 }

//                 System.out.println("Produk berhasil ditambahkan!");
//             }

//             // Tampilkan Produk
//             else if (pilihan == 2) {

//                 System.out.println("\n=== DAFTAR SMARTPHONE ===");
//                 for (Smartphone s : daftarHP) {
//                     s.tampilkanInfo();
//                     System.out.println("-------------------");
//                 }

//                 System.out.println("\n=== DAFTAR LAPTOP ===");
//                 for (Laptop l : daftarLaptop) {
//                     l.tampilkanInfo();
//                     System.out.println("-------------------");
//                 }

//                 System.out.println("\n=== DAFTAR KAMERA ===");
//                 for (Kamera k : daftarKamera) {
//                     k.tampilkanInfo();
//                     System.out.println("-------------------");
//                 }
//             }

//             // Beli Produk
//             else if (pilihan == 3) {

//                 input.nextLine();
//                 System.out.print("Masukkan Nomor Seri: ");
//                 String cari = input.nextLine();
//                 boolean ditemukan = false;

//                 // cek hp
//                 for (Smartphone s : daftarHP) {
//                     if (s.nomorSeri.equals(cari)) {
//                         s.tampilkanInfo();
//                         System.out.println("Pembelian berhasil!");
//                         ditemukan = true;
//                     }
//                 }

//                 // cek laptop
//                 for (Laptop l : daftarLaptop) {
//                     if (l.nomorSeri.equals(cari)) {
//                         l.tampilkanInfo();
//                         System.out.println("Pembelian berhasil!");
//                         ditemukan = true;
//                     }
//                 }

//                 // cek kamera
//                 for (Kamera k : daftarKamera) {
//                     if (k.nomorSeri.equals(cari)) {
//                         k.tampilkanInfo();
//                         System.out.println("Pembelian berhasil!");
//                         ditemukan = true;
//                     }
//                 }

//                 if (!ditemukan) {
//                     System.out.println("Produk tidak ditemukan!");
//                 }
//             }

//         } while (pilihan != 4);

//         System.out.println("Terima kasih telah menggunakan sistem.");
//     }
// }