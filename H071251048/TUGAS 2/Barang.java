public class Barang {
    String namaBarang;
    int harga;

    // Constructor default
    public Barang() {
        this.namaBarang = "Tidak diketahui";
        this.harga = 0;
    }

    // Constructor dengan parameter
    public Barang(String namaBarang, int harga) {
        this.namaBarang = namaBarang;
        this.harga = harga;
    }

    public void tampilkanBarang() {
        System.out.println("Barang: " + namaBarang + ", Harga: " + harga);
    }
}