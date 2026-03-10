/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package terminal;

import java.util.Scanner;
import service.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author umair
 */
public class Terminal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tiket[] daftarAntri = new Tiket[100];
        boolean sesiAktif = true;
        int jumlahData = 0;
        
        Scanner input = new Scanner(System.in);
        System.out.println("--- Sistem Ticketing ---");
        while (sesiAktif && jumlahData < 100) {
                try {
                    System.out.println("Antrian ke-"+(jumlahData+1));
                    System.out.print("Masukkan ID Booking (Awali TIX): ");
                    String ID = input.nextLine();
                    if (!ID.startsWith("TIX")) {
                        throw new DataTiketInvalidException("ID Booking tidak berawalan TIX.");
                    }
                    System.out.print("Tanggal (DD/MM/YYYY)           : ");
                    String date = input.nextLine();
                    LocalDate tanggal;
                    try {
                        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        tanggal = LocalDate.parse(date, formatTgl);
                    } catch (DateTimeParseException e){
                        throw new DataTiketInvalidException("Format TANGGAL salah! Gunakan DD/MM/YYYY");
                    }
                    
                    System.out.print("Waktu Keberangkatan            : ");
                    String time = input.nextLine();
                    LocalTime waktu;
                    try {
                        DateTimeFormatter formatJam = DateTimeFormatter.ofPattern("HH:mm");
                        waktu = LocalTime.parse(time, formatJam); 
                    } catch (DateTimeParseException e) {
                        throw new DataTiketInvalidException("Format JAM salah! Gunakan HH:mm");
                    }
                    
                    
                    System.out.print("Stasiun tujuan                 : ");
                    String dest = input.nextLine();
                    System.out.print("Harga Dasar                    : Rp.");
                    int hargaDasar = Integer.parseInt(input.nextLine());
                    System.out.print("Kelas (Eko:1, Eks:2, Lux: 3)   : ");
                    int kelas = Integer.parseInt(input.nextLine());
                    Tiket tiketBaru = null;
                    switch(kelas) {
                        case 1: 
                            tiketBaru = new Ekonomi(ID, hargaDasar, tanggal, waktu, dest);
                            break;
                        case 2:
                            tiketBaru = new Executive(ID, hargaDasar, tanggal, waktu, dest);
                            break;
                        case 3:
                            tiketBaru = new Luxury(ID, hargaDasar, tanggal, waktu, dest);
                            break;
                        default:
                            throw new Exception("Kelas tidak ada!");
                    }
                    
                    daftarAntri[jumlahData] = tiketBaru;
                    jumlahData++;
                    System.out.print("Tambah data baru (y/n): ");
                    char ulang = input.next().charAt(0);
                    input.nextLine();
                    if((ulang == 'n')||(ulang == 'N')) sesiAktif = false;

                }  catch (NumberFormatException e){
                       System.out.println("Error: Input harus angka! Data cacat dibuang.");
                }  catch (DataTiketInvalidException e) {
                       System.out.println("Error: "+e.getMessage());
                }  catch (Exception e) {
                       System.out.println("Error: "+e.getMessage());
                }
        }
        
        System.out.println("=== Data Penumpang ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Antrean ke-" + (i + 1));
            daftarAntri[i].display();
    }

    }
    
}
