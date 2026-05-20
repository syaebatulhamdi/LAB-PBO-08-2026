import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class DataProcessor {

    public int process(String fileName) {
        try {
            int waktu = (int) (Math.random() * 1500) + 500;
            Thread.sleep(waktu);

            int jumlahKata = (int) (Math.random() * 900) + 100;

            System.out.println("[" + Thread.currentThread().getName() + "] "
                    + "Selesai memproses " + fileName
                    + " (" + jumlahKata + " kata)");

            return jumlahKata;

        } catch (InterruptedException
             e) {
            System.out.println("Proses terganggu");
            return 0;
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        String[] dokumen = {
                "Dokumen_A.txt",
                "Dokumen_B.txt",
                "Dokumen_C.txt",
                "Dokumen_D.txt",
                "Dokumen_E.txt",
                "Dokumen_F.txt",
                "Dokumen_G.txt",
                "Dokumen_H.txt",
                "Dokumen_I.txt",
                "Dokumen_J.txt"
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        ConcurrentHashMap<String, Integer> hasil = new ConcurrentHashMap<>();

        CountDownLatch latch = new CountDownLatch(dokumen.length);

        ConcurrentHashMap<String, Long> durasi = new ConcurrentHashMap<>();

        AtomicInteger totalKata = new AtomicInteger(0);

        DataProcessor processor = new DataProcessor();

        for (String file : dokumen) {

            executor.execute(() -> {

                long mulai = System.currentTimeMillis();
  
                int jumlah = processor.process(file);

                long selesai = System.currentTimeMillis();

                hasil.put(file, jumlah);

                durasi.put(file, selesai - mulai);

                totalKata.addAndGet(jumlah);

                latch.countDown();
            });
        }

        latch.await();

        executor.shutdown();

        System.out.println("\n========== HASIL AKHIR ==========");
        System.out.println("+----------------+--------------+----------------+");
        System.out.printf("| %-14s | %-12s | %-14s |\n",
                "Nama Dokumen", "Jumlah Kata", "Durasi(ms)");
        System.out.println("+----------------+--------------+----------------+");

        long totalDurasi = 0;

        for (String file : dokumen) {

            int kata = hasil.get(file);

            long waktu = durasi.get(file);

            totalDurasi += waktu;

            System.out.printf("| %-14s | %-12d | %-14d |\n",
                    file, kata, waktu);
        }

        System.out.println("+----------------+--------------+----------------+");

        double rataRata = (double) totalDurasi / dokumen.length;

        System.out.println("Total Kata Keseluruhan : " + totalKata.get());
        System.out.println("Rata-rata Waktu Proses : " + rataRata + " ms");
    }
}