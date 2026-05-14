package H071251079.tugas_7.soal_1;

import java.util.Random;

public class Pemasok implements Runnable {

    private Gudang gudang;
    private String nama;
    private Random random;

    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("[" + nama + "] Pemasok mulai bekerja!");

        while (!Thread.currentThread().isInterrupted()) {
            int jumlahKirim = random.nextInt(16) + 5;

            System.out.println("[" + nama + "] Mau kirim " + jumlahKirim + " barang ke gudang...");
            gudang.tambahStok(jumlahKirim);

            try {
                int jedaDetik = random.nextInt(1000) + 1000;
                Thread.sleep(jedaDetik);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("[" + nama + "] Pemasok selesai.");
    }
}