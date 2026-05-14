package Library;

public abstract class LibraryItem {
    protected String title; 
    protected int itemId;
    protected boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }
    // method abstrak untuk deskripsi, pinjam, dan denda
    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    // saat mengembalikan item, statusnya diubah jadi tidak dipinjam
    public void returnItem() { 
        isBorrowed = false;
    }
    // cek status
    public boolean isBorrowed() {
        return isBorrowed;
    }
    // ambil data tanpa akses langsung
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }
}