package H071251079.tugas_5.soal_2;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void prosesPerintah(String perintah) {
        if ("NYALA".equalsIgnoreCase(perintah)) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Menjalankan perintah: " + perintah);
        }
    }

    @Override
    void cekFungsi() {
        System.out.println("Fungsi Smart Lamp berhasil!");
    }
    
}
