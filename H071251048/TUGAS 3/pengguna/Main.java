package pengguna;

import sistemkeamanan.SmartLock;

public class Main {
    public static void main(String[] args) {

        SmartLock pintu1 = new SmartLock("R101", "123456");

        System.out.println("Status terkunci: " + pintu1.isTerkunci());

        pintu1.bukaPintu("111111");
        pintu1.bukaPintu("222222");

        pintu1.bukaPintu("123456");

        System.out.println("Status terkunci: " + pintu1.isTerkunci());

        pintu1.kunciPintu();

        pintu1.ubahPin("123456", "654321");

        pintu1.bukaPintu("123456");

        pintu1.bukaPintu("654321");

        pintu1.kunciPintu();
        pintu1.bukaPintu("000000");
        pintu1.bukaPintu("000000");
        pintu1.bukaPintu("654321");

        pintu1.bukaPintu("654321");
    }
}