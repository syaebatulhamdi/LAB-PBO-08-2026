package H071251079.tugas_5.soal_1;

public class Main {
    public static void main(String[] args) {
        KaryawanTetap rafly = new KaryawanTetap("rafly", "123", 1000000, 10000);
        KaryawanKontrak raku = new KaryawanKontrak("raku", "456", 10000);

        for (int i = 0; i < 25; i++) {
            rafly.absen();
            raku.absen();
        }

        System.out.println("Gaji Rafly: " + rafly.hitungGaji(500000));
        System.out.println("Gaji Raku: " + raku.hitungGaji());
    }
}
