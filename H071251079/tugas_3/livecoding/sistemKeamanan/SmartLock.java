package H071251079.tugas_3.livecoding.sistemKeamanan;

public class SmartLock {
    private String pinAkses;
    private int sisaPercobaan;
    
    protected String idRuangan;

    boolean statusTerkunci;
    private boolean paksaTerkunci;

    public SmartLock(String idRuangan, String pinAkses) {
        this.idRuangan = idRuangan;

        if (pinAkses.length() == 6) {
            this.pinAkses = pinAkses;
        } else {
            System.out.println("PIN awal harus 6 digit!");
            this.pinAkses = "000000";
        }

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
        if (paksaTerkunci || statusTerkunci) {
            System.out.println("Tidak bisa ubah PIN saat pintu terkunci!");
            return;
        }

        if (pinLama.equals(pinAkses) && pinBaru.length() == 6) {
            pinAkses = pinBaru;
            System.out.println("PIN berhasil diubah");
        } else {
            System.out.println("PIN lama salah atau PIN baru tidak valid!");
        }
    }

    public void bukaPintu(String pinMasuk) {
        if (paksaTerkunci) {
            System.out.println("Akses diblokir! Sistem terkunci permanen.");
            return;
        }

        if (pinMasuk.equals(pinAkses)) {
            statusTerkunci = false;
            sisaPercobaan = 3;
            System.out.println("Pintu terbuka");
        } else {
            sisaPercobaan--;
            System.out.println("PIN salah! Sisa: " + sisaPercobaan);

            if (sisaPercobaan == 0) {
                picuAlarm();
            }
        }
    }

    public void kunciPintu() {
        statusTerkunci = true;
        System.out.println("Pintu dikunci");
    }

    private void picuAlarm() {
        System.out.println("ALARM! Percobaan habis!");
        paksaTerkunci = true;
    }
}