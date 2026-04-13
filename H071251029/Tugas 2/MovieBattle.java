public class MovieBattle {
    String judul;
    double rating;
    Actor actor;

    // Constructor default
    MovieBattle() {
        judul = "harry potter";
        rating = 9.2;
        actor=new Actor("draco", 47);
    }

    // Constructor parameter
    MovieBattle(String judul, double rating, Actor actor) {
        this.judul = judul;
        this.rating = rating;
        this.actor = actor;
    }

    // Method tampil
    void tampil() {
        System.out.println("Judul: " + judul);
        System.out.println("Rating: " + rating);
        actor.tampilActor();
        System.out.println("----------------");
    }

    // Method interaksi
    void banding(MovieBattle m) {
        if (this.rating > m.rating)
            System.out.println(this.judul + " lebih bagus dari " + m.judul);
        else if (this.rating < m.rating)
            System.out.println(m.judul + " lebih bagus dari " + this.judul);
        else
            System.out.println("Rating sama");
    }
}    

