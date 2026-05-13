public class Monitoring implements Runnable {

    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        try {

            while (!Thread.currentThread().isInterrupted()) {
                // Simulasi monitoring status gudang setiap detik
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();
            
                int persen = (stok * 100) / kapasitas;

                int jumlahPagar = persen / 10;

                String bar = "";

                for (int i = 0; i < jumlahPagar; i++) {
                    bar += "#";
                }

                for (int i = jumlahPagar; i < 10; i++) {
                    bar += "-";
                }

                System.out.println(
                        "Status Gudang: [" + bar + "] " + persen + "%"
                );

                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            System.out.println("Program selesai");
        }
    }
}