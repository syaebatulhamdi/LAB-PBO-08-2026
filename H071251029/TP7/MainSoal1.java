import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainSoal1 {

    public static void main(String[] args) throws InterruptedException {

        Gudang gudang = new Gudang(20);

        ExecutorService executor = Executors.newFixedThreadPool(5); 

        // 2 Thread Pemasok
        executor.execute(new Pemasok(gudang));
        executor.execute(new Pemasok(gudang));

        // 3 Thread Kurir
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));

        // Thread Monitoring
        Monitoring monitoring = new Monitoring(gudang);

        Thread monitoringThread = new Thread(monitoring);

        monitoringThread.start();

        System.out.println("Program berjalan selama 15 detik...\n");

        // Program berjalan selama 15 detik
        Thread.sleep(15000);

        // Menghentikan thread dengan aman
        executor.shutdown();

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {

            executor.shutdownNow();
        }

        monitoringThread.interrupt();

        System.out.println("\nProgram selesai");
    }
}