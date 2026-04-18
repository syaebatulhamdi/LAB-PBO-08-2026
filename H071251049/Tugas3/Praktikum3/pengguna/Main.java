package pengguna;

import sistemkeamanan.SmartLock;

public class Main {
    public static void main(String[] args) {

        SmartLock pintu = new SmartLock("Ruang Server", "123456");

        System.out.println("ID Ruangan: " + pintu.getIdRuangan());
        System.out.println("Status terkunci: " + pintu.isTerkunci());

        System.out.println("UJI BUKA PINTU SALAH");

        pintu.bukaPintu("111111");
        pintu.bukaPintu("222222");
        pintu.bukaPintu("333333");

        pintu.bukaPintu("123456");
        pintu.bukaPintu("1232346");

        System.out.println("PENGUJIAN PINTU KEDUA");

        SmartLock pintu2 = new SmartLock("Ruang Server2", "123456");

        pintu2.bukaPintu("123456");

        pintu2.ubahPin("123456", "123");      // gagal
        pintu2.ubahPin("123456", "654321");   // sukses

        pintu2.kunciPintu();
    }
}
