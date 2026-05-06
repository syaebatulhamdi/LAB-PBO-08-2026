package Tuprak5.Soal2;

class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("SmartLamp berfungsi sebagai penerangan pintar.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Perintah tidak dikenali.");
        }
    }
}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("SmartCCTV berfungsi sebagai kamera pengawas.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("SmartSpeaker berfungsi sebagai asisten suara.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("SmartSpeaker terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah: " + perintah);
    }
}