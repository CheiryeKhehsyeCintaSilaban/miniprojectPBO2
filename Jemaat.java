/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Crud;

import MainMenu.User;


/**
 *
 * @author Asus1
 */
public final class Jemaat extends User { 
    private final String nama;
    private String alamat;
    private String telepon;

    public Jemaat(String username, String password, String role, String nama, String alamat, String telepon) {
        super(username, password, role); 
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    
    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    /**
     *
     */
    @Override
    public void tampilkanDetail() {
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Telepon: " + telepon);
    }
}

