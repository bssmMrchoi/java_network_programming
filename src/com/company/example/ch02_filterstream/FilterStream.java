package com.company.example.ch02_filterstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//프로젝트 최상단에 data.txt 파일 만들기
/*
필터 스트림 : 저수준의 데이터를 상위 수준의 데이터 형식으로 변환하고 결합하기 위해 사용한다.
    - 바이트 스트림 : fileinputstream/output, bufferedinputstream/output 등
    - 문자 스트림 : filereader/writer 등
 */
public class FilterStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("data.txt");
        BufferedInputStream bin1 = new BufferedInputStream(fin);
        System.out.println(bin1.read());

        BufferedInputStream bin2 = new BufferedInputStream(new FileInputStream("data.txt"));
        System.out.println(bin2.read());

        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream("data.txt")));
        System.out.println(isr.read());
    }
}
