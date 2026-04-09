import java.util.Random;

public class RekamMedis {
    String diagnosa;
    int tingkatKeparahan;

    public RekamMedis() {
        this.diagnosa = "belum ada";
        this.tingkatKeparahan = 1;
    }

    public RekamMedis(String diagnosa, int tingkatKeparahan) {
        this.diagnosa = diagnosa;
        this.tingkatKeparahan = tingkatKeparahan;
    }

    // behavior
    public int getTingkatDarurat() {
        Random r = new Random();
        return tingkatKeparahan + r.nextInt(10);
    }
}