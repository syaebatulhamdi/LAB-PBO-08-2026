public class DompetDigital {

    private double saldo;
    private String pin;

    protected String idNasabah;

    String namaBank = "FinPay Digital";

    public DompetDigital(String idNasabah, String pinAwal) {
        this.idNasabah = idNasabah;
        this.pin = pinAwal;
        this.saldo = 0; 
        catatLog("Akun berhasil dibuat untuk ID: " + idNasabah);
    }


    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ubahPin(String pinLama, String pinBaru) {
        if (!pinLama.equals(this.pin)) {
            System.out.println("[GAGAL] Ubah PIN ditolak: PIN lama tidak cocok.");
            catatLog("Percobaan ubah PIN GAGAL - PIN lama salah.");
        } else if (pinBaru.length() != 6) {
            System.out.println("[GAGAL] Ubah PIN ditolak: PIN baru harus tepat 6 karakter.");
            catatLog("Percobaan ubah PIN GAGAL - PIN baru tidak valid (panjang: " + pinBaru.length() + ").");
        } else {
            this.pin = pinBaru;
            System.out.println("[SUKSES] PIN berhasil diubah.");
            catatLog("PIN berhasil diubah.");
        }
    }

    // ===== METODE TRANSAKSI =====

    public void setorTunai(double nominal) {
        if (nominal <= 0) {
            System.out.println("[GAGAL] Setor ditolak: Nominal tidak boleh nol atau negatif (Rp" + nominal + ").");
            catatLog("Setor tunai GAGAL - nominal ilegal: " + nominal);
        } else {
            saldo += nominal;
            System.out.println("[SUKSES] Setor tunai Rp" + nominal + " berhasil. Saldo sekarang: Rp" + saldo);
            catatLog("Setor tunai berhasil: +Rp" + nominal + " | Saldo: Rp" + saldo);
        }
    }


    public void tarikTunai(double nominal, String pinInput) {
        if (!pinInput.equals(this.pin)) {
            System.out.println("[GAGAL] Tarik tunai ditolak: PIN salah.");
            catatLog("Tarik tunai GAGAL - PIN salah.");
        } else if (nominal <= 0) {
            System.out.println("[GAGAL] Tarik tunai ditolak: Nominal tidak valid.");
            catatLog("Tarik tunai GAGAL - nominal tidak valid: " + nominal);
        } else if (nominal > saldo) {
            System.out.println("[GAGAL] Tarik tunai ditolak: Saldo tidak mencukupi. Saldo saat ini: Rp" + saldo);
            catatLog("Tarik tunai GAGAL - saldo tidak cukup. Diminta: Rp" + nominal + " | Saldo: Rp" + saldo);
        } else {
            saldo -= nominal;
            System.out.println("[SUKSES] Tarik tunai Rp" + nominal + " berhasil. Saldo sekarang: Rp" + saldo);
            catatLog("Tarik tunai berhasil: -Rp" + nominal + " | Saldo: Rp" + saldo);
        }
    }


    private void catatLog(String pesan) {
        System.out.println("  [LOG - " + namaBank + "] " + pesan);
    }
}