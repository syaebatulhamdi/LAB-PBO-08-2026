class DompetDigital {
    // atribut private (rahasia)
    private String pin;
    private double saldo;

    // atribut protected
    protected String idNasabah;

    // atribut default
    String jenisAkun;

    // constructor
    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0;
        this.jenisAkun = "Premium";
    }

    // getter aman
    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getJenisAkun() {
        return jenisAkun;
    }

    // setter ubah PIN
    public void ubahPin(String pinLama, String pinBaru) {
        if (pin.equals(pinLama) && pinBaru.length() == 6) {
            pin = pinBaru;
            System.out.println("PIN berhasil diubah.");
            logTransaksi("Ubah PIN berhasil");
        } else {
            System.out.println("PIN gagal diubah.");
            logTransaksi("Ubah PIN gagal");
        }
    }

    // setor tunai
    public void setorTunai(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setor tunai berhasil: Rp " + jumlah);
            logTransaksi("Setor berhasil");
        } else {
            System.out.println("Setor gagal, nominal tidak valid.");
            logTransaksi("Setor gagal");
        }
    }

    // tarik tunai
    public void tarikTunai(String inputPin, double jumlah) {
        if (!pin.equals(inputPin)) {
            System.out.println("Tarik tunai gagal, PIN salah.");
            logTransaksi("Tarik gagal - PIN salah");
        } else if (jumlah > saldo) {
            System.out.println("Tarik tunai gagal, saldo tidak cukup.");
            logTransaksi("Tarik gagal - saldo kurang");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik tunai berhasil: Rp " + jumlah);
            logTransaksi("Tarik berhasil");
        }
    }

    // method internal
    private void logTransaksi(String pesan) {
        System.out.println("[LOG] " + pesan);
    }
}

public class tuprak3 {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital("USR001", "123456");

        // tampilkan identitas akun
        System.out.println("ID Nasabah : " + dompet.getIdNasabah());
        System.out.println("Jenis Akun : " + dompet.getJenisAkun());

        // ubah pin salah
        dompet.ubahPin("111111", "654321");

        // ubah pin benar
        dompet.ubahPin("123456", "654321");

        // setor valid
        dompet.setorTunai(500000);

        // setor ilegal
        dompet.setorTunai(-10000);

        // tarik pakai pin lama
        dompet.tarikTunai("123456", 100000);

        // tarik pakai pin baru
        dompet.tarikTunai("654321", 100000);

        // saldo akhir
        System.out.println("Saldo akhir : Rp " + dompet.getSaldo());
    }
}