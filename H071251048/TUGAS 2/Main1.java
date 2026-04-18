public class Main1 {
    public static void main(String[] args) {
        // Membuat objek Pedagang
        Barang barang1 = new Barang("Baju", 100000);
        Pedagang pedagang1 = new Pedagang("Andi", 500000, barang1);

        // Membuat objek Pembeli
        Pedagang pembeli1 = new Pedagang("Budi", 150000, new Barang());

        // Menampilkan info sebelum transaksi
        System.out.println("Sebelum Transaksi:");
        pedagang1.tampilkanInfo();
        pembeli1.tampilkanInfo();

        // Melakukan transaksi jual beli
        pedagang1.jual(pembeli1);

        // Menampilkan info setelah transaksi
        System.out.println("Setelah Transaksi:");
        pedagang1.tampilkanInfo();
        pembeli1.tampilkanInfo();
    }
}