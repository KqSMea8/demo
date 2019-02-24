package com.hexin.common.dianIt;


public class liXingHua {


    public static void main(String[] args) {

        // 判断是否全数字
//        String str = "1123456788a";
//        if (isNumber(str)){
//            System.out.println("全部数字组成");
//        }else {
//            System.out.println("有字母");
//        }

        //字符串拆分
        splits();

        //String 常用方法
        //strings();

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
