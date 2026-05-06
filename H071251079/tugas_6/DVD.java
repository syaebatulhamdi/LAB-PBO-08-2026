package H071251079.tugas_6;

public class DVD extends LibraryItem{
    double duration;

    public DVD(String title, int itemId, double duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    String getDescription() {
        return "DVD: " + getTitle() + ", durasi " + duration + " menit, ID: " + getItemId();
    }

    @Override
    String borrowItem(int days) {
        if (isBorrowed() == true) {
            throw new IllegalArgumentException("Item sudah dipinjam");
        }
        if (days > 7) {
            throw new IllegalArgumentException("Durasi peminjaman maksimal adalah 7 hari");
        }
        return "Item " + getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    double calculateFine(int daysLate) {
        return daysLate * 25000;
    }   
}
