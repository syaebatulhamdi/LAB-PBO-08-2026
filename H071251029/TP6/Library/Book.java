package Library;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, String author, int itemId) {
        super(title, itemId);
        this.author = author;
    } 
    // implementasi method abstrak dari LibraryItem
    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed)
            throw new IllegalStateException("Item telah dipinjam!");

        if (days > 14)
            throw new IllegalArgumentException("Buku hanya boleh dipinjam max 14 hari!");
        
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}