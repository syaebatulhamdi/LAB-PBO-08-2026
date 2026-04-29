package H071251079.tugas_5.soal_1;

public abstract class Karyawan {
    private String nama, idKaryawan;
    private int jumlahKehadiran;
    
    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }
    
    int absen() {
        return jumlahKehadiran++;
    }
    
    abstract double hitungGaji();
    
    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }
}
