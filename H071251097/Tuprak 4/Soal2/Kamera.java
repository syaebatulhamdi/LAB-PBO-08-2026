package Soal2;

public class Kamera extends Produk {
    int resolusi;
    String lensType;

    public Kamera(String merek, String nomorSeri, double harga, int resolusi, String lensType) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
        this.lensType = lensType;

    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Resolusi: " + resolusi + " MP");
        System.out.println("lensType: " + lensType );
    }
}