package com.DoAn.Business.Nhap;

import com.DoAn.Data.DichVu_HoaDon;

import java.util.ArrayList;
import java.util.Scanner;

public class NhapDichVu_HoaDon {
    static Scanner sc = new Scanner(System.in);
    public void NhapDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList){
        String mp;
        while (true)
        {
            while (true){
                mp = maphong();
                if (KiemTra(mp, DVHDArrayList)) {
                    DVHDArrayList.add(new DichVu_HoaDon(mp, cs1kw(), cs2kw(), cs1m3(), cs2m3(), chiphikhac()));
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

    public String maphong(){
        String maphong;
        do{
            System.out.print("Nhập mã phòng: ");
            maphong = sc.nextLine().toUpperCase();
        }while (maphong.equals(""));
        return maphong;
    }

    public boolean KiemTra(String maphong, ArrayList<DichVu_HoaDon> DVHDArrayList) {
        boolean kt = true;
        for (DichVu_HoaDon i : DVHDArrayList
        ) {
            if (maphong.equalsIgnoreCase(i.getMaphong())) {
                kt = false;
            }
        }
        return kt;
    }

    public static int cs1kw, cs2kw, cs1m3, cs2m3;

    public int cs1kw()
    {
        cs1kw = 0;
        do{
            try{
                System.out.print("Nhập chỉ số tháng trước sử dụng điện: ");
                cs1kw = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n"+ex.getMessage());
            }
            if(cs1kw <= 0){
                System.out.println("Nhập sai vui lòng nhập lại !!! ");
            }

        }while (!(cs1kw>0));
        return cs1kw;
    }

    public int cs2kw(){
        cs2kw = 0;
        do{
            try{
                System.out.print("Nhập chỉ số tháng này sử dụng điện: ");
                cs2kw = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n"+ex.getMessage());
            }
            if(!(cs2kw >= cs1kw)){
                System.out.println("Nhập sai vui lòng nhập lại !!! ");
            }

        }while (!(cs2kw >= cs1kw));
        return cs2kw;
    }

    public int cs1m3()
    {
        cs1m3 = 0;
        do{
            try{
                System.out.print("Nhập chỉ số tháng trước sử dụng nước: ");
                cs1m3 = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n"+ex.getMessage());
            }
            if(cs1m3 <= 0){
                System.out.println("Nhập sai vui lòng nhập lại !!! ");
            }

        }while (!(cs1m3>0));
        return cs1m3;
    }

    public int cs2m3(){
        cs2m3 = 0;
        do{
            try{
                System.out.print("Nhập chỉ số tháng này sử dụng nước: ");
                cs2m3 = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n"+ex.getMessage());
            }
            if(!(cs2m3 >= cs1m3)){
                System.out.println("Nhập sai vui lòng nhập lại !!! ");
            }

        }while (!(cs2m3 >= cs1m3));
        return cs2m3;
    }

    public int chiphikhac(){
        int cpk = 0;
        do{
            try{
                System.out.print("Nhập tổng số tiền chi phí khác: ");
                cpk = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n"+ex.getMessage());
            }
            if(cpk <= 0){
                System.out.println("Nhập sai vui lòng nhập lại !!! ");
            }

        }while (!(cpk>0));
        return cpk;
    }
}
