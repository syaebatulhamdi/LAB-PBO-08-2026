package soal2;

class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Lampu pintar siap digunakan");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        }
    }
}
