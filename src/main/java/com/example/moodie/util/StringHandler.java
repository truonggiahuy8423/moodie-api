package com.example.moodie.util;

public class StringHandler {
    public static boolean isNullOrEmptyOrBlank(String str) {
        // Kiểm tra chuỗi null hoặc rỗng hoặc chỉ toàn khoảng trắng
        System.out.println("Check null: " + str);
        return str == null || str.trim().isEmpty();
    }


}
