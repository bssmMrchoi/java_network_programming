package com.company.example.ch03_readerwriter;

import java.io.*;

/*
    키보드로 입력한 데이터를 파일에 저장 후 파일 읽기
 */
public class ReaderWriterStream {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String data = reader.readLine();

            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            writer.write(data);
            writer.close();

            BufferedReader readFile = new BufferedReader(new FileReader("data.txt"));
            System.out.println(readFile.readLine());
            readFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
