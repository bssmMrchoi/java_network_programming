package com.company.example.ch04_thread;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
    Message-Digest algorithm 5
    임의의 길이의 메시지를 입력받아, 128bit 짜리 고정 길이의 값을 출력
    단방향 암호화 : 한번 암호화 되면 복호화 할 수 없음
    입력 메시지의 길이 제한X
    보안 관련 용도로 권장하지X (충돌 : 입력이 다른데 암호화 된 출력이 같은 경우)
    출력값 개수
        md5 => 16*32개
        sha-256 => 16*64개
 */
public class DigestThread extends Thread{
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
            Thread t = new DigestThread("password");
            t.start();
        }
    }
}
