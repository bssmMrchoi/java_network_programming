package com.company.example.ch02_filterstream;

import java.io.*;

public class FilterStream2 {
    public static void main(String[] args) {
        try {
            DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
            dout.writeInt(65);
            //00000000 00000000 00000000 01000001 저장
            dout.close();

            DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
            System.out.println(din.readInt());
            din.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
