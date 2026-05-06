package H071251079.tugas_6;

public abstract class LibraryItem {
    private String title;
    private int itemId;
    private boolean isBorrowed;
    
    
    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }
    
    abstract String getDescription();
    
    abstract String borrowItem(int days);
    
    abstract double calculateFine(int daysLate);
    
    String returnItem() {
        this.isBorrowed = false;
        return this.title + " dikembalikan";
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getItemId() {
        return itemId;
    }
    
    public boolean isBorrowed() {
        return isBorrowed;
    }
    
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
}
