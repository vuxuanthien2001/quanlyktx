package com.DoAn.Data;

public class Phong {
    private String maphong;
    private String tenphong;
    private String masv;

    public Phong(){

    }


    public Phong(String maphong, String tenphong, String masv) {
        this.maphong = maphong;
        this.tenphong = tenphong;
        this.masv = masv;

    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    @Override
    public String toString() {
        return maphong + "#" + tenphong +"#" + masv+"\n";
    }
}
