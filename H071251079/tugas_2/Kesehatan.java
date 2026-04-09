public class Kesehatan {
    int hp = 20;
    int maxHP = 100;

    public int getHP() {
        return hp;
    }

    public void setHP(Karakter karakter, int hp) {
        if (hp > this.maxHP) {
            System.out.printf("Max Hp hanya sampai %d\n", maxHP);
        } else {
            this.hp = hp;
            System.out.printf("Update Kesehatan %s ke %d\n", karakter.getNama(), hp);
        }
    }

    public String getKondisi() {
        if (this.hp < 1) {
            return "Kalah";
        } else {
            return "Hidup";
        }
    }

    public void kurangiHP(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void healing(Karakter karakter, int hp) {
        if ((this.hp + hp) > this.maxHP) {
            this.hp = maxHP;
        } else {
            this.hp += hp;
        }
        System.out.printf("%s melakukan regenerasi, memulihkan %d kesehatan\n", karakter.getNama(), hp);
    }
}