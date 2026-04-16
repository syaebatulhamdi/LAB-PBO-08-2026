package Praktikum3 ;
import java.util.Scanner;

public class DompetDigital {
    
    protected String namaNasabah;
    private int norek;
    private int pin;
    int saldo; 

    public DompetDigital(String namaNasabah, int pin, int norek) {
    this.namaNasabah = namaNasabah;
    this.pin = pin;
    this.norek = norek;
    }

    public void getInfo(){
    System.out.println("Nama Nasabah    : " + this.namaNasabah);
    System.out.println("saldo           : " + this.saldo);
    }

public void setPin(int Pinbaru){
    Scanner x = new Scanner(System.in);
    System.out.print("masukkan PIN : ");
    int pinlama = x.nextInt();
    Boolean valid = true;
    if (pinlama != this.pin){
        valid = false;
        System.out.println("PIN yang anda masukkan salah.");
        log("Gagal ubah PIN: PIN lama salah");
    }
    String pinbaru = String.valueOf(Pinbaru);
    if(pinbaru.length() != 6) {
        valid = false;
        System.out.println("PIN harus 6 digit angka");
        log("Gagal ubah PIN: panjang tidak 6 digit");
    }

    if(valid){
        this.pin = Pinbaru;
        System.out.println("Pin berhasil di ubah");
        log("Berhasil ubah PIN");
    }

}
public void setor (int uang){
    if (uang <= 0){
        System.out.println("input tidak valid, nominal harus lebih dari 0");
        log("Gagal setor: nominal tidak valid");
    }
    else{
        this.saldo += uang;
        System .out.println("saldo anda sekarang adalah : " + this.saldo);
        log("Berhasil setor: +" + uang);
    }

}
public void tarik(int uang){
    Scanner x = new Scanner(System.in);
    int pinlama = x.nextInt();
    Boolean valid = true;
    if (pinlama != this.pin){
        valid = false;
        System.out.println("PIN yang anda masukkan salah.");
        log("Gagal tarik: PIN salah");
    }
    if (uang <= 0 || uang > this.saldo){
        valid = false;
        System.out.println("input tidak valid");
        log("Gagal tarik: nominal tidak valid / saldo tidak cukup");
    }
    if (valid){
        this.saldo -= uang;
        System.out.println("berhasil saldo saat ini:  " + this.saldo);
        log("Berhasil tarik: -" + uang);
    }
}
    private void log(String pesan) {
        System.out.println("[LOG] " + pesan);
    }
}