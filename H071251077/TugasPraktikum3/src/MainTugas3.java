public class MainTugas3 {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   SISTEM DOMPET DIGITAL - FINPAY    ");
        System.out.println("======================================\n");


        DompetDigital dompet = new DompetDigital("USR-20240101", "123456");

        System.out.println("\n--- 1. INFO AKUN ---");
        System.out.println("ID Nasabah : " + dompet.getIdNasabah());
        System.out.println("Saldo Awal : Rp" + dompet.getSaldo());

        System.out.println("\n--- 2. UBAH PIN - PIN LAMA SALAH ---");
        dompet.ubahPin("999999", "abcdef");

        System.out.println("\n--- 3. UBAH PIN - SYARAT BENAR ---");
        dompet.ubahPin("123456", "65432"); 

        dompet.ubahPin("123456", "654321");

        System.out.println("\n--- 4. SETOR TUNAI VALID ---");
        dompet.setorTunai(500000);

        System.out.println("\n--- 5. SETOR TUNAI NEGATIF ---");
        dompet.setorTunai(-100000);

        System.out.println("\n--- 6. TARIK TUNAI - PIN LAMA/SALAH ---");
        dompet.tarikTunai(200000, "123456"); 

        System.out.println("\n--- 7. TARIK TUNAI - PIN BARU BENAR ---");
        dompet.tarikTunai(200000, "654321");

        System.out.println("\n--- 8. SALDO AKHIR ---");
        System.out.println("Saldo Akhir: Rp" + dompet.getSaldo());

        System.out.println("\n======================================");
        System.out.println("          PENGUJIAN SELESAI           ");
        System.out.println("======================================");
    }
}