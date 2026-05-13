package H071251079.tugas_7.soal_2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("==========================================");
        System.out.println("   SEARCH ENGINE CORE - DATA INDEXER    ");
        System.out.println("==========================================\n");

        List<String> daftarDokumen = new ArrayList<>();
        daftarDokumen.add("Dokumen_A.txt");
        daftarDokumen.add("Dokumen_B.txt");
        daftarDokumen.add("Laporan_Keuangan.pdf");
        daftarDokumen.add("Artikel_AI.txt");
        daftarDokumen.add("Skripsi_Bab1.docx");
        daftarDokumen.add("README.md");
        daftarDokumen.add("Data_Mahasiswa.csv");
        daftarDokumen.add("Proposal_Penelitian.txt");
        daftarDokumen.add("Tutorial_Java.html");
        daftarDokumen.add("Notulen_Rapat.txt");
        daftarDokumen.add("Jurnal_Ilmiah.pdf");
        daftarDokumen.add("Panduan_Praktikum.docx");

        int totalDokumen = daftarDokumen.size();
        System.out.println("[MAIN] Total dokumen yang akan diindeks: " + totalDokumen);
        System.out.println("[MAIN] Jumlah thread yang dipakai: 4\n");

        DataProcessor processor = new DataProcessor();

        ConcurrentHashMap<String, Integer> hasilIndex = new ConcurrentHashMap<>();

        ConcurrentHashMap<String, String> infoThread = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Long> infoDurasi = new ConcurrentHashMap<>();

        CountDownLatch latch = new CountDownLatch(totalDokumen);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("[MAIN] Mulai proses indexing...");
        System.out.println("------------------------------------------");

        long waktuMulaiTotal = System.currentTimeMillis();

        for (String namaDokumen : daftarDokumen) {
            IndexingTask task = new IndexingTask(
                namaDokumen, processor, hasilIndex, infoThread, infoDurasi, latch
            );
            executor.submit(task);
        }

        System.out.println("[MAIN] Semua task sudah di-submit ke thread pool.");
        System.out.println("[MAIN] Menunggu semua dokumen selesai diproses...\n");

        latch.await();

        long waktuSelesaiTotal = System.currentTimeMillis();
        long totalDurasi = waktuSelesaiTotal - waktuMulaiTotal;

        System.out.println("\n------------------------------------------");
        System.out.println("[MAIN] Semua dokumen selesai diproses!\n");

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        tampilkanHasilAkhir(hasilIndex, infoThread, infoDurasi, totalDurasi);
    }

    private static void tampilkanHasilAkhir(ConcurrentHashMap<String, Integer> hasilIndex, ConcurrentHashMap<String, String> infoThread, ConcurrentHashMap<String, Long> infoDurasi, long totalDurasi) {

        System.out.println("=".repeat(80));
        System.out.println("                            HASIL AKHIR INDEXING");
        System.out.println("=".repeat(80));

        System.out.printf("%-30s | %-20s | %-10s | %-10s%n",
            "Nama Dokumen", "Thread", "Jml Kata", "Durasi(ms)");
        System.out.println("-".repeat(80));

        int totalKata = 0;
        long totalDurasiProses = 0;

        for (String namaDokumen : hasilIndex.keySet()) {
            int jumlahKata = hasilIndex.get(namaDokumen);
            String thread = infoThread.getOrDefault(namaDokumen, "-");
            long durasi = infoDurasi.getOrDefault(namaDokumen, 0L);

            totalKata += jumlahKata;
            totalDurasiProses += durasi;

            System.out.printf("%-30s | %-20s | %-10d | %-10d%n",
                namaDokumen, thread, jumlahKata, durasi);
        }

        System.out.println("-".repeat(80));

        double rataRataDurasi = (double) totalDurasiProses / hasilIndex.size();

        System.out.println("\n========== RINGKASAN ==========");
        System.out.println("Total dokumen diproses : " + hasilIndex.size());
        System.out.println("Total kata keseluruhan : " + totalKata + " kata");
        System.out.printf("Rata-rata waktu proses : %.2f ms%n", rataRataDurasi);
        System.out.println("Total waktu keseluruhan: " + totalDurasi + " ms");
        System.out.println("================================");
    }
}