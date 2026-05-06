public class MainSoal2 {
    public static void main(String[] args) {

        System.out.println("===== SMART HOME =====");

        // SMART LAMP
        SmartLamp lamp = new SmartLamp("Philips", 10);
        lamp.cekFungsi();       
        lamp.infoPower();       
        lamp.prosesPerintah("NYALA"); 

        // SMART CCTV
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 20);
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi(); 

        // SMART SPEAKER
        SmartSpeaker speaker = new SmartSpeaker("Google", 15);
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi(); 
        speaker.prosesPerintah("Putar musik"); 
    }
}