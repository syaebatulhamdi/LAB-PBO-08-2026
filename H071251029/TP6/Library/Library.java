package Library;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
 
public class Library {

    private ArrayList<LibraryItem> items = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    // Timestamp
    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // Add item
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    // Add member
    public void addMember(Member m) {
        members.add(m);
    }

    // Get member by name
    public Member getMember(String name) {
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    // Find item
    private LibraryItem findItem(int id) {
        for (LibraryItem item : items) {
            if (item.getItemId() == id) {
                return item;
            }
        } 
        throw new IllegalArgumentException("Item tidak ditemukan!");
    }

    // Borrow item
    public void borrowItem(int id, Member m, int days) {
        LibraryItem item = findItem(id);

        String msg = m.borrow(item, days);
        System.out.println(msg);

        // LOG TABEL
        logger.logBorrow(now(), item.getTitle(), m.getName());
    }

    // Return item
    public void returnItem(int id, Member m) {
        LibraryItem item = findItem(id);

        String msg = m.returnItem(item);
        System.out.println(msg);

        // LOG TABEL
        logger.logReturn(now(), item.getTitle(), m.getName());
    }

    // Display all items
    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("Tidak ada item dalam perpustakaan.");
            return;
        }

        System.out.println("+-------+------------------------------+-----------+");
        System.out.println("|  ID   |           Judul             |  Status   |");
        System.out.println("+-------+------------------------------+-----------+");

        for (LibraryItem item : items) {
            String id = String.format("%-5s", item.getItemId());
            String judul = String.format("%-28s", item.getTitle());
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";

            System.out.printf("| %-5s | %-28s | %-9s |\n", id, judul, status);
        }

        System.out.println("+-------+------------------------------+-----------+");
    }

    // Show logs
    public void showLogs() {
        System.out.println(logger.getFormattedLogs());
    }

    // Getter
    public LibraryLogger getLogger() {
        return logger;
    }

    public boolean isIdUsed(int id) {
        for (LibraryItem item : items) {
            if (item.getItemId() == id) {
                return true;
            }
        }
        return false;
    }
}