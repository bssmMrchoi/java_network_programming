package com.company.example.ch01_stream;

import java.io.IOException;
import java.io.OutputStream;

/*
 => 네트워크로 전송되는 모든 TCP 세그먼트는 라우팅과 오류 정정을 위해 최소 40바이트 이상의 추가적인 데이터를 포함함
 => 이런 문제를 해결하기 위해 버퍼링하여 전송
아스키코드 33부터 126 사이의 값을 출력
33부터 105까지 72개
34부터 106까지 72개
등등
1개의 문자를 OutputStream 통해 출력
 */
public class PrintStream2 {
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;

        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine+1]; //writ('/n') 포함

        while (true) {
            for (int i=start; i<start+numberOfCharactersPerLine; i++) {
                line[i-start] = (byte)((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte)'\n';
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {
            generateCharacters(System.out);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
