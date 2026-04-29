package H071251079.tugas_5.soal_1;

public class KaryawanKontrak extends Karyawan {
    int upahPerHari, totalGaji;

    public KaryawanKontrak(String nama, String idKaryawan, int upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    double hitungGaji() {
        totalGaji = upahPerHari * getJumlahKehadiran();

        if (getJumlahKehadiran() > 20) {
            totalGaji += 500000;
        }

        return totalGaji;
    }
}
