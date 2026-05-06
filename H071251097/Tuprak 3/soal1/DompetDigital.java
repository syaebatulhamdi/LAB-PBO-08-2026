// public class DompetDigital {
//     private String pin;
//     private double saldo;
//     protected String idNasabah;
//     String statusAkun;

//     public DompetDigital(String idNasabah, String pin) {
//         this.idNasabah = idNasabah;
//         this.pin = pin;
//         this.saldo = 0;
//         this.statusAkun = "Aktif";
//     }

//     public String getIdNasabah() {
//         return idNasabah;
//     } 
  
//     public double getSaldo() {
//         return saldo;
//     }

//     public void ubahPin(String pinLama, String pinBaru) {
//         System.out.println("\n[UBAH PIN]");

//         if (!this.pin.equals(pinLama)) {
//             System.out.println("Status : GAGAL (PIN lama salah)");
//         } else if (pinBaru.length() != 6) {
//             System.out.println("Status : GAGAL (PIN harus 6 digit)");
//         } else {
//             this.pin = pinBaru;
//             System.out.println("Status : BERHASIL");
//             logTransaksi("PIN berhasil diubah");
//         }
//     }

//     public void setor(double jumlah) {
//         System.out.println("\n[SETOR]");

//         if (jumlah <= 0) {
//             System.out.println("Nominal : " + jumlah);
//             System.out.println("Status  : GAGAL (tidak valid)");
//             logTransaksi("Setor gagal");
//         } else {
//             saldo += jumlah;
//             System.out.println("Nominal : " + jumlah);
//             System.out.println("Status  : BERHASIL");
//             logTransaksi("Setor " + jumlah);
//         }
//     }

//     public void tarik(double jumlah, String pinInput) {
//         System.out.println("\n[TARIK]");

//         if (!this.pin.equals(pinInput)) {
//             System.out.println("Status : GAGAL (PIN salah)");
//             logTransaksi("Tarik gagal - PIN salah");
//         } else if (jumlah > saldo) {
//             System.out.println("Status : GAGAL (saldo tidak cukup)");
//             logTransaksi("Tarik gagal - saldo kurang");
//         } else {
//             saldo -= jumlah;
//             System.out.println("Nominal : " + jumlah);
//             System.out.println("Status  : BERHASIL");
//             logTransaksi("Tarik " + jumlah);
//         }
//     }

//     private void logTransaksi(String pesan) {
//         System.out.println("[LOG] " + pesan);
//     }
// }
