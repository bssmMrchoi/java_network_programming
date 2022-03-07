package com.company.example.ch01_stream;

import java.io.*;

public class InputStream1 {
    public static void main(String[] args) {
        byte[] input = new byte[10];
        for(int i=0; i<input.length; i++) {
            try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//                System.out.println(reader.readLine());
                int b = System.in.read(); //1byte씩 읽음
                System.in.read(); //enter 때문에 한번 더 읽음, 누를땐 13, 뗄땐 10, 보통 in.read()는 키보드 입력으로 받지 않는다.
                if (b == -1) break;
                input[i] = (byte) b;
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

        for (int i=0; i<input.length; i++) {
            System.out.print((char)input[i]);
        }
    }
}
