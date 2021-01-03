package com.DoAn.Business.File;

import com.DoAn.Data.DichVu_HoaDon;

import java.io.*;
import java.util.ArrayList;

public class FileDichVu_HoaDon {
    // Khởi tạo
    static File file = new File("DichVuHoaDon.txt");

    // Ghi
    public void GhiFileDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList) throws IOException {
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (DichVu_HoaDon DVHD: DVHDArrayList
        ) {
            fileWriter.write(DVHD.toString());
        }
        fileWriter.close();
    }

    // Đọc
    public void DocFileDVHD(ArrayList<DichVu_HoaDon> DVHDArrayList) throws IOException {
        if(file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                {
                    DVHDArrayList.add(new DichVu_HoaDon(line.split("#")[0], Integer.parseInt(line.split("#")[1]),
                            Integer.parseInt(line.split("#")[2]), Integer.parseInt(line.split("#")[3]), Integer.parseInt(line.split("#")[4]),
                            Integer.parseInt(line.split("#")[5])));
                }
            }
            bufferedReader.close();
            fileReader.close();
        }
    }
}
