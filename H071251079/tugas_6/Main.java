package H071251079.tugas_6;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi 1-8: ");

            int pilihan = 0;
            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine();
                System.out.println();
                continue;
            }
            
            try { 

                if (pilihan == 1) {
                    tambahItem();
                } else if (pilihan == 2) {
                    tambahAnggota();
                } else if (pilihan == 3) {
                    pinjamItem();
                } else if (pilihan == 4) {
                    kembalikanItem();
                } else if (pilihan == 5) {
                    lihatStatusPerpustakaan();
                } else if (pilihan == 6) {
                    lihatLogAktivitas();
                } else if (pilihan == 7) {
                    lihatItemYangDipinjamAnggota();
                } else if (pilihan == 8) {
                    System.out.println("Terimakasih telah menggunakan layanan kami!");
                    break;
                } else {
                    System.out.println("Harus memilih pilihan 1-8 !!!");
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
                continue;
            }
        }

        input.close();
    }

    private static void tambahItem() {
        System.out.println("Pilih Item:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.print("Pilih opsi 1 atau 2: ");

        int pilih = 0;
        String title = "";
        int itemId = 0;

        try {
            pilih = input.nextInt();
            input.nextLine();

            System.out.print("Masukkan title: ");
            title = input.nextLine();

            System.out.print("Masukkan Id Item: ");
            itemId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        LibraryItem item;

        if (pilih == 1) {

            System.out.print("Masukkan Author: ");
            String author = input.nextLine();
            item = new Book(title, itemId, author);

        } else if (pilih == 2) {

            System.out.print("Masukkan duration(menit): ");
            double duration = input.nextDouble();
            input.nextLine();
            item = new DVD(title, itemId, duration);

        } else {
            System.out.println("Pilihan item harus 1 atau 2.");
            return;
        }

        System.out.println(library.addItem(item));
        System.out.println(item.getDescription());
    }

    private static void tambahAnggota() {
        System.out.print("Masukkan nama: ");
        String name = input.nextLine();
        System.out.print("Masukkan Id Member: ");
        int memberId = 0;
        try {
            memberId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }
        Member member = new Member(name, memberId);
        System.out.println(library.addMember(member));
    }

    private static void pinjamItem() {
        System.out.print("Masukkan Id Member: ");
        int memberId = 0;
        try {
            memberId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        Member member = library.findMemberById(memberId);
        if (member == null) {
            System.out.println("Id anggota dengan " + memberId + " tidak ditemukan");
            return;
        }

        System.out.print("Masukkan Id Item: ");
        int itemId = 0;
        try {
            itemId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        LibraryItem item = library.findItemById(itemId);
        if (item == null) {
            System.out.println("Id item dengan " + itemId + " tidak ditemukan");
            return;
        }

        System.out.print("Masukkan waktu peminjaman (hari): ");
        int days = 0;
        try {
            days = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        System.out.println(member.borrow(item, days));
        library.logger.logActivity("dipinjam", member.getName(), item.getTitle());
    }

    private static void kembalikanItem() {
        System.out.print("Masukkan Id Member: ");
        int memberId = 0;
        try {
            memberId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        Member member = library.findMemberById(memberId);
        if (member == null) {
            System.out.println("Id anggota dengan " + memberId + " tidak ditemukan");
            return;
        }

        System.out.print("Masukkan Id Item: ");
        int itemId = 0;
        try {
            itemId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        LibraryItem item = library.findItemById(itemId);
        if (item == null) {
            System.out.println("Id item dengan " + itemId + " tidak ditemukan");
            return;
        }

        System.out.print("Masukkan keterlambatan pengembalian (hari): ");
        int daysLate = 0;
        try {
            daysLate = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        System.out.println(member.returnItem(item, daysLate));
        library.logger.logActivity("dikembalikan", member.getName(), item.getTitle());
    }

    private static void lihatStatusPerpustakaan() {
        library.getLibraryStatus();
    }

    private static void lihatLogAktivitas() {
        library.getAllLogs();
    }

    private static void lihatItemYangDipinjamAnggota() {
        System.out.print("Masukkan Id Member: ");
        int memberId = 0;
        try {
            memberId = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
            input.nextLine();
            return;
        }

        Member member = library.findMemberById(memberId);
        if (member == null) {
            System.out.println("Id anggota dengan " + memberId + " tidak ditemukan");
            return;
        }
        member.getBorrowedItems();
    }

}