package H071251079.tugas_5.soal_2;


public class SmartSpeaker extends PerangkatElektronik implements KontrolSuara, InteraksiInternet{

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Menjalankan perintah: " + perintah);
    }

    @Override
    void cekFungsi() {
        System.out.println("FUngsi Smart Speaker berhasil!");
    }

    
}