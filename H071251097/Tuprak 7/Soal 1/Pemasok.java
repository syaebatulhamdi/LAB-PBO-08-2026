import java.util.Random;

class Pemasok implements Runnable{
    Gudang gudang;
    Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    public void run(){
        while(!Thread.currentThread().isInterrupted()){

            int jumlah = random.nextInt(5) + 1;
            gudang.tambahstok(jumlah);

            try {
                Thread.sleep((random.nextInt(2) + 1) * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
