package com.DoAn.Business.HienThi;

import com.DoAn.Data.DichVu_HoaDon;

import java.util.ArrayList;

public class HienDichVu_HoaDon {
    public void Hien1DVHD(DichVu_HoaDon DichVu_HoaDon){
        System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║\n",DichVu_HoaDon.getMaphong(),DichVu_HoaDon.getCs1kw(),DichVu_HoaDon.getCs2kw(),DichVu_HoaDon.getCs1m3(), DichVu_HoaDon.getCs2m3(), DichVu_HoaDon.getChiphikhac());
    }
    public void HienThiDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList){
        System.out.println("\t╔==================================================================================================================================╗");
        System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║\n","Mã phòng","CS1 điện","CS2 điện","CS1 nước","CS2 nước","Chi phí khác");
        System.out.println("\t╟==================================================================================================================================╢");
        for (DichVu_HoaDon DVHD: DVHDArrayList){
            Hien1DVHD(DVHD);
        }
        System.out.println("\t╚==================================================================================================================================╝");
    }
}
