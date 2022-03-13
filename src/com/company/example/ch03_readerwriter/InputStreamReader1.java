package com.company.example.ch03_readerwriter;

import java.io.*;

public class InputStreamReader1 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(reader.readLine());

            //바이트 스트림(writer)이 파일 저장에 더 적합함
//            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
//            writer.write("asdfasdfasdf");
//            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
