public class Main {
    public static void main(String[] args) {

        Thought t1 = new Thought("Tugas belum selesai", 15);
        Thought t2 = new Thought("Memikirkan masa depan", 20);


        Coping c1 = new Coping("Mendengarkan musik", 10);
        Coping c2 = new Coping("Istirahat", 8);

        Overthinker ayla = new Overthinker("Ayla", 40, t1, c1);
        Overthinker salsa = new Overthinker("Salsa", 35, t2, c2);
       
        // PEMANGGILAN CONSTRUCTOR DEFAULT
        Overthinker rafly = new Overthinker();
        rafly.checkStatus();

        // STATUS AWAL
        System.out.println("\n=== STATUS AWAL ===");
        ayla.checkStatus();
        salsa.checkStatus();

        // PROSES
        System.out.println("\n=== PROSES ===");

        ayla.think();
        salsa.think();

        ayla.interact(salsa);

        ayla.cope();
        salsa.cope();

        // HASIL
        ayla.finishTask();
        salsa.resolveThought();

        // STATUS AKHIR
        System.out.println("\n=== STATUS AKHIR ===");
        ayla.checkStatus();
        salsa.checkStatus();
    }
}









