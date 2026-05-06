package Tuprak4nomor2

public class Camera extends Product {
    int resolution;
    String lensType;

    public Camera(String brand, int seriesNumber, double price, int res, String lens) {
        super(brand, seriesNumber, price);
        this.resolution = res;
        this.lensType = lens;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}