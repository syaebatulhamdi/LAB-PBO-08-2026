package H071251079.tugas_5.soal_2;


public class Main {
    public static void main(String[] args) {
        SmartLamp smartlamp = new SmartLamp("Philips", 13);
        SmartCCTV smartcctv = new SmartCCTV("Ezviz", 10);
        SmartSpeaker smartSpeaker = new SmartSpeaker("Siri", 20);

        smartlamp.prosesPerintah("nyala");
        smartlamp.prosesPerintah("MATIKAN");
        smartlamp.cekFungsi();

        System.out.println();
        
        smartcctv.hubungkanWiFi();
        smartcctv.cekFungsi();

        System.out.println();

        smartSpeaker.prosesPerintah("Hey siri, kenapa manusia minum air?");
        smartSpeaker.hubungkanWiFi();
        smartSpeaker.cekFungsi();

    }
}
