import java.util.Random;

public class Kurir implements Runnable {

    private Gudang gudang;
    private Random random = new Random();

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }
    
    @Override
    public void run() {

        try {
            
            while (!Thread.currentThread().isInterrupted()) {
                // Simulasi kurir mengambil stok
                int jumlah = random.nextInt(4) + 1;

                gudang.ambilStok(jumlah);
                // Simulasi kurir mengantarkan barang
                Thread.sleep((random.nextInt(2) + 2) * 1000);
            }
    
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}