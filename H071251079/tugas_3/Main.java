package H071251079.tugas_3;

public class Main {
    public static void main(String[] args) {
        DompetDigital dompetdDigital = new DompetDigital("Rafly",12345, 654321);

        String getNama = dompetdDigital.getNama();
        int getSaldo = dompetdDigital.getSaldo();
        System.out.println("Informasi Akun: ");
        System.out.println("Nama : " + getNama);
        System.out.println("Saldo : " + getSaldo);

        pembatas();
        
        // setter pin (salah - pin lama)
        dompetdDigital.setPin(1234567, 654321);

        pembatas();

        // setter pin (benar)
        dompetdDigital.setPin(654321, 123456);

        pembatas();

        // setor tunai (benar)
        dompetdDigital.setorTunai(1000);

        pembatas();

        // setor tunai (salah/mines)
        dompetdDigital.setorTunai(-1000);

        pembatas();

        // tarik tunai (pin lama)
        dompetdDigital.tarikTunai(654321, 123456, 100);

        pembatas();

        // tarik tunai (pin baru)
        dompetdDigital.tarikTunai(123456, 654321, 500);

        pembatas();

        // getter sisa saldo
        int sisaSaldo = dompetdDigital.getSaldo();
        System.out.println("Sisa saldo akhir: " + sisaSaldo);
    }

    public static void pembatas() {
        System.out.println("========================================");
    }
}
