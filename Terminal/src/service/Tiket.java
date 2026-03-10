/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author umair
 */
public abstract class Tiket {
    protected String IDTiket;
    protected int hargaDasar;
    protected LocalDate tanggal;
    protected LocalTime waktu;
    protected String dest;
    
    public Tiket(String IDTiket, int hargaDasar, LocalDate tanggal, LocalTime waktu, String dest){
        this.IDTiket = IDTiket;
        this.hargaDasar = hargaDasar;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.dest = dest;
    }
    
    public abstract double hitungHargaTotal();
    
    public void display() {
        System.out.println("ID Booking  : "+this.IDTiket);
        System.out.println("Tanggal     : "+this.tanggal);
        System.out.println("Waktu       : "+this.waktu);
        System.out.println("Tujuan      : "+this.dest);
        System.out.println("Total Harga : "+hitungHargaTotal());
    }
}


