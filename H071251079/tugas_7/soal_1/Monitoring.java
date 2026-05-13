package H071251079.tugas_7.soal_1;

public class Monitoring implements Runnable {

    private Gudang gudang;
    private int panjangBar = 20;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        System.out.println("[MONITORING] Sistem monitoring aktif!");

        while (!Thread.currentThread().isInterrupted()) {
            int stokSekarang = gudang.getStok();
            int maks = gudang.getKapasitasMaksimal();
            int persen = (int) ((double) stokSekarang / maks * 100);

            String visualBar = buatVisualBar(persen);

            System.out.println("--------------------------------------------------");
            System.out.println("  Status Gudang: [" + visualBar + "] " + persen + "%");
            System.out.println("  Stok: " + stokSekarang + " / " + maks + " barang");
            System.out.println("--------------------------------------------------");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("[MONITORING] Monitoring dihentikan.");
    }

    private String buatVisualBar(int persen) {
        int jumlahPagar = (int) (panjangBar * persen / 100.0);
        int jumlahTitik = panjangBar - jumlahPagar;

        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < jumlahPagar; i++) {
            bar.append("#");
        }

        for (int i = 0; i < jumlahTitik; i++) {
            bar.append("-");
        }

        return bar.toString();
    }
}
