package Tuprak4nomor2.Tuprak4nomor2;

public class Laptop extends Product {
    int ramSize;
    String processorType;

    public Laptop(String brand, int seriesNumber, double price, int ram, String processor) {
        super(brand, seriesNumber, price);
        this.ramSize = ram;
        this.processorType = processor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Processor Type: " + processorType);
        System.out.println("RAM Size: " + ramSize + "GB");
    }
}