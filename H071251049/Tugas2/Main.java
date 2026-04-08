public class Main {
    public static void main(String[] args) {

        Alamat a1 = new Alamat("Jl. Mawar", "Makassar");
        RekamMedis r1 = new RekamMedis("Demam", 3);

        Alamat a2 = new Alamat("Jl. Melati", "Makassar");
        RekamMedis r2 = new RekamMedis("Flu", 2);

        Pasien p1 = new Pasien("Andi", 20, a1, r1);
        Pasien p2 = new Pasien("Budi", 22, a2, r2);

        p1.tampilData();
        p1.cekKondisi();

        
        p2.tampilData();
        p2.cekKondisi();
        System.out.println();

        p1.bandingkan(p2);
    }
}