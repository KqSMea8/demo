package com.hexin.common.dianIt;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.*;
import java.net.URL;

public class liXingHua {


    public static void main(String[] args) throws IOException, InstantiationException {


    }



    /**
     * 文件下载
     **/
    public static void downloadFile() {
        try {
            URL url = new URL("http://contract.hexindai.com/file/download?path=/www/frontend/attachment/member/pdf/2019/03/15/hexindai12341313131313112328.pdf");
            InputStream inputStream = url.openStream();
            File file = new File("test.pdf");
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            byte[] buf = new byte[1048];
            int length = bis.read(buf);
            while (length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读写word
     * poi jar
     **/
    public static String readWord(String path) {
        String buffer = "";
        try {
            if (path.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(path));
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            } else if (path.endsWith("docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                extractor.close();
            } else {
                System.out.println("此文件不是word文件！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }


    /**
     * String常用方法
     **/
    public static void strings() {
        String strs = "helloworld";
        System.out.println(strs.indexOf("world"));      // 返回符合条件的下标
        System.out.println(strs.lastIndexOf("l"));  // 从后开始查找
        System.out.println(strs.contains("worlds"));    // 直接判断是否在在字符串中，contains基本上都是查找
        System.out.println(strs.replaceAll("l", "_")); // 字符串的替换
        System.out.println(strs.substring(2)); // 字符串截取
        System.out.println(strs.trim()); // 消除两边的空格
    }

    /**
     * 判断是否全数字
     **/
    public static boolean isNumber(String temp) {
        char[] data = temp.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] > '9' || data[i] < '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * String拆分
     **/
    public static void splits() {
        String str = "张三:20|李四:30|王五:40";
        String result[] = str.split("\\|");
        for (int i = 0; i < result.length; i++) {
            String temp[] = result[i].split(":");
            System.out.println("姓名：" + temp[0] + "," + "年龄" + temp[1]);
        }
    }


}
