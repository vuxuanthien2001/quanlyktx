package com.DoAn.Data;

public class DichVu_HoaDon {
    private String maphong;
    private int cs1kw;
    private int cs2kw;
    private int cs1m3;
    private int cs2m3;
    private int dongiam3 = 5000;
    private int chiphikhac;

    public DichVu_HoaDon(){

    }

    public DichVu_HoaDon(String maphong, int cs1kw, int cs2kw, int cs1m3, int cs2m3, int chiphikhac) {
        this.maphong = maphong;
        this.cs1kw = cs1kw;
        this.cs2kw = cs2kw;
        this.cs1m3 = cs1m3;
        this.cs2m3 = cs2m3;
        this.chiphikhac = chiphikhac;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public int getCs1kw() {
        return cs1kw;
    }

    public void setCs1kw(int cs1kw) {
        this.cs1kw = cs1kw;
    }

    public int getCs2kw() {
        return cs2kw;
    }

    public void setCs2kw(int cs2kw) {
        this.cs2kw = cs2kw;
    }



    public int getCs1m3() {
        return cs1m3;
    }

    public void setCs1m3(int cs1m3) {
        this.cs1m3 = cs1m3;
    }

    public int getCs2m3() {
        return cs2m3;
    }

    public void setCs2m3(int cs2m3) {
        this.cs2m3 = cs2m3;
    }

    public int getDongiam3() {
        return dongiam3;
    }

    public void setDongiam3(int dongiam3) {
        this.dongiam3 = dongiam3;
    }

    public int getChiphikhac() {
        return chiphikhac;
    }

    public void setChiphikhac(int chiphikhac) {
        this.chiphikhac = chiphikhac;
    }

    @Override
    public String toString() {
        return maphong + "#" + cs1kw + "#" + cs2kw + "#" +cs1m3 + "#" + cs2m3 + "#" + chiphikhac+"\n";
    }
}
