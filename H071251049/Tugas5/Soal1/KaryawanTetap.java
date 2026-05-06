package Tuprak5.Soal1;

class KaryawanTetap extends Karyawan {
    private int gajiPokok;
    private int tunjanganMakan;

    KaryawanTetap(String nama, String idKaryawan, int gajiPokok, int tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public int hitungGaji() {
        return gajiPokok + (tunjanganMakan * getinfohadir());
    }

    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Gaji Pokok     : " + gajiPokok);
        System.out.println("Tunjangan Makan: " + tunjanganMakan);
        System.out.println("total gaji : " + hitungGaji());
    }
}