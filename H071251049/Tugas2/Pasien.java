public class Pasien {
    String nama;
    int umur;
    Alamat alamat;          // atribut objek
    RekamMedis rekamMedis;  // atribut objek

    // constructor default
    public Pasien() {
        this.nama = "anonim";
        this.umur = 0;
        this.alamat = new Alamat();
        this.rekamMedis = new RekamMedis();
    }

    // constructor parameter
    public Pasien(String nama, int umur, Alamat alamat, RekamMedis rekamMedis) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.rekamMedis = rekamMedis;
    }

    // behavior 1: interaksi dengan atribut objek
    public void cekKondisi() {
        int darurat = rekamMedis.getTingkatDarurat();
        System.out.println("Pasien: " + nama);
        System.out.println("Tingkat darurat: " + darurat);
    }

    // behavior 2: interaksi antar objek class yang sama
    public void bandingkan(Pasien pasienLain) {
        int darurat1 = this.rekamMedis.getTingkatDarurat();
        int darurat2 = pasienLain.rekamMedis.getTingkatDarurat();

        System.out.println(this.nama + " vs " + pasienLain.nama);

        if (darurat1 > darurat2) {
            System.out.println(this.nama + " lebih darurat");
        } else if (darurat2 > darurat1) {
            System.out.println(pasienLain.nama + " lebih darurat");
        } else {
            System.out.println("Keduanya sama darurat");
        }
    }

    // behavior tambahan
    public void tampilData() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Alamat: " + alamat.jalan + ", " + alamat.kota);
        System.out.println("Diagnosa: " + rekamMedis.diagnosa);
    }
}