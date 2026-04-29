public class MainSoal1 {
    public static void main(String[] args) {

        System.out.println("===== SISTEM PENGGAJIAN =====");

        KaryawanTetap kt = new KaryawanTetap("Taesan", "KT01", 5000000, 20000);

        // LOOP simulasi absen 22 hari
        for (int i = 0; i < 22; i++) {
            kt.absen(); 
        }

        System.out.println("\n-- Karyawan Tetap --");
        System.out.println("Nama              : " + kt.getNama()); 
        System.out.println("ID                : " + kt.getIdKaryawan()); 
        System.out.println("Jumlah Kehadiran  : " + kt.getJumlahKehadiran()); 
        System.out.println("Total Gaji + Bonus: " + kt.hitungGaji(1000000)); 
        
        KaryawanKontrak kk = new KaryawanKontrak("Anton", "KK01", 100000);

        for (int i = 0; i < 25; i++) {
            kk.absen();
        }

        System.out.println("\n-- Karyawan Kontrak --");
        System.out.println("Nama              : " + kk.getNama());
        System.out.println("ID                : " + kk.getIdKaryawan());
        System.out.println("Jumlah Kehadiran  : " + kk.getJumlahKehadiran());
        System.out.println("Total Gaji        : " + kk.hitungGaji());
    }
}