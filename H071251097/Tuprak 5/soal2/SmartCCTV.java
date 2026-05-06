package soal2;

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("CCTV aktif memantau");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}


