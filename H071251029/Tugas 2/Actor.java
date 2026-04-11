public class Actor {
    String nama;
    int umur;

    Actor(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    void tampilActor() {
        System.out.println("Actor: " + nama + ", Umur: " + umur);
    }
}