class DompetDigital {

    // ===== ATRIBUT =====
    private String pin;        
    private double saldo;      
    protected String idNasabah; 
    protected String namaNasabah; 
    String statusAkun; 

    // ===== CONSTRUCTOR =====
    public DompetDigital(String idNasabah, String namaNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.namaNasabah = namaNasabah;
        this.pin = pin;
        this.saldo = 0;
        this.statusAkun = "Aktif";
    }

    // ===== GETTER =====
    public String getIdNasabah() {
        return idNasabah;
    }

    public String getNamaNasabah() { 
        return namaNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    // ===== SETTER (UBAH PIN) =====
    public void ubahPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            System.out.println("PIN lama salah!");
            logTransaksi("Gagal ubah PIN");
        } else if (pinBaru.length() != 6) {
            System.out.println("PIN baru harus 6 digit!");
            logTransaksi("Gagal ubah PIN");
        } else {
            this.pin = pinBaru;
            System.out.println("PIN berhasil diubah!");
            logTransaksi("Berhasil ubah PIN");
        }
    }

    // ===== SETOR =====
    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah tidak valid!");
            logTransaksi("Gagal setor");
        } else {
            saldo += jumlah;
            System.out.println("Setor berhasil!");
            logTransaksi("Berhasil setor");
        }
    }

    // ===== TARIK =====
    public void tarik(double jumlah, String pinInput) {
        if (!this.pin.equals(pinInput)) {
            System.out.println("PIN salah!");
            logTransaksi("Gagal tarik");
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup!");
            logTransaksi("Gagal tarik");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik berhasil!");
            logTransaksi("Berhasil tarik");
        }
    }

    // ===== METHOD INTERNAL =====
    private void logTransaksi(String pesan) {
        System.out.println("\n[LOG]: " + pesan);
    }
}