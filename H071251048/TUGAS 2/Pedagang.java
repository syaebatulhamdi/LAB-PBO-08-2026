public class Pedagang {
    String nama;
    int saldo;
    Barang barangDagangan; //atribut objek

    // Constructor default
    public Pedagang() {
        this.nama = "Pedagang Baru";
        this.saldo = 0;
        this.barangDagangan = new Barang();
    }

    // Constructor dengan parameter
    public Pedagang(String nama, int saldo, Barang barangDagangan) {
        this.nama = nama;
        this.saldo = saldo;
        this.barangDagangan = barangDagangan;
    }

    // Method berinteraksi antar objek sekelas
    public void jual(Pedagang pembeli) {
        int harga = this.barangDagangan.harga;

        if (pembeli.saldo >= harga) {
            pembeli.saldo -= harga;
            this.saldo += harga;

            System.out.println(pembeli.nama + " membeli " + this.barangDagangan.namaBarang +
                    " dari " + this.nama + " seharga " + harga);
        } else {
            System.out.println(pembeli.nama + " tidak memiliki cukup saldo untuk membeli "
                    + this.barangDagangan.namaBarang);
        }
    }

    // Method untuk menampilkan info pedagang
    public void tampilkanInfo() {
        System.out.println("Nama Pedagang: " + nama);
        System.out.println("Saldo: " + saldo);
        barangDagangan.tampilkanBarang();
        System.out.println();
    }
}