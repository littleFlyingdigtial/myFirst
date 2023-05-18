package com.flyingdigital.test.thread;

public class ThreadTest {
    static int a;
    public static void main(String[] args) {
        System.out.println(a);
    }
    class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("正常try");
            } catch (Exception e){
                System.out.println("catch里抛异常之前");
                throw new NullPointerException();
            }
        }
    }
}
