public class Gudang {

    private int stok;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = 0;
    }
   // Metode untuk menambah stok
    public synchronized void tambahStok(int jumlah) {
         // Pastikan stok tidak melebihi kapasitas maksimal
        while (stok + jumlah > kapasitasMaksimal) { 

            try {
                
                System.out.println("Gudang penuh, pemasok menunggu...");
                wait();
              // Menunggu hingga stok tersedia
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        stok += jumlah;
       
        System.out.println("Tambah " + jumlah + " | stok = " + stok);
        
        notifyAll(); // Memberi tahu kurir yang menunggu bahwa stok telah bertambah
    }
    // Metode untuk mengambil stok
    public synchronized void ambilStok(int jumlah) {

        while (stok < jumlah) {

            try {

                System.out.println("Stok tidak cukup, kurir menunggu...");
                wait();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        stok -= jumlah;
       
        System.out.println("Ambil " + jumlah + " | stok = " + stok);

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}