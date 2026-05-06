package Tuprak5.Soal2;

public class Main {
    public static void main(String[] args) {

        SmartLamp lampu = new SmartLamp("Prabowops", 10);
        SmartCCTV cctv = new SmartCCTV("jokowicctv", 20);
        SmartSpeaker speaker = new SmartSpeaker("aniesspeaker", 15);

        // SmartLamp
        lampu.cekFungsi();
        lampu.infoPower();
        lampu.prosesPerintah("nyala");

        System.out.println();

        // SmartCCTV
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println();

        // SmartSpeaker
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();      // dari interface InteraksiInternet
        speaker.prosesPerintah("PLAY MUSIC"); // dari interface KontrolSuara
    }
}