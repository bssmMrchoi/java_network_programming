package com.company.example.ch01_stream;

import java.io.IOException;
import java.io.OutputStream;

/*
아스키코드 33부터 126 사이의 값을 출력
33부터 105까지 72개
34부터 106까지 72개
등등
1개의 문자를 OutputStream 통해 출력
 => 한 번에 한 바이트씩 축력하는 방식은 매우 비효율
 */
public class PrintStream1 {
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;

        int start = firstPrintableCharacter;
        while (true) {
            for (int i=start; i<start+numberOfCharactersPerLine; i++) {
                out.write((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            out.write('\n');
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
