package Soal2;

public class Smartphone extends Produk {
    double ukuranLayar;
    int storage;

    public Smartphone(String merek, String nomorSeri, double harga, double ukuranLayar, int storage) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.storage = storage;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar);
        System.out.println("Storage: " + storage + " GB");
    }
}