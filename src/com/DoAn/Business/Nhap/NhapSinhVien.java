package com.DoAn.Business.Nhap;

import com.DoAn.Data.SinhVien;

import java.util.Scanner;
import java.util.ArrayList;

public class NhapSinhVien {
    static Scanner sc = new Scanner(System.in);
    public void NhapSinhVien(ArrayList<SinhVien> SinhVienArrayList) {
        String msv;
        while (true){
            while (true) {
                msv = masv();
                if (KiemTra(msv, SinhVienArrayList)) {
                    SinhVienArrayList.add(new SinhVien(msv, hoten(), ngaysinh(), gioitinh(), diachi(), malop(), sdt()));
                    System.out.println("Nhập thành công");
                    break;
                } else {
                    System.out.println("Mã đã tồn tại !!!\nVui lòng nhập lại !!!");
                }
            }
            System.out.print("Nhập T để tiếp tục: ");
            String x = sc.nextLine().toUpperCase();
            if(!(x.equalsIgnoreCase("T"))){
                break;
            }
        }

    }

    public boolean KiemTra(String msv, ArrayList<SinhVien> SinhVienArrayList) {
        boolean kt = true;
        for (SinhVien i : SinhVienArrayList
        ) {
            if (msv.equalsIgnoreCase(i.getMasv())) {
                kt = false;
            }
        }
        return kt;
    }

    // masv + "#" + hoten + "#" + ngaysinh + "#" + gioitinh + "#" + diachi + "#" + malop + "#" + sdt ;
    public String masv() {
        String masv;
        System.out.print("Nhập mã sinh viên: ");
        do{
            masv = sc.nextLine().toUpperCase();
            if(masv.equals("")){
                System.out.print("Nhập lại mã sinh viên: ");
            }
        }while (masv.equals(""));
        return masv;
    }

    public String hoten() {
        String hoten;
        System.out.print("Nhập họ tên sinh viên: ");
        do{
            hoten = sc.nextLine();
            if(hoten.equals("")){
                System.out.print("Nhập lại họ tên sinh viên: ");
            }
        }while (hoten.equals(""));
        ChuanHoa chuanHoa = new ChuanHoa();
        hoten = chuanHoa.ChuanHoaDanhTuRieng(hoten);
        return hoten;
    }

    public String ngaysinh() {
        String ngaysinh;
        System.out.print("Nhập ngày sinh sinh viên: ");
        do{
            ngaysinh = sc.nextLine();
            if(ngaysinh.equals("") || checkngaysinh(ngaysinh) != true){
                System.out.print("Nhập lại ngày sinh sinh viên (Ngày/tháng/năm): ");
            }
        }while (ngaysinh.equals("") || checkngaysinh(ngaysinh) != true);
        return ngaysinh;
    }

    public boolean checkngaysinh(String ngaysinh){
        String ns = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
        return ngaysinh.matches(ns);
    }

    public String gioitinh() {
        String gioitinh;
        System.out.print("Nhập giới tính sinh viên: ");
        do{
            gioitinh = sc.nextLine();
            ChuanHoa chuanHoa = new ChuanHoa();
            gioitinh = chuanHoa.ChuanHoaDanhTuRieng(gioitinh);
            if(!(gioitinh.equals("Nam") || gioitinh.equals("Nữ"))){
                System.out.print("Nhập lại giới tính sinh viên (Nam or Nữ): ");
            }
        }while (!(gioitinh.equals("Nam") || gioitinh.equals("Nữ")));
        return gioitinh;
    }

    public String diachi() {
        String diachi;
        System.out.print("Nhập địa chỉ sinh viên: ");
        do{
            diachi = sc.nextLine();
            if(diachi.equals("")){
                System.out.print("Nhập lại địa chỉ sinh viên: ");
            }
        }while (diachi.equals(""));
        ChuanHoa chuanHoa = new ChuanHoa();
        diachi = chuanHoa.ChuanHoaDanhTuRieng(diachi);
        return diachi;
    }

    public String malop() {
        String malop;
        System.out.print("Nhập mã lớp sinh viên: ");
        do{
            malop = sc.nextLine().toUpperCase();
            if(malop.equals("")){
                System.out.print("Nhập lại mã lớp sinh viên: ");
            }
        }while (malop.equals(""));
        return malop;
    }

    public String sdt() {
        String sdt;
        System.out.print("Nhập số điện thoại liên lạc: ");
        do{
            sdt = sc.nextLine();
            if(sdt.equals("") || checksdt(sdt) != true){
                System.out.print("Nhập lại số điện thoại sinh viên (10 số and bắt đầu bằng 0): ");
            }
        }while (sdt.equals("") || checksdt(sdt) != true);
        return sdt;
    }

    public boolean checksdt(String sdt){
        String s = "0[0-9]{9}";
        return sdt.matches(s);
    }
}
