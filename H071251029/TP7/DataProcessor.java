import java.util.Random;

public class DataProcessor {
    private Random random = new Random(); // Simulasi pemrosesan data

    public int process(String fileName) {
        try {
            int waktu = random.nextInt(1501) + 500; 
            Thread.sleep(waktu); 
        } catch (InterruptedException e) { 
            Thread.currentThread().interrupt();
        }

        return random.nextInt(900) + 100;
    }
}