public class HasilData {
    private String namaDokumen;
    private String namaThread;
    private int jumlahKata;
    private long durasi;

    public HasilData(String namaDokumen, String namaThread, int jumlahKata, long durasi) {
        this.namaDokumen = namaDokumen;
        this.namaThread = namaThread;
        this.jumlahKata = jumlahKata;
        this.durasi = durasi;
    }

    public String getNamaDokumen() {
        return namaDokumen;
    }

    public String getNamaThread() {
        return namaThread;
    }

    public int getJumlahKata() {
        return jumlahKata;
    }

    public long getDurasi() {
        return durasi;
    }
}