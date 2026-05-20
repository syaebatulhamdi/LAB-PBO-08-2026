import java.util.Random;

class Kurir implements Runnable {
    Gudang gudang;
    Random random = new Random();

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }

    public void run(){
        while(!Thread.currentThread().isInterrupted()){

            int jumlah = random.nextInt(5) + 1;
            gudang.ambilstok(jumlah);

            try {
                Thread.sleep((random.nextInt(3) + 2) * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
