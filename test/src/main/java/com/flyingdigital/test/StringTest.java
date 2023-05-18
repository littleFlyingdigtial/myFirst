package com.flyingdigital.test;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class StringTest {
    public static void main(String[] args) {
        String s = "3E";
        Byte.valueOf("3E",16);
        System.out.println(Byte.parseByte("3E",16));
//        System.out.println(Byte.valueOf("0x3E",16));
        System.out.println(0x3e);

//        HashMap
    }

    /*private static void process(String userInfoString, String userId, String username) {
        JSONObject jsonObject = JSONArray.parseObject(userInfoString);
        userId = jsonObject.get("userId").toString();
        username = jsonObject.get("username").toString();
        System.out.println(jsonObject.getString("usefsdafrName"));
        System.out.println(userId);
        System.out.println(username);
    }*/
}
