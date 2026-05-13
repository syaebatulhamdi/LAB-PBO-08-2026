package H071251079.tugas_7.soal_2;

import java.util.Random;

public class DataProcessor {

    private Random random = new Random();

    public int process(String fileName) {

        long waktuMulai = System.currentTimeMillis();

        System.out.println("  [" + Thread.currentThread().getName() + "] Mulai baca: " + fileName + "...");

        try {
            int jedaMs = random.nextInt(1501) + 500;
            Thread.sleep(jedaMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("  [" + Thread.currentThread().getName() + "] Proses " + fileName + " di-interrupt!");
            return 0;
        }

        int jumlahKata = random.nextInt(451) + 50;

        long waktuSelesai = System.currentTimeMillis();
        long durasi = waktuSelesai - waktuMulai;

        System.out.println("  [" + Thread.currentThread().getName() + "] Selesai memproses "
                + fileName + " (" + jumlahKata + " kata) - Durasi: " + durasi + "ms");

        return jumlahKata;
    }
}
