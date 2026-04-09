public class Alien {
    String ras;
    String kemampuan;
    int powerBonus = 5;

    public String getDetail() {
        return ras + " (" + kemampuan + ") +" + powerBonus;
    }

    public int getPowerBonus() {
        return powerBonus;
    }

    public void setPowerBonus(int powerBonus) {
        this.powerBonus = powerBonus;
        System.out.printf("Update power bonus menjadi %d\n", powerBonus);
    }
}