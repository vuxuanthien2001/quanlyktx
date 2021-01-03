package com.DoAn.Business.ChucNang;

import com.DoAn.Business.HienThi.HienDichVu_HoaDon;
import com.DoAn.Business.Nhap.NhapDichVu_HoaDon;
import com.DoAn.Data.DichVu_HoaDon;

import java.util.ArrayList;
import java.util.Scanner;

public class CNDichVu_HoaDon {
    public static Scanner sc = new Scanner(System.in);
    // Sửa
    public void SuaDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList, String xau) {
        NhapDichVu_HoaDon NhapDVHD = new NhapDichVu_HoaDon();
        boolean kiemtra = false;
        for (int i = 0; i < DVHDArrayList.size(); i++) {
            if (xau.equalsIgnoreCase(DVHDArrayList.get(i).getMaphong())) {
                kiemtra = true;
                System.out.println("Đã tìm thấy thông tin cần sửa !!!");
                DVHDArrayList.set(i, new DichVu_HoaDon(NhapDVHD.maphong(), NhapDVHD.cs1kw(), NhapDVHD.cs2kw(), NhapDVHD.cs1m3(), NhapDVHD.cs2m3(), NhapDVHD.chiphikhac()));
            }
        }
        if (kiemtra == false)
            System.out.println("Không tìm thấy thông tin cần sửa !!!");
    }

    // Xóa
    public void XoaDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList, String xau) {
        boolean kiemtra = false;
        for (int i = 0; i < DVHDArrayList.size(); i++) {
            if (xau.equalsIgnoreCase(DVHDArrayList.get(i).getMaphong())) {
                kiemtra = true;
                System.out.println("Đã xóa !!! ");
                DVHDArrayList.remove(i);
            }
        }
        if (kiemtra == false) System.out.println("Không tìm thấy thông tin cần xóa !!!");
    }

    // Hiện All
    public void HienAll(ArrayList<DichVu_HoaDon> DVHDArrayList){
        System.out.println("\nDanh sách hóa đơn:\n");
        System.out.println("\t╔===============================================================================================================================================================================================================================╗");
        System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║%30s║%30s║%30s║\n","Mã phòng","CS1 điện","CS2 điện","CS1 nước","CS2 nước","Chi phí khác","Tiền điện","Tiền nước","Tổng tiền");
        System.out.println("\t╟===============================================================================================================================================================================================================================╢");
        for (DichVu_HoaDon DVHD: DVHDArrayList
             ) {
            System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║%30s║%30s║%30s║\n",
                    DVHD.getMaphong(),DVHD.getCs1kw(),DVHD.getCs2kw(),DVHD.getCs1m3(), DVHD.getCs2m3(), DVHD.getChiphikhac(),
                    TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()),TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(), DVHD.getDongiam3()),
                    TongTien(TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()),TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(),DVHD.getDongiam3()), DVHD.getChiphikhac()));
        }
        System.out.println("\t╚===============================================================================================================================================================================================================================╝");
    }

    // Hiện tiền điện
    public void HienDien(ArrayList<DichVu_HoaDon> DVHDArrayList){
        System.out.println("\nDanh sách tiền điện:\n");
        System.out.println("\t╔========================================================================================╗");
        System.out.printf("\t║%15s║%20s║%20s║%30s║\n","Mã phòng","CS1 điện","CS2 điện","Tiền điện");
        System.out.println("\t╟========================================================================================╢");
        for (DichVu_HoaDon DVHD: DVHDArrayList
             ) {
            System.out.printf("\t║%15s║%20s║%20s║%30s║\n",DVHD.getMaphong(),DVHD.getCs1kw(),DVHD.getCs2kw(),TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()));
        }
        System.out.println("\t╚========================================================================================╝");
    }
    // Hiện tiền nước
    public void HienNuoc(ArrayList<DichVu_HoaDon> DVHDArrayList){
        System.out.println("\nDanh sách tiền nước:\n");
        System.out.println("\t╔========================================================================================╗");
        System.out.printf("\t║%15s║%20s║%20s║%30s║\n","Mã phòng","CS1 điện","CS2 điện","Tiền nước");
        System.out.println("\t╟========================================================================================╢");
        for (DichVu_HoaDon DVHD: DVHDArrayList
        ) {
            System.out.printf("\t║%15s║%20s║%20s║%30s║\n",DVHD.getMaphong(),DVHD.getCs1kw(),DVHD.getCs2kw(),TinhTienNuoc(DVHD.getCs1m3(),DVHD.getCs2m3(),DVHD.getDongiam3()));
        }
        System.out.println("\t╚========================================================================================╝");
    }

    // Tìm kiếm
    public void TimDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList) {
        System.out.print("Nhập mã phòng cần tìm kiếm: ");
        String xau = sc.nextLine();
        boolean kiemtra = false;
        for (DichVu_HoaDon DVHD : DVHDArrayList
        ) {
            if (xau.equalsIgnoreCase(DVHD.getMaphong())) {
                kiemtra = true;
            }
        }
        if(kiemtra == true)
        {
            System.out.println("\nDanh sách tìm được:\n");
            HienDichVu_HoaDon HienDVHD = new HienDichVu_HoaDon();
            System.out.println("\t╔===============================================================================================================================================================================================================================╗");
            System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║%30s║%30s║%30s║\n","Mã phòng","CS1 điện","CS2 điện","CS1 nước","CS2 nước","Chi phí khác","Tiền điện","Tiền nước","Tổng tiền");
            System.out.println("\t╟===============================================================================================================================================================================================================================╢");
            for (DichVu_HoaDon DVHD : DVHDArrayList
            ) {
                if (xau.equalsIgnoreCase(DVHD.getMaphong())) {
                    {
                        System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║%30s║%30s║%30s║\n",
                                DVHD.getMaphong(),DVHD.getCs1kw(),DVHD.getCs2kw(),DVHD.getCs1m3(), DVHD.getCs2m3(), DVHD.getChiphikhac(),
                                TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()),TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(), DVHD.getDongiam3()),
                                TongTien(TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()),TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(),DVHD.getDongiam3()), DVHD.getChiphikhac()));
                    }
                }
            }
            System.out.println("\t╚===============================================================================================================================================================================================================================╝");
        }
        if (kiemtra == false)
            System.out.println("\nKhông tìm thấy thông tin cần tìm !!!");
    }

    public void ThongKe(ArrayList<DichVu_HoaDon> DVHDArrayList){
        System.out.println("\nDanh sách thống kê:\n");
        System.out.println("\t╔===============================================================================================================================================================================================================================╗");
        System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║%30s║%30s║%30s║\n","Mã phòng","CS1 điện","CS2 điện","CS1 nước","CS2 nước","Chi phí khác","Tiền điện","Tiền nước","Tổng tiền");
        System.out.println("\t╟===============================================================================================================================================================================================================================╢");
        for (DichVu_HoaDon DVHD: DVHDArrayList
        ) {
            System.out.printf("\t║%15s║%20s║%20s║%20s║%20s║%30s║%30s║%30s║%30s║\n",
                    DVHD.getMaphong(),DVHD.getCs1kw(),DVHD.getCs2kw(),DVHD.getCs1m3(), DVHD.getCs2m3(), DVHD.getChiphikhac(),
                    TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()),TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(), DVHD.getDongiam3()),
                    TongTien(TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()),TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(),DVHD.getDongiam3()), DVHD.getChiphikhac()));
        }
        System.out.println("\t╟===============================================================================================================================================================================================================================╢");
        System.out.printf("\t║                                             Tổng                                                  ║%30s║%30s║%30s║%30s║",TongCPK(DVHDArrayList), TongTienDien(DVHDArrayList),TongTienNuoc(DVHDArrayList), Tong(DVHDArrayList));
        System.out.println("\n\t╚===============================================================================================================================================================================================================================╝");

    }

    public int chiso(int cs1, int cs2){
        return cs2 - cs1;
    }

    public int TinhTienDien(int cs1, int cs2){
        int tien;
        if(chiso(cs1, cs2) <= 50){
            tien = chiso(cs1, cs2) * 1678;
        }
        else if(chiso(cs1, cs2) <= 100)
        {
            tien = 50 * 1678 + (chiso(cs1, cs2) - 50) * 1734;
        }
        else if(chiso(cs1, cs2) <= 200){
            tien = 50 * 1678 + 50 * 1734 + (chiso(cs1, cs2) - 200) * 2014;
        }
        else if(chiso(cs1, cs2) <= 300){
            tien = 50 * 1678 + 50 * 1734 + 100 * 2014 + (chiso(cs1, cs2) - 200) * 2536;
        }
        else if(chiso(cs1, cs2) <= 400){
            tien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + (chiso(cs1,cs2) - 300) * 2843;
        }
        else {
            tien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + 100 * 2843 + (chiso(cs1, cs2) - 400) * 2972;
        }
        return tien;
    }


    public int TinhTienNuoc(int cs1, int cs2, int dongia){
        return (cs2 - cs1) * dongia;
    }

    public int TongTien(int dien, int nuoc, int cpk){
        return (dien + nuoc + cpk);
    }

    public int TongTienDien(ArrayList<DichVu_HoaDon> DVHDArrayList)
    {
        int tong = 0;
        for (DichVu_HoaDon DVHD: DVHDArrayList
        ) {
            tong = tong + TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw());
        }
        return tong;
    }

    public int TongTienNuoc(ArrayList<DichVu_HoaDon> DVHDArrayList)
    {
        int tong = 0;
        for (DichVu_HoaDon DVHD: DVHDArrayList
        ) {
            tong = tong + TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(), DVHD.getDongiam3());
        }
        return tong;
    }

    public int TongCPK(ArrayList<DichVu_HoaDon> DVHDArrayList){
        int tong = 0;
        for (DichVu_HoaDon DVHD: DVHDArrayList
             ) {
            tong = tong + DVHD.getChiphikhac();
        }
        return tong;
    }

    public int Tong(ArrayList<DichVu_HoaDon> DVHDArrayList){
        int tong = 0;
        for (DichVu_HoaDon DVHD: DVHDArrayList
        ) {
            tong = tong + TongTien(TinhTienDien(DVHD.getCs1kw(), DVHD.getCs2kw()),TinhTienNuoc(DVHD.getCs1m3(), DVHD.getCs2m3(),DVHD.getDongiam3()), DVHD.getChiphikhac());
        }
        return tong;
    }
}
