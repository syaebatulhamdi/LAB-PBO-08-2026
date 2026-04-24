package Praktikum4.Soal2;

// Smartphone
class Smartphone extends Product {
    private double screenSize;
    private int storage;

    public Smartphone(String brand, int serialNumber, double price, double screenSize, int storage) {
        super(brand, serialNumber, price);
        this.screenSize = screenSize;
        this.storage = storage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipe: Smartphone");
        System.out.println("Ukuran layar: " + screenSize + " inch");
        System.out.println("Storage: " + storage + " GB");
    }
}

// Laptop
class Laptop extends Product {
    private int ram;
    private String processor;

    public Laptop(String brand, int serialNumber, double price, int ram, String processor) {
        super(brand, serialNumber, price);
        this.ram = ram;
        this.processor = processor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipe: Laptop");
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Processor: " + processor);
    }
}

// Camera
class Camera extends Product {
    private int resolution;
    private String lensType;

    public Camera(String brand, int serialNumber, double price, int resolution, String lensType) {
        super(brand, serialNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipe: Camera");
        System.out.println("Resolusi: " + resolution + " MP");
        System.out.println("Lens: " + lensType);
    }
}