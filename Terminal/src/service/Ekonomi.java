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
public class Ekonomi extends Tiket{
    public Ekonomi (String IDTiket, int hargaDasar, LocalDate tanggal, LocalTime waktu, String dest) {
        super(IDTiket, hargaDasar, tanggal, waktu, dest);
    }
    
    @Override
    public double hitungHargaTotal() {
        return hargaDasar;
    }
}
