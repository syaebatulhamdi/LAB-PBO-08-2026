package sistemkeamanan;

public class SmartLock {

    private String pinAkses;
    private int sisaPercobaan = 3;
    protected String idRuangan;
    boolean statusTerkunci = true;

    private boolean diblokir = false;

    public SmartLock(String idRuangan, String pinAkses) {
        this.idRuangan = idRuangan;
        this.pinAkses = pinAkses;
    }

    public boolean isTerkunci() {
        return statusTerkunci;
    }

    public void ubahPin(String pinLama, String pinBaru) {
        if (diblokir) {
            System.out.println("Akses diblokir. Hubungi administrator.");
            return;
        }

        if (pinAkses.equals(pinLama) && pinBaru.length() == 6) {
            pinAkses = pinBaru;
            System.out.println("PIN berhasil diubah.");
        } else {
            System.out.println("PIN gagal diubah.");
        }
    }
    public void bukaPintu(String inputPin) {
        if (diblokir) {
            System.out.println("Akses diblokir. Hubungi administrator.");
            return;
        }

        if (pinAkses.equals(inputPin)) {
            statusTerkunci = false;
            sisaPercobaan = 3; 
            System.out.println("Pintu terbuka.");
        } else {
            sisaPercobaan--;
            System.out.println("PIN salah. Sisa percobaan: " + sisaPercobaan);
            if (sisaPercobaan == 0) {
                diblokir = true;
                picuAlarm();
            }
        }
    }
    public void kunciPintu() {
        statusTerkunci = true;
        System.out.println("Pintu terkunci.");
        }
    private void picuAlarm() {
       if (sisaPercobaan == 0) {
            System.out.println("!!! ALARM AKTIF !!!");
        System.out.println("Sistem terkunci permanen.");
    }
 
    }
}

