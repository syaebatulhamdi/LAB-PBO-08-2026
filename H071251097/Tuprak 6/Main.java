import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextItemId = 100;
    private static int nextMemberId = 1;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine().trim();
            System.out.println();
            switch (input) {
                case "1": tambahItem(); break;
                case "2": tambahAnggota(); break;
                case "3": pinjamItem(); break;
                case "4": kembalikanItem(); break;
                case "5": lihatStatus(); break;
                case "6": lihatLog(); break;
                case "7": lihatItemDipinjamAnggota(); break;
                case "8":
                    System.out.println("Terima kasih. Sampai jumpa!");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    private static void tambahItem() {
        System.out.println("-- Tambah Item --");
        System.out.println("Jenis item:");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilih jenis: ");
        String jenis = scanner.nextLine().trim();

        System.out.print("Judul: ");
        String title = scanner.nextLine().trim();

        int id = nextItemId++;
        try {
            if (jenis.equals("1")) {
                System.out.print("Nama penulis: ");
                String author = scanner.nextLine().trim();
                Book book = new Book(title, id, author);
                System.out.println(library.addItem(book));
                System.out.println("ID Item: " + id);
            } else if (jenis.equals("2")) {
                System.out.print("Durasi (menit): ");
                int duration = Integer.parseInt(scanner.nextLine().trim());
                DVD dvd = new DVD(title, id, duration);
                System.out.println(library.addItem(dvd));
                System.out.println("ID Item: " + id);
            } else {
                System.out.println("Jenis tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        }
    }

    private static void tambahAnggota() {
        System.out.println("-- Tambah Anggota --");
        System.out.print("Nama anggota: ");
        String name = scanner.nextLine().trim();
        int id = nextMemberId++;
        Member member = new Member(name, id);
        System.out.println(library.addMember(member));
        System.out.println("ID Anggota: " + id);
    }

    private static void pinjamItem() {
        System.out.println("-- Pinjam Item --");
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Jumlah hari peminjaman: ");
            int days = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.borrowItem(memberId, itemId, days));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void kembalikanItem() {
        System.out.println("-- Kembalikan Item --");
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("ID Item: ");
            int itemId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Jumlah hari keterlambatan: ");
            int daysLate = Integer.parseInt(scanner.nextLine().trim());
            System.out.println(library.returnItem(memberId, itemId, daysLate));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void lihatStatus() {
        System.out.println("-- Status Perpustakaan --");
        System.out.println(library.getLibraryStatus());
    }

    private static void lihatLog() {
        System.out.println("-- Log Aktivitas --");
        System.out.println(library.getAllLogs());
    }

    private static void lihatItemDipinjamAnggota() {
        System.out.println("-- Item yang Dipinjam Anggota --");
        try {
            System.out.print("ID Anggota: ");
            int memberId = Integer.parseInt(scanner.nextLine().trim());
            Member member = library.findMemberById(memberId);
            System.out.println("Anggota: " + member.getName());
            member.getBorrowedItems();
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
