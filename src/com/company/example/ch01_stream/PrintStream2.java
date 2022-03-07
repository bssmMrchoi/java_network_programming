package com.company.example.ch01_stream;

import java.io.IOException;
import java.io.OutputStream;

/*
아스키코드 33부터 126 사이의 값을 출력
33부터 105까지
34부터 106까지
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
