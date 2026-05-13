package H071251079.tugas_7.soal_2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class IndexingTask implements Runnable {

    private String namaFile;
    private DataProcessor processor;

    private ConcurrentHashMap<String, Integer> hasilIndex;

    private ConcurrentHashMap<String, String> infoThread;

    private ConcurrentHashMap<String, Long> infoDurasi;

    private CountDownLatch latch;

    public IndexingTask(String namaFile, DataProcessor processor, ConcurrentHashMap<String, Integer> hasilIndex, ConcurrentHashMap<String, String> infoThread, ConcurrentHashMap<String, Long> infoDurasi, CountDownLatch latch) {
        this.namaFile = namaFile;
        this.processor = processor;
        this.hasilIndex = hasilIndex;
        this.infoThread = infoThread;
        this.infoDurasi = infoDurasi;
        this.latch = latch;
    }

    @Override
    public void run() {
        String namaThread = Thread.currentThread().getName();
        infoThread.put(namaFile, namaThread);

        long mulai = System.currentTimeMillis();

        int jumlahKata = processor.process(namaFile);

        long durasi = System.currentTimeMillis() - mulai;

        hasilIndex.put(namaFile, jumlahKata);
        infoDurasi.put(namaFile, durasi);

        latch.countDown();
    }
}