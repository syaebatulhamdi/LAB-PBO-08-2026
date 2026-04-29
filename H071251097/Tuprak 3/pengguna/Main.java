package pengguna;

import sistemkeamanan.SmartLock;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   SIMULASI SISTEM SMART LOCK");
        System.out.println("========================================\n");

        SmartLock kunci = new SmartLock("Ruang Server", "123456");

        System.out.println("INFO AWAL");
        System.out.println("Ruangan  : " + kunci.getIdRuangan());
        System.out.println("Terkunci : " + kunci.isTerkunci());
        System.out.println();

        // uji 1 = ubah PIN saat pintu masih terkunci
        System.out.println("UJI 1: Ubah PIN saat pintu terkunci");
        kunci.ubahPin("123456", "newpin99");
        System.out.println();

        // uji 2 = buka pintu dengan PIN salah
        System.out.println("UJI 2: Input PIN salah");
        kunci.bukaPintu("000000");
        System.out.println();

        // uji 3 = buka pintu dengan PIN benar
        System.out.println("UJI 3: Input PIN benar");
        kunci.bukaPintu("123456");
        System.out.println("Status terkunci: " + kunci.isTerkunci());
        System.out.println();

        // uji 4 = Ubah PIN saat pintu terbuka
        System.out.println("UJI 4: Ubah PIN saat pintu terbuka");
        kunci.ubahPin("123456", "abc"); // PIN baru pendek
        kunci.ubahPin("salah", "newpin99"); // PIN lama salah
        kunci.ubahPin("123456", "newpin99"); // Berhasil
        System.out.println();

        // uji 5 = kunci pintu kembali lalu buka dengan PIN baru
        System.out.println("UJI 5: Kunci & buka dengan PIN baru");
        kunci.kunciPintu();
        kunci.bukaPintu("newpin99");
        System.out.println();

        // uji 6 = simulasi pembobolan (3x salah = alarm)
        System.out.println("UJI 6: Simulasi pembobolan");
        kunci.kunciPintu();
        kunci.bukaPintu("aaaaaa");
        kunci.bukaPintu("bbbbbb");
        kunci.bukaPintu("cccccc"); // Percobaan ke-3, alarm menyala
        System.out.println();

        // uji 7 = coba akses setelah diblokir
        System.out.println("UJI 7: Akses setelah diblokir");
        kunci.bukaPintu("newpin99"); // Meski PIN benar, tetap diblokir
        System.out.println();

        System.out.println("========================================");
        System.out.println("   SIMULASI SELESAI");
        System.out.println("========================================");
    }
}









