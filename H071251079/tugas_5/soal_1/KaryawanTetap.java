package H071251079.tugas_5.soal_1;

public class KaryawanTetap extends Karyawan {
    int gajiPokok, tunjanganMakan, totalGaji;
    public KaryawanTetap(String nama, String idKaryawan, int gajiPokok, int tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    double hitungGaji(double bonusKinerja) {
        totalGaji = gajiPokok + (tunjanganMakan * getJumlahKehadiran());
        return totalGaji + bonusKinerja;
    }

    @Override
    double hitungGaji() {
        totalGaji = gajiPokok + (tunjanganMakan * getJumlahKehadiran());
        return totalGaji;
    }
}
