public class Overthinker {
    String name;
    int stressLevel;
    Thought thought;
    Coping coping;

    // Constructor default
    public Overthinker() {
        name = "rafly";
        stressLevel = 50;
        thought = new Thought("Hal kecil", 5);
        coping = new Coping("Istirahat", 5);
    }

    // Constructor dengan parameter
    public Overthinker(String name, int stressLevel, Thought thought, Coping coping) {
        this.name = name;
        this.stressLevel = stressLevel;
        this.thought = thought;
        this.coping = coping;
    }
 
    // Menjaga agar stress tetap 0-100
    public void updateStress(int value) {
        stressLevel += value;
        if (stressLevel > 100) stressLevel = 100;
        if (stressLevel < 0) stressLevel = 0;
    }

    // Overthinking (menambah stress)
    public void think() {
        System.out.println(name + " overthinking: " + thought.topic);
        updateStress(thought.intensity);
    }

    // Interaksi antar object 
    public void interact(Overthinker other) {
        System.out.println(name + " berbagi dengan " + other.name);

        this.updateStress(-5);
        other.updateStress(-3);
    }

    // Coping (mengurangi stress)
    public void cope() {
        System.out.println(name + " coping: " + coping.method);
        updateStress(-coping.effect);
}

    // Khusus Ayla (tugas selesai)
    public void finishTask() {
        updateStress(-10);
        thought.topic = "Tugas selesai dan merasa lega";
        coping.method = "Menikmati waktu santai tanpa beban";
    }

    // Khusus Salsa (lebih tenang)
    public void resolveThought() {
        updateStress(-10);
        thought.topic = "Lebih tenang dan fokus pada saat ini";
        coping.method = "Menikmati waktu santai tanpa beban";
    }

    public void checkStatus() {
        System.out.println("Nama   : " + name);
        System.out.println("Stress : " + stressLevel + "%");
        System.out.println("Pikiran: " + thought.topic);
        System.out.print("------------------------\n");
    }
}