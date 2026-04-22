package sistemkeamanan;

public class SmartLock {
    private String pinAkses;
    private int sisaPercobaan;
    protected String idRuangan;
    boolean statusTerkunci; 

    public SmartLock(String idRuangan, String pinAwal) {
        this.idRuangan = idRuangan;
        this.pinAkses = pinAwal;
        this.sisaPercobaan = 3;
        this.statusTerkunci = true;
    }

    public String getIdRuangan() {
        return idRuangan;
    }

    public boolean isTerkunci() {
        return statusTerkunci;
    }

    public void ubahPin(String pinLama, String pinBaru) {
        if (statusTerkunci) {
            System.out.println("[GAGAL] PIN tidak bisa diubah saat pintu terkunci.");
            return;
        }
        if (!pinLama.equals(pinAkses)) {
            System.out.println("[GAGAL] PIN lama salah. Perubahan PIN ditolak.");
            return;
        }
        if (pinBaru.length() < 6) {
            System.out.println("[GAGAL] PIN baru harus minimal 6 karakter.");
            return;
        }
        pinAkses = pinBaru;
        System.out.println("[SUKSES] PIN berhasil diubah.");
    }

    public void bukaPintu(String pinInput) {
        if (sisaPercobaan <= 0) {
            System.out.println("[BLOKIR] Akses diblokir permanen. Silahkan direstart");
            return;
        }
        if (pinInput.equals(pinAkses)) {
            statusTerkunci = false;
            sisaPercobaan = 3;
            System.out.println("[SUKSES] PIN benar. Pintu " + idRuangan + " terbuka.");
        } else {
            sisaPercobaan--;
            System.out.println("[GAGAL] PIN salah. Sisa percobaan: " + sisaPercobaan);
            if (sisaPercobaan <= 0) {
                picuAlarm();
            }
        }
    }

    public void kunciPintu() {
        statusTerkunci = true;
        System.out.println("[INFO] Pintu " + idRuangan + " telah dikunci.");
    }

    private void picuAlarm() {
        System.out.println("[ALARM] PERINGATAN! Terlalu banyak percobaan PIN salah!");
        System.out.println("[ALARM] Akses ke " + idRuangan + " diblokir secara permanen!");
    }
}
