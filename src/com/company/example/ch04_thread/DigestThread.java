package com.company.example.ch04_thread;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
    runnable 사용
    sha-256
    임의의 길이의 메시지를 입력받아, 256bit(64개의 16진수-4bit) 짜리 고정 길이의 값을 출력
    단방향 암호화 : 한번 암호화 되면 복호화 할 수 없음
    입력 메시지의 길이 제한X
    현재 보안 관련 용도로 많이 사용되고 있음(패스워드)
    =>출력값 개수
        md5 => 2^128
        sha-256 => 2^256
 */
public class DigestThread implements Runnable{
    private String pwd;

    public DigestThread(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public void run() {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
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
            Thread t = new Thread(new DigestThread("password"));
            t.start();
        }
    }
}
