package com.example.moodie.util;

public class StringHandler {
    public static boolean isNullOrEmptyOrBlank(String str) {
        // Kiểm tra chuỗi null hoặc rỗng hoặc chỉ toàn khoảng trắng
        return str == null || str.trim().isEmpty();
    }


}
