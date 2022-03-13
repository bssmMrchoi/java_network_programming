package com.company.example.ch01_stream;

import java.io.IOException;
/*
    1024만큼 크기를 설정 했으나 실제로는 512바이트만 서버로 도착했고 나머지는 전송 중인 상태가 발생할 수 있다
     => 실제 읽고자하는 바이트의 크기가 보장되지 못하다.
 */
public class InputStream2 {
    public static void main(String[] args) {
        byte[] input = new byte[1024];
        try {
            int bytesRead = System.in.read(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input.length);
        for (int i=0; i<input.length; i++) {
            System.out.print((char)input[i]);
        }
    }
}
