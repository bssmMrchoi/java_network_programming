package com.company.example.ch01_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
    스트림 사용이 끝나면 해당 스트림의 close() 메서드를 호출하여 스트림을 닫음.
     - 자바 6 이전은 finally 사용해야함(해제 패턴)
     - 스트림 변수를 try 블록 인자 목록 안에 선언하면 자동으로 close() 호출하므로 finally 노필요
 */
public class OutputStream1 {
    public static void main(String[] args) {
        try (OutputStream out = new FileOutputStream("test.txt")){
            out.write(65);
            out.write(66);
            out.write(67);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        OutputStream out = null;
//        try {
//            out = new FileOutputStream("test.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if(out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
