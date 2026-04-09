public class Karakter {
    String nama;
    int damage = 5;
    Alien alien = new Alien();
    Kesehatan kesehatan = new Kesehatan();

    public Karakter() {
        nama = null;
        damage = 0;
        alien.ras = "Zoro";
        alien.kemampuan = "Santoryu"; 
    }

    public Karakter(String nama, String rasAlien, String kemampuan) {
        this.nama = nama;
        this.alien.ras = rasAlien;
        this.alien.kemampuan = kemampuan;
    }

    public Karakter(String nama, String rasAlien, String kemampuan, int damage, int hp) {
        this.nama = nama;
        this.alien.ras = rasAlien;
        this.alien.kemampuan = kemampuan;
        this.kesehatan.hp = hp;
        this.damage = damage;
    }

    public Karakter(String nama, String rasAlien, String kemampuan, int hp) {
        this.nama = nama;
        this.alien.ras = rasAlien;
        this.alien.kemampuan = kemampuan;
        this.kesehatan.hp = hp;
    }

    public void attack(Karakter musuh) {
        int totalDamage = this.damage + alien.getPowerBonus();

        System.out.printf("%s menyerang %s menggunakan kemampuan %s (%s)\n",
                this.nama, musuh.nama, alien.kemampuan, alien.ras);

        System.out.printf("Damage ke %s = %d\n", musuh.nama, totalDamage);

        musuh.kesehatan.kurangiHP(totalDamage);
    }

    public String getNama() {
        return nama;
    }

    public void UpdateDamage(int damage) {
        this.damage = damage;
        System.out.printf("Update damage %s ke %d\n", nama, damage);
    }

    public void showStatus() {
        System.out.printf("================ %s Status =======================\n", nama);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Ras Alien\t: " + alien.getDetail());
        System.out.println("Total Damage\t: " + (damage + alien.getPowerBonus()));
        System.out.println("Kesehatan\t: " + kesehatan.getHP());
        System.out.println("Kondisi\t\t: " + kesehatan.getKondisi());
    }
}