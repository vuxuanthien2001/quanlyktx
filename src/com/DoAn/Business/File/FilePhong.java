package com.DoAn.Business.File;

import com.DoAn.Data.Phong;

import java.io.*;
import java.util.ArrayList;

public class FilePhong {
    // Khởi tạo
    static File file = new File("Phong.txt");

    // Ghi
    public void GhiFilePhong(ArrayList<Phong> PhongArrayList) throws IOException {
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (Phong Phong: PhongArrayList
        ) {
            fileWriter.write(Phong.toString());
        }
        fileWriter.close();
    }

    // Đọc
    public void DocFilePhong(ArrayList<Phong> PhongArrayList) throws IOException {
        if(file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                PhongArrayList.add(new Phong(line.split("#")[0], line.split("#")[1], line.split("#")[2]));
            }
            bufferedReader.close();
            fileReader.close();
        }
    }
}

