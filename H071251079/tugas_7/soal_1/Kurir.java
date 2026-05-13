package H071251079.tugas_7.soal_1;

import java.util.Random;

public class Kurir implements Runnable {

    private Gudang gudang;
    private String nama;
    private Random random;

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("[" + nama + "] Kurir siap mengambil barang!");

        while (!Thread.currentThread().isInterrupted()) {
            int jumlahAmbil = random.nextInt(13) + 3;

            System.out.println("[" + nama + "] Mau ambil " + jumlahAmbil + " barang dari gudang...");
            gudang.ambilStok(jumlahAmbil);

            try {
                int jedaDetik = random.nextInt(1000) + 2000;
                Thread.sleep(jedaDetik);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("[" + nama + "] Kurir selesai.");
    }
}