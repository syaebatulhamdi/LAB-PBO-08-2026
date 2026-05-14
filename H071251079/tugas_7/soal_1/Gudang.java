package H071251079.tugas_7.soal_1;

public class Gudang {

    private int stok;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
        System.out.println("Gudang siap! Kapasitas maks: " + kapasitasMaksimal);
    }

    public synchronized void tambahStok(int jumlah) {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("  [PEMASOK] Gudang hampir penuh (stok=" + stok + "), nunggu dulu...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("  [PEMASOK] Kena interrupt pas nunggu");
                return;
            }
        }

        stok += jumlah;
        System.out.println("  [PEMASOK] Berhasil tambah " + jumlah + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);

        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) {
        while (stok < jumlah) {
            System.out.println("  [KURIR] Stok kurang (stok=" + stok + ", butuh=" + jumlah + "), nunggu pemasok...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("  [KURIR] Kena interrupt pas nunggu");
                return;
            }
        }

        stok -= jumlah;
        System.out.println("  [KURIR] Berhasil ambil " + jumlah + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}