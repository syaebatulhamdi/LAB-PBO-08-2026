import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainSoal2 {
    public static void main(String[] args) {
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

        ConcurrentHashMap<String, Integer> hasilMap = new ConcurrentHashMap<>();

        List<HasilData> daftarHasil = new ArrayList<>();

        CountDownLatch latch = new CountDownLatch(dokumen.length);

        DataProcessor processor = new DataProcessor();

        for (String dokumenNama : dokumen) {
            executor.execute(() -> {
                long start = System.currentTimeMillis();

                int jumlahKata = processor.process(dokumenNama);

                long end = System.currentTimeMillis();
                long durasi = end - start;

                String namaThread = Thread.currentThread().getName();

                hasilMap.put(dokumenNama, jumlahKata);

                synchronized (daftarHasil) {
                    daftarHasil.add(new HasilData(
                            dokumenNama,
                            namaThread,
                            jumlahKata,
                            durasi
                    ));
                }

                System.out.println("[" + namaThread + "] Selesai memproses "
                        + dokumenNama + " (" + jumlahKata + " kata)");

                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("\n========================= TABEL RINGKASAN =========================");
        System.out.printf("%-20s %-20s %-15s %-15s\n",
                "Nama Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi(ms)");

        int totalKata = 0;
        long totalDurasi = 0;

        for (HasilData data : daftarHasil) {
            System.out.printf("%-20s %-20s %-15d %-15d\n",
                    data.getNamaDokumen(),
                    data.getNamaThread(),
                    data.getJumlahKata(),
                    data.getDurasi());

            totalKata += data.getJumlahKata();
            totalDurasi += data.getDurasi();
        }

        double rataDurasi = (double) totalDurasi / daftarHasil.size();

        System.out.println("\n=========================== HASIL AKHIR ===========================");
        System.out.println("Total Kata Keseluruhan : " + totalKata);
        System.out.println("Rata-rata Durasi       : " + rataDurasi + " ms");
    }
}