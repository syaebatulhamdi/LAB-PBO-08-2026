package H071251079.tugas_3;

public class DompetDigital {  
    // private (paling rahasia)
    private int IDNasabah;
    private int pin;
    
    // protected (digunakan jika ada subclass nya)
    protected String nama;
    
    // default
    int limitTransaksiHarian;
    int jumlahTransaksiHarian;

    // private
    private int saldo;
    
    // constructor
    public DompetDigital(String nama, int IDNasabah, int pin) {
        this.nama = nama;
        this.IDNasabah = IDNasabah;
        this.pin = pin;
        this.saldo = 0;
        this.limitTransaksiHarian = 3;
    }

    // getter nama
    public String getNama() {
        return nama;
    }

    // setter
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // method private/internal 
    private boolean verifikasiPin(int pinLama, int pinBaru) {
        return Integer.toString(pinLama).length() == 6 
            && Integer.toString(pinBaru).length() == 6 
            && this.pin == pinLama;
    }
    
    // set pin
    public void setPin(int pinLama, int pinBaru) {
        if (verifikasiPin(pinLama, pinBaru)) {
            this.pin = pinBaru;
            cetakLog("Berhasil update pin!");
        } else {
            cetakLog("Pin yang dimasukkan salah dan wajib 6 karakter");
        }
    }

    // get saldo
    public int getSaldo() {
        return saldo;
    }

    // method public setor tunai
    public void setorTunai(int saldo) {
        if (saldo < 0) {
            cetakLog("Saldo tidak boleh negatif!");
        } else {
            this.saldo += saldo;
            cetakLog("Berhasil setor tunai!");
        }
    }

    // method public tarik tunai
    public void tarikTunai(int pinLama, int pinBaru,int saldo) {
        if (jumlahTransaksiHarian >= limitTransaksiHarian) {
            cetakLog("batas harian tercapai!");
            return;
        }

        if (! verifikasiPin(pinLama, pinBaru)) {
            cetakLog("Pin tidak terverifikasi!");
        } else if (this.saldo < saldo) {
            cetakLog("Saldo anda tidak cukup!");
        } else {
            this.saldo -= saldo;
            cetakLog("Berhasil tarik tunai!");
        }
    }

    // method private/internal
    private void cetakLog(String log) {
        System.out.println(log);
    }
}
