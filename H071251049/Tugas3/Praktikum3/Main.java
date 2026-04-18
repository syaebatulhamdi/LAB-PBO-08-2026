package Praktikum3;

public class Main {
    public static void main(String[] args) {
        DompetDigital Afdhol = new DompetDigital("Afdhol", 123456, 8739276);
        Afdhol.getInfo();
        Afdhol.setPin(132456);
        Afdhol.setPin(112233);
        Afdhol.setor(1000000);
        Afdhol.setor(-100000);
        Afdhol.tarik(1000000);
        Afdhol.tarik(150000);
        Afdhol.getInfo();
    }
}
