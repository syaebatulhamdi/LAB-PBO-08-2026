package TP4;

class Produk {
    String merek;
    String nomorSeri;
    double harga;

    Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    void tampil() {
        System.out.println("Merek       : " + merek);
        System.out.println("Nomor Seri  : " + nomorSeri);
        System.out.println("Harga       : " + harga);
    }
}

// ===== SMARTPHONE =====
class Smartphone extends Produk {
    double layar;
    int storage;

    Smartphone(String m, String n, double h, double layar, int storage) {
        super(m, n, h);
        this.layar = layar;
        this.storage = storage;
    }

    void tampil() {
        System.out.println("\n=== Smartphone ===");
        super.tampil();
        System.out.println("Ukuran Layar: " + layar);
        System.out.println("Storage     : " + storage);
    }
}

// ===== LAPTOP (INI YANG DIPERBAIKI) =====
class Laptop extends Produk {
    int ram;
    String processorType; // ✅ WAJIB ADA

    Laptop(String m, String n, double h, int ram, String processorType) {
        super(m, n, h);
        this.ram = ram;
        this.processorType = processorType;
    }

    void tampil() {
        System.out.println("\n=== Laptop ===");
        super.tampil();
        System.out.println("RAM         : " + ram);
        System.out.println("Processor   : " + processorType);
    }
}

// ===== KAMERA =====
class Kamera extends Produk {
    int mp;

    Kamera(String m, String n, double h, int mp) {
        super(m, n, h);
        this.mp = mp;
    }

    void tampil() {
        System.out.println("\n=== Kamera ===");
        super.tampil();
        System.out.println("Resolusi    : " + mp);
    }
}