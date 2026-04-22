import java.util.Scanner;

public class TP1No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] daftarBulan = { "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.print("Input: ");
        String input = sc.nextLine(); 
        String[] bagian = input.split("-");

        int tgl = Integer.parseInt(bagian[0]);
        int bln = Integer.parseInt(bagian[1]);
        int thnRaw = Integer.parseInt(bagian[2]);


        int tahunFull = (thnRaw <= 26) ? 2000 + thnRaw : 1900 + thnRaw;

        System.out.println("Output: " + tgl + " " + daftarBulan[bln - 1] + " " + tahunFull);
    }
}