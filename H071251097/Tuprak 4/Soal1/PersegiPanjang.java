package Soal1;

public class PersegiPanjang extends Bangun {
    double p, l;

    public PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    public double luas() {
        return p * l;
    }

    public double keliling() {
        return 2 * (p + l);
    }
}