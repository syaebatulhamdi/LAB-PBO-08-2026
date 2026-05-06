package Tuprak5.Soal1;

class KaryawanKontrak extends Karyawan{
    private int upahPerhari;
    KaryawanKontrak(String nama, String idKaryawan, int upahPerhari) {
        super(nama, idKaryawan);
        this.upahPerhari = upahPerhari;
    }

    @Override
    int hitungGaji() {
        int totalGaji = upahPerhari * getinfohadir();
        if (getinfohadir()>20){
            totalGaji += 500000;
        }
        return totalGaji;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Upah Per Hari: " + upahPerhari);
        System.out.println("Hitung gaji : "+ hitungGaji());
    }
}
