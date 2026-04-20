package H071251079.tugas_4.soal_2;

class Product {
    String brand;
    int seriesNumber;
    double price;

    Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Series Number: " + seriesNumber);
        System.out.println("Price: $" + price);
    }
}

class Smartphone extends Product {
    double screenSize;
    int strorageCapacity;

    Smartphone(String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price);
        this.screenSize = screenSize;
        this.strorageCapacity = storageCapacity;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + strorageCapacity + "GB");
    }
}

class Camera extends Product {
    int resolution;
    String lensType;

    Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + " MP");
        System.out.println("Lens Type: " + lensType);
    }
}

class Laptop extends Product {
    String processorType;
    int ramSize;

    Laptop(String brand, int seriesNumber, double price, String processorType, int ramSize) {
        super(brand, seriesNumber, price);
        this.processorType = processorType;
        this.ramSize = ramSize;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Processor Type: " + processorType);
        System.out.println("RAM Size: " + ramSize + " GB");
    }
}
