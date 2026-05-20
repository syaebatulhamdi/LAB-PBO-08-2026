class Monitor implements Runnable{
    Gudang gudang;

    public Monitor(Gudang gudang) {
        this.gudang = gudang;
    }

    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            int stok = gudang.stok;
            int kapasitas = gudang.kapasitasmaks;
            int persen = (stok * 100) / kapasitas;

            System.out.println("Status Gudang [#######-------] "+ persen + "%");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
