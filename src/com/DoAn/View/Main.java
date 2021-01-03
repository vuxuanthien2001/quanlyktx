package com.DoAn.View;

import com.DoAn.Business.ChucNang.*;
import com.DoAn.Data.*;
import com.DoAn.Business.Nhap.*;
import com.DoAn.Business.HienThi.*;
import com.DoAn.Business.File.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        DangNhap();
    }

    public static int ChonSinhVien()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t╔==========================================================╗");
        System.out.println("\t\t║                  Quản lý sinh viên                       ║");
        System.out.println("\t\t╟==========================================================╢");
        System.out.println("\t\t║  1  ║  Nhập thông tin sinh viên                          ║");
        System.out.println("\t\t║  2  ║  Hiển thị thông tin sinh viên                      ║");
        System.out.println("\t\t║  3  ║  Sửa thông tin sinh viên                           ║");
        System.out.println("\t\t║  4  ║  Xóa thông tin sinh viên                           ║");
        System.out.println("\t\t║  5  ║  Sắp xếp thông tin sinh viên                       ║");
        System.out.println("\t\t║  6  ║  Tìm kiếm thông tin sinh viên theo mã              ║");
        System.out.println("\t\t║  7  ║  Tìm kiếm thông tin sinh viên theo tên             ║");
        System.out.println("\t\t║  8  ║  Trở về                                            ║");
        System.out.println("\t\t╚==========================================================╝");
        System.out.print("\t\tChọn: ");
        int x = 0;
        do {
            try {
                x = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n\t\t"+ex.getMessage());
            }
            if(x <= 0 || x > 8)
                System.out.print("\t\tChọn lại: ");
        }while (!(x > 0 &&  x <=8));
        return x;
    }
    static Scanner sc = new Scanner(System.in);

    // Menu sinh viên
    public static void MenuSinhVien(ArrayList<SinhVien> SinhVienArrayList, NhapSinhVien NhapSinhVien, HienSinhVien HienSinhVien, CNSinhVien CNSinhVien, FileSinhVien FileSinhVien) throws IOException {
        FileSinhVien.DocFileSinhVien(SinhVienArrayList);
        do {
            switch (ChonSinhVien()){
                case 1: {
                    NhapSinhVien.NhapSinhVien(SinhVienArrayList);
                    FileSinhVien.GhiFileSinhVien(SinhVienArrayList);
                    Run();
                    break;
                }
                case 2:{
                    System.out.println("\nDanh sách sinh viên: \n");
                    HienSinhVien.HienThiSinhVien(SinhVienArrayList);
                    Run();
                    break;
                }
                case 3:{
                    System.out.print("\nNhập mã sinh viên cần sửa: ");
                    String xau = sc.nextLine().toUpperCase();
                    System.out.println();
                    CNSinhVien.SuaSinhVien(SinhVienArrayList,xau);
                    FileSinhVien.GhiFileSinhVien(SinhVienArrayList);
                    Run();
                    break;
                }
                case 4:{
                    System.out.print("\nNhập mã sinh viên cần xóa: ");
                    String xau = sc.nextLine().toUpperCase();
                    System.out.println();
                    CNSinhVien.XoaSinhVien(SinhVienArrayList,xau);
                    FileSinhVien.GhiFileSinhVien(SinhVienArrayList);
                    Run();
                    break;
                }
                case 5:{
                    System.out.println("\nĐã sắp xếp xong !!!");
                    CNSinhVien.SapXepSinhVien(SinhVienArrayList);
                    FileSinhVien.GhiFileSinhVien(SinhVienArrayList);
                    System.out.println("\nDanh sách sau khi được sắp xếp:\n");
                    HienSinhVien.HienThiSinhVien(SinhVienArrayList);
                    Run();
                    break;
                }
                case 6:{
                    System.out.println();
                    CNSinhVien.TimSinhVienTheoMa(SinhVienArrayList);
                    Run();
                    break;
                }
                case 7:{
                    System.out.println();
                    CNSinhVien.TimSinhVienTheoTen(SinhVienArrayList);
                    Run();
                    break;
                }
                case 8:{
                    Run();
                    break;
                }
                default:{
                    System.out.println("\nNhập lại !!!");
                    break;
                }
            }
        }while (true);
    }

    public static int ChonPhong()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t╔==========================================================╗");
        System.out.println("\t\t║                  Quản lý phòng                           ║");
        System.out.println("\t\t╟==========================================================╢");
        System.out.println("\t\t║  1  ║  Nhập thông tin phòng                              ║");
        System.out.println("\t\t║  2  ║  Hiển thị thông tin phòng                          ║");
        System.out.println("\t\t║  3  ║  Sửa thông tin phòng                               ║");
        System.out.println("\t\t║  4  ║  Xóa thông tin phòng                               ║");
        System.out.println("\t\t║  5  ║  Tìm kiếm thông tin phòng                          ║");
        System.out.println("\t\t║  6  ║  Tìm kiếm thông tin sinh viên                      ║");
        System.out.println("\t\t║  7  ║  Trở về                                            ║");
        System.out.println("\t\t╚==========================================================╝");
        System.out.print("\t\tChọn: ");
        int x = 0;
        do {
            try {
                x = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n\t\t"+ex.getMessage());
            }
            if(x <= 0 || x > 7)
                System.out.print("\t\tChọn lại: ");
        }while (!(x > 0 &&  x <=7));
        return x;
    }

    // Menu phòng
    public static void MenuPhong(ArrayList<Phong> PhongArrayList, NhapPhong NhapPhong, HienPhong HienPhong, CNPhong CNPhong, FilePhong FilePhong) throws IOException {
        FilePhong.DocFilePhong(PhongArrayList);
        do {
            switch (ChonPhong()){
                case 1: {
                    NhapPhong.NhapPhong(PhongArrayList);
                    FilePhong.GhiFilePhong(PhongArrayList);
                    Run();
                    break;
                }
                case 2:{
                    System.out.println("\nDanh sách phòng: \n");
                    HienPhong.HienThiPhong(PhongArrayList);
                    Run();
                    break;
                }
                case 3:{
                    System.out.print("\nNhập mã sinh viên cần sửa: ");
                    String xau = sc.nextLine().toUpperCase();
                    System.out.println();
                    CNPhong.SuaPhong(PhongArrayList,xau);
                    FilePhong.GhiFilePhong(PhongArrayList);
                    Run();
                    break;
                }
                case 4:{
                    System.out.print("\nNhập mã phòng cần xóa: ");
                    String xau = sc.nextLine().toUpperCase();
                    System.out.println();
                    CNPhong.XoaPhong(PhongArrayList,xau);
                    FilePhong.GhiFilePhong(PhongArrayList);
                    Run();
                    break;
                }
                case 5:{
                    System.out.println();
                    CNPhong.TimPhong(PhongArrayList);
                    Run();
                    break;
                }
                case 6:{
                    System.out.println();
                    CNPhong.TimSinhVien(PhongArrayList);
                    Run();
                    break;
                }
                case 7:{
                    Run();
                    break;
                }
                default:{
                    System.out.println("\nNhập lại !!!");
                    break;
                }
            }
        }while (true);
    }


    // Menu dịch vụ
    public static int ChonDVHD()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t╔==========================================================╗");
        System.out.println("\t\t║                  Quản lý dịch vụ - hóa đơn               ║");
        System.out.println("\t\t╟==========================================================╢");
        System.out.println("\t\t║  1  ║  Nhập thông tin dịch vụ - hóa đơn                  ║");
        System.out.println("\t\t║  2  ║  Hiển thị thông tin dịch vụ hóa đơn                ║");
        System.out.println("\t\t║  3  ║  Hiển thị thông tin lựa chọn (điện, nước, hóa đơn) ║");
        System.out.println("\t\t║  4  ║  Sửa thông tin dịch vụ hóa đơn                     ║");
        System.out.println("\t\t║  5  ║  Xóa thông tin dịch vụ hóa đơn                     ║");
        System.out.println("\t\t║  6  ║  Tìm kiếm thông tin dịch vụ hóa đơn                ║");
        System.out.println("\t\t║  7  ║  Thống kê                                          ║");
        System.out.println("\t\t║  8  ║  Trở về                                            ║");
        System.out.println("\t\t╚==========================================================╝");
        System.out.print("\t\tChọn: ");
        int x = 0;
        do {
            try {
                x = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n\t\t"+ex.getMessage());
            }
            if(x <= 0 || x > 8)
                System.out.print("\t\tChọn lại: ");
        }while (!(x > 0 &&  x <=8));
        return x;
    }

    public static int ChonHienDVHD(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t╔==========================================================╗");
        System.out.println("\t\t║      Hiển thị thông tin lựa chọn (điện, nước, hóa đơn)   ║");
        System.out.println("\t\t╟==========================================================╢");
        System.out.println("\t\t║  1  ║  Hiện tiền thông tin tiền điện                     ║");
        System.out.println("\t\t║  2  ║  Hiện tiền thông tin tiền nước                     ║");
        System.out.println("\t\t║  3  ║  Hiển thị thông tin hóa đơn                        ║");
        System.out.println("\t\t║  4  ║  Trở về                                            ║");
        System.out.println("\t\t╚==========================================================╝");
        System.out.print("\t\tChọn: ");
        int x = 0;
        do {
            try {
                x = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n\t\t"+ex.getMessage());
            }
            if(x <= 0 || x > 4)
                System.out.print("\t\tChọn lại: ");
        }while (!(x > 0 &&  x <=4));
        return x;
    }

    // Menu dịch vụ - hóa đơn
    public static void MenuDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList, NhapDichVu_HoaDon NhapDVHD, HienDichVu_HoaDon HienDVHD, CNDichVu_HoaDon CNDVHD, FileDichVu_HoaDon FileDVHD) throws IOException {
        FileDVHD.DocFileDVHD(DVHDArrayList);
        do {
            switch (ChonDVHD()){
                case 1: {
                    NhapDVHD.NhapDVHD(DVHDArrayList);
                    FileDVHD.GhiFileDVHD(DVHDArrayList);
                    Run();
                    break;
                }
                case 2:{
                    System.out.println("\nDanh sách dịch vụ - hóa đơn: \n");
                    HienDVHD.HienThiDVHD(DVHDArrayList);
                    Run();
                    break;
                }
                case 3:{
                    do{
                        switch (ChonHienDVHD()){
                            case 1: {
                                CNDVHD.HienDien(DVHDArrayList);
                                Run();
                                break;
                            }
                            case 2:{
                                CNDVHD.HienNuoc(DVHDArrayList);
                                Run();
                                break;
                            }
                            case 3:{
                                CNDVHD.HienAll(DVHDArrayList);
                                Run();
                                break;
                            }
                            case 4:{
                                MenuDVHD(DVHDArrayList,NhapDVHD,HienDVHD,CNDVHD,FileDVHD);
                                break;
                            }
                            default:{
                                System.out.println("\nNhập lại !!!");
                                break;
                            }
                        }
                    }while (true);
                }
                case 4:{
                    System.out.print("\nNhập mã phòng cần sửa: ");
                    String xau = sc.nextLine();
                    System.out.println();
                    CNDVHD.SuaDVHD(DVHDArrayList,xau);
                    FileDVHD.GhiFileDVHD(DVHDArrayList);
                    Run();
                    break;
                }
                case 5:{
                    System.out.print("\nNhập mã phòng cần xóa: ");
                    String xau = sc.nextLine();
                    System.out.println();
                    CNDVHD.XoaDVHD(DVHDArrayList,xau);
                    FileDVHD.GhiFileDVHD(DVHDArrayList);
                    Run();
                    break;
                }
                case 6:{
                    System.out.println();
                    CNDVHD.TimDVHD(DVHDArrayList);
                    Run();
                    break;
                }
                case 7:{
                    CNDVHD.ThongKe(DVHDArrayList);
                    Run();
                    break;
                }
                case 8:{
                    Run();
                    break;
                }
                default:{
                    System.out.println("\nNhập lại !!!");
                    break;
                }
            }
        }while (true);
    }




    public static void RunSinhVien() throws IOException {
        ArrayList<SinhVien> SinhVienArrayList = new ArrayList<>();
        SinhVien SinhVien = new SinhVien();
        NhapSinhVien NhapSinhVien = new NhapSinhVien();
        HienSinhVien HienSinhVien = new HienSinhVien();
        CNSinhVien CNSinhVien = new CNSinhVien();
        FileSinhVien FileSinhVien = new FileSinhVien();
        MenuSinhVien(SinhVienArrayList,NhapSinhVien,HienSinhVien,CNSinhVien,FileSinhVien);
    }

    public static void RunPhong() throws IOException {
        ArrayList<Phong> PhongArrayList = new ArrayList<>();
        Phong Phong = new Phong();
        NhapPhong NhapPhong = new NhapPhong();
        HienPhong HienPhong = new HienPhong();
        CNPhong CNPhong = new CNPhong();
        FilePhong FilePhong = new FilePhong();
        MenuPhong(PhongArrayList,NhapPhong,HienPhong, CNPhong, FilePhong);
    }



    public static void RunDVHD() throws IOException {
        ArrayList<DichVu_HoaDon> DVHDArrayList = new ArrayList<>();
        DichVu_HoaDon DVHD = new DichVu_HoaDon();
        NhapDichVu_HoaDon NhapDVHD = new NhapDichVu_HoaDon();
        HienDichVu_HoaDon HienDVHD = new HienDichVu_HoaDon();
        CNDichVu_HoaDon CNDVHD = new CNDichVu_HoaDon();
        FileDichVu_HoaDon FileDVHD = new FileDichVu_HoaDon();
        MenuDVHD(DVHDArrayList,NhapDVHD,HienDVHD,CNDVHD,FileDVHD);
    }


    public static void Run() throws IOException {
        System.out.println("\n\t\t╔==========================================================╗");
        System.out.println("\t\t║                  Quản lý ký túc xá                       ║");
        System.out.println("\t\t╟==========================================================╢");
        System.out.println("\t\t║  1  ║  Quản lý sinh viên                                 ║");
        System.out.println("\t\t║  2  ║  Quản lý phòng                                     ║");
        System.out.println("\t\t║  3  ║  Quản lý dịch vụ - hóa đơn                         ║");
        System.out.println("\t\t║  4  ║  Thoát                                             ║");
        System.out.println("\t\t╚==========================================================╝");
        System.out.print("\t\tChọn: ");
        int x = 0;
        do {
            try {
                x = Integer.parseInt(sc.nextLine());
            }catch (Exception ex){
                System.out.println("\n\t\t"+ex.getMessage());
            }
            if(x <= 0 || x > 4)
                System.out.print("\t\tChọn lại: ");
        }while (!(x > 0 &&  x <=4));
        do {
            switch (x){
                case 1: {
                    RunSinhVien();
                    break;
                }
                case 2:{
                    RunPhong();
                    break;
                }
                case 3:{
                    RunDVHD();
                    break;
                }
                case 4:{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("\nNhập lại !!!");
                    break;
                }
            }
        }while (true);
    }

    public static void DangNhap() throws IOException {
        Scanner sc = new Scanner(System.in);
        String tk, mk;
        String xau = "admin";
        while (true){
            System.out.print("\t\t\t\t\t\tTài khoản: ");
            tk = sc.nextLine();
            System.out.print("\t\t\t\t\t\tMật khẩu: ");
            mk = sc.nextLine();
            if(tk.equals(xau) && mk.equals(xau))
            {
                Hien();
                sc.nextLine();
                Run();
                break;
            }
            else {
                System.out.println("\n\t\t\tThông tin tài khoản hoặc mật khẩu không đúng\n");
            }
        }
    }

    public static void Hien(){
        System.out.println("\n\t\t\t\t\t\t\tĐỒ ÁN 1\n\t\t\t\t\t\tQUẢN LÝ KÝ TÚC XÁ");
        System.out.println("\n\t\t╔==========================================================╗");
        System.out.println("\t\t║  Người thực hiện: VŨ XUÂN THIỆN                          ║");
        System.out.println("\t\t╟==========================================================╢");
        System.out.println("\t\t║  Mã sinh viên: 10119432   ║   Mã lớp: 101195             ║");
        System.out.println("\t\t╟==========================================================╢");
        System.out.println("\t\t║  Giáo viên hướng dẫn: ThS.TRẦN ĐỖ THU HÀ                 ║");
        System.out.println("\t\t╚==========================================================╝");
        System.out.println("\n\t\t\t\t\tNhấn ENTER để tiếp tục");
    }
}
