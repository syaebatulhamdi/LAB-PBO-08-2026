package Praktikum4.Soal2;

public class Product {
    protected String brand;
    protected int serialNumber;
    protected double price;

    public Product(String brand, int serialNumber, double price) {
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Harga: " + price);
    }
}