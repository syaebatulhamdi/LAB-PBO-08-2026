public class Main {
    public static void main(String[] args) {

        Actor a1 = new Actor("Lindsay Lohan", 37);
        Actor a2 = new Actor("Alicia Silverstone", 47);

        MovieBattle f1 = new MovieBattle("Mean Girls", 8.2, a1);
        MovieBattle f2 = new MovieBattle("Clueless", 8.2, a2);
        MovieBattle f3 = new MovieBattle();
        f3.tampil();

        // f1.tampil();
        // f2.tampil();

        // f1.banding(f2);
    }
}