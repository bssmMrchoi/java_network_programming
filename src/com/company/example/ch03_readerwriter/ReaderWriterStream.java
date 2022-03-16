package com.company.example.ch03_readerwriter;

import java.io.*;

public class ReaderWriterStream {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String data = reader.readLine();
            System.out.println(data);

            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
