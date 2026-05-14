package Library;

public class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, int duration, int itemId) {
        super(title, itemId);
        this.duration = duration;
    } 

    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed)
            throw new IllegalStateException("Item telah dipinjam!");

        if (days > 7)
            throw new IllegalArgumentException("DVD hanya dapat dipinjam maksimal 7 hari!");

        // jika valid, status dipinjam diubah jadi true
        isBorrowed = true;
        return "DVD " + title + " berhasil dipinjam selama " + days + " hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}