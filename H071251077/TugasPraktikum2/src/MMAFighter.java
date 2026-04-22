public class MMAFighter {
    String name;
    String nickname;
    PhysicalStat stats; 

    // Constructor Default
    public MMAFighter() {
        this.name = "Unknown Fighter";
        this.nickname = "The Rookie";
        this.stats = new PhysicalStat(70.0, 173);
    }

    // Constructor Parameter 
    public MMAFighter(String name, String nickname, PhysicalStat stats) {
        this.name = name;
        this.nickname = nickname;
        this.stats = stats;
    }


    public String getWeightClass() {
        double weight = this.stats.weightKg;
        if (weight <= 56.7) return "Flyweight";
        else if (weight <= 70.3) return "Lightweight";
        else if (weight <= 83.9) return "Middleweight";
        else if (weight <= 93.0) return "Light Heavyweight";
        else return "Heavyweight";
    }


    public void announceFight(MMAFighter opponent) {
        System.out.println("========= UFC 360 =========");
        System.out.println("FIGHTER 1: " + this.name);
        System.out.println("DIVISION : " + this.getWeightClass());
        System.out.println("------------------------------------");
        System.out.println("FIGHTER 2: " + opponent.name);
        System.out.println("DIVISION : " + opponent.getWeightClass());
        
        if (this.getWeightClass().equals(opponent.getWeightClass())) {
            System.out.println("MATCH STATUS: FIGHT IS ON!");
        } else {
            System.out.println("MATCH STATUS: WEIGHT MISMATCH!");
        }
    }


    public void calculateWinProbability(MMAFighter opponent) {
        System.out.println("\n--- WIN PROBABILITY ANALYSIS ---");
        int myScore = 0;
        int opponentScore = 0;

        if (this.stats.heightCm > opponent.stats.heightCm) {
            myScore++;
        } else if (this.stats.heightCm < opponent.stats.heightCm) {
            opponentScore++;
        }


        if (this.stats.weightKg > opponent.stats.weightKg) {
            myScore++;
        } else if (this.stats.weightKg < opponent.stats.weightKg) {
            opponentScore++;
        }

        System.out.print("PREDICTION: ");
        if (myScore > opponentScore) {
            System.out.println(this.name + " has the physical advantage against " + opponent.name);
        } else if (myScore < opponentScore) {
            System.out.println(opponent.name + " has the physical advantage against " + this.name);
        } else {
            System.out.println("Both fighters are physically balanced.");
        }
    }
}