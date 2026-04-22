// package Soal1;

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {

//         Scanner input = new Scanner(System.in);
//         System.out.println("=================================");
//         System.out.println("        BANGUN RUANG");
//         System.out.println("=================================");
//         System.out.println("1. Kubus");
//         System.out.println("2. Balok");
//         System.out.println("3. Bola");
//         System.out.println("4. Tabung");

//         System.out.println("=================================");
//         System.out.println("        BANGUN DATAR");
//         System.out.println("=================================");
//         System.out.println("5. Persegi");
//         System.out.println("6. Persegi Panjang");
//         System.out.println("7. Lingkaran");
//         System.out.println("8. Trapesium");

        
//         System.out.print("\nPilihan: ");
//         int pilih = input.nextInt();

//         switch(pilih) {

//             case 1:
//                 System.out.print("Sisi: ");
//                 double s = input.nextDouble();
//                 Kubus k = new Kubus(s);
//                 System.out.println("Luas: " + k.luas());
//                 System.out.println("Volume: " + k.volume());
//                 break;

//             case 2:
//                 System.out.print("Panjang: ");
//                 double p = input.nextDouble();
//                 System.out.print("Lebar: ");
//                 double l = input.nextDouble();
//                 System.out.print("Tinggi: ");
//                 double t = input.nextDouble();
//                 Balok b = new Balok(p,l,t);
//                 System.out.println("Luas: " + b.luas());
//                 System.out.println("Volume: " + b.volume());
//                 break;

//             case 3:
//                 System.out.print("Jari-jari: ");
//                 double r = input.nextDouble();
//                 Bola bola = new Bola(r);
//                 System.out.println("Luas: " + bola.luas());
//                 System.out.println("Volume: " + bola.volume());
//                 break;

//             case 4:
//                 System.out.print("Jari-jari: ");
//                 r = input.nextDouble();
//                 System.out.print("Tinggi: ");
//                 t = input.nextDouble();
//                 Tabung tab = new Tabung(r,t);
//                 System.out.printf("Luas: %.2f \n" , tab.luas());
//                 System.out.printf("Volume: %.2f \n" , tab.volume());
//                 break;

//             case 5:
//                 System.out.print("Sisi: ");
//                 s = input.nextDouble();
//                 Persegi ps = new Persegi(s);
//                 System.out.println("Luas: " + ps.luas());
//                 System.out.println("Keliling: " + ps.keliling());
//                 break;

//             case 6:
//                 System.out.print("Panjang: ");
//                 p = input.nextDouble();
//                 System.out.print("Lebar: ");
//                 l = input.nextDouble();
//                 PersegiPanjang pp = new PersegiPanjang(p,l);
//                 System.out.println("Luas: " + pp.luas());
//                 System.out.println("Keliling: " + pp.keliling());
//                 break;

//             case 7:
//                 System.out.print("Jari-jari: ");
//                 r = input.nextDouble();
//                 Lingkaran ling = new Lingkaran(r);
//                 System.out.println("Luas: " + ling.luas());
//                 System.out.println("Keliling: " + ling.keliling());
//                 break;

//             case 8:
//                 System.out.print("Sisi a: ");
//                 double a = input.nextDouble();
//                 System.out.print("Sisi b: ");
//                 double b2 = input.nextDouble();
//                 System.out.print("Sisi c: ");
//                 double c = input.nextDouble();
//                 System.out.print("Sisi d: ");
//                 double d = input.nextDouble();
//                 System.out.print("Tinggi: ");
//                 t = input.nextDouble();

//                 Trapesium tr = new Trapesium(a,b2,c,d,t);
//                 System.out.println("Luas: " + tr.luas());
//                 System.out.println("Keliling: " + tr.keliling());
//                 break;

//             default:
//                 System.out.println("Pilihan tidak tersedia");
//         }
//     }
// }
