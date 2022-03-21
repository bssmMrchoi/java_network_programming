package com.company.example.ch04_thread;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Thread extends Thread{
    private String pwd;

    public MD5Thread(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public void run() {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                //한 byte(4bit 4bit)씩 추가함
                sb.append(Integer.toHexString(0xff & byteData[i]));
            }
            result = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(this.toString() + ": " + result);
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            Thread t = new MD5Thread("password");
            t.start();
        }
    }
}
