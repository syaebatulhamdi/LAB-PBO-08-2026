abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        jumlahKehadiran++;
    }

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    public String getNama() {
        return nama;
    }

    abstract double hitungGaji();
}

class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String id, double gajiPokok, double tunjanganMakan) {
        super(nama, id);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }

    double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}

class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String id, double upahPerHari) {
        super(nama, id);
        this.upahPerHari = upahPerHari;
    }

    @Override
    double hitungGaji() {
        double total = upahPerHari * getJumlahKehadiran();

        if (getJumlahKehadiran() > 20) {
            total += 500000;
        }

        return total;
    }
}

public class tugas51 {
    public static void main(String[] args) {

        KaryawanTetap tetap = new KaryawanTetap("Budi", "KT01", 5000000, 50000);

        for (int i = 0; i < 5; i++) {
            tetap.absen();
        }

        System.out.println("=== Karyawan Tetap ===");
        System.out.println("Nama : " + tetap.getNama());
        System.out.println("Gaji + Bonus : Rp" + tetap.hitungGaji(1000000));

        KaryawanKontrak kontrak = new KaryawanKontrak("Andi", "KK01", 150000);

        for (int i = 0; i < 22; i++) {
            kontrak.absen();
        }

        System.out.println("\n=== Karyawan Kontrak ===");
        System.out.println("Nama : " + kontrak.getNama());
        System.out.println("Total Gaji : Rp" + kontrak.hitungGaji());
    }
}