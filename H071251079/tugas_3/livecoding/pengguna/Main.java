package H071251079.tugas_3.livecoding.pengguna;

import H071251079.tugas_3.livecoding.sistemKeamanan.SmartLock;

public class Main {
    public static void main(String[] args) {
        SmartLock lock = new SmartLock("Ruang Server", "123456");

        System.out.println("Ruangan: " + lock.getIdRuangan());

        lock.bukaPintu("654321");

        // lock.bukaPintu("123456");

        lock.ubahPin("123456", "654321");

        lock.bukaPintu("654321");

        lock.kunciPintu();

        lock.bukaPintu("111111");
        lock.bukaPintu("222222");
        lock.bukaPintu("333333");

        lock.bukaPintu("654321");
    }
}