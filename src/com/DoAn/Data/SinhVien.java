package com.DoAn.Data;

public class SinhVien {
    private String masv;
    private String hoten;
    private String ngaysinh;
    private String gioitinh;
    private String diachi;
    private String malop;
    private String sdt;




    public SinhVien(){

    }

    public SinhVien(String masv, String hoten, String ngaysinh, String gioitinh, String diachi, String malop, String sdt) {
        this.masv = masv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.malop = malop;
        this.sdt = sdt;

    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return masv + "#" + hoten + "#" + ngaysinh + "#" + gioitinh + "#" + diachi + "#" + malop + "#" + sdt +"\n";
    }
}


