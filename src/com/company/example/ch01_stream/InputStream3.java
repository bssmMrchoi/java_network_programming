package com.company.example.ch01_stream;

import java.io.IOException;

/*
실제 읽고자 하는 바이트의 크기(1024)가 보장되어야 하는 상황
 */
public class InputStream3 {
    public static void main(String[] args) {
        int bytesRead = 0;
        int bytesToRead = 16; //1024만큼 다 쓰기 힘드니 32로 바꿔보자
        byte[] input = new byte[bytesToRead];
        while (bytesRead < bytesToRead) {
            try {
                bytesRead += System.in.read(input, bytesRead, bytesToRead - bytesRead);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i<input.length; i++) {
            System.out.print((char)input[i]);
        }
    }
}
