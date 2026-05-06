package Tuprak5.Soal1;

abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran = 0;

    Karyawan(String nama, String idKaryawan){
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }
    void tampilkanInfo(){
        System.out.println("Nama       : " + nama);
        System.out.println("ID Karyawan: " + idKaryawan);
    }

    void hadir(){
        jumlahKehadiran++;
    }

    int getinfohadir(){
        return jumlahKehadiran;
    }

    abstract int hitungGaji();
 }
