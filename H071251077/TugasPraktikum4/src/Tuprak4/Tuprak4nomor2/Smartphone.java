package Tuprak4nomor2.Tuprak4nomor2;

public class Smartphone extends Product {
    double screenSize;
    int storageCapacity;

    public Smartphone(String brand, int seriesNumber, double price, double screenSize, int storage) {
        super(brand, seriesNumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }
}