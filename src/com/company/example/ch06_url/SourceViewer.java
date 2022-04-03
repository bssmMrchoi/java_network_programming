package com.company.example.ch06_url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/*
    웹 페이지 다운로드
    URL이 가리키는 대상은 GIF, JPEG, MP3등 뭐든 될 수 있다.
 */
public class SourceViewer {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            URL url = new URL("https://www.google.com");
            in = url.openStream();
            Reader reader = new InputStreamReader(new BufferedInputStream(in));
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char)c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
