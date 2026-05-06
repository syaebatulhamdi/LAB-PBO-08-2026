package Soal2;

public class Laptop extends Produk {
    String processor;
    int size;

    public Laptop(String merek, String nomorSeri, double harga, String processor, int size) {
        super(merek, nomorSeri, harga);
        this.processor = processor;
        this.size = size;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Processor: " + processor);
    }
}