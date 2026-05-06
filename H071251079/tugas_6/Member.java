package H071251079.tugas_6;

import java.util.ArrayList;
import java.util.List;

public class Member {
    String name;
    int memberId;
    List<LibraryItem> borrowedItems;
    Table table = new Table();

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    String borrow(LibraryItem item, int days) {
        if (item.isBorrowed() == true) {
            throw new IllegalStateException("Item sudah dipinjam");
        }
        item.borrowItem(days);
        item.setBorrowed(true);
        this.borrowedItems.add(item);

        return "Item " + item.getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    String returnItem(LibraryItem item, int daysLate) {
        if (item.isBorrowed() == false) {
            throw new IllegalStateException("Item tidak sedang dipinjam");
        }

        item.returnItem();
        this.borrowedItems.remove(item);
        double denda = item.calculateFine(daysLate);
        String dendaFormatRp = String.format("%,.0f",denda);

        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: " + (daysLate > 0 ? "Rp " + dendaFormatRp : "Tidak ada");
    }

    void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        List<String[]> data = new ArrayList<>();
        for (LibraryItem item : borrowedItems) {
            data.add(new String[]{String.valueOf(item.getItemId()), item.getTitle()});
        }
        String[] headers = {"ID", "Judul"};
        table.printTable(headers, data);
    }
}
