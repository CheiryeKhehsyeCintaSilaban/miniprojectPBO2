/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package MainMenu;

/**
 *
 * @author Asus1
 */
import Crud.Admin;
import Crud.Jemaat;
import java.util.ArrayList;
import java.util.Scanner;

public class Minpro2 implements Admin {
    static ArrayList<Jemaat> daftarJemaat = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Minpro2 mainApp = new Minpro2();
        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Jemaat Gereja ===");
            System.out.println("1. Tambah Jemaat");
            System.out.println("2. Lihat Data Jemaat");
            System.out.println("3. Update Data Jemaat");
            System.out.println("4. Hapus Data Jemaat");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> mainApp.create();
                case 2 -> mainApp.read();
                case 3 -> mainApp.update();
                case 4 -> mainApp.delete();
                case 5 -> System.out.println("Keluar dari program...");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    // Implementasi method CRUD
    @Override
    public void create() {
        System.out.println("\n--- Tambah Data Jemaat ---");
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan telepon: ");
        String telepon = scanner.nextLine();

        Jemaat JemaatBaru = new Jemaat("user" + (daftarJemaat.size() + 1), "password123", "jemaat", nama, alamat, telepon);
        daftarJemaat.add(JemaatBaru);
        System.out.println("Jemaat berhasil ditambahkan!");
    }

    @Override
    public void read() {
        System.out.println("\n--- Data Jemaat ---");
        if (daftarJemaat.isEmpty()) {
            System.out.println("Tidak ada data jemaat.");
        } else {
            for (Jemaat Jemaat : daftarJemaat) {
                Jemaat.tampilkanDetail();
                System.out.println("--------------------");
            }
        }
    }

    @Override
    public void update() {
        System.out.println("\n--- Update Data Jemaat ---");
        System.out.print("Masukkan nama jemaat yang akan diupdate: ");
        String namaDicari = scanner.nextLine();
        boolean found = false;

        for (Jemaat jemaat : daftarJemaat) {
            if (jemaat.getNama().equalsIgnoreCase(namaDicari)) {
                System.out.print("Masukkan alamat baru: ");
                jemaat.setAlamat(scanner.nextLine());
                System.out.print("Masukkan telepon baru: ");
                jemaat.setTelepon(scanner.nextLine());
                System.out.println("Data berhasil diupdate!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Jemaat tidak ditemukan.");
        }
    }

    @Override
    public void delete() {
        System.out.println("\n--- Hapus Data Jemaat ---");
        System.out.print("Masukkan nama jemaat yang akan dihapus: ");
        String namaDicari = scanner.nextLine();
        boolean found = false;

        for (Jemaat jemaat : daftarJemaat) {
            if (jemaat.getNama().equalsIgnoreCase(namaDicari)) {
                daftarJemaat.remove(jemaat);
                System.out.println("Data jemaat berhasil dihapus!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Jemaat tidak ditemukan.");
        }
    }
}
