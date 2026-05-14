package Library;

import java.util.Scanner;

public class Main {

    // Input integer aman 
    public static int safeInt(Scanner sc) { 
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Input harus angka! Coba lagi: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {

            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih: ");

            int pilih = safeInt(sc);

            switch (pilih) {

                case 1 -> {
                    System.out.print("Jenis (1=Buku, 2=DVD): ");

                    int jenis;
                    while (true) {
                        jenis = safeInt(sc);
                        if (jenis == 1 || jenis == 2) break;
                        System.out.print("Jenis tidak valid! Masukkan 1 atau 2: ");
                    }

                    System.out.print("Judul: ");
                    String judul = sc.nextLine();

                    // CEK ID UNIK
                    int id;
                    while (true) {
                        System.out.print("ID Item: ");
                        id = safeInt(sc);

                        if (!lib.isIdUsed(id)) break;

                        System.out.println("ID sudah digunakan! Masukkan ID lain.");
                    }

                    if (jenis == 1) {
                        System.out.print("Penulis: ");
                        String penulis = sc.nextLine();
                        lib.addItem(new Book(judul, penulis, id));
                    } else {
                        System.out.print("Durasi (menit): ");
                        int d = safeInt(sc);
                        lib.addItem(new DVD(judul, d, id));
                    }

                    lib.getLogger().logMisc("Item ditambahkan: " + judul);
                    System.out.println("Item berhasil ditambahkan!");
                }

                case 2 -> {
                    System.out.print("Nama Anggota: ");
                    String nama = sc.nextLine();

                    lib.addMember(new Member(nama));

                    lib.getLogger().logMisc("Anggota baru: " + nama);
                    System.out.println("Anggota berhasil ditambahkan!");
                }

                case 3 -> {
                    System.out.print("Nama Anggota: ");
                    String nama = sc.nextLine();
                    Member m = lib.getMember(nama);

                    if (m == null) {
                        System.out.println("Anggota tidak ditemukan!");
                        break;
                    }

                    System.out.print("ID Item: ");
                    int id = safeInt(sc);

                    System.out.print("Lama pinjam (hari): ");
                    int hari = safeInt(sc);

                    try {
                        lib.borrowItem(id, m, hari);
                    } catch (Exception e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.print("Nama Anggota: ");
                    String nama = sc.nextLine();
                    Member m = lib.getMember(nama);

                    if (m == null) {
                        System.out.println("Anggota tidak ditemukan!");
                        break;
                    }

                    System.out.print("ID Item: ");
                    int id = safeInt(sc);

                    try {
                        lib.returnItem(id, m);
                    } catch (Exception e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                }

                case 5 -> {
                    System.out.println("\n=== Status Perpustakaan ===");
                    lib.displayAllItems();
                }

                case 6 -> {
                    System.out.println("\n=== Log Aktivitas ===");
                    lib.showLogs();
                }

                case 7 -> {
                    System.out.print("Nama Anggota: ");
                    String nama = sc.nextLine();

                    Member m = lib.getMember(nama);

                    if (m == null) {
                        System.out.println("Anggota tidak ditemukan!");
                    } else {
                        m.showBorrowedItems();
                    }
                }

                case 8 -> {
                    System.out.println("Keluar dari sistem...");
                    return;
                }

                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}