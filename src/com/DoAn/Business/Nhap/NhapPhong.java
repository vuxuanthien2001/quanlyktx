package com.DoAn.Business.Nhap;

import com.DoAn.Data.Phong;

import java.util.ArrayList;
import java.util.Scanner;

public class NhapPhong {
    static Scanner sc = new Scanner(System.in);

    public void NhapPhong(ArrayList<Phong> PhongArrayList){
        String msv;
        while (true){
            while (true) {
                msv = masv();
                if (KiemTra(msv, PhongArrayList)) {
                    PhongArrayList.add(new Phong(maphong(), tenphong(), msv));
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

    public boolean KiemTra(String xau, ArrayList<Phong> PhongArrayList) {
        boolean kt = true;
        for (Phong i : PhongArrayList
        ) {
            if (xau.equalsIgnoreCase(i.getMasv())) {
                kt = false;
            }
        }
        return kt;
    }

    public String tenphong(){
        String tenphong;
        System.out.print("Nhập tên phòng: ");
        do{
            tenphong = sc.nextLine();
            if(tenphong.equals("")){
                System.out.print("Nhập lại tên phòng: ");
            }
        }while (tenphong.equals(""));
        ChuanHoa chuanHoa = new ChuanHoa();
        tenphong = chuanHoa.ChuanHoaDanhTuRieng(tenphong);
        return tenphong;
    }

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
}

