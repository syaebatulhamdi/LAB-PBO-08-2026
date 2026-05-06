package TuPrak6;
public class DVD extends BarangPerpus{
   
    int durasi;
    public DVD(String judul, int ID, int durasi) {
        super(judul, ID);
        this.durasi = durasi;
    }

    // OVERRIDE METHOD LibraryItem
    @Override
    String getDescription(){
       
        return "DVD : " + judul + " durasi : " + durasi + " menit, ID : " + ID;
    }
    @Override
    String pinjamBarang(int Days){
        if (Days > 7){
            throw new IllegalArgumentException("Maksimal peminjaman 7 hari.");
        } if (pinjaman) {
            throw new IllegalArgumentException("item telah dipinjam dan belum dikembalikan.");
        }
        super.BarangDipinjam();
        return getDescription() + " dipinjam.";
    }
    @Override
    // Denda Peminjaman
    double tenggatWaktu(int DaysLate){
        double denda = DaysLate*25000;
        return denda;
    }

}

