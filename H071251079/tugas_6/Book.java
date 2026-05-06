package H071251079.tugas_6;

public class Book extends LibraryItem {
    public String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }
    
    @Override
    String getDescription() {
        return "Buku: " + getTitle() + " oleh " + this.author + ", ID: " + getItemId();
    }
    
    @Override
    String borrowItem(int days) {
        if (isBorrowed() == true) {
            throw new IllegalArgumentException("Item sudah dipinjam");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Durasi peminjaman maksimal adalah 14 hari");
        }
        return "Item " + getTitle() + " berhasil dipinjam selama " + days + " hari";
    }
    
    @Override
    double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}
