package com.DoAn.Business.Nhap;

public class ChuanHoa {
    public String ChuanHoaXau(String str){
        str=str.trim();
        str=str.replaceAll("\\s+"," ");
        return str;
    }
    public String ChuanHoaDanhTuRieng(String str){
        str = ChuanHoaXau(str);
        StringBuilder str1 = new StringBuilder();
        String temp[] = str.split(" ");
        for (int i = 0; i < temp.length; i++){
            str1.append(String.valueOf(temp[i].charAt(0)).toUpperCase()+temp[i].substring(1));
            if (i < temp.length - 1){
                str1.append(" ");
            }
        }
        return str1.toString();
    }
}
