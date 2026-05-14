import java.util.Scanner;

abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println("Menyedot daya sebesar " + dayaListrik + " Watt");
    }
}

interface InteraksiInternet {
    void hubungkanWiFi();
}

interface KontrolSuara {
    void prosesPerintah(String perintah);
}

class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    void cekFungsi() {
        System.out.println("SmartLamp sebagai penerangan.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Perintah tidak dikenali.");
        }
    }
}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    void cekFungsi() {
        System.out.println("SmartCCTV sebagai pengawas.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    void cekFungsi() {
        System.out.println("SmartSpeaker memutar musik.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Speaker terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Menjalankan perintah: " + perintah);
    }
}

public class tugas52 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== SMART HOME SYSTEM ===");
        System.out.println("1. SmartLamp");
        System.out.println("2. SmartCCTV");
        System.out.println("3. SmartSpeaker");
        System.out.print("Pilih perangkat : ");
        int pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1) {
            System.out.print("Masukkan merk lampu : ");
            String merk = input.nextLine();

            System.out.print("Masukkan daya listrik : ");
            int daya = input.nextInt();
            input.nextLine();

            SmartLamp lampu = new SmartLamp(merk, daya);

            lampu.cekFungsi();
            lampu.infoPower();

            System.out.print("Masukkan perintah suara : ");
            String perintah = input.nextLine();

            lampu.prosesPerintah(perintah);

        } else if (pilih == 2) {

            System.out.print("Masukkan merk CCTV : ");
            String merk = input.nextLine();

            System.out.print("Masukkan daya listrik : ");
            int daya = input.nextInt();

            SmartCCTV cctv = new SmartCCTV(merk, daya);

            cctv.cekFungsi();
            cctv.infoPower();
            cctv.hubungkanWiFi();

        } else if (pilih == 3) {

            System.out.print("Masukkan merk Speaker : ");
            String merk = input.nextLine();

            System.out.print("Masukkan daya listrik : ");
            int daya = input.nextInt();
            input.nextLine();

            SmartSpeaker speaker = new SmartSpeaker(merk, daya);

            speaker.cekFungsi();
            speaker.infoPower();
            speaker.hubungkanWiFi();

            System.out.print("Masukkan perintah suara : ");
            String perintah = input.nextLine();

            speaker.prosesPerintah(perintah);

        } else {
            System.out.println("Pilihan tidak tersedia.");
        }

        input.close();
    }
}