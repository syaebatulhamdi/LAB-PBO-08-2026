package Tuprak5.Soal2;

abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;

    // Constructor
    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    // Abstract method 
    abstract void cekFungsi();

    // Method 
    public void infoPower() {
        System.out.println(merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt");
    }
}