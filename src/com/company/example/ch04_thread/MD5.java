package com.company.example.ch04_thread;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
    Message-Digest algorithm 5
    임의의 길이의 메시지를 입력받아, 128bit(32개의 16진수-4bit) 짜리 고정 길이의 값을 출력
    단방향 암호화 : 한번 암호화 되면 복호화 할 수 없음
    입력 메시지의 길이 제한X
    보안 관련 용도로 권장하지X (충돌 : 입력이 다른데 암호화 된 출력이 같은 경우)
    =>출력값 개수
        md5 => 2^128
        sha-256 => 2^256
 */
public class MD5 {
    public static String testMD5(String pwd) {
        String MD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                //한 byte(4bit 4bit)씩 추가함
                sb.append(Integer.toHexString(0xff & byteData[i]));
            }
            MD5 = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            MD5 = null;
        }
        return MD5;
    }

    public static void main(String[] args) {
        System.out.println(testMD5("password"));
    }
}
