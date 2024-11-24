/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

/**
 *
 * @author USER
 */
class Menu {
    String nama;
    double harga;
    String kategori;
    
    public Menu (String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
    
    public void tampilMenu() {
        System.out.println(this.nama + " - Rp. " + this.harga + " (" + this.kategori + ")");
    }
}