import java.util.Random;

public class Pemasok implements Runnable {

    private Gudang gudang;
    private Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        try {
            // Pemasok akan terus menambah stok selama program berjalan
            while (!Thread.currentThread().isInterrupted()) {
                // Simulasi pemasok menambah stok
                int jumlah = random.nextInt(5) + 1;

                gudang.tambahStok(jumlah);
    
                Thread.sleep((random.nextInt(2) + 1) * 1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}