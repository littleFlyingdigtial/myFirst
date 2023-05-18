package com.flyingdigital.test.thread;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;

import java.nio.charset.StandardCharsets;
import java.sql.*;

public class Main {
    private static final long count = 100000000000L;
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://172.19.1.26:3306/yhui";
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, "root", "Ceshi123");

            statement = connection.createStatement();
            statement.executeQuery("select * from a_multinlinestring_type");

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                byte[] bytes = resultSet.getBytes(2);
                WKBReader wkbReader = new WKBReader();
                Geometry geometry = wkbReader.read(bytes);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            try{
                if (statement!=null){
                    statement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static String decodeHex(String hexStr) {
        // 定义字符数组，用于保存字符串字符，长度为16进制字符串的一半
        hexStr = hexStr.replace(" ","").replace("\\x","");
        byte[] strs = new byte[hexStr.length() / 2];
        // 遍历赋值
        for (int i = 0; i < strs.length; i++) {
            // 截取高位，使用Integer.parseInt进行转换
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            // 截取低位，使用Integer.parseInt进行转换
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            // 拼接赋值
            strs[i] = (byte)(high * 16 + low);
        }
        // 将字符数组转换为字符串，返回结果
        return new String(strs,StandardCharsets.UTF_8);
    }

    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        hexStr = hexStr.replace(" ", "").replace("\\x","");
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
