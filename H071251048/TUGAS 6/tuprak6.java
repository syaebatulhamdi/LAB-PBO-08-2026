import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ================= ABSTRACT CLASS =================
abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem() {
        this.isBorrowed = false;
        return title + " dikembalikan";
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}

// ================= BOOK =================
class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    public String borrowItem(int days) {
        if (days > 14 || isBorrowed) {
            throw new IllegalArgumentException("Buku tidak bisa dipinjam");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}

// ================= DVD =================
class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    public String borrowItem(int days) {
        if (days > 7 || isBorrowed) {
            throw new IllegalArgumentException("DVD tidak bisa dipinjam");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}

// ================= MEMBER =================
class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item sudah dipinjam");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        } else {
            for (LibraryItem item : borrowedItems) {
                System.out.println(item.getDescription());
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return memberId;
    }
}

// ================= LOGGER =================
class LibraryLogger {
    private List<String> logs = new ArrayList<>();

    public String logActivity(String activity) {
        String time = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String log = time + " " + activity;
        logs.add(log);
        return log;
    }

    public String getLogs() {
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}

// ================= LIBRARY =================
class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public void addMember(Member m) {
        members.add(m);
    }

    public Member findMember(int id) {
        return members.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan"));
    }

    public LibraryItem findItemById(int id) {
        return items.stream()
                .filter(i -> i.itemId == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan"));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        for (LibraryItem item : items) {
            sb.append(item.getDescription())
              .append(" - ")
              .append(item.isBorrowed() ? "Dipinjam" : "Tersedia")
              .append("\n");
        }
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}

// ================= MAIN =================
public class tuprak6 {
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
            System.out.println("7. Lihat Item Dipinjam Anggota");
            System.out.println("8. Keluar");

            int pilih = sc.nextInt();
            sc.nextLine();

            try {
                switch (pilih) {

                    case 1:
                        System.out.println("1. Buku | 2. DVD");
                        int jenis = sc.nextInt(); sc.nextLine();

                        System.out.print("Judul: ");
                        String title = sc.nextLine();
                        System.out.print("ID: ");
                        int id = sc.nextInt(); sc.nextLine();

                        if (jenis == 1) {
                            System.out.print("Author: ");
                            String author = sc.nextLine();
                            System.out.println(lib.addItem(new Book(title, id, author)));
                        } else {
                            System.out.print("Durasi: ");
                            int durasi = sc.nextInt();
                            System.out.println(lib.addItem(new DVD(title, id, durasi)));
                        }
                        break;

                    case 2:
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("ID Member: ");
                        int mid = sc.nextInt();

                        lib.addMember(new Member(nama, mid));
                        System.out.println("Member berhasil ditambahkan");
                        break;

                    case 3:
                        System.out.print("ID Member: ");
                        mid = sc.nextInt();
                        System.out.print("ID Item: ");
                        id = sc.nextInt();
                        System.out.print("Hari: ");
                        int hari = sc.nextInt();

                        Member m = lib.findMember(mid);
                        LibraryItem item = lib.findItemById(id);

                        String res = m.borrow(item, hari);
                        lib.getLogger().logActivity(item.title + " dipinjam oleh " + m.getName());

                        System.out.println(res);
                        break;

                    case 4:
                        System.out.print("ID Member: ");
                        mid = sc.nextInt();
                        System.out.print("ID Item: ");
                        id = sc.nextInt();
                        System.out.print("Telat (hari): ");
                        int telat = sc.nextInt();

                        m = lib.findMember(mid);
                        item = lib.findItemById(id);

                        res = m.returnItem(item, telat);
                        lib.getLogger().logActivity(item.title + " dikembalikan oleh " + m.getName());

                        System.out.println(res);
                        break;

                    case 5:
                        System.out.println(lib.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(lib.getAllLogs());
                        break;

                    case 7:
                        System.out.print("ID Member: ");
                        mid = sc.nextInt();

                        m = lib.findMember(mid);
                        m.getBorrowedItems();
                        break;

                    case 8:
                        System.out.println("Program selesai");
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}