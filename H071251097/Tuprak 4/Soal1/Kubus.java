package Soal1;

public class Kubus extends Bangun {
    double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    public double luas() {
        return 6 * sisi * sisi;
    }

    public double volume() {
        return sisi * sisi * sisi;
    }
}
