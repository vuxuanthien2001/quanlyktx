package com.DoAn.Business.HienThi;

import com.DoAn.Data.SinhVien;

import java.util.ArrayList;

public class HienSinhVien {
    public void Hien1SinhVien(SinhVien SinhVien){
        System.out.printf("\t║%15s║%30s║%20s║%10s║%30s║%10s║%20s║\n",SinhVien.getMasv(),SinhVien.getHoten(),SinhVien.getNgaysinh(),SinhVien.getGioitinh(),SinhVien.getDiachi(),SinhVien.getMalop(),SinhVien.getSdt());
    }
    public void HienThiSinhVien(ArrayList<SinhVien> SinhVienArrayList){
        System.out.println("\t╔=============================================================================================================================================╗");
        System.out.printf("\t║%15s║%30s║%20s║%10s║%30s║%10s║%20s║\n","Mã sinh viên","Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Mã lớp", "Số điện thoại");
        System.out.println("\t╟=============================================================================================================================================╢");
        for (SinhVien SinhVien: SinhVienArrayList){
            Hien1SinhVien(SinhVien);
        }
        System.out.println("\t╚=============================================================================================================================================╝");
    }
}
