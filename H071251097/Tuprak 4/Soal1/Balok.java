package Soal1;

public class Balok extends Bangun {
    double p, l, t;

    public Balok(double p, double l, double t) {
        this.p = p;
        this.l = l;
        this.t = t;
    }

    public double luas() {
        return 2 * (p*l + p*t + l*t);
    }

    public double volume() {
        return p * l * t;
    }
}
