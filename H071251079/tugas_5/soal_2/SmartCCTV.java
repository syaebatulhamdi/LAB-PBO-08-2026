package H071251079.tugas_5.soal_2;

public class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi Smart CCTV berhasil!");
    }
    
}
