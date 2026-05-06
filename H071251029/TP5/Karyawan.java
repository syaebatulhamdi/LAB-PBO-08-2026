abstract class Karyawan {

    private String nama;         
    private String idKaryawan;  
    private int jumlahKehadiran;

    // CONSTRUCTOR untuk isi data awal saat objek dibuat
    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;                 
        this.idKaryawan = idKaryawan;    
        this.jumlahKehadiran = 0;         
    }

    // METHOD ABSEN setiap dipanggil, kehadiran bertambah 1
    public void absen() {
        jumlahKehadiran++;
    }

    // GETTER untuk mengambil jumlah kehadiran
    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    // ABSTRACT METHOD wajib diisi oleh class turunan
    public abstract double hitungGaji();
}


class KaryawanTetap extends Karyawan {

    private double gajiPokok;      
    private double tunjanganMakan; 

    public KaryawanTetap(String nama, String id, double gajiPokok, double tunjanganMakan) {
        super(nama, id); 
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    // OVERRIDE isi method abstract dari parent
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }

    // OVERLOADING method sama, tapi ada parameter bonus
    public double hitungGaji(double bonus) {
        return hitungGaji() + bonus;
    }
}

class KaryawanKontrak extends Karyawan {

    private double upahPerHari; 

    public KaryawanKontrak(String nama, String id, double upahPerHari) {
        super(nama, id);
        this.upahPerHari = upahPerHari;
    }

    public double hitungGaji() {

        // hitung gaji dasar
        double total = upahPerHari * getJumlahKehadiran();

        // KONDISI kalau hadir lebih dari 20 hari
        if (getJumlahKehadiran() > 20) {
            total += 500000; 
        }

        return total;
    }
}