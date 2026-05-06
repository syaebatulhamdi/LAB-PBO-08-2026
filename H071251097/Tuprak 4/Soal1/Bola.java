package Soal1;

public class Bola extends Bangun {
    double r;

    public Bola(double r) {
        this.r = r;
    }

    public double luas() {
        return 4 * Math.PI * r * r;
    }

    public double volume() {
        return (4.0/3.0) * Math.PI * r * r * r;
    }
}