public class Main {
    public static void main(String[] args) {

        Karakter karakter1 = new Karakter("Zorg", "Kryptonian", "Laser Vision"); 
        Karakter karakter2 = new Karakter("Xenon", "Martian", "Regeneration");
        // Karakter karakter3 = new Karakter("Zoro","Ras Lumut", "Santoryu", 15, 80);
        
        // karakter3.showStatus();
        karakter1.showStatus();
        perbatasan();

        karakter2.showStatus();
        perbatasan();

        karakter1.attack(karakter2);
        karakter2.attack(karakter1);

        karakter1.showStatus();
        perbatasan();

        karakter2.showStatus();
        perbatasan();

        karakter2.kesehatan.healing(karakter2, 10);

        karakter2.showStatus();
        perbatasan();

        karakter1.alien.setPowerBonus(10);

        karakter1.showStatus();
        perbatasan();

        karakter1.attack(karakter2);

        karakter2.showStatus();
        perbatasan();
    }

    public static void perbatasan() {
        System.out.println("=======================================================");
    }
}