public class Main {
    public static void main(String[] args){
        PhysicalStat khabibStats = new PhysicalStat(70.0, 178);
        PhysicalStat pereiraStats = new PhysicalStat(93.0, 193);


        MMAFighter fighter1 = new MMAFighter("Khabib Nurmagomedov", "The Eagle", khabibStats);
        MMAFighter fighter2 = new MMAFighter("Alex Pereira", "Poatan", pereiraStats);
        MMAFighter fighter3 = new MMAFighter();

        fighter1.announceFight(fighter3);
        fighter2.announceFight(fighter3);

        fighter1.calculateWinProbability(fighter2);
        fighter2.calculateWinProbability(fighter3);

    
    }

}
