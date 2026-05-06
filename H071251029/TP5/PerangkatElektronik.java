abstract class PerangkatElektronik {

    protected String merk;     
    protected int dayaListrik; 

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    // METHOD menampilkan daya listrik
    public void infoPower() {
        System.out.println("Menggunakan daya " + dayaListrik + " Watt");
    }

    // ABSTRACT wajib diisi turunan
    public abstract void cekFungsi();
}


// INTERFACE fitur WiFi
interface InteraksiInternet {
    void hubungkanWiFi();
}

// INTERFACE fitur suara
interface KontrolSuara {
    void prosesPerintah(String perintah);
}


// SMART LAMP hanya punya kontrol suara
class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int daya) {
        super(merk, daya);
    }

    public void cekFungsi() {
        System.out.println("Lampu pintar siap digunakan");
    }

    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        }
    }
}


// SMART CCTV hanya punya WiFi
class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int daya) {
        super(merk, daya);
    }

    public void cekFungsi() {
        System.out.println("CCTV aktif");
    }

    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}


// SMART SPEAKER punya WiFi + suara
class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int daya) {
        super(merk, daya);
    }

    public void cekFungsi() {
        System.out.println("Speaker siap digunakan");
    }

    public void hubungkanWiFi() {
        System.out.println("Speaker terhubung ke WiFi");
    }

    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah: " + perintah);
    }
}