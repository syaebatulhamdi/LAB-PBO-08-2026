import java.util.ArrayList;
import java.util.List;

public class Member {
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
            return "Gagal: Item " + item.getTitle() + " tidak tersedia (sudah dipinjam).";
        }
        item.borrowItem(days);
        borrowedItems.add(item);
        return "Item " + item.getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Gagal: Item " + item.getTitle() + " tidak sedang dipinjam oleh " + name + ".";
        }
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        String fineFormatted = String.format("%,.0f", fine).replace(",", ".");
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + fineFormatted;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+------+----------------------+");
        System.out.printf("| %-4s | %-20s |%n", "ID", "Judul");
        System.out.println("+------+----------------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-4d | %-20s |%n", item.getItemId(), item.getTitle());
        }
        System.out.println("+------+----------------------+");
    }

    public List<LibraryItem> getBorrowedItemsList() { return borrowedItems; }
    public String getName() { return name; }
    public int getMemberId() { return memberId; }
}
