package com.flyingdigital.test;

import java.util.HashMap;
import java.util.Map;

public enum EnumTest {
    s("a"),
    d("b"),
    f("c");

    private String st;

    public static void main(String[] args) {
        int a = 1;
        Long b = 1L;
        Map<Long, String> map = new HashMap<>();
        System.out.println(map.get(1));
        System.out.println(a == b);
    }
    public static void get(){
        EnumTest[] values = EnumTest.values();
        for (EnumTest value : values) {
            System.out.println(value.getSt());
        }
    }
    
    EnumTest(String st){
        this.st = st;
    }
    public void setSt(String s) {
        this.st = s;
    }

    public String getSt() {
        return st;
    }
}
