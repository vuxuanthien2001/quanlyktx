package com.DoAn.Business.File;

import com.DoAn.Data.SinhVien;

import java.io.*;
import java.util.ArrayList;

public class FileSinhVien {
    // Khởi tạo
    static File file = new File("SinhVien.txt");

    // Ghi
    public void GhiFileSinhVien(ArrayList<SinhVien> SinhVienArrayList) throws IOException {
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (SinhVien SinhVien: SinhVienArrayList
        ) {
            fileWriter.write(SinhVien.toString());
        }
        fileWriter.close();


    }

    // Đọc
    public void DocFileSinhVien(ArrayList<SinhVien> SinhVienArrayList) throws IOException {
        if(file.exists()){
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine())!=null){
                {
                    SinhVienArrayList.add(new SinhVien(line.split("#")[0], line.split("#")[1], line.split("#")[2],
                            line.split("#")[3], line.split("#")[4], line.split("#")[5],
                            line.split("#")[6]));
                }
            }
            bufferedReader.close();
            fileReader.close();
        }
    }
}
