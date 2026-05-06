package Soal1;

public class Trapesium extends Bangun {
    double a, b, c, d, t;

    public Trapesium(double a, double b, double c, double d, double t) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.t = t;
    }

    public double luas() {
        return 0.5 * (a + b) * t;
    }

    public double keliling() {
        return a + b + c + d;
    }
}