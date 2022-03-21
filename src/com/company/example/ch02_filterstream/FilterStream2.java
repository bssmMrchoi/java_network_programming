package com.company.example.ch02_filterstream;

import java.io.*;
/*
    파일 생성 및 데이터 저장 후 파일 읽기
    BufferedOutputStream : 파일을 기록할 때 8192byte의 버퍼를 두고 작업 -> 속도 향상
    DataOutputStream : 자바의 기본 데이터 타입별로 출력하는 메소드 -> 바이너리 형태로 저장
 */
public class FilterStream2 {
    public static void main(String[] args) {
        try {
            DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
            dout.writeInt(65);
            //00000000 00000000 00000000 01000001 저장
            dout.writeUTF("안녕?");
            dout.writeChar('c');
            dout.close();

            DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
            System.out.println(din.readInt());
            System.out.println(din.readUTF());
            System.out.println(din.readChar());
            din.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
