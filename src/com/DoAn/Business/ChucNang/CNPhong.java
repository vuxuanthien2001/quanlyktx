package com.DoAn.Business.ChucNang;

import com.DoAn.Business.HienThi.HienPhong;
import com.DoAn.Business.Nhap.NhapPhong;
import com.DoAn.Data.Phong;

import java.util.ArrayList;
import java.util.Scanner;

public class CNPhong {
    public static Scanner sc = new Scanner(System.in);
    // Sửa
    public void SuaPhong(ArrayList<Phong> PhongArrayList, String xau) {
        NhapPhong NhapPhong = new NhapPhong();
        boolean kiemtra = false;
        for (int i = 0; i < PhongArrayList.size(); i++) {
            if (xau.equalsIgnoreCase(PhongArrayList.get(i).getMasv())) {
                kiemtra = true;
                System.out.println("Đã tìm thấy thông tin cần sửa !!!");
                PhongArrayList.set(i, new Phong(NhapPhong.maphong(), NhapPhong.tenphong(), xau));
            }
        }
        if (kiemtra == false)
            System.out.println("Không tìm thấy thông tin cần sửa !!!");
    }

    // Xóa
    public void XoaPhong(ArrayList<Phong> PhongArrayList, String xau) {
        boolean kiemtra = false;
        for (int i = 0; i < PhongArrayList.size(); i++) {
            if (xau.equalsIgnoreCase(PhongArrayList.get(i).getMaphong())) {
                kiemtra = true;
                System.out.println("Đã xóa !!! ");
                PhongArrayList.remove(i);
            }
        }
        if (kiemtra == false) System.out.println("Không tìm thấy thông tin cần xóa !!!");
    }

    // Tìm kiếm
    public void TimPhong(ArrayList<Phong> PhongArrayList) {
        System.out.print("Nhập mã phòng cần tìm kiếm: ");
        String xau = sc.nextLine();
        boolean kiemtra = false;
        for (Phong Phong : PhongArrayList
        ) {
            if (xau.equalsIgnoreCase(Phong.getMaphong())) {
                kiemtra = true;
            }
        }
        if(kiemtra == true)
        {
            System.out.println("\nDanh sách tìm được:\n");
            HienPhong HienPhong = new HienPhong();
            System.out.println("\t╔==============================================================╗");
            System.out.printf("\t║%20s║%20s║%20s║\n","Mã phòng","Tên phòng", "Mã sinh viên");
            System.out.println("\t╟==============================================================╢");
            for (Phong Phong : PhongArrayList
            ) {
                if (xau.equalsIgnoreCase(Phong.getMaphong())) {
                    HienPhong.Hien1Phong(Phong);
                }
            }
            System.out.println("\t╚==============================================================╝");
        }
        if (kiemtra == false)
            System.out.println("\nKhông tìm thấy thông tin cần tìm !!!");
    }

    public void TimSinhVien(ArrayList<Phong> PhongArrayList) {
        System.out.print("Nhập mã sinh viên cần tìm kiếm: ");
        String xau = sc.nextLine();
        boolean kiemtra = false;
        for (Phong Phong : PhongArrayList
        ) {
            if (xau.equalsIgnoreCase(Phong.getMasv())) {
                kiemtra = true;
            }
        }
        if(kiemtra == true)
        {
            System.out.println("\nDanh sách tìm được:\n");
            HienPhong HienPhong = new HienPhong();
            System.out.println("\t╔==============================================================╗");
            System.out.printf("\t║%20s║%20s║%20s║\n","Mã phòng","Tên phòng", "Mã sinh viên");
            System.out.println("\t╟==============================================================╢");
            for (Phong Phong : PhongArrayList
            ) {
                if (xau.equalsIgnoreCase(Phong.getMasv())) {
                    HienPhong.Hien1Phong(Phong);
                }
            }
            System.out.println("\t╚==============================================================╝");
        }
        if (kiemtra == false)
            System.out.println("\nKhông tìm thấy thông tin cần tìm !!!");
    }
}
