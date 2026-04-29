package H071251079.tugas_5.soal_2;

public abstract class PerangkatElektronik {
    private String merk;
    private int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println("Perangkat sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}
