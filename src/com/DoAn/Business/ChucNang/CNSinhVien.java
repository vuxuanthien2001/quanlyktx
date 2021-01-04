package com.DoAn.Business.ChucNang;

import com.DoAn.Business.Nhap.ChuanHoa;
import com.DoAn.Data.SinhVien;
import com.DoAn.Business.Nhap.NhapSinhVien;
import com.DoAn.Business.HienThi.HienSinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CNSinhVien {

    public static Scanner sc = new Scanner(System.in);
    // Sửa
    public void SuaSinhVien(ArrayList<SinhVien> SinhVienArrayList, String xau) {
        NhapSinhVien NhapSinhVien = new NhapSinhVien();
        boolean kiemtra = false;
        for (int i = 0; i < SinhVienArrayList.size(); i++) {
            if (xau.equalsIgnoreCase(SinhVienArrayList.get(i).getMasv())) {
                kiemtra = true;
                System.out.println("Đã tìm thấy thông tin cần sửa !!!");
                SinhVienArrayList.set(i, new SinhVien(xau, NhapSinhVien.hoten(), NhapSinhVien.ngaysinh(), NhapSinhVien.gioitinh(), NhapSinhVien.diachi(), NhapSinhVien.malop(), NhapSinhVien.sdt()));
            }
        }
        if (kiemtra == false)
            System.out.println("Không tìm thấy thông tin cần sửa !!!");
    }

    // Xóa
    public void XoaSinhVien(ArrayList<SinhVien> SinhVienArrayList, String xau) {
        boolean kiemtra = false;
        for (int i = 0; i < SinhVienArrayList.size(); i++) {
            if (xau.equalsIgnoreCase(SinhVienArrayList.get(i).getMasv())) {
                kiemtra = true;
                System.out.println("Đã xóa !!! ");
                SinhVienArrayList.remove(i);
            }
        }
        if (kiemtra == false) System.out.println("Không tìm thấy thông tin cần xóa !!!");
    }

    // Tìm kiếm
    public void TimSinhVienTheoMa(ArrayList<SinhVien> SinhVienArrayList) {
        System.out.print("Nhập mã sinh viên cần tìm kiếm: ");
        String xau = sc.nextLine().toUpperCase();
        boolean kiemtra = false;
        for (SinhVien SinhVien : SinhVienArrayList
        ) {
            if (xau.equalsIgnoreCase(SinhVien.getMasv())) {
                kiemtra = true;
            }
        }
        if(kiemtra == true)
        {
            System.out.println("\nDanh sách tìm được:\n");
            HienSinhVien HienSinhVien = new HienSinhVien();
            System.out.println("\t╔=============================================================================================================================================╗");
            System.out.printf("\t║%15s║%30s║%20s║%10s║%30s║%10s║%20s║\n","Mã sinh viên","Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Mã lớp", "Số điện thoại");
            System.out.println("\t╟=============================================================================================================================================╢");
            for (SinhVien SinhVien : SinhVienArrayList
            ) {
                if (xau.equalsIgnoreCase(SinhVien.getMasv())) {
                    HienSinhVien.Hien1SinhVien(SinhVien);
                }
            }
            System.out.println("\t╚=============================================================================================================================================╝");
        }
        if (kiemtra == false)
            System.out.println("\nKhông tìm thấy thông tin cần tìm !!!");
    }

    public void TimSinhVienTheoTen(ArrayList<SinhVien> SinhVienArrayList) {
        ChuanHoa chuanHoa = new ChuanHoa();
        System.out.print("Nhập tên sinh viên cần tìm kiếm: ");
        String xau = sc.nextLine();
        xau = chuanHoa.ChuanHoaDanhTuRieng(xau);
        boolean kiemtra = false;
        for (SinhVien SinhVien : SinhVienArrayList
        ) {
            if (SinhVien.getHoten().endsWith(xau) == true) {
                kiemtra = true;
            }

        }
        if(kiemtra == true){
            System.out.println("\nDanh sách tìm được:\n");
            HienSinhVien HienSinhVien = new HienSinhVien();
            System.out.println("\t╔=============================================================================================================================================╗");
            System.out.printf("\t║%15s║%30s║%20s║%10s║%30s║%10s║%20s║\n", "Mã sinh viên", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Mã lớp", "Số điện thoại");
            System.out.println("\t╟=============================================================================================================================================╢");
            for (SinhVien sv : SinhVienArrayList
            ) {
                if (sv.getHoten().endsWith(xau) == true) {
                    HienSinhVien.Hien1SinhVien(sv);
                }
            }
            System.out.println("\t╚=============================================================================================================================================╝");
        }
        if(kiemtra == false){
            System.out.println("\nKhông tìm thấy thông tin cần tìm !!!");
        }

    }

    // Sắp xếp theo tên
    public void SapXepSinhVien(ArrayList<SinhVien> SinhVienArrayList){
        Collections.sort(SinhVienArrayList, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                String[]tmp1 = o1.getHoten().split(" ");
                String[]tmp2 = o2.getHoten().split(" ");
                return tmp1[tmp1.length-1].compareToIgnoreCase(tmp2[tmp2.length-1]);
            }
        });
    }
}
