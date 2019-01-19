package com.hexin.common.testClass;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass {

//    // JDK8 stream 特性
//    public static void main(String[] args) {
//        List<String> wordList = Arrays.asList("regularsssss", "expression", "specified", "as", "a", "string", "must");
//        int countByIterator = 0;
//        for (String word : wordList) {
//            if (word.length() > 7) {
//                countByIterator++;
//            }
//        }
//        long countByStream= wordList.stream().filter(w -> w.length() > 7).count();
//    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //jdk8 stream filter
        List<String> strArrs = Arrays.asList("1", "2", "3", "4");

        strArrs.stream().filter(str -> {
            return "3".equals(str) ? true : false;
        }).forEach(str -> {
            System.out.println(str);
        });

        System.out.println("------------------------------------------");


        List<String> strArr = Arrays.asList("21", "2", "22", "3", "4");

        strArr.stream().filter(str -> {
            return str.startsWith("2");
        }).filter(str -> {
            return str.equals("22");
        }).forEach(str -> {
            System.out.println(str);
        });


        System.out.println("------------------------------------------");
        // String currentTime = new SimpleDateFormat("").format(new Date(System.currentTimeMillis()));
        List<String> wordList = Arrays.asList("regularsssss", "expression", "specified", "as", "a", "string", "must");
        int countByIterator = 0;
        for (String word : wordList) {
            if (word.length() > 7) {
                countByIterator++;
            }
        }
        long countByStream = wordList.stream().filter(w -> w.length() > 7).count();
        System.out.println(countByStream);
        System.out.println(":::::::::");
        wordList.forEach(list -> System.out.println(list));

        Stream<String> as = wordList.stream().filter(li -> li.equals("as"));
    }


}
