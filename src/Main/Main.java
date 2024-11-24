/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author USER
 */
import java.util.*;

public class Main {
    static Menu[] menuRestoran = new Menu[8];
    static ArrayList<String> pesanan = new ArrayList<>();
    static double totalBiaya = 0;
    
    public static void inisialisasiMenu() {
        menuRestoran[0] = new Menu("Nasi Goreng",25000,"Makanan");
        menuRestoran[1] = new Menu("Mie Goreng", 20000, "Makanan");
        menuRestoran[2] = new Menu("Sate Ayam",30000,"Makanan");
        menuRestoran[3] = new Menu("Soup Kacang Merah",22000,"Makanan");
        menuRestoran[4] = new Menu("Es Teh",10000,"Minuman");
        menuRestoran[5] = new Menu("Es Jeruk",12000,"Minuman");
        menuRestoran[6] = new Menu("Kopi Susu",15000,"Minuman");
        menuRestoran[7] = new Menu("Air Mineral",5000,"Minuman");
    }
    public static void tampilkanMenu() {
        System.out.println("\nMenu Restoran:");
        System.out.println("Makanan:");
        for (int i = 0; i < 4; i++) {
            menuRestoran[i].tampilMenu();
        }
        System.out.println("Minuman:");
        for (int i = 4; i < 8; i++) {
            menuRestoran[i].tampilMenu();
        }
    }
    
    public static void ambilPesanan() {
        Scanner scanner = new Scanner(System.in);
        String pilihan;
        
        do {
            System.out.print("Masukan nama menu ingin dipesan (atau ketik 'selesai' untuk selesai): ");
            pilihan = scanner.nextLine();
            boolean ditemukan = false;
            
            for (Menu menu : menuRestoran) {
                if (menu.nama.equalsIgnoreCase(pilihan)) {
                    pesanan.add(pilihan);
                    totalBiaya += menu.harga;
                    ditemukan = true;
                    System.out.println("Pesanan Anda: " + pilihan);
                    break;
                }
            }
            
            if (!pilihan.equalsIgnoreCase("selesai") && !ditemukan) {
                System.out.println("Menu tidak tersedia, silakan pilih lagi.");
            }
        } while (!pilihan.equalsIgnoreCase("selesai"));
    }
    
    public static void hitungTotalBiaya() {
        double pajak = totalBiaya * 0.1;
        double biayaPelayanan = 20000;
        double diskon = 0;
        
        if (totalBiaya > 100000) {
            diskon = totalBiaya * 0.1;
            totalBiaya -= diskon;
        }
        
        if (totalBiaya > 50000) {
            System.out.println("Penawaran beli satu gratis satu minuman diterapkan.");
            totalBiaya -= menuRestoran[4].harga;
        }
        
        totalBiaya += pajak + biayaPelayanan;
        System.out.println("\nStruk pesanan:");
        for (String item : pesanan) {
            System.out.println(item);
        }
        System.out.println("Total Harga: Rp. " + totalBiaya);
        System.out.println("Pajak (10%): Rp. " + pajak);
        System.out.println("Biaya pelayanan: Rp. " + biayaPelayanan);
        if (diskon > 0) {
            System.out.println("Diskon: Rp. " + diskon);
        }
        System.out.println("Total pembayaran: Rp. " + totalBiaya);
    }
    
    public static void manajemenMenu() {
        Scanner scanner = new Scanner (System.in);
        int pilihan;
        do{
            System.out.println("\nMenu Manajemen Restoran:");
            System.out.println("1. Tambahan Menu");
            System.out.println("2. Ubah Harga Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Kembali");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    tambahMenu(scanner);
                    break;
                case 2:
                    ubahHargaMenu(scanner);
                    break;
                case 3:
                    hapusMenu(scanner);
                    break;
                case 4:
                    System.out.println("Kembali ke menu utama.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }
    
    public static void tambahMenu(Scanner scanner) {
        System.out.print("Masukkan nama menu: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga menu: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan kategori (Makanan/Minuman): ");
        String kategori = scanner.nextLine();
        
        Menu menuBaru = new Menu(nama, harga, kategori);
        
        System.out.println("Menu " + nama + " berhasil ditambahkan.");
    }
    
    public static void ubahHargaMenu(Scanner scanner) {
        
    }
    
    public static void hapusMenu(Scanner scanner) {
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        inisialisasiMenu();
        
        do {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Pemesanan");
            System.out.println("2. Manajemen Menu");
            System.out.println("3. Keluar");
            System.out.print("pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    tampilkanMenu();
                    ambilPesanan();
                    hitungTotalBiaya();
                    break;
                case 2:
                    manajemenMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi restoran.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);
    }

}