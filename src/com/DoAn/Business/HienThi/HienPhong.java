package com.DoAn.Business.HienThi;

import com.DoAn.Data.Phong;

import java.util.ArrayList;

public class HienPhong {
    public void Hien1Phong(Phong Phong){
        System.out.printf("\t║%20s║%20s║%20s║\n",Phong.getMaphong(),Phong.getTenphong(),Phong.getMasv());
    }
    public void HienThiPhong(ArrayList<Phong> PhongArrayList){
        System.out.println("\t╔==============================================================╗");
        System.out.printf("\t║%20s║%20s║%20s║\n","Mã phòng","Tên phòng", "Mã sinh viên");
        System.out.println("\t╟==============================================================╢");
        for (Phong Phong: PhongArrayList){
            Hien1Phong(Phong);
        }
        System.out.println("\t╚==============================================================╝");
    }
}