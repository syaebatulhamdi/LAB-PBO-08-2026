package Praktikum4.Soal1;
// Persegi.java

class Persegi {
    protected double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double luas() {
        return sisi * sisi;
    }

    public double keliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang extends Persegi {
    protected double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        super(panjang);
        this.lebar = lebar;
    }

    @Override
    public double luas() {
        return sisi * lebar;
    }

    @Override
    public double keliling() {
        return 2 * (sisi + lebar);
    }
}

class Lingkaran {
    protected double jari;

    public Lingkaran(double jari) {
        this.jari = jari;
    }

    public double luas() {
        return Math.PI * jari * jari;
    }

    public double keliling() {
        return 2 * Math.PI * jari;
    }
}

class Trapesium {
    private double a, b, c, d, tinggi;

    public Trapesium(double a, double b, double c, double d, double tinggi) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.tinggi = tinggi;
    }

    public double luas() {
        return (a + b) * tinggi / 2;
    }

    public double keliling() {
        return a + b + c + d;
    }
}