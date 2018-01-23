package com.kpmg.data.export.utils;

import java.io.*;
import java.util.List;

public class FileWriteUtil {


    public void writeContent(String fileName, String filePath, List<String> content) {

        File file = null;
        BufferedWriter csvWtriter = null;
        try {
            String absolutePath = filePath + "/" + fileName;
            file = new File(absolutePath);
            if (!file.exists()) {
                //创建文件
                file.createNewFile();
            }

            csvWtriter = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(absolutePath, true), "UTF-8"), 1024);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 10; i++) {
                sb.append("ddd").append(",").append("aaaa").append(",").append("vvvvv");
                csvWtriter.write(sb.toString());
                csvWtriter.newLine();
                sb.setLength(0);
            }
            csvWtriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
