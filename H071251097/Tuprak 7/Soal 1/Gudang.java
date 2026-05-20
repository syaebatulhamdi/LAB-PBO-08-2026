class Gudang{
    int stok;
    int kapasitasmaks;

    public Gudang(int kapasitasmaks) {
        this.kapasitasmaks = kapasitasmaks;
        this.stok = 0;
    }

    public synchronized void tambahstok(int jumlah){  
        while(stok + jumlah > kapasitasmaks){
            try {
                System.out.println(Thread.currentThread().getName()
                        + " harap tunggu, gudang penuh.");
                wait();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        stok += jumlah;
        System.out.println(Thread.currentThread().getName()+ " menambahkan "+ jumlah +" barang || stok saat ini "+ stok);
        notifyAll();
    }

    public synchronized void ambilstok(int jumlah){
        while(stok < jumlah){
            try {
                System.out.println(Thread.currentThread().getName()+ " harap tunggu, stok habis");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        stok -= jumlah;
        System.out.println(Thread.currentThread().getName()+ " mengambil "+ jumlah +" barang || stok saat ini "+ stok);
        notifyAll();
    }
}