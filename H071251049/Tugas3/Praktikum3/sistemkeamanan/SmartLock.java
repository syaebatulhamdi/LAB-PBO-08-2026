package sistemkeamanan;

public class SmartLock {

    private String pinAkses;
    private int sisaPercobaan = 3;

    protected String idRuangan;
    private boolean statusTerkunci = true;
    private boolean sistemDiblokir = false;

    public SmartLock(String idRuangan, String pinAkses) {
        this.idRuangan = idRuangan;
        this.pinAkses = pinAkses;
    }

    public String getIdRuangan() {
        return idRuangan;
    }

    public boolean isTerkunci() {
        return statusTerkunci;
    }

    // ===== CEK BLOKIR =====
    private boolean cekBlokir() {
        if (sistemDiblokir) {
            System.out.println("Akses Ditolak: Sistem terkunci sepenuhnya.");
            return true;
        }
        return false;
    }

    // ===== BUKA PINTU =====
    public void bukaPintu(String pinInput) {

        if (cekBlokir()) return;

        if (!statusTerkunci) {
            System.out.println("Pintu sudah terbuka");
            return;
        }

        if (pinInput.equals(pinAkses)) {
            statusTerkunci = false;
            sisaPercobaan = 3;
            System.out.println("Pintu berhasil dibuka");
        } else {
            sisaPercobaan--;
            System.out.println("PIN salah! Sisa percobaan: " + sisaPercobaan);

            if (sisaPercobaan == 0) {
                alarm();
            }
        }
    }

    // ===== UBAH PIN =====
    public void ubahPin(String pinLama, String pinBaru) {

        if (cekBlokir()) return;

        if (statusTerkunci) {
            System.out.println("PIN hanya bisa diubah saat pintu terbuka!");
            return;
        }

        if (!pinAkses.equals(pinLama)) {
            System.out.println("PIN lama salah!");
            return;
        }

        if (pinBaru.length() < 6) {
            System.out.println("Gagal: PIN baru harus terdiri dari 6 karakter.");
            return;
        }

        pinAkses = pinBaru;
        System.out.println("Sukses: PIN berhasil diubah");
    }

    public void kunciPintu() {
        if (!statusTerkunci) {
            statusTerkunci = true;
            System.out.println("Pintu telah dikunci.");
        } else {
            System.out.println("Pintu sudah terkunci.");
        }
    } 

    // ===== ALARM =====
    private void alarm() {
        System.out.println("ALARM MEYALA: Percobaan masuk paksa terdeteksi pada "
                + idRuangan + "! Sistem diblokir.");
        sistemDiblokir = true;
        statusTerkunci = true;
    }
}