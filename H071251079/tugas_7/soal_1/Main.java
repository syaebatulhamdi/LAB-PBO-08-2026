package H071251079.tugas_7.soal_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   SISTEM MANAJEMEN GUDANG LOGISTIK    ");
        System.out.println("========================================");

        Gudang gudang = new Gudang(50);

        ExecutorService executorPemasok = Executors.newFixedThreadPool(3);

        ExecutorService executorKurir = Executors.newFixedThreadPool(3);

        Monitoring monitoring = new Monitoring(gudang);
        Thread threadMonitoring = new Thread(monitoring);
        threadMonitoring.setDaemon(true);

        threadMonitoring.start();

        executorPemasok.submit(new Pemasok(gudang, "Pemasok-A"));
        executorPemasok.submit(new Pemasok(gudang, "Pemasok-B"));

        executorKurir.submit(new Kurir(gudang, "Kurir-1"));
        executorKurir.submit(new Kurir(gudang, "Kurir-2"));
        executorKurir.submit(new Kurir(gudang, "Kurir-3"));

        System.out.println("\n[MAIN] Sistem berjalan selama 15 detik...\n");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n[MAIN] 15 detik habis! Menghentikan semua thread...");

        executorPemasok.shutdown();
        executorKurir.shutdown();

        try {
            if (!executorPemasok.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("[MAIN] Pemasok masih jalan, paksa berhenti...");
                executorPemasok.shutdownNow();
            }
            if (!executorKurir.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("[MAIN] Kurir masih jalan, paksa berhenti...");
                executorKurir.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorPemasok.shutdownNow();
            executorKurir.shutdownNow();
        }

        threadMonitoring.interrupt();

        System.out.println("\n[MAIN] Semua thread sudah dihentikan.");
        System.out.println("[MAIN] Stok akhir gudang: " + gudang.getStok() + " barang");
        System.out.println("========================================");
        System.out.println("   SISTEM SELESAI                      ");
        System.out.println("========================================");
    }
}