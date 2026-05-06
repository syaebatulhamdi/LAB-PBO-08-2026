package TP4;

// ===== CLASS INDUK =====
class Bangun { }

// ===== BANGUN DATAR =====
class BangunDatar extends Bangun {
    double luas() { return 0; }
    double keliling() { return 0; }
}

// Persegi
class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) { this.sisi = sisi; }

    double luas() { return sisi * sisi; }
    double keliling() { return 4 * sisi; }
}

// Persegi Panjang
class PersegiPanjang extends BangunDatar {
    double p, l;

    PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    double luas() { return p * l; }
    double keliling() { return 2 * (p + l); }
}

// Lingkaran
class Lingkaran extends BangunDatar {
    double r;

    Lingkaran(double r) { this.r = r; }

    double luas() { return Math.PI * r * r; }
    double keliling() { return 2 * Math.PI * r; }
}

// Trapesium
class Trapesium extends BangunDatar {
    double a, b, c, d, t;

    Trapesium(double a, double b, double c, double d, double t) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.t = t;
    }

    double luas() { return 0.5 * (a + b) * t; }
    double keliling() { return a + b + c + d; }
}

// ===== BANGUN RUANG =====
class BangunRuang extends Bangun {
    double volume() { return 0; }
    double luasPermukaan() { return 0; }
}

// Kubus
class Kubus extends BangunRuang {
    double s;

    Kubus(double s) { this.s = s; }

    double volume() { return s * s * s; }
    double luasPermukaan() { return 6 * s * s; }
}

// Balok
class Balok extends BangunRuang {
    double p, l, t;

    Balok(double p, double l, double t) {
        this.p = p; this.l = l; this.t = t;
    }

    double volume() { return p * l * t; }
    double luasPermukaan() { return 2 * (p*l + p*t + l*t); }
}

// Bola
class Bola extends BangunRuang {
    double r;

    Bola(double r) { this.r = r; }

    double volume() { return (4.0/3) * Math.PI * r * r * r; }
    double luasPermukaan() { return 4 * Math.PI * r * r; }
}

// Tabung
class Tabung extends BangunRuang {
    double r, t;

    Tabung(double r, double t) {
        this.r = r; this.t = t;
    }

    double volume() { return Math.PI * r * r * t; }
    double luasPermukaan() { return 2 * Math.PI * r * (r + t); }
}
