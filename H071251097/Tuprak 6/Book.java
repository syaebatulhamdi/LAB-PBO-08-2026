import java.util.List; 
import java.util.ArrayList; 

public class Book extends LibraryItem {
    private String author;
    private static List<Book> allBooks = new ArrayList<>();

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
        allBooks.add(this); 
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya dapat dipinjam maksimal 14 hari.");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000.0;
    }

    public String getAuthor() { return author; }

    public static void printBooks() {
        System.out.println("+------+----------------------+");
        System.out.printf("| %-4s | %-20s |%n", "ID", "Judul");
        System.out.println("+------+----------------------+");
        for (Book b : allBooks) {
            System.out.printf("| %-4d | %-20s |%n", b.itemId, b.title);
        }
        System.out.println("+------+----------------------+");
    }
}